package com.prabudi.getapp.presentation.di.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabudi.getapp.R
import com.prabudi.getapp.data.model.home.PromoList
import com.prabudi.getapp.databinding.ListItemPromoBinding

class HomePromoAdapter :RecyclerView.Adapter<PromoViewHolder>() {
    private val list = ArrayList<PromoList>()
    private var onItemClickListener: OnItemPromoClickListener? = null

    fun setList(data:List<PromoList>){
        list.clear()
        list.addAll(data)
    }

    fun setItemClick(listener: OnItemPromoClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemPromoBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_promo,
            parent,
            false
        )
        return PromoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(list[position], onItemClickListener!!)
    }
}

interface OnItemPromoClickListener {
    fun onItemClick(view: View?, obj: PromoList)
}

class PromoViewHolder(private val binding: ListItemPromoBinding):
RecyclerView.ViewHolder(binding.root){

    fun bind(data: PromoList, listener: OnItemPromoClickListener){
        binding.rv.setOnClickListener { listener.onItemClick(it, data) }
        binding.tvTitle.text = "Promo ${data.order}"
        Glide.with(binding.ivPromo.context)
            .load(data.imageUrl)
            .into(binding.ivPromo)
    }

}