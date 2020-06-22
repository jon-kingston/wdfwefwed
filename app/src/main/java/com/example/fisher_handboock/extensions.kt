package com.example.fisher_handboock

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast


fun Context.makeToast(text: String){
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}


