package com.prabudi.getapp.presentation.di.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabudi.getapp.R
import com.prabudi.getapp.data.model.home.MenuList
import com.prabudi.getapp.databinding.ListItemHomeBinding

class HomeAdapter :RecyclerView.Adapter<ViewHolder>() {
    private val menuList = ArrayList<MenuList>()
    private var onItemClickListener: OnItemClickListener? = null

    fun setList(data:List<MenuList>){
        menuList.clear()
        menuList.addAll(data)
    }

    fun setItemClick(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemHomeBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_home,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuList[position], onItemClickListener!!)
    }
}

interface OnItemClickListener {
    fun onItemClick(view: View?, obj: MenuList)
}

class ViewHolder(private val binding: ListItemHomeBinding):
RecyclerView.ViewHolder(binding.root){

    fun bind(data: MenuList, listener: OnItemClickListener){
        binding.cvItem.setOnClickListener { listener.onItemClick(it, data) }
        binding.titleTextView.text = data.label
        Glide.with(binding.imageView.context)
            .load(data.logoUrl)
            .into(binding.imageView)
    }

}