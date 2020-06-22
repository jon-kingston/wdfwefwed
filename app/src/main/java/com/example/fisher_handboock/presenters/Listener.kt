package com.example.secondfbtect.presenters

import android.content.Context
import com.example.secondfbtect.Pictures
import com.example.secondfbtect.User

interface Listener {

    fun onUserLoaded(user: User?) {}

    fun onPictureLoaded(pic: Pictures?) {}

    fun onPicturesListLoaded(pic: ArrayList<Pictures>?) {}

    fun onPostLoaded(post: String?) {}

}