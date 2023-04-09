package com.example.tugasfilmapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilmViewModel : ViewModel() {

    private var _filmVM : MutableLiveData<List<ListFilm>> = MutableLiveData()
    val filmVM  : LiveData<List<ListFilm>> get() = _filmVM

    private var _username : MutableLiveData<String> = MutableLiveData()
    val username : LiveData<String> get() = _username

    private var list = arrayListOf(
        ListFilm("Shazam Fury of the Gods", "20/03/2023", "4.7 / 5",
            "Film ini merupakan sebuah film yang mengadaptasikan superhero fiksi", R.drawable.img_film_shazam),
        ListFilm("The Magician's Elephant", "20/05/2023", "4.5 / 5",
            "Film ini merupakan sebuah film yang mengadaptasikan superhero fiksi", R.drawable.img_magicians_elephant),
        ListFilm("Shazam Fury of the Gods", "20/03/2023", "4.7 / 5",
            "Film ini merupakan sebuah film yang mengadaptasikan superhero fiksi", R.drawable.img_film_shazam),
        ListFilm("Shazam Fury of the Gods", "20/03/2023", "4.7 / 5",
            "Film ini merupakan sebuah film yang mengadaptasikan superhero fiksi", R.drawable.img_film_shazam),
        ListFilm("Shazam Fury of the Gods", "20/03/2023", "4.7 / 5",
            "Film ini merupakan sebuah film yang mengadaptasikan superhero fiksi", R.drawable.img_film_shazam),
        ListFilm("Shazam Fury of the Gods", "20/03/2023", "4.7 / 5",
            "Film ini merupakan sebuah film yang mengadaptasikan superhero fiksi", R.drawable.img_film_shazam),
        ListFilm("Shazam Fury of the Gods", "20/03/2023", "4.7 / 5",
            "Film ini merupakan sebuah film yang mengadaptasikan superhero fiksi", R.drawable.img_film_shazam),
        ListFilm("Shazam Fury of the Gods", "20/03/2023", "4.7 / 5",
            "Film ini merupakan sebuah film yang mengadaptasikan superhero fiksi", R.drawable.img_film_shazam),


        )

    fun getListFilm(){
        _filmVM.value = list
    }

    fun setUsername(user: String){
        _username.value = user
    }

}