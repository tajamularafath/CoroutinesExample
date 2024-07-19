package com.example.coroutinesexample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)


        postViewModel.posts.observe(this) { posts ->
            recyclerView.adapter = PostAdapter(posts)
        }

        lifecycleScope.launch {
            postViewModel.fetchPosts()
        }

        GlobalScope.launch {

        }

        val scope = CoroutineScope(Job() + Dispatchers.Main)
        scope.launch {
            // Coroutine code here

        }

    }
}