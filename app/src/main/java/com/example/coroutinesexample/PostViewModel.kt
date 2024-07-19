package com.example.coroutinesexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    private val _posts = MutableLiveData<List<PostData>>()
    val posts: LiveData<List<PostData>> = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            try{
                val postList = RetrofitInstance.api.getPosts()
                _posts.postValue(postList)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}