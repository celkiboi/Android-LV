package hr.ferit.tomislavcelic.myapplication.data

import androidx.annotation.DrawableRes
import hr.ferit.tomislavcelic.myapplication.data.Ingredient

data class Recipe(
    val id: Int,
    @DrawableRes val image: Int,
    val title: String,
    val category: String,
    val cookingTime: String,
    val energy: String,
    val rating: String,
    val description: String,
    val reviews: String,
    val ingredients:List<Ingredient> = listOf()){
}