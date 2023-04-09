package com.example.tugasfilmapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tugasfilmapp.ListFilm
import com.example.tugasfilmapp.ListFilmSerializable
import com.example.tugasfilmapp.R
import com.example.tugasfilmapp.databinding.FragmentDetailFilmBinding

class DetailFilmFragment : Fragment() {

    private lateinit var binding : FragmentDetailFilmBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailFilmBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var getNamaFilm = arguments?.getString("NAMA_FILM")
        var getTanggalRelease = arguments?.getString("TANGGAL_RELEASE")
        var getRating = arguments?.getString("RATING")
        var getDeskripsi = arguments?.getString("DESKRIPSI")
        var getGambar = arguments?.getInt("GAMBAR")

        var listFilm = ListFilm(getNamaFilm.toString(),getTanggalRelease.toString(), getRating.toString(),
        getDeskripsi.toString(), getGambar.toString().toInt())

        binding.film = listFilm
    }

}