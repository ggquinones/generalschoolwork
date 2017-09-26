import mysql.connector

conn = mysql.connector.connect(
    user='root',
    password='MaximumHaze16',
    host='localhost',
    database='seniorproject'
)
cur=conn.cursor()


def main():

    authorsUpload()
    matchedBooksUpload()
    print("Database Uploaded")
    return(0)



def matchedBooksUpload():

    # key=book_id values in order(author_id,title,tags,book_length)
    matchedbooks = {}

    fr = open('C:\\users\\sarah\\desktop\\dbtransfer\\matchedbooks.txt', 'r')

    # reads in book metadata for table creation
    for line in fr:
        matchedbooks[line[0:line.find('%')]] = (
        line[(line.find('%') + 1):line.find('%%')], line[(line.find('%%') + 2):line.find('%%%')],
        line[(line.find('%%%') + 3):line.find('%%%%')],line[(line.find('%%%%') + 4):line.find('%%%%%')])

    for key in matchedbooks:
       cur.execute("insert into matchedbooks values(%s,%s,%s,%s,%s)",(key, matchedbooks[key][0], matchedbooks[key][1], matchedbooks[key][2],matchedbooks[key][3]))
    conn.commit()

def authorsUpload():
    # key=author_id value=author_name
    authors = {}
    fr = open('C:\\users\\sarah\\desktop\\dbtransfer\\authors.txt', 'r')

    #reads in author metadata for table creation
    for line in fr:
        authors[line[0:line.find('%')]] = line[(line.find('%') + 1):(len(line) - 2)]
    #creates author table
    for key in authors:
        cur.execute("insert into authors values(%s,%s)", (key, authors[key]))
    conn.commit()


if __name__ == '__main__':
    main()
