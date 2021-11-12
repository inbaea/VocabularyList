package com.example.vocabularylist.study_vocas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.vocabularylist.R
import com.example.vocabularylist.vocas.AnimalModel

class Voca(private val voca: AnimalModel) : DialogFragment(), View.OnClickListener {
    private lateinit var ivStudyCloseVoca : ImageView
    private lateinit var ivStudyVoca : ImageView
    private lateinit var tvStudyVoca : TextView

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
        tvStudyVoca = view.findViewById(R.id.tvStudyVoca)

        if(voca as? AnimalModel != null){
            ivStudyVoca.setImageDrawable(ContextCompat.getDrawable(requireContext(), voca.src))
            tvStudyVoca.text = voca.name
        }

        ivStudyCloseVoca.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivStudyCloseVoca -> {
                dismiss()
            }
        }
    }
}