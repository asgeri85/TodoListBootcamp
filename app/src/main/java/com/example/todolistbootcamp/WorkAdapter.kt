package com.example.todolistbootcamp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistbootcamp.databinding.CardWorkBinding
import com.example.todolistbootcamp.model.Work
import com.example.todolistbootcamp.view.DetailFragmentDirections
import com.example.todolistbootcamp.view.HomeFragment
import com.example.todolistbootcamp.view.HomeFragmentDirections

class WorkAdapter(var mContext:Context,var list:ArrayList<Work>): RecyclerView.Adapter<WorkAdapter.WorkHolder>() {
    inner class WorkHolder(var workBinding:CardWorkBinding):RecyclerView.ViewHolder(workBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkHolder {
        val view=CardWorkBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return WorkHolder(view)
    }

    override fun onBindViewHolder(holder: WorkHolder, position: Int) {
        val work=list[position]
        holder.workBinding.textViewCardNAme.text=work.name
        holder.workBinding.imageButton.setOnClickListener {
            list.removeAt(position)
            notifyDataSetChanged()
        }

        holder.workBinding.card.setOnClickListener {
            val action=HomeFragmentDirections.actionHomeFragmentToDetailFragment(work)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    fun listeyeEkle(work:Work){
        list.add(work)
        notifyDataSetChanged()
    }
}