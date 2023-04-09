package com.example.tugasfilmapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasfilmapp.ListFilm
import com.example.tugasfilmapp.R
import com.example.tugasfilmapp.databinding.ItemFilmBinding

class FilmAdapter(private var listFilm : ArrayList<ListFilm>) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindFilm(itemData : ListFilm){
            binding.film = itemData

            binding.root.setOnClickListener {
                val bundle = Bundle().apply {
                    putString("NAMA_FILM", itemData.namaFilm)
                    putString("TANGGAL_RELEASE", itemData.tanggalRelease)
                    putString("RATING", itemData.rating)
                    putString("DESKRIPSI", itemData.deskripsiSinopsis)
                    putInt("GAMBAR", itemData.gambar)
                }

                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailFilmFragment, bundle)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.ViewHolder {
        val view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmAdapter.ViewHolder, position: Int) {
        holder.bindFilm(listFilm[position])
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }
    fun setDataFilm(itemFilm : ArrayList<ListFilm>){
        this.listFilm = itemFilm
    }
}