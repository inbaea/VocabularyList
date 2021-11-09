package com.example.vocabularylist.vocas

import android.os.Parcel
import android.os.Parcelable
import com.example.vocabularylist.R
import com.example.vocabularylist.main.MainActivity

open class Vocas() : MainActivity(), Parcelable {
    private val animal = ArrayList<AnimalModel>()

    constructor(parcel: Parcel) : this() {}

    init {
        initAnimalVocas()
    }

    private fun initAnimalVocas(){
        animal.add(AnimalModel("곰", resources.getDrawable(R.drawable.animal_bear, applicationContext.theme)))
        animal.add(AnimalModel("토끼", resources.getDrawable(R.drawable.animal_bunny, applicationContext.theme)))
        animal.add(AnimalModel("고양이", resources.getDrawable(R.drawable.animal_cat, applicationContext.theme)))
        animal.add(AnimalModel("개", resources.getDrawable(R.drawable.animal_dog, applicationContext.theme)))
        animal.add(AnimalModel("코끼리", resources.getDrawable(R.drawable.animal_elephant, applicationContext.theme)))
        animal.add(AnimalModel("기린", resources.getDrawable(R.drawable.animal_giraffe, applicationContext.theme)))
        animal.add(AnimalModel("사자", resources.getDrawable(R.drawable.animal_lion, applicationContext.theme)))
        animal.add(AnimalModel("양", resources.getDrawable(R.drawable.animal_sheep, applicationContext.theme)))
    }

    fun getAnimal() : ArrayList<AnimalModel>{
        return this.animal
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Vocas> {
        override fun createFromParcel(parcel: Parcel): Vocas {
            return Vocas(parcel)
        }

        override fun newArray(size: Int): Array<Vocas?> {
            return arrayOfNulls(size)
        }
    }
}