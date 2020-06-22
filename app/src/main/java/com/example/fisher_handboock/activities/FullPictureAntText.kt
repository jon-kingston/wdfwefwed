package com.example.fisher_handboock.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fisher_handboock.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_full_picture_ant_text.*




class FullPictureAntText : AppCompatActivity() {

    companion object {
        const val TEXT = "text"
        const val REF = "ingref"
    }

    val ref ="d"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_picture_ant_text)

        textView3.text = intent.getStringExtra(TEXT)

        Picasso.get()
            .load(intent.getStringExtra(REF))
//                .error(android.R.drawable.btn_dialog)
//                .placeholder(android.R.drawable.btn_dialog)
            .into(imageView3)
    }
}