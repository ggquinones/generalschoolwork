import mysql.connector,os
conn=mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='seniorproject'
    )
mycursor=conn.cursor()

def main():

    count=0
    lengths={}
    for filename in os.listdir('C:\\Users\\Gabriel\\Desktop\\BB'):
        fr=open('C:\\Users\\Gabriel\\Desktop\\BB\\'+filename,'r')
        for letter in fr:
            count+=1
        lengths[filename[0:len(filename)-4]]=count
        count=0

    for book in lengths:
        mycursor.execute("update matchedbooks set book_length=%s where book_id=%s",(lengths[book],book))

    conn.commit()















"""
    # 1 to 1 mappings and contains query only has one tuple
    for filename in os.listdir('C:\\Users\\Gabriel\\Desktop\\BB'):
        # Gets 1 to 1 mappings
        title = filename[0:len(filename) - 4]
        mycursor.execute("select book_id,title from books where title=%s", (title,))
        output = mycursor.fetchall()
        if (len(output) != 0):  # gets all titles that match to a DB row
            book_id = str(output[0][0])  # gets bookID of output of matched title
            os.rename('C:\\Users\\Gabriel\\Desktop\\BB\\'+filename,'C:\\Users\\Gabriel\\Desktop\\BB\\'+book_id+'.txt')
        else:
            title = "%" + filename[0:len(filename) - 4] + "%"
            mycursor.execute("select book_id,title from books where title like %s", (title,))
            output = mycursor.fetchall()
            if (len(output) ==1):  # gets all titles that match to a DB row
                book_id = str(output[0][0])  # gets bookID of output of matched titleos.rename(title, book_id)
                os.rename('C:\\Users\\Gabriel\\Desktop\\BB\\' + filename,
                          'C:\\Users\\Gabriel\\Desktop\\BB\\' + book_id + '.txt')
"""

"""
    for filename in os.listdir('C:\\Users\\Gabriel\\Desktop\\BB'):
        title = "%"+filename[0:len(filename) - 4]+"%"
        mycursor.execute("select book_id,title from books where title like %s", (title,))
        output = mycursor.fetchall()
        if (len(output) != 0):  # gets all titles that match to a DB row
            book_id = str(output[0][0])  # gets bookID of output of matched titleos.rename(title, book_id)
            os.rename('C:\\Users\\Gabriel\\Desktop\\BB\\' + filename,
                      'C:\\Users\\Gabriel\\Desktop\\BB\\' + book_id + '.txt')
"""
if(__name__=='__main__'):
    main()