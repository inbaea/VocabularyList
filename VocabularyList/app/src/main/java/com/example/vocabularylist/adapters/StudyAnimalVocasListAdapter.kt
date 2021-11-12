package com.example.vocabularylist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabularylist.R
import com.example.vocabularylist.vocas.AnimalModel

class StudyAnimalVocasListAdapter(val context: Context, private val animalVocas : ArrayList<AnimalModel>?)
    : RecyclerView.Adapter<StudyAnimalVocasListAdapter.ViewHolder>(){

    private var onClickListener : OnClickListener? = null

    interface OnClickListener{
        fun onClick(animal : AnimalModel)
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(
            R.layout.items_for_vocas,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(animalVocas!![position])
    }

    override fun getItemCount(): Int {
        return animalVocas!!.size
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val ivVocasPicture = view.findViewById<ImageView>(R.id.ivVocasPicture)

        fun bind(animal : AnimalModel){
            ivVocasPicture.setImageDrawable(ContextCompat.getDrawable(context, animal.src))

            ivVocasPicture.setBackgroundResource(R.drawable.rounded_rectangle)
            ivVocasPicture.clipToOutline = true

            itemView.setOnClickListener{
                onClickListener?.onClick(animal)
            }
        }
    }
}