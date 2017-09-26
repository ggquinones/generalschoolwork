import mysql.connector, requests,urllib.request
import tmdbsimple as tmdb


conn=mysql.connector.connect(
        user='root',
        password='ginnyq0811',
        host='localhost',
        database='VHSdb'
    )


mycursor=conn.cursor()
KEY = 'c071aaec51545bc6a78d8b90c0df3521'
tmdb.API_KEY = KEY

search =tmdb.Search()
choice = input("Enter a movie or < q > to exit:")
while choice != 'q':
    response = search.movie()
    movies =search.results
    for movie in movies:
        try:
            title = movie['title']
            #path = movie['poster_path']
            prod_year = movie['release_date']
            # urllib.request.urlretrieve('https://image.tmdb.org/t/p/w500' + path, title + '.jpg')
            print(title + " " + prod_year)
            choice = input("Press < n > to show next movie or < e > to select the current movie: ")
            if choice == "e":
                break
        except TypeError:
            continue
    input = input("Enter a movie or < q > to exit:")



