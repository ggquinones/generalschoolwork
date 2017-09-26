from internetarchive import search_items
from internetarchive import search_items

for item in search_items('identifier:nasa').iter_as_items():
    print(item)