import sys,subprocess

# Input String format for now:
# AuthorName BookTitle
#
# For null input % for the parameter

# Global Variables
# Taking the command line inputs and putting them into their respective variables
author = sys.argv[1]
title  = sys.argv[2]
def main():
    determine_query_type()

def determine_query_type():
    if(author is not "%" and title is not "%"): #author and title search
        print("Author and Title Search")
    elif(author is not "%" and title is "%"):   #author search
        print("Author Search")
        write_to_file(author_search(author))
    elif(author is "%" and title is not "%"):   #title search
        print("Title Search")
        write_to_file(title_search(title))
    else:
        print("No search requested!")           #Not recognized as query

def author_search(author_name):
        output = subprocess.check_output('calibredb list --fields title,authors --search author:' + author_name,
                                         shell=True)
        output = str(output.decode('UTF-8'))
        return output

def title_search(book_title):
    output = subprocess.check_output('calibredb list --fields title --search title:' + book_title,
                                     shell=True)
    output = str(output.decode('UTF-8'))
    return output

def author_title_search(author_name,book_title):
    output = subprocess.check_output('calibredb list --fields title,author --search title:' + book_title,
                                     shell=True)
    output = str(output.decode('UTF-8'))
    return output

def write_to_file(query_output):
    fw = open("outputfile.txt", 'w')
    fw.write(query_output + '\n')
    fw.close()


if __name__ == '__main__':
    main()