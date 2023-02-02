package com.prabudi.getapp.presentation.di.home.webpage

import android.graphics.Bitmap
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.prabudi.getapp.R
import com.prabudi.getapp.data.model.home.PromoList
import com.prabudi.getapp.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web)
        binding.apply {
            bundle = intent.extras
            setupData()
        }
    }

    private fun setupData() {
        bundle.apply {
            val data = if (SDK_INT >= 33) { intent.getParcelableExtra("PromoList", PromoList::class.java) }
            else { @Suppress("DEPRECATION")  intent.getParcelableExtra("PromoList") }
            if (data != null) {
                setSupportActionBar(binding.appbar.toolbar)
                supportActionBar?.title = "Promo ${data.order}"
                binding.appbar.toolbar.setTitleTextColor(ContextCompat.getColor(baseContext, R.color.white))
                binding.appbar.toolbar.navigationIcon = VectorDrawableCompat.create(baseContext.resources, R.drawable.ic_close, null)
                binding.appbar.toolbar.setNavigationOnClickListener { finish() }
                binding.wvPromo.apply {
                    webViewClient = object : WebViewClient(){
                        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                            super.onPageStarted(view, url, favicon)
                            binding.progressBar.progress = progress
                        }

                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            binding.progressBar.visibility = View.GONE
                        }
                    }

                    settings.javaScriptEnabled = true
                    loadUrl(data.url.toString())
                }
            }
        }
    }
}