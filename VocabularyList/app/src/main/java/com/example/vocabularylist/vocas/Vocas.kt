package com.example.vocabularylist.vocas

import com.example.vocabularylist.R

open class Vocas {
    private val animal = ArrayList<AnimalModel>()

    init {
        initAnimalVocas()
    }

    private fun initAnimalVocas(){
        animal.add(AnimalModel("곰", R.drawable.animal_bear))
        animal.add(AnimalModel("토끼", R.drawable.animal_bunny))
        animal.add(AnimalModel("고양이", R.drawable.animal_cat))
        animal.add(AnimalModel("개", R.drawable.animal_dog))
        animal.add(AnimalModel("코끼리", R.drawable.animal_elephant))
        animal.add(AnimalModel("기린", R.drawable.animal_giraffe))
        animal.add(AnimalModel("사자", R.drawable.animal_lion))
        animal.add(AnimalModel("양", R.drawable.animal_sheep))
    }

    fun getAnimal() : ArrayList<AnimalModel>{
        return this.animal
    }
}