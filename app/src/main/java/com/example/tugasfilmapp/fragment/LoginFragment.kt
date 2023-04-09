package com.example.tugasfilmapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tugasfilmapp.R
import com.example.tugasfilmapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    private var listAccount: MutableMap<String, String> = mutableMapOf()
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        listAccount["account1"] = "password1"
        listAccount["account2"] = "password2"

        binding.btnLogin.setOnClickListener {
            checkAccount()

        }
    }

    private fun checkAccount(){
        val inputUsername = binding.tfUsername.text.toString()
        val inputPassword = binding.tfPassword.text.toString()
        if(inputUsername.isNotEmpty() && inputPassword.isNotEmpty()){
            var accountFailed = true
            for (account in listAccount){
                if(account.key == inputUsername && account.value == inputPassword){
                    val bundleData = Bundle().apply {
                        putString("USERNAME", inputUsername)
                    }
                    accountFailed = false
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundleData)
                    break
                }
            }
            if(accountFailed){
                Toast.makeText(context, "username & password yang anda masukan salah!", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(context, "username & password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
        }
    }


}