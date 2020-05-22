package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.fragment.FragmentFavorite
import com.example.recyclerview.fragment.FragmentPlaying
import com.example.recyclerview.fragment.FragmentRating
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentPlaying.DetailFragmentListener, FragmentRating.DetailFragmentRatingListener {
    var myMovie = ArrayList<MovieModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
       
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set first view is Fragment Playing
        if (supportFragmentManager.backStackEntryCount == 0) {
            val fragA = FragmentPlaying( )
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragA)
                .commit()
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_playing -> {
                    val fragment = FragmentPlaying()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .addToBackStack(null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_top_rating -> {
                    val fragment = FragmentRating()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .addToBackStack(null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favorite -> {
                    val fragment = FragmentFavorite()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .addToBackStack(null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    fun getData(): ArrayList<MovieModel>{
        return myMovie
    }
    // get favorite movie from RatingFragment
    override fun onDetailFragmentRatingListener(movie: MovieModel) {
        myMovie.add(movie)
    }
    // get favorite movie from PlayingFragment
    override fun onDetailFragmentListener(movie: MovieModel) {
        myMovie.add(movie)
    }
}


