import subprocess,sys

def Main():
    output = subprocess.check_output('calibredb list --fields title' ,shell=True)
    output = str(output.decode('UTF-8'))
    books=make_books_dictionary(output)
    for key in books:
        print(key+" "+books[key])


def make_books_dictionary(output):
    lines = separate_lines(output)
    books = {}
    for item in lines:
        books[item[0:item.find(" ")]] = item[item.find(" ") + 1:].strip() + "\n"
    # Prints out books dictionary
    #for key in books:
       # print(key+" "+books[key])
    return books
###############################################################################################
# Helper method for make_books_dictionary
# Puts every line into a separate list element
def separate_lines(output):
    books = []
    temp = ""
    # puts every thing up to a '\n' character into a spot in books
    for index in range(len(output)):
        temp+=output[index]
        if(output[index] is "\n"):
            books.append(temp)
            temp=""

    books.pop(0) # takes off first useless
    books=put_overflows_together(books)
    return books
##############################################################################################
# Helper method for separate_lines
# Some titles have too many characters and overflow into the next line and are counted as two books.
# This function puts those overflowed parts of titles into their corresponding title and removes the overflowed
# part from the list
def put_overflows_together(lines):
    # Puts lines that flow over into the next line on the same line and replaces the overflowed item in lines to "*"
    for index in range(len(lines)):
        if (lines[index][0] is " "):
            lines[index - 1] += lines[index].strip() + "\n"
            lines[index] = "*"
            # Removes marked lines, i.e. lines that are "*"
    for item in lines:
        if (item is "*"):
            lines.remove(item)
    return lines

if __name__=='__main__':
    Main()