package com.example.mypostapplication.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypostapplication.R
import com.example.mypostapplication.adapter.PostAdapter
import com.example.mypostapplication.util.Resource
import kotlinx.android.synthetic.main.fragment_posts_list.*
import kotlinx.android.synthetic.main.fragment_posts_list.view.*


class PostsListFragment : Fragment() {
    val viewModel: PostListViewModelFragment by viewModels()
    private lateinit var adapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_posts_list, container, false)
        setupRecyclerView(view)
        setupObservers()
        return view
    }

    private fun setupRecyclerView(view: View) {
        adapter = PostAdapter()
        view.post_list.layoutManager = LinearLayoutManager(activity)
        view.post_list.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    progress_bar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    progress_bar.visibility = View.VISIBLE
            }
        })
    }
}