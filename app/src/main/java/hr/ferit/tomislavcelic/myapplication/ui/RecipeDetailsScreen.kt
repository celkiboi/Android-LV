package hr.ferit.tomislavcelic.myapplication.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import hr.ferit.tomislavcelic.myapplication.NavigationController
import hr.ferit.tomislavcelic.myapplication.R
import hr.ferit.tomislavcelic.myapplication.Routes
import hr.ferit.tomislavcelic.myapplication.data.Ingredient
import hr.ferit.tomislavcelic.myapplication.data.Recipe
import hr.ferit.tomislavcelic.myapplication.data.RecipeViewModel
import hr.ferit.tomislavcelic.myapplication.ui.theme.DarkGray
import hr.ferit.tomislavcelic.myapplication.ui.theme.Gray
import hr.ferit.tomislavcelic.myapplication.ui.theme.LightGray
import hr.ferit.tomislavcelic.myapplication.ui.theme.Pink
import hr.ferit.tomislavcelic.myapplication.ui.theme.Purple500
import hr.ferit.tomislavcelic.myapplication.ui.theme.Transparent
import hr.ferit.tomislavcelic.myapplication.ui.theme.White


@Composable
fun RecipeDetailsScreen(
    viewModel: RecipeViewModel,
    navigation: NavController,
    recipe: Recipe
) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        state = scrollState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            TopImageAndBar(recipe.image, navigation, recipe, viewModel)
            ScreenInfo (recipe.title, recipe.category)
            BasicInfo(recipe)
            Description(recipe)
            Servings()
            IngredientsHeader()
            IngredientsList(recipe)
            ShoppingListButton()
            Reviews(recipe)
            OtherRecipes()

        }
    }
}

@Composable
fun IngredientCard(
    iconResource: String,
    title: String,
    subtitle: String
) {
    Column(
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = rememberAsyncImagePainter(model = iconResource),
            contentDescription = title,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .width(70.dp)
                .height(70.dp),
            contentScale = ContentScale.Fit

        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Medium
            )
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall.copy(
                color = DarkGray
            )
        )
    }
}

@Composable
fun Servings() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
    ){
        Text(text = "Servings", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            CircularButton(iconResource = R.drawable.ic_minus)
            Text(
                text = "1",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier
                    .width(45.dp)
                    .padding(horizontal = 5.dp)
            )
            CircularButton(iconResource = R.drawable.ic_plus)
        }
    }
}

@Composable
fun IngredientsHeader() {
    var currentActiveButton by remember { mutableStateOf(0) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)
    ) {
        TabButton(
            text = "Ingredients",
            isActive = currentActiveButton == 0
        ) {
            currentActiveButton = 0
        }
        TabButton(
            text = "Tools",
            isActive = currentActiveButton == 1
        ){
            currentActiveButton = 1
        }
        TabButton("Step", currentActiveButton == 2)
        {
            currentActiveButton = 2
        }
    }
}

@Composable
fun CircularButton(
    @DrawableRes iconResource: Int, color: Color = Gray,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(defaultElevation = 12.dp),
    onClick: () -> Unit = {}
) {
    Button(
        contentPadding = PaddingValues(),
        elevation = elevation,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = color
        ),
        shape = RoundedCornerShape(5.dp), modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
        )
    }
}

@Composable
fun TopImageAndBar(
    coverImage: String,
    navigation: NavController,
    recipe: Recipe,
    viewModel: RecipeViewModel
) {
    Box(
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = coverImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
            ) {

                CircularButton(
                    R.drawable.ic_arrow_back,
                    onClick = {
                        navigation.navigate(Routes.SCREEN_ALL_RECIPES)
                    },
                    color = Pink
                )
                CircularButton(
                    R.drawable.ic_favorite,
                    color = if(recipe.isFavorited) Pink else DarkGray
                ) {
                    recipe.isFavorited = !recipe.isFavorited
                    viewModel.updateData(recipe)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White
                        ),
                        startY = 100f
                    )
                )
                .align(alignment = Alignment.BottomCenter)
        )
    }
}

@Composable
fun ScreenInfo(
    title: String,
    category: String
) {
    Column {
        Text(
            text = category,
            style = TextStyle(
                color = Purple500,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun InfoColumn(
    @DrawableRes iconResource: Int,
    text: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconResource), contentDescription = null,
            tint = Pink,
            modifier = Modifier.height(24.dp)
        )
        Text(text = text, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BasicInfo(recipe: Recipe) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        InfoColumn(R.drawable.ic_clock, recipe.cookingTime)
        InfoColumn(R.drawable.ic_flame, recipe.energy)
        InfoColumn(R.drawable.ic_star, recipe.rating)
    }
}

@Composable
fun Description(
    recipe: Recipe
) {
    Text(
        text = recipe.description,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
    )
}

@Composable
fun <T> EasyGrid(nColumns: Int, items: List<T>, content: @Composable (T) -> Unit) {
    Column(Modifier.padding(16.dp)) {
        for (i in items.indices step nColumns) {
            Row {
                for (j in 0 until nColumns) {
                    if (i + j < items.size) {
                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier.weight(1f)
                        ) {
                            content(items[i + j])
                        }
                    } else {
                        Spacer(Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}

@Composable
fun IngredientsList(
    recipe: Recipe
) {
    EasyGrid(nColumns = 3, items = recipe.ingredients) {
        IngredientCard(it.image, it.title, it.subtitle)
    }
}

@Composable
fun ShoppingListButton() {
    Button(
        onClick = { },
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Add to shopping list", modifier =
            Modifier.padding(8.dp)
        )
    }
}

@Composable
fun Reviews(recipe: Recipe) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(start = 16.dp))
    ) {
        Column {
            Text(text = "Reviews", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
            Text(text = recipe.reviews, color = DarkGray)
        }
        IconButton(
            iconResource = R.drawable.ic_arrow_right,
            text = "See all",
            colors = ButtonDefaults.buttonColors(containerColor = Transparent, contentColor = Pink),
            /*side = 1*/
        )
    }
}

@Composable
fun OtherRecipes() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.strawberry_pie_2),
            contentDescription = "Strawberry Pie",
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.strawberry_pie_3),
            contentDescription = "Strawberry Pie",
            modifier = Modifier
        )
    }
}

@Composable
fun TabButton(
    text: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if(isActive)
            ButtonDefaults.buttonColors(contentColor = White, containerColor = Pink)
        else
            ButtonDefaults.buttonColors(contentColor = DarkGray, containerColor = LightGray),
        modifier = Modifier
            .fillMaxHeight(),
        onClick = { onClick() }
    ) {
        Text(text = text)
    }
}

