package com.example.vocabularylist.study_vocas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.example.vocabularylist.R

class StudyVocas : AppCompatActivity(), View.OnClickListener {
    private lateinit var toolbar : Toolbar
    private lateinit var ivMoveToAnimalVocas : ImageView
    private lateinit var ivMoveToBodyVocas : ImageView
    private lateinit var ivMoveToFlagVocas : ImageView
    private lateinit var ivMoveToCostomVocas : ImageView

    companion object{
        const val ANIMAL_VOCA_KEY = "animal_key"
        const val BODY_VOCA_KEY = "body_key"
        const val FLAG_VOCA_KEY = "flag_key"
        const val COSTOM_VOCA_KEY = "costom_key"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_vocas)

        toolbar = findViewById(R.id.toolbar_study_vocas)

        ivMoveToAnimalVocas = findViewById(R.id.ivMoveToAnimalVocas)
        ivMoveToBodyVocas = findViewById(R.id.ivMoveToBodyVocas)
        ivMoveToFlagVocas = findViewById(R.id.ivMoveToFlagVocas)
        ivMoveToCostomVocas = findViewById(R.id.ivMoveToCostomVocas)

        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.button_back)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "단어 학습"

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        ivMoveToAnimalVocas.setOnClickListener(this)
        ivMoveToCostomVocas.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val mIntent = Intent(this@StudyVocas, VocasList::class.java)

        when(v?.id){
            R.id.ivMoveToAnimalVocas -> {
                mIntent.putExtra(ANIMAL_VOCA_KEY, true)
            } R.id.ivMoveToBodyVocas -> {
                mIntent.putExtra(BODY_VOCA_KEY, true)
            } R.id.ivMoveToFlagVocas -> {
                mIntent.putExtra(FLAG_VOCA_KEY, true)
            } R.id.ivMoveToCostomVocas -> {
                mIntent.putExtra(COSTOM_VOCA_KEY, true)
            }
        }

        startActivity(mIntent)
    }
}