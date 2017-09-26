import spotipy

name="Tupac"
spotify = spotipy.Spotify()
results = spotify.search(q='artist:' + name, type='artist')
results = results['artists']['items'][0]
print(results)
for key in results:
    if(key == "name"):
        print(results[key])