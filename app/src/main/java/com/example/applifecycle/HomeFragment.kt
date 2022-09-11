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
        binding = FragmentHomeBinding.inflate(layoutInflater)
        this.initialize()
        return binding.root
    }

    /**
     * Button click listener
     *
     */
    private fun initialize() {
        binding.buttonKaydet.setOnClickListener { this.buttonClick() }
    }


    /**
     * Get and Set text message.
     *
     */
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
        val textViewMessage = binding.textViewName.text.toString()
        binding.textViewName.text = textViewMessage


    }

}