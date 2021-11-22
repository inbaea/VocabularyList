package com.example.vocabularylist.bookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabularylist.R
import com.example.vocabularylist.adapters.BookmarkAdapter
import com.example.vocabularylist.adapters.StudyVocasListAdapter
import com.example.vocabularylist.study_vocas.VocaCard
import com.example.vocabularylist.vocas.VocaModel
import com.example.vocabularylist.vocas.Vocas

class Bookmark : AppCompatActivity() {
    private lateinit var toolbar : Toolbar
    private lateinit var rvPictureListOfBookmark : RecyclerView
    private val vocas = Vocas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        toolbar = findViewById(R.id.toolbar_bookmark)
        rvPictureListOfBookmark = findViewById(R.id.rvPictureListOfBookmark)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        setBookmarkVocas()
    }

    private fun setBookmarkVocas(){
        val bookmarkAdapter = BookmarkAdapter(this, vocas.getBookmarkVocas())
        rvPictureListOfBookmark.adapter = bookmarkAdapter
        rvPictureListOfBookmark.layoutManager = GridLayoutManager(this, 2)

        bookmarkAdapter.setOnClickListener(object : BookmarkAdapter.OnClickListener{
            override fun onClick(voca: VocaModel) {
                val voca = VocaCard(voca, vocas.getBookmarkVocas())
                voca.show(supportFragmentManager, "Animal_Voca")
            }
        })
    }
}