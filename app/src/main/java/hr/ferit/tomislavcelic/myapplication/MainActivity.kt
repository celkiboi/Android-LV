package hr.ferit.tomislavcelic.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import hr.ferit.tomislavcelic.myapplication.data.RecipeViewModel
import hr.ferit.tomislavcelic.myapplication.ui.RecipeDetailsScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = RecipeViewModel()
        setContent {
            NavigationController(viewModel)
        }
    }
}