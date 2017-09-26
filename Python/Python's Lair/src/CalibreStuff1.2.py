import subprocess,sys
# Input String format for now:
# AuthorName BookTitle
#
# For null input % for the parameter

# Global Variables
# Taking the command line inputs and putting them into their respective variables
author = sys.argv[1]
title  = sys.argv[2]

def main():
    determine_run_query()

def title_search(title_name):
    output = subprocess.check_output('calibredb list --fields authors --search title:' + title_name,
                                     shell=True)
    output = str(output.decode('UTF-8'))
    fw = open('latest_query.txt', 'w')
    authors = make_dictionaries(output)
    # writes author name to CSV
    fw.write(title_name + "%\n")
    # writes titles for corresponding author_name
    for key in authors:
        fw.write(key + '%' + authors[key] + '%\n')
    fw.write('%%')
    fw.close()

#Takes in author name from command line, and puts into a CSV the author name followed by all titles associated with that author.
#Input: author name from command line
#Output: CSV File.
#FORMAT:
#<Author Name(s)>%
#<book_ID>%<book_Title>%
#<book_ID>%<book_Title>%
#%%     (DOUBLE %'s INDICATE END OF TITLE LIST FOR CORRESPONDING AUTHOR)
def author_search(author_name):
    output = subprocess.check_output('calibredb list --fields title --search author:' + author_name,
                                     shell=True)
    output = str(output.decode('UTF-8'))
    fw=open('latest_query.txt','w')
    titles=make_dictionaries(output)
    # writes author name to CSV
    fw.write(author_name+"%\n")
    # writes titles for corresponding author_name
    for key in titles:
        fw.write(key+'%'+titles[key]+'%\n')
    fw.write('%%')
    fw.close()

#Determines query to run based on the given command line arguments
def determine_run_query():
    # author and title search
    if (author is not "%" and title is not "%"):
        print("Author and Title Search")
    # author search
    elif (author is not "%" and title is "%"):
        print("Author Search")
        author_search(author)
        #write_to_file(author_search(author))
    # title search
    elif (author is "%" and title is not "%"):
        print("Title Search")
        #write_to_file(title_search(title))
    #Initial Upload
    elif(author is "%" and title is "%"):
        print("Initial Upload")
        initial_upload_CSV()
    else:
        print("Query not recognized!")  # Not recognized as query

#Takes subprocess output and puts each line into a element of a List
#Takes off first and last element, NOT NEEDED
#Input: subprocess output
#Output: List of all the lines in the subprocess output
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

#Gets all titles in DB
#Output: subprocess output with all titles
def get_all_titles():
    output = subprocess.check_output('calibredb list --fields title', shell=True)
    output = str(output.decode('UTF-8'))
    return output

#Gets all authors in DB
#Output: subprocess output with all authors
def get_all_authors():
    output = subprocess.check_output('calibredb list --fields authors', shell=True)
    output = str(output.decode('UTF-8'))
    return output

#Gets all titles and authors and puts them into a CSV file. Uses % to seperate bookIDs, titles, and author names.
#ONE BOOK WITH INFO> PER LINE
#Output: CSV File
def initial_upload_CSV():
    titles=make_dictionaries(get_all_titles())
    authors=make_dictionaries(get_all_authors())
    fw = open('ledger.txt', 'w')
    for key in authors:
        fw.write(key + "%" + authors[key] + "%" + titles[key] + "%\n")
    fw.close()

if(__name__ == '__main__'):
    main()