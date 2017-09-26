import subprocess,sys

def main():
    output = subprocess.check_output('calibredb list --fields title',shell=True)
    output = str(output.decode('UTF-8'))
    print(output)


# Takes a text file with all of the authors in batchbooks
# and makes a dictionary where the BookID is the KEY and the corresponding authors are
# the VALUES
def make_author_dictionary():
    # Opens text file with all the authors to read from
    fr = open('allauthors.txt', 'r')
    # Lists and Dictionaries to use
    authors = {}
    linesTemp = []
    lines = []

    # Reads in lines in file
    # Removes the \n at the end of each line
    for line in fr:
        linesTemp.append(line[0:len(line) - 1])
    # removes blank line at the end of the file
    linesTemp.pop()
    fr.close()
    # puts all overflow lines into a single line
    for index in range(len(linesTemp) - 1):
        if (linesTemp[index][0] is ' '):
            linesBefore = 1
            while (linesTemp[index - linesBefore] is '*'):  # Looks for line to attach the overflow line to
                linesBefore += 1
            linesTemp[index - linesBefore] += '\n' + linesTemp[index][
                                                     4:]  # puts overflow line with appropriate line with '\n' before it for formatting
            linesTemp[index] = '*'  # marks overflow line which has been moved with a *

    # Puts all lines into a list, excludes overflow lines marked as *
    for item in linesTemp:
        if (item is not '*'):
            lines.append(item)

    # Extracts BookID (KEY) and authors(VALUES) and puts them into a dictionary
    for item in lines:
        authors[item[0:4].replace(' ', '')] = item[4:]

    return authors
    # Prints Dictionary for checking
    #for key in authors:
    #    print(key + " " + authors[key])

# END OF make_authors_dictionary FUNCTION

# Takes a text file with all of the book titles in batchbooks
# and makes a dictionary where the BookID is the KEY and the corresponding titles are
# the VALUES
def make_titles_dictionary():
    #Opens text file with all the book titles to read from
    fr = open('allbooks.txt', 'r')
    #output = subprocess.check_output('calibredb list --fields title',shell=True)
    #output = str(output.decode('UTF-8'))
    #Lists and Dictionaries to use
    books = {}
    linesTemp = []
    lines = []

    # Reads in lines in file
    # Removes the \n at the end of each line
    for line in fr:
        linesTemp.append(line[0:len(line) - 1])
    # removes blank line at the end of the file
    linesTemp.pop()
    fr.close()
    # puts all overflow lines into a single line
    for index in range(len(linesTemp) - 1):
        if (linesTemp[index][0] is ' '):
            linesBefore = 1
            while (linesTemp[index - linesBefore] is '*'): #Looks for line to attach the overflow line to
                linesBefore += 1
            linesTemp[index - linesBefore] += linesTemp[index][4:] # puts overflow line with appropriate line with '\n' before it for formatting
            linesTemp[index] = '*' #marks overflow line which has been moved with a *

    #Puts all lines into a list, excludes overflow lines marked as *
    for item in linesTemp:
        if (item is not '*'):
            lines.append(item)

    #Extracts BookID (KEY) and titles(VALUES) and puts them into a dictionary
    for item in lines:
        books[item[0:4].replace(' ', '')] = item[4:]

    return books
    #Prints Dictionary for checking
    #for key in books:
       # print(key + " " + books[key])

# END OF make_titles_dictionary FUNCTION

def make_CSV():
    titles=make_titles_dictionary()
    authors=make_author_dictionary()

    fw=open('ledger.txt','w')
    for key in authors:
        fw.write(key+" "+authors[key]+" "+titles[key]+"\n")

if __name__ =='__main__':
    main()
