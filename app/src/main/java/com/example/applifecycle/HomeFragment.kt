package com.example.applifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.applifecycle.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Initialize binding.
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //Initialize.
        this.initialize()

        return binding.root
    }

    private fun initialize() {
        //Button click listener.
        binding.buttonKaydet.setOnClickListener { this.buttonClick() }
    }

    private fun buttonClick() {
        val editText = binding.editTextUsername.text.toString()

        binding.textViewName.text = editText
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        savedInstanceState?.let {
            val content = binding.editTextUsername.text.toString()
            binding.textViewName.text = content
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //Get textView message.
        val textViewMessage = binding.textViewName.text.toString()


    }

}