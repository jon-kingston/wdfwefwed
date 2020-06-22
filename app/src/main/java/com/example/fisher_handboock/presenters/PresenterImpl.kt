package com.example.secondfbtect.presenters

import android.util.Log
import android.widget.Toast
import com.example.fisher_handboock.activities.MainActivity
import com.example.fisher_handboock.makeToast
import com.example.secondfbtect.Pictures
import com.example.secondfbtect.api.getAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterImpl(var listener: Listener) : Presenter {


    override fun getUser(id: String) {
        TODO("Not yet implemented")
    }


    override fun getPicture(id: String) {
        getAPI()
            .getPictureById(id)
            .enqueue(object : Callback<Pictures> {
                override fun onFailure(call: Call<Pictures>, t: Throwable) =
                    listener.onPictureLoaded(null)

                override fun onResponse(call: Call<Pictures>, response: Response<Pictures>) {
                    if (response.isSuccessful) listener.onPictureLoaded(response.body())
                }
            })
    }

    override fun getPicturesList() {
        Log.e("pointsss","succes1")
        getAPI()
            .getPicturs()
            .enqueue(object : Callback<ArrayList<Pictures>> {
                override fun onFailure(call: Call<ArrayList<Pictures>>, t: Throwable) =
                    listener.onPictureLoaded(null)

                override fun onResponse(call: Call<ArrayList<Pictures>>, response: Response<ArrayList<Pictures>>) {
                    if (response.isSuccessful) listener.onPicturesListLoaded(response.body())
                }

            })
    }
}