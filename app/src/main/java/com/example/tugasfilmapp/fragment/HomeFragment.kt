package com.example.tugasfilmapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tugasfilmapp.FilmViewModel
import com.example.tugasfilmapp.ListFilm
import com.example.tugasfilmapp.R
import com.example.tugasfilmapp.adapter.FilmAdapter
import com.example.tugasfilmapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private lateinit var binding : FragmentHomeBinding
    private lateinit var filmViewModel: FilmViewModel
    private lateinit var filmAdapter: FilmAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmViewModel = ViewModelProvider(this).get(FilmViewModel::class.java)

        filmViewModel.getListFilm()
        filmAdapter = FilmAdapter(ArrayList())

        filmViewModel.filmVM.observe(viewLifecycleOwner, Observer {
            filmAdapter.setDataFilm(it as ArrayList<ListFilm>)
        })

        showRecycleView()

        //get username
        var usernameAccount = arguments?.getString("USERNAME")
        filmViewModel.setUsername(usernameAccount.toString())

        binding.btnProfil.setOnClickListener {
            filmViewModel.username.observe(viewLifecycleOwner, Observer {
                val bundleData = Bundle().apply {
                    putString("USERNAME", it as String)
                }
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment, bundleData)
            })
        }
    }

    fun showRecycleView(){
        binding.rvFilm.adapter = filmAdapter
        binding.rvFilm.layoutManager = GridLayoutManager(context, 2)
    }

}