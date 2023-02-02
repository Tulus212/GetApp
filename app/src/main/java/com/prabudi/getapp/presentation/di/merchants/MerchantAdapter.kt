package com.prabudi.getapp.presentation.di.merchants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabudi.getapp.R
import com.prabudi.getapp.data.model.merchants.MerchantList
import com.prabudi.getapp.databinding.ListItemMerchantBinding

class MerchantAdapter :RecyclerView.Adapter<ViewHolder>() {
    private val merchantList = ArrayList<MerchantList>()

    fun setList(data:List<MerchantList>){
        merchantList.clear()
        merchantList.addAll(data)
    }

    fun addList(data:List<MerchantList>){
        merchantList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemMerchantBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_merchant,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return merchantList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(merchantList[position])
    }
}

class ViewHolder(private val binding: ListItemMerchantBinding):
RecyclerView.ViewHolder(binding.root){

    fun bind(data: MerchantList){
        binding.tvName.text = data.displayValue
        Glide.with(binding.image.context)
            .load(data.images?.feature?.imageURL)
            .into(binding.image)
    }

}

