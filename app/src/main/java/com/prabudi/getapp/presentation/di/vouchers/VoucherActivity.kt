package com.prabudi.getapp.presentation.di.vouchers

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
import com.prabudi.getapp.databinding.ActivityVoucherBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VoucherActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: VoucherViewModelFactory
    private lateinit var voucherVM: VoucherViewModel
    private lateinit var binding: ActivityVoucherBinding
    private var adapter = VoucherAdapter()
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_voucher)
        voucherVM = ViewModelProvider(this, factory)[VoucherViewModel::class.java]
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
        binding.voucherRv.layoutManager = LinearLayoutManager(this)
        binding.voucherRv.adapter = adapter
        setupDataVoucher()
    }

    private fun setupDataVoucher() {
        binding.voucherPb.visibility = View.VISIBLE
        val responseLiveData = voucherVM.getVoucher()
        responseLiveData.observe(this) {
            if (it != null) {
                Log.i("TAG RV", "observed $it")
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.voucherPb.visibility = View.GONE
            } else {
                binding.voucherPb.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}