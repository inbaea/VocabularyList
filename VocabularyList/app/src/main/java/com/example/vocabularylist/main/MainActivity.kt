package com.example.vocabularylist.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.vocabularylist.R
import com.example.vocabularylist.study_vocas.StudyVocas


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btMoveToStudyVocas : Button
    private lateinit var btMoveToReviewVocas : Button
    private lateinit var btMoveToBookmark : Button
    private lateinit var btMoveToAddNewVocabulary : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMoveToStudyVocas = findViewById(R.id.btMoveToStudyVocas)
        btMoveToReviewVocas = findViewById(R.id.btMoveToReviewVocas)
        btMoveToBookmark = findViewById(R.id.btMoveToBookmark)
        btMoveToAddNewVocabulary = findViewById(R.id.btMoveToAddNewVocabulary)

        btMoveToStudyVocas.setOnClickListener(this)
        btMoveToReviewVocas.setOnClickListener(this)
        btMoveToBookmark.setOnClickListener(this)
        btMoveToAddNewVocabulary.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btMoveToStudyVocas -> {
                val mIntent = Intent(this@MainActivity, StudyVocas::class.java)
                startActivity(mIntent)
            }

            R.id.btMoveToReviewVocas -> {

            }

            R.id.btMoveToBookmark -> {

            }

            R.id.btMoveToAddNewVocabulary -> {

            }
        }
    }
}