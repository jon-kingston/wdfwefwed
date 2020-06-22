package com.example.fisher_handboock.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fisher_handboock.R
import com.example.fisher_handboock.adapters.ImageAdapter
import com.example.fisher_handboock.listItem
import com.example.fisher_handboock.makeToast
import com.example.secondfbtect.Pictures
import com.example.secondfbtect.presenters.Listener
import com.example.secondfbtect.presenters.PresenterImpl
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, Listener {
    var lists = ArrayList<Pictures>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("pointsss","succes")

        nav_view.setNavigationItemSelectedListener(this)


        PresenterImpl(this).getPicturesList()

    }


    override fun onPicturesListLoaded(pic: ArrayList<Pictures>?) {
       super.onPicturesListLoaded(pic)

        if (pic != null) {
            lists = pic
            rcView.hasFixedSize()
            rcView.layoutManager = LinearLayoutManager(this)
            rcView.adapter = ImageAdapter(this, lists)

            makeToast(lists.size.toString())

        } else makeToast("error")


    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_fish -> makeToast("FISH!!!!!")
            R.id.id_histori -> makeToast("Histori")
            R.id.id_sna -> makeToast("snasti")

        }
        return true
    }
}
