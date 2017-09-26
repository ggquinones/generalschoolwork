import subprocess,mysql.connector

# Global Variables
# Taking the command line inputs and putting them into their respective variables
conn=mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniorproject'
    )
mycursor=conn.cursor()
#mycursor.execute("SHOW TABLES")
def main():
    output = subprocess.check_output('calibredb list --fields authors', shell=True)
    output = str(output.decode('UTF-8'))
    temp = make_dictionaries(output)
    authors=take_out_UVA(temp)

    # Adds first 3 rows which correspond to the common repeated author names: Various, Unknown, and Anonymous
    mycursor.execute("insert into authors values(1,'Unknown');")
    mycursor.execute("insert into authors values(2,'Various');")
    mycursor.execute("insert into authors values(3,'Anonymous');")
    author_id=4
    for key in authors:
        if(len(authors[key])<150):
            mycursor.execute("insert ignore into authors values(%s, %s);", (author_id, authors[key]))
            #mycursor.execute("insert into authors values("+str(author_id)+",'"+temp[key]+"');")
            author_id+=1
    conn.commit()

# Function takes out all author names that contain 'Unknown', 'Various', or 'Anonymous' from the inputted dictionary
# and returns a dictionary without them.
def take_out_UVA(dict):
    temp={}
    for key in dict:
        # Basically a "CONTAINS" conditional to catch instances when 'Various  .' is the author name instead of simply 'Various'
        if('Unknown' not in dict[key] and 'Various' not in dict[key] and 'Anonymous' not in dict[key]):
            temp[key]=dict[key]

    return temp
# Takes subprocess output and
#
#
def separate_output_lines(output):
    linesTemp = []
    temp = ""
    # puts every thing up to a '\n' character into a spot in books
    for index in range(len(output)):
        temp += output[index]        #adds current character in output to temp
        if (output[index] is "\n"):
            temp=temp[0:len(temp)-1] #takes off \n at the end of temp
            linesTemp.append(temp)       #adds temp to lines
            temp = ""                #resets temp to blank

    linesTemp.pop(0)  # takes off first line
    linesTemp.pop()   # takes off last blank line
    return linesTemp

#Takes the List returned by separate_output_lines and puts elements together which should be together.
#Neede for overflow lines when a title or author's name/author list takes more than on line
#Input: List of all the lines in the subprocess output
#Output: List of all titles or authors corrected for overflows.
def put_overflows_together(linesTemp):
    lines=[]
    for index in range(len(linesTemp) - 1):
        if (linesTemp[index][0] is ' '):
            linesBefore = 1
            while (linesTemp[index - linesBefore] is '*'):   # Looks for line to attach the overflow line to
                linesBefore += 1
            # puts overflow line with appropriate line with '\n' before it for formatting
            linesTemp[index - linesBefore] += linesTemp[index][4:]
            # marks overflow line which has been moved with a *
            linesTemp[index] = '*'

    # Puts all lines into a list, excludes overflow lines marked as *
    for item in linesTemp:
        if (item is not '*'):
            lines.append(item)

    return lines

#Makes a dictionary of a given subprocess output
#Input: subprocess output
#Output: dictionary where KEY is bookid and VALUE is corresponding book title or book author
def make_dictionaries(output):
    lines=put_overflows_together(separate_output_lines(output))
    dictionary={}
    #puts BookID as KEY and the rest as VALUE
    for item in lines:
        dictionary[item[0:4].replace(' ', '')] = item[4:]
    return dictionary



if(__name__ == '__main__'):
    main()