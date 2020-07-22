package com.androiddevs.mvvmnewsapp.ui.UI.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.ui.UI.UI.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.ui.UI.UI.ui.NewsRepository
import com.androiddevs.mvvmnewsapp.ui.UI.UI.ui.NewsViewModel
import com.androiddevs.mvvmnewsapp.ui.UI.UI.ui.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val repository=NewsRepository(ArticleDatabase(this))
        val viewModelFactory=NewsViewModelFactory(repository)
        newsViewModel=ViewModelProvider(this,viewModelFactory).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
    }
}
