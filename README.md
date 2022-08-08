# ListOfFilms

## Description
This application displays a list of movies on the screen sorted by year of release

## Requirements:

+ Fragment+RecyclerView must be used to display the list of movies
there must be a presentation layer, implemented according to the MVVM pattern, which receives the list of movies via the repository and passes it to Fragment when the fragment is launched
+ to use Retrofit+Gson libraries for loading data from the network
+ films must be sorted by year of release.
+ each item in the list must contain the following information
+ title in the form "<Title> (< release year >)"

director's name in the format "Last name and surname".

actor's first and last names without duplicates

when clicking on the RecyclerView element, a dialog box must appear with the following text: "Movie <Title> has been clicked".

## The technology stack used
> + MVVM
> + Navigation Component
> + Coroutines 
> + LiveData
> + DI Dagger2
> + Retrofit2
> + View Binding
> + View (Fragment, DialogFragment, RecyclerView)

### JSON data
[films.json](https://raw.githubusercontent.com/constanta-android-dev/intership-wellcome-task/main/films.json)
