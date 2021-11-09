package com.example.vocabularylist.study_vocas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.example.vocabularylist.R
import com.example.vocabularylist.main.MainActivity
import com.example.vocabularylist.vocas.Vocas

class StudyVocas : AppCompatActivity(), View.OnClickListener {
    private lateinit var toolbar : Toolbar
    private lateinit var btMoveToAnimalVocas : Button
    private lateinit var btMoveToPlantVocas : Button
    private lateinit var btMoveToJobVocas : Button
    private lateinit var btMoveToCostomVocas : Button

    private var vocas : Vocas? = null

    companion object{
        const val ANIMAL_VOCAS = "animal_vocas"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_vocas)

        toolbar = findViewById(R.id.toolbar_study_vocas)
        btMoveToAnimalVocas = findViewById(R.id.btMoveToAnimalVocas)
        btMoveToPlantVocas = findViewById(R.id.btMoveToPlantVocas)
        btMoveToJobVocas = findViewById(R.id.btMoveToJobVocas)
        btMoveToCostomVocas = findViewById(R.id.btMoveToCostomVocas)

        if(intent.hasExtra(MainActivity.VOCAS)){
            vocas = intent.getParcelableExtra(MainActivity.VOCAS) as Vocas?
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btMoveToAnimalVocas -> {
                val mIntent = Intent(this@StudyVocas, VocasList::class.java)
                mIntent.putExtra(ANIMAL_VOCAS, vocas?.getAnimal())

                startActivity(mIntent)
            }
        }
    }
}