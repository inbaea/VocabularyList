package com.example.vocabularylist.study_vocas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabularylist.R
import com.example.vocabularylist.adapters.StudyAnimalVocasListAdapter
import com.example.vocabularylist.vocas.AnimalModel
import com.example.vocabularylist.vocas.Vocas

class VocasList : AppCompatActivity() {
    private lateinit var toolbar : Toolbar
    private lateinit var rvPictureListOfTopics : RecyclerView
    private val vocas = Vocas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_vocas_list)

        toolbar = findViewById(R.id.toolbar_vocas_list)
        rvPictureListOfTopics = findViewById(R.id.rvPictureListOfTopics)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        setAnimalVocasList()
    }

    private fun setAnimalVocasList(){
        val animalVocas = vocas.getAnimal()

        val studyAnimalVocasListAdapter = StudyAnimalVocasListAdapter(this, animalVocas)
        rvPictureListOfTopics.adapter = studyAnimalVocasListAdapter
        rvPictureListOfTopics.layoutManager = GridLayoutManager(this, 2)

        studyAnimalVocasListAdapter.setOnClickListener(object : StudyAnimalVocasListAdapter.OnClickListener{
            override fun onClick(animal: AnimalModel) {
                val voca = Voca(animal)
                voca.show(supportFragmentManager, "Animal_Voca")
            }
        })
    }
}