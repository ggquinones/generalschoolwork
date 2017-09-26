from gutenberg.acquire import load_etext
from gutenberg.cleanup import strip_headers
from SeniorDesign import metainfo


def getEpubs():
    collectionTitles = []
    for key in metadata:
        if( hasImageEpub(metadata[key]) and isText(metadata[key]) and isEnglish(metadata[key]) and noMissingData(metadata[key]) ):
            collectionTitles.append(metadata[key]['title'])
    return collectionTitles

def hasImageEpub(book):
    if 'application/epub+zip' in book['formats'] and 'epub.images' in book['formats']['application/epub+zip']:
        return True
    return False

def isText(book):
    if 'Text' in book['type']:
        return True
    return False

def isEnglish(book):
    if len(book['language'])==1 and 'en' in book['language'] :
        return True
    return False

def noMissingData(book):
    for key in book:
        if book[key] is None:
            return False
    return True

def makeFile(titles):
    fw = open("publicDomainTexts.txt", 'w')
    for title in titles:
        try:
            fw.write(title+"\n")
        except Exception:
            print("Title Skipped")


print("Getting metadata....")
metadata = metainfo.readmetadata()
print("Starting scan....")
#print(metadata[2701])
makeFile(getEpubs())