package hr.ferit.tomislavcelic.myapplication.data

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class RecipeViewModel: ViewModel() {
    private val db = Firebase.firestore
    val recipesData = mutableListOf<Recipe>()
    init {
        fetchDatabaseData()
    }

    fun fetchDatabaseData() {
        db.collection("recipes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result.documents) {
                    val recipe = document.toObject(Recipe::class.java)

                    if (recipe != null) {
                        recipe.id = document.id
                        recipesData.add(recipe)
                    }
                }
            }
    }

    fun updateData(recipe: Recipe) {
        db
            .collection("recipes")
            .document(recipe.id)
            .set(recipe)
    }
}