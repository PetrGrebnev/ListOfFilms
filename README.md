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

## Done

No internet connection
  
![image](https://user-images.githubusercontent.com/95710980/190977786-b64f1b6a-8634-4200-924d-3489c127f659.png)

Getting a list and displaying a sorted list
  
![image](https://user-images.githubusercontent.com/95710980/190977957-7669bc10-9096-4336-ab23-246e11ff238d.png)

Dialog window
  
![image](https://user-images.githubusercontent.com/95710980/190978096-22f5c091-f868-4c05-91ff-b01561492159.png)
