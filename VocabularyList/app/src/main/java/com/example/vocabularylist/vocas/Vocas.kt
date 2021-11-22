package com.example.vocabularylist.vocas

import com.example.vocabularylist.R
import com.example.vocabularylist.add_new_vocabulary.AddNewVocabulary
import com.example.vocabularylist.database.BookmarkDatabaseHandler
import com.example.vocabularylist.database.CustomVocaDatabaseHandler
import com.example.vocabularylist.main.MainActivity

class Vocas {
    val bookmarkDatabaseHandler = BookmarkDatabaseHandler(MainActivity.mContext!!)
    val customDatabaseHandler = CustomVocaDatabaseHandler(MainActivity.mContext!!)

    fun getAnimalVocas() : ArrayList<VocaModel>{
        val animal = ArrayList<VocaModel>()

        animal.add(VocaModel(0, "곰", R.drawable.animal_bear, "", false))
        animal.add(VocaModel(0, "토끼", R.drawable.animal_bunny,  "",false))
        animal.add(VocaModel(0, "고양이", R.drawable.animal_cat, "", false))
        animal.add(VocaModel(0, "개", R.drawable.animal_dog, "", false))
        animal.add(VocaModel(0, "코끼리", R.drawable.animal_elephant, "", false))
        animal.add(VocaModel(0, "기린", R.drawable.animal_giraffe, "", false))
        animal.add(VocaModel(0, "사자", R.drawable.animal_lion, "", false))
        animal.add(VocaModel(0, "양", R.drawable.animal_sheep, "", false))

        return animal
    }


    fun getCustomVocas() : ArrayList<VocaModel>{
        return customDatabaseHandler.getCustomVocaList()
    }

    fun getBookmarkVocas() : ArrayList<VocaModel>{
        return bookmarkDatabaseHandler.getBookmarkVocaList()
    }
}