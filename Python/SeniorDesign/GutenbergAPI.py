from gutenberg.acquire import load_etext
from gutenberg.cleanup import strip_headers
from SeniorDesign import metainfo


#text = strip_headers(load_etext(2701)).strip()
  # prints 'MOBY DICK; OR THE WHALE\n\nBy Herman Melville ...'
# START OF MAIN METHOD
"""
def main():

    books=makeBooksArray()
    for item in books:
        print(item.toString())
    return 0

    print(len(books))
    max=0
    maxgenres=""

    for item in books:
        if(len(item.genres)>= max):
            max = len(item.genres)
            maxgenres=item.genres
    print(maxgenres)
    print(max)

#END OF MAIN METHOD
"""

# START OF BOOK CLASS
class Book:

    def __init__(self, id, title, author,genres,bookLength,authorID):
        self.title = title
        self.author = author
        self.genres = genres
        self.id = id
        self.authorID=authorID
        self.bookLength= bookLength

    def toString(self):
        print('----------------------------------------------------------------------')
        #genreString = ', '.join(self.genres)
        return(str(self.id)+'\n'+self.author+' '+str(self.authorID)+' '+str(self.bookLength)+'\n'+self.title+'\n'+self.genres)
# END OF BOOK CLASS


def extractNames(author):
    authorName = []
    # First Name of Author
    authorName.append(author[author.find(",") + 2:])
    authorName.append(author[:author.find(",")])
    return authorName



# START OF MAKE BOOKS ARRAY
def makeBooksArray():
    """
    Goes through Project Gutenberg metadata catalog and puts all books that meet a criteria into a list of Book objects
    CRITERIA:
    if(
            (len(metadata[key]['subjects']) > 0) and
            ( metadata[key]['subjects'] is not None) and
            (metadata[key]['downloads']>75) and
            ( metadata[key]['author'] is not None) and
            ("en" in metadata[key]['language'])
       ):

    :return: List of Book objects that meet a certain criteria
    """
    books=[]
    metadata = metainfo.readmetadata()
    for key in metadata:
       if( (len(metadata[key]['subjects']) > 0) and( metadata[key]['subjects'] is not None) and (metadata[key]['downloads']>75) and ( metadata[key]['author'] is not None) and ("en" in metadata[key]['language'])    ):
           #authorNames = extractNames(metadata[key]['author'])
           genreString = ', '.join(metadata[key]['subjects'])
           books.append(Book(key,metadata[key]['title'],metadata[key]['author'],genreString,0,0))
    return books
# END OF MAKE BOOKS ARRAY



if __name__=='__main__':
    main()
