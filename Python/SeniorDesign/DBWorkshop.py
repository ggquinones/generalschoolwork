import mysql.connector,os
from SeniorDesign import GutenbergAPI
from gutenberg.acquire import load_etext
from gutenberg.cleanup import strip_headers

def main():
    #upload_book_metadata()
    #get_text_for_books()
    #get_book_lengths()
    #db_error_report_update()
    #match_DB_and_texts()
    #DB_to_File()
    File_to_DB()

    return 0

def upload_book_metadata():
    """
    Uploads the metadata of all books returned by makeBooksArray in ProjectGutenbergAPI.py into a
    MySql DB table, books.

    """
    conn = mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniordesign'
    )
    cur = conn.cursor()
    books = GutenbergAPI.makeBooksArray()
    query="INSERT IGNORE INTO books VALUES(%s,%s,%s,%s,%s)"
    for item in books:
        cur.execute(query, (item.id, item.title, item.author, item.genres,item.bookLength))
    conn.commit()
    conn.close()

def get_text_for_books():
    """
    Goes through DB and for each entry tries to get the text for the entries book_id,
    using ProjectGutenberg's code to download the text for a given Project Gutenberg book_id.
    If successful a file is made @ "C:\\Users\\Gabriel\\Desktop\\Senior Design\\newDBBooks"
    with the book_id as the name of the file.(Saved as .txt files)

    """
    conn = mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniordesign'
    )
    cur = conn.cursor()
    cur.execute("SELECT * FROM books")
    error_report = ""
    for row in cur:
        try:
            id = row[0]
            if(id >= 500):
                print("................printing............printing............")
                text = strip_headers(load_etext(id).strip())
                fw = open("C:\\Users\\Gabriel\\Desktop\\Senior Design\\newDBBooks\\" + str(id) + ".txt", 'w')
                fw.write(text)
                fw.close()

        except Exception:
            print(id)
            error_report += str(id)+"\n"
    fw = open("C:\\Users\\Gabriel\\Desktop\\Senior Design\\error_report.txt",'w')
    fw.write(error_report)
    fw.close()
    conn.close()

def get_book_lengths():
    conn = mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniordesign'
    )
    cur = conn.cursor()

    count = 0
    lengths = {}
    for filename in os.listdir("C:\\Users\\Gabriel\\Desktop\\Senior Design\\newDBBooks\\"):
        fr = open("C:\\Users\\Gabriel\\Desktop\\Senior Design\\newDBBooks\\" + filename, 'r')
        for letter in fr:
            count += 1
        lengths[filename[0:len(filename) - 4]] = count
        count = 0

    for book in lengths:
        cur.execute("update books set book_length=%s where book_id=%s", (lengths[book], book))

    conn.commit()
    conn.close()

def db_error_report_update():
    conn = mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniordesign'
    )
    cur = conn.cursor()

    with open("C:\\Users\\Gabriel\\Desktop\\Senior Design\\error_report.txt") as f:
        content = f.readlines()
    content = [x.strip() for x in content]
    for line in content:
        cur.execute("SELECT * FROM books WHERE book_id=%s")

def match_DB_and_texts():
    conn = mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniordesign'
    )
    cur = conn.cursor()
    count=0
    count1 = 0
    for filename in os.listdir('C:\\Users\\Gabriel\\Desktop\\Senior Design\\newDBBooks'):
        id=int(filename[0:len(filename)-4])
        cur.execute("SELECT * FROM books WHERE book_id = %s",(id,))

        if len(cur.fetchall()) == 0 :
            os.remove('C:\\Users\\Gabriel\\Desktop\\Senior Design\\newDBBooks\\'+filename)
            count1+=1
        else:
            count+=1
    print(count1)
    print(count)
    conn.close()

def DB_to_File():
    conn = mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniordesign'
    )
    cur = conn.cursor()
    cur.execute("SELECT * FROM books")
    fw = open("C:\\users\\gabriel\\desktop\\senior design\\transferFile.txt",'w')

    for row in cur:
        id=row[0]
        title=row[1]
        author = row[2]
        genres= row[3]
        length = row[4]
        line = str(id)+"%"+title+"%%"+author+"%%%"+genres+"%%%%"+str(length)+"%%%%%\n"
        fw.write(line)

    fw.close()
    conn.close()

def File_to_DB():
    conn = mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniordesign'
    )
    cur = conn.cursor()
    fr = open("C:\\users\\gabriel\\desktop\\senior design\\transferFile.txt", 'r')
    count =0
    for line in fr:
        id = int(line[0:line.find("%")])
        title= line[line.find("%")+1:line.find("%%")]
        author = line[line.find("%%")+2:line.find("%%%")]
        genre = line[line.find("%%%")+3:line.find("%%%%")]
        length = int(line[line.find("%%%%")+4:line.find("%%%%%")])
        cur.execute("insert into example values(%s,%s,%s,%s,%s)",(id,title,author,genre,length))

    conn.commit()
    conn.close()
    fr.close()

if __name__=='__main__':
    main()