package com.brandon.newsinfoapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.brandon.newsinfoapp.data.model.Article
import com.brandon.newsinfoapp.databinding.NewsListItemBinding
import com.bumptech.glide.Glide

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    // Use DIffUtil to compare the old list with the new list
    private val callback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            // Compare the id of the articles
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            // Compare the contents of the articles
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class NewsViewHolder(val binding: NewsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description
            binding.tvPublishedAt.text = article.publishedAt
            binding.tvSource.text = article.source.name

            Glide.with(binding.ivArticleImage.context)
                .load(article.urlToImage)
                .into(binding.ivArticleImage)

            binding.root.setOnClickListener {
                onItemClickListener?.let { it(article) }
            }
        }

    }

    // This is a lambda function as a click listener
    private var onItemClickListener : ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener : (Article)-> Unit) {
        onItemClickListener = listener
    }

}