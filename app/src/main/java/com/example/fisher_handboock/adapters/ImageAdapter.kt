package com.example.fisher_handboock.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fisher_handboock.R
import com.example.fisher_handboock.activities.FullPictureAntText
import com.example.fisher_handboock.activities.MainActivity
import com.example.secondfbtect.Pictures
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*
import org.xmlpull.v1.XmlPullParser.TEXT

class ImageAdapter(
    val ctx: Context,
    val immages: List<Pictures>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(ctx).inflate(R.layout.item_layout, null)
        return ImageHolder(view)
    }

    override fun getItemCount() = immages.size

    override fun getItemViewType(position: Int) = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ImageHolder) {
            holder.text_tv.text = immages[position].title

            Picasso.get()
                .load(immages[position].thumbnailUrl)
//                .error(android.R.drawable.btn_dialog)
//                .placeholder(android.R.drawable.btn_dialog)
                .into(holder.image)

            holder.image.setImageResource(android.R.drawable.btn_dialog)

            holder.text_tv.setOnClickListener(){
                Toast.makeText(ctx, holder.text_tv.text, Toast.LENGTH_SHORT).show()
                val ind = Intent(ctx, FullPictureAntText::class.java).apply {
                    putExtra(FullPictureAntText.TEXT, immages[position].title.toString())
                    putExtra(FullPictureAntText.REF, immages[position].thumbnailUrl.toString())
                }
                ctx.startActivity(ind)
            }
        }

    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        //когда адаптер засовывается в recyclerView
        //recyclerView.layoutManager = LinearLayoutManager(ctx)
    }


    class ImageHolder(container: View) : RecyclerView.ViewHolder(container) {
        val image: ImageView = container.imageView!!
        val text_tv: TextView = container.textView2!!
    }


}



//class MessagesAdapter(
//    val ctx: Context,
//    val messages: List<Message>
//) : RecyclerView.Adapter<MessagesAdapter.Holder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        Holder(LayoutInflater.from(ctx).inflate(R.layout.input_message, null))
//
//    override fun getItemCount() = messages.size
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.text_tv.text = messages[position].text
//        holder.date.text = messages[position].date
//        holder.avatar.setImageResource(android.R.drawable.btn_dialog)
//    }
//
//
//    class Holder(container: View) : RecyclerView.ViewHolder(container) {
//        val avatar: ImageView = container.findViewById(R.id.avatar_iv)
//        val text_tv: TextView = container.findViewById(R.id.text_tv)
//        val date: TextView = container.findViewById(R.id.date_tv)
//    }
//}