package com.example.mypostapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypostapplication.R
import com.example.mypostapplication.domain.Posts
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter : RecyclerView.Adapter<PostViewHolder>() {

    private val items = ArrayList<Posts>()

    fun setItems(items: ArrayList<Posts>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class PostViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var posts: Posts

    @SuppressLint("SetTextI18n")
    fun bind(item: Posts) {
        this.posts = item
        view.textViewId.text = item.id.toString()
        view.textViewUserId.text = item.userId.toString()
    }
}