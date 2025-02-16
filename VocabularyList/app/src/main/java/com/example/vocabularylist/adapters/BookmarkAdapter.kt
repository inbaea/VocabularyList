package com.example.vocabularylist.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabularylist.R
import com.example.vocabularylist.vocas.VocaModel

class BookmarkAdapter(val context: Context, private val vocas : ArrayList<VocaModel>)
    : RecyclerView.Adapter<BookmarkAdapter.ViewHolder>(){

    private var onClickListener : OnClickListener? = null

    interface OnClickListener{
        fun onClick(voca : VocaModel)
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(
                R.layout.items_for_bookmark,
                parent,
                false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(vocas[position])
    }

    override fun getItemCount(): Int {
        return vocas.size
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val ivVocasPicture = view.findViewById<ImageView>(R.id.ivBookmarkPicture)

        fun bind(voca : VocaModel){
            if(voca.srcPath.isEmpty()){
                ivVocasPicture.setImageDrawable(ContextCompat.getDrawable(context, voca.src))
            } else{
                ivVocasPicture.setImageURI(Uri.parse(voca.srcPath))
            }

            ivVocasPicture.setBackgroundResource(R.drawable.rounded_rectangle)
            ivVocasPicture.clipToOutline = true

            itemView.setOnClickListener{
                onClickListener?.onClick(voca)
            }
        }
    }
}