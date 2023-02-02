package com.prabudi.getapp.presentation.di.vouchers

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prabudi.getapp.R
import com.prabudi.getapp.data.model.vouchers.VoucherList
import com.prabudi.getapp.databinding.ListItemVoucherBinding
import java.text.SimpleDateFormat
import java.util.*

class VoucherAdapter :RecyclerView.Adapter<ViewHolder>() {
    private val voucherList = ArrayList<VoucherList>()

    fun setList(data:List<VoucherList>){
        voucherList.clear()
        voucherList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemVoucherBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item_voucher,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return voucherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(voucherList[position])
    }
}

class ViewHolder(private val binding: ListItemVoucherBinding):
RecyclerView.ViewHolder(binding.root){

    fun bind(data: VoucherList){
        val date = data.validUntil?.let{ convertTimeStampToDateString(it, "dd MMMM yyyy") }
        binding.tvName.text = "Valid Until $date"
        Glide.with(binding.image.context)
            .load(data.images?.feature?.imageURL)
            .into(binding.image)
        binding.cv.setOnClickListener {
            basicAlert(it)
        }
    }
}

fun convertTimeStampToDateString(timeStamp: String, format: String): String {
    return convertDateToString(format, convertTimeStampToDate(timeStamp))
}

fun convertTimeStampToDate(timeStamp: String): Date {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    return inputFormat.parse(timeStamp)!!
}

fun convertDateToString(format: String, date: Date): String {
    val sdf = SimpleDateFormat(format)
    return sdf.format(date)
}

fun basicAlert(view: View){
    val builder = AlertDialog.Builder(view.context)
    val positiveButtonClick = { _: DialogInterface, _: Int -> }
    with(builder)
    {
        setTitle("INFO")
        setMessage("Under Development Feature")
        setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
        show()
    }
}

