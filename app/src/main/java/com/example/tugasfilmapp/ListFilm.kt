package com.example.tugasfilmapp

data class ListFilm(
    var namaFilm : String,
    var tanggalRelease : String,
    var rating : String,
    var deskripsiSinopsis : String,
    var gambar : Int
) : java.io.Serializable
