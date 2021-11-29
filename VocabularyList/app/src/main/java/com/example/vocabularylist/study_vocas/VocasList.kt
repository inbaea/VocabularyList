package com.example.vocabularylist.study_vocas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabularylist.R
import com.example.vocabularylist.adapters.StudyVocasListAdapter
import com.example.vocabularylist.vocas.VocaModel
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

        setVocasList()
    }

    private fun setVocasList(){
        var vocaList : ArrayList<VocaModel> = ArrayList()

        when {
            intent.hasExtra(StudyVocas.ANIMAL_VOCA_KEY) -> {
                vocaList = vocas.getAnimalVocas()
                supportActionBar?.title = "동물"
            } intent.hasExtra(StudyVocas.BODY_VOCA_KEY) -> {
                //vocaList = vocas.getBodyVocas()
                supportActionBar?.title = "신체"
            } intent.hasExtra(StudyVocas.FLAG_VOCA_KEY) -> {
                vocaList = vocas.getFlagVocas()
                supportActionBar?.title = "국기"
            } intent.hasExtra(StudyVocas.COSTOM_VOCA_KEY) -> {
                vocaList = vocas.getCustomVocas()
                supportActionBar?.title = "나만의 단어"
            }
        }

        val studyVocasListAdapter = StudyVocasListAdapter(this, vocaList)
        rvPictureListOfTopics.adapter = studyVocasListAdapter
        rvPictureListOfTopics.layoutManager = GridLayoutManager(this, 2)

        studyVocasListAdapter.setOnClickListener(object : StudyVocasListAdapter.OnClickListener{
            override fun onClick(voca: VocaModel) {
                val voca = VocaCard(voca, vocas.getBookmarkVocas())
                voca.show(supportFragmentManager, "Animal_Voca")
            }
        })

        studyVocasListAdapter.setOnClickListener(object : StudyVocasListAdapter.OnClickListener{
            override fun onClick(voca: VocaModel) {
                val voca = VocaCard(voca, vocas.getBookmarkVocas())
                voca.show(supportFragmentManager, "Flag_Voca")
            }
        })
    }
}