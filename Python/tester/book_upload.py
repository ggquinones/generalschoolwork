import subprocess,mysql.connector

conn=mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniorproject'
    )
mycursor=conn.cursor()

def main(): 
    output = subprocess.check_output('calibredb list --fields tags',shell=True)
    output = str(output.decode('UTF-8'))
    tags = make_dictionaries(output)

    output = subprocess.check_output('calibredb list --fields title', shell=True)
    output = str(output.decode('UTF-8'))
    titles = make_dictionaries(output)

    output = subprocess.check_output('calibredb list --fields authors', shell=True)
    output = str(output.decode('UTF-8'))
    authors = make_dictionaries(output)

    book=[]

    #Loads array book with Book objects
    for key in tags:
        book.append(Book(titles[key], authors[key], tags[key],-1,int(key)))
    book.sort(key=lambda x: x.bookID, reverse=False)
    #general query to use to get author_id for a certain given author_name
    query = ("select author_id from authors where author_name=%s;")

    for item in book:
        if('Unknown' in item.author):
            item.authorID=1
            item.author='Unknown'
        elif('Various' in item.author):
            item.authorID=2
            item.author = 'Various'
        elif('Anonymous' in item.author):
            item.authorID=3
            item.author = 'Anonymous'
        else:
            mycursor.execute(query, (item.author,))
            item.authorID=mycursor.fetchall()[0][0]

    query="insert ignore into books values(%s,%s,%s,%s)"
    for item in book:
        mycursor.execute(query,(item.bookID,item.authorID,item.title,item.tags))

    conn.commit()


# Start Book class
class Book:

    def __init__(self, title, author, tags,authorID, bookID, bookLength):
        self.title = title
        self.author = author
        self.tags = tags
        self.bookID = bookID
        self.authorID=authorID
        self.bookLength= bookLength

    def toString(self):
        print('----------------------------------------------------------------------')
        print(str(self.bookID)+'\n'+self.author+' '+str(self.authorID)+'\n'+self.title+'\n'+self.tags)

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