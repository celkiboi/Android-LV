package hr.ferit.tomislavcelic.myapplication.data

import androidx.annotation.DrawableRes
import hr.ferit.tomislavcelic.myapplication.data.Ingredient

data class Recipe(
    var id: String = "",
    val image: String = "",
    val title: String = "",
    val category: String = "",
    val cookingTime: String = "",
    val energy: String = "",
    val rating: String = "",
    val description: String = "",
    val reviews: String = "",
    val ingredients: List<Ingredient> = emptyList(),
    var isFavorited: Boolean = false )