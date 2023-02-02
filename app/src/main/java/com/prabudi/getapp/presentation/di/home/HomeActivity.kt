package com.prabudi.getapp.presentation.di.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabudi.getapp.R
import com.prabudi.getapp.data.model.home.MenuList
import com.prabudi.getapp.data.model.home.PromoList
import com.prabudi.getapp.databinding.ActivityHomeBinding
import com.prabudi.getapp.presentation.di.home.webpage.WebActivity
import com.prabudi.getapp.presentation.di.merchants.MerchantActivity
import com.prabudi.getapp.presentation.di.vouchers.VoucherActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(),OnItemClickListener,OnItemPromoClickListener {
    @Inject
    lateinit var factory: HomeViewModelFactory
    private lateinit var homeVM: HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    private var adapter = HomeAdapter()
    private var promoAdapter = HomePromoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        homeVM = ViewModelProvider(this, factory)[HomeViewModel::class.java]
        setupToolbar()
        setupRV()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.appbar.toolbar)
        supportActionBar?.title = getString(R.string.app_name)
        binding.appbar.toolbar.setTitleTextColor(ContextCompat.getColor(baseContext, R.color.white))
    }

    private fun setupRV() {
        binding.homeRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.homePromoRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.homeRv.adapter = adapter
        binding.homePromoRv.adapter = promoAdapter
        adapter.setItemClick(this)
        promoAdapter.setItemClick(this)
        setupDataMenu()
        setupDataPromo()
    }

    private fun setupDataMenu() {
        binding.homePb.visibility = View.VISIBLE
        binding.textView.visibility = View.GONE
        val responseLiveData = homeVM.getMenu()
        responseLiveData.observe(this) {
            if (it != null) {
                Log.i("TAG RV", "observed $it")
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.homePb.visibility = View.GONE
                binding.textView.visibility = View.VISIBLE
            } else {
                binding.homePb.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupDataPromo() {
        binding.homePb.visibility = View.VISIBLE
        binding.textView.visibility = View.GONE
        val responseLiveData = homeVM.getMenuPromo()
        responseLiveData.observe(this) {
            if (it != null) {
                Log.i("TAG RV", "observed $it")
                promoAdapter.setList(it)
                promoAdapter.notifyDataSetChanged()
                binding.homePb.visibility = View.GONE
                binding.textView.visibility = View.VISIBLE
            } else {
                binding.homePb.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onItemClick(view: View?, obj: PromoList) {
        intent = Intent(this, WebActivity::class.java)
        intent.putExtra("PromoList", obj)
        startActivity(intent)
    }

    override fun onItemClick(view: View?, obj: MenuList) {
        if(obj.label == "Merchants"){
            intent = Intent(this, MerchantActivity::class.java)
            intent.putExtra("toolbar", obj.label)
            startActivity(intent)
        }else{
            intent = Intent(this, VoucherActivity::class.java)
            intent.putExtra("toolbar", obj.label)
            startActivity(intent)
        }
    }
}