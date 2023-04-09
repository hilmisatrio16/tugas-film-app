package com.example.tugasfilmapp

data class ListFilmSerializable(
    var namaFilm : String,
    var tanggalRelease : String,
    var rating : String,
    var deskripsiSinopsis : String,
    var gambar : Int
) : java.io.Serializable
