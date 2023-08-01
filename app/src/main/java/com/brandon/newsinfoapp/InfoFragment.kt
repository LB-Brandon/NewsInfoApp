package com.brandon.newsinfoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.brandon.newsinfoapp.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {
    private lateinit var fragmentInfoBinding : FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        val args : InfoFragmentArgs by navArgs()
        val article = args.selectedArticle
        val webView = fragmentInfoBinding.wvInfo
        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true
        webView.setWebViewClient(WebViewClient())
        webView.loadUrl(article.url)
//        fragmentInfoBinding.wvInfo.apply {
//            webViewClient = WebViewClient()
//            if(article.url != "" && article.url != null) {
//                Log.i("TAG", "onViewCreated: ${article.url}")
//                loadUrl(article.url)
//            }
//        }
    }

}