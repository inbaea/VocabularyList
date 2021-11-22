package com.example.vocabularylist.study_vocas

import android.net.Uri
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.vocabularylist.R
import com.example.vocabularylist.vocas.VocaModel
import com.example.vocabularylist.vocas.Vocas
import java.util.*
import kotlin.collections.ArrayList

class VocaCard(private val voca: VocaModel, private val bookmarks: ArrayList<VocaModel>) : DialogFragment(), View.OnClickListener {
    private lateinit var ivStudyCloseVoca : ImageView
    private lateinit var ivStudyVoca : ImageView
    private lateinit var ivAddDeleteStarButton : ImageView
    private lateinit var tvStudyVoca : TextView
    private lateinit var ivWordSpeech : ImageView

    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.voca_card, container,false)

        ivStudyCloseVoca = view.findViewById(R.id.ivStudyCloseVoca)
        ivStudyVoca = view.findViewById(R.id.ivStudyVoca)
        ivAddDeleteStarButton = view.findViewById(R.id.ivAddDeleteStarButton)
        tvStudyVoca = view.findViewById(R.id.tvStudyVoca)
        ivWordSpeech = view.findViewById(R.id.ivWordSpeech)

        if(voca.srcPath.isEmpty()){
            ivStudyVoca.setImageDrawable(ContextCompat.getDrawable(requireContext(), voca.src))
        } else {
            ivStudyVoca.setImageURI(Uri.parse(voca.srcPath))
        }

        tvStudyVoca.text = voca.word

        tts = TextToSpeech(requireContext()){
            if(it == TextToSpeech.SUCCESS){
                val result = tts?.setLanguage(Locale.KOREAN)
                if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                    Toast.makeText(requireContext(), "Language not supported", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "TTS init failed", Toast.LENGTH_SHORT).show()
            }
        }

        for(bookmark in bookmarks){
            if(voca.srcPath.isEmpty() && voca.src == bookmark.src){
                voca.id = bookmark.id
                voca.isBookmarkClicked = true
                break
            } else if(voca.srcPath.isNotEmpty() && voca.srcPath == bookmark.srcPath){
                voca.id = bookmark.id
                voca.isBookmarkClicked = true
                break
            }
        }

        if(voca.isBookmarkClicked){
            ivAddDeleteStarButton.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_star_24))
        } else {
            ivAddDeleteStarButton.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_star_border_24))
        }

        ivStudyCloseVoca.setOnClickListener(this)
        ivAddDeleteStarButton.setOnClickListener(this)
        ivWordSpeech.setOnClickListener(this)

        return view
    }

    private fun speak(str: String){
        tts?.speak(str, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivStudyCloseVoca -> {
                dismiss()
            } R.id.ivAddDeleteStarButton -> {
                val vocas = Vocas()
                if(voca.isBookmarkClicked){
                    voca.isBookmarkClicked = !voca.isBookmarkClicked

                    ivAddDeleteStarButton.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_star_border_24))

                    vocas.bookmarkDatabaseHandler.deleteVoca(voca)

                    voca.id = 0
                } else {
                    voca.isBookmarkClicked = !voca.isBookmarkClicked

                    ivAddDeleteStarButton.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_star_24))

                    vocas.bookmarkDatabaseHandler.addVoca(voca)
                }
            } R.id.ivWordSpeech -> {
                speak(voca.word)
            }
        }
    }
}