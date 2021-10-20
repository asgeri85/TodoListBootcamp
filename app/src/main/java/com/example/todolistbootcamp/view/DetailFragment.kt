package com.example.todolistbootcamp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.todolistbootcamp.R
import com.example.todolistbootcamp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding:FragmentDetailBinding?=null
    private val binding get() = _binding!!
    private val args:DetailFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewName.text=args.work.name
        binding.textViewDate.text=args.work.date
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}