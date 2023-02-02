package com.prabudi.getapp.presentation.di.merchants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.prabudi.getapp.R
import com.prabudi.getapp.databinding.ActivityMerchantBinding
import com.prabudi.getapp.utils.OnLoadMoreScrollListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MerchantActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MerchantViewModelFactory
    private lateinit var merchantViewModel: MerchantViewModel
    private lateinit var binding: ActivityMerchantBinding
    private var adapter = MerchantAdapter()
    private var page = 1
    private var lastPage = 2
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_merchant)
        merchantViewModel = ViewModelProvider(this, factory)[MerchantViewModel::class.java]
        binding.apply {
            bundle = intent.extras
            setupToolbar()
            setupRV()
        }
    }

    private fun setupToolbar() {
        bundle.apply {
            val data = intent.getStringExtra("toolbar")
            if (data != null) {
                setSupportActionBar(binding.appbar.toolbar)
                supportActionBar?.title = data
                binding.appbar.toolbar.setTitleTextColor(
                    ContextCompat.getColor(
                        baseContext,
                        R.color.white
                    )
                )
                binding.appbar.toolbar.navigationIcon =
                    VectorDrawableCompat.create(baseContext.resources, R.drawable.ic_back, null)
                binding.appbar.toolbar.setNavigationOnClickListener { finish() }
            }
        }
    }

    private fun setupRV() {
        binding.merchantRv.layoutManager = LinearLayoutManager(this)
        binding.merchantRv.adapter = adapter
        setupDataVoucher()
    }

    private fun setupDataVoucher() {
        binding.merchantPb.visibility = View.VISIBLE
        val responseLiveData = merchantViewModel.getMerchant(page.toString())
        responseLiveData.observe(this) {
            if (it != null) {
                Log.i("TAG RV", "observed $it")
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.merchantPb.visibility = View.GONE
                binding.merchantRv.addOnScrollListener(
                    OnLoadMoreScrollListener(
                        binding.merchantRv.layoutManager as LinearLayoutManager
                    ) {
                        if (page != lastPage) {
                            page++
                            binding.merchantPb.visibility = View.VISIBLE
                            val nextPage = merchantViewModel.getMerchant(page.toString())
                            nextPage.observe(this) { data ->
                                if (data != null) {
                                    adapter.addList(data)
                                    adapter.notifyDataSetChanged()
                                    binding.merchantPb.visibility = View.GONE
                                } else {
                                    binding.merchantPb.visibility = View.GONE
                                    Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    })
                binding.merchantPb.visibility = View.GONE
            } else {
                binding.merchantPb.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}