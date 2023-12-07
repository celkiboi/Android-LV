package hr.ferit.tomislavcelic.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import hr.ferit.tomislavcelic.myapplication.data.recipes
import hr.ferit.tomislavcelic.myapplication.ui.RecipeDetailsScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*
            FeritTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    /*RecipesScreen()*/
                    RecipeDetailsScreen(recipe = recipes[0])
                }
            }
            */
            NavigationController()
        }
    }
}