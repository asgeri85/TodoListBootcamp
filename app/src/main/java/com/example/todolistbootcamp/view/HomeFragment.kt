package com.example.todolistbootcamp.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todolistbootcamp.MainActivity
import com.example.todolistbootcamp.R
import com.example.todolistbootcamp.WorkAdapter
import com.example.todolistbootcamp.databinding.AlertWorkBinding
import com.example.todolistbootcamp.databinding.FragmentHomeBinding
import com.example.todolistbootcamp.model.Work

class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private lateinit var adapter: WorkAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager= GridLayoutManager(context,2)
        binding.recyclerView.setHasFixedSize(true)
        val liste= arrayListOf(Work("İngilizce","Salı"),Work("Kotlin","Pazartesi"),Work("Algoritmaya giriş","Perşembe"))
        adapter=WorkAdapter(requireContext(),liste)
        binding.recyclerView.adapter=adapter
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        binding.toolbar.title="TodoList"
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(item.itemId==R.id.action_ekle){
            alertOpen()
            true
        }else{
            super.onOptionsItemSelected(item)
        }

    }

    private fun alertOpen(){
        val alertWorkBinding=AlertWorkBinding.inflate(layoutInflater)
        val ad=AlertDialog.Builder(requireContext())
        ad.setView(alertWorkBinding.root)
        ad.setTitle("Bilgileri giriniz")
        ad.setPositiveButton("Ekle"){ _, _ ->
            val name=alertWorkBinding.editAlertAd.text.toString().trim()
            val date=alertWorkBinding.editAlertTarih.text.toString().trim()
            if (name.isNotEmpty() && date.isNotEmpty()){
                adapter.listeyeEkle(Work(name,date))
            }else{
                Toast.makeText(context,"Alanları doldurunuz",Toast.LENGTH_SHORT).show()
            }

        }

        ad.setNegativeButton("İptal"){_,_->

        }

        ad.create().show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}