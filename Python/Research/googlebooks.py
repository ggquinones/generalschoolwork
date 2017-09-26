import json,mysql.connector

import requests

conn = mysql.connector.connect(
    user='root',
    password='ginnyq0811',
    host='localhost',
    database='seniorproject'
)
cur = conn.cursor()

GETparams={}
genres={}
def main():
    #gbooks()

    collectParams()
    for key in GETparams:
        print(str(key))

    print('done with Genre collecting!!!!!!!!!!!!!!!')
    print('Genre printing!!!!!!!!!!!!!!!')


def collectParams():
    for book_id in range(980):
        try:
            cur.execute("select title,author_id from matchedbooks where book_id=%s", (book_id,))
            data = cur.fetchall()
            title = data[0][0]
            author_id = data[0][1]
            cur.execute("select author_name from authors where author_id=%s",(author_id,))
            data=cur.fetchall()
            author=data[0][0]
            GETparams[book_id]=author,title

        except IndexError:
            pass



def collectGenre1():

    #title=title[0:title.index('(')]+title[title.index(')')+1:len(title)]
    for key in GETparams:

        author = GETparams[key][0]
        title = GETparams[key][1]
        #print(title)

        response = requests.get(url="https://www.googleapis.com/books/v1/volumes?q=" + title)
        #print(response.url)
        APIout = response.text
        data = json.loads(APIout)
        try:
            books = data['items']
        except KeyError:
            continue

        for item in books:
            if (('categories' in item['volumeInfo']) and ('authors' in item['volumeInfo']) ):
                genres[key]=item['volumeInfo']['categories']
                break

def anotha():
    return 0

def collectGenres():
    for key in GETparams:
        print("start of"+str(key))
        author=GETparams[key][0]
        title=GETparams[key][1]
        r = requests.get(url="https://www.googleapis.com/books/v1/volumes?q= " + title + " inauthor:" + author+"&fields=kind,items(title,characteristics/length)")
        APIoutput = r.json()

        if('items' in APIoutput):
            print(str(key))
            APIoutput=APIoutput['items']
            length=len(APIoutput)+1
            for index in range(length):
                try:
                    print(APIoutput[index]['volumeInfo']['categories'])
                except KeyError:
                    print("Key error on key "+str(key)+"on index "+str(index))
                    continue
                except IndexError:
                    print("Index error on key " + str(key) + "on index " + str(index))
                    continue

        print("end of" + str(key))
def collectGenre():
    googleapikey = "AIzaSyAhP5mMOGQHTuA3fZsBk7Lc9ge8ynRW8H8"
    index=0

    for key in GETparams:
        author=GETparams[key][0]
        title=GETparams[key][1]
        #r = requests.get(url="https://www.googleapis.com/books/v1/volumes?q= %s inauthor: %s"%(title,author))
        r = requests.get(url="https://www.googleapis.com/books/v1/volumes?q= "+title+" inauthor:"+author)
        APIoutput=r.json()

        length=len( APIoutput['items'])
        for index in range(length+1):
            try:
                print(APIoutput['items'][index]['volumeInfo']['categories'])
            except KeyError:
                print("Key Error on"+ str(key)+"on kind"+str(index))
                continue
            except IndexError:
                print("Index Error on"+ str(key))
                continue

        index+=1

def getBooks(author,title):
    googleapikey="AIzaSyAhP5mMOGQHTuA3fZsBk7Lc9ge8ynRW8H8"
    r = requests.get(url="https://www.googleapis.com/books/v1/volumes?q="+title+"inauthor:"+author)
    #print(r.url)
    rj = r.json()
    genres = []
    try:
        rj = rj['items']
        length = len(rj)






        for index in range(length):
            if (('categories' in rj[index]['volumeInfo'])):
                genres.append(rj[index]['volumeInfo']['categories'])

        for item in genres:
            print(item[0])
    except KeyError:
        pass
    #stuff =rj['items'][0]['volumeInfo']
    #print(rj['items'][0]['volumeInfo']['categories'])
   # print(rj['items'][1]['volumeInfo'])



    #print(rj['items'][2]['volumeInfo']['categories'])



if __name__ == "__main__":
    main()
"""
rj = rj['items']
            if (('categories' in rj[index]['volumeInfo'])):
                #genres.append(rj[index]['volumeInfo']['categories'])
                print(rj[index]['volumeInfo']['categories'])
"""