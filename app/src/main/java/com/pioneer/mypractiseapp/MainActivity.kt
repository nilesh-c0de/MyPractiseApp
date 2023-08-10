package com.pioneer.mypractiseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    lateinit var viewModel: MainViewModel

    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tvItem: TextView = findViewById<TextView>(R.id.tv_item)

        // type - 1

        /*
        // retrofit service
        val myApi = RetrofitClient.getInstance().create(MyApi::class.java)

        viewModel = ViewModelProvider(this, MainViewModelFactory(myApi))[MainViewModel::class.java]

        viewModel.fetchAlbums()

        viewModel.albums.observe(this) { albums ->
            tvItem.text = ""

            var string = ""

            for (item in albums) {
                string = string + item.id + "\n" +item.title + "\n" + "\n\n"
            }
            tvItem.text = string
        }

         */


        // type - 2
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        lifecycleScope.launch {
            viewModel.albums.collect { albums ->

                tvItem.text = ""
                var string = ""

                for (item in albums) {
                    string = string + item.id + "\n" +item.title + "\n" + "\n\n"
                }

                tvItem.text = string

            }
        }

    }
}