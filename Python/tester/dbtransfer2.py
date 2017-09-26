import mysql.connector

conn = mysql.connector.connect(
    user='root',
    password='ginnyq0811',
    host='localhost',
    database='seniordesign'
)
cur=conn.cursor()



def TexttoDB_Upload():

    # key=book_id values in order(author_id,title,tags,book_length)
    metadata = {}

    fr = open('C:\\users\\gabriel\\desktop\\senior design\\DB_Transfer_File.txt', 'r')

    # reads in book metadata for table creation
    # Book(book_id, title, author, genres, book_length)
    for line in fr:
        id = line[0:line.find('%')]
        title = line[(line.find('%') + 1):line.find('%%')]
        author = line[(line.find('%%') + 2):line.find('%%%')]
        genres = line[(line.find('%%%') + 3):line.find('%%%%')]
        book_length = line[(line.find('%%%%') + 4):line.find('%%%%%')]
        cur.execute("insert into example values(%s,%s,%s,%s,%s)", (id, title, author, genres, book_length))




    conn.commit()

TexttoDB_Upload()