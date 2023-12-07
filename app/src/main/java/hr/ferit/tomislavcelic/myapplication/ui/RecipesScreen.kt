@file:Suppress("DEPRECATION")

package hr.ferit.tomislavcelic.myapplication.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.navArgument
import hr.ferit.tomislavcelic.myapplication.R
import hr.ferit.tomislavcelic.myapplication.Routes
import hr.ferit.tomislavcelic.myapplication.data.recipes
import hr.ferit.tomislavcelic.myapplication.ui.theme.DarkGray
import hr.ferit.tomislavcelic.myapplication.ui.theme.LightGray
import hr.ferit.tomislavcelic.myapplication.ui.theme.Pink
import hr.ferit.tomislavcelic.myapplication.ui.theme.Purple500
import hr.ferit.tomislavcelic.myapplication.ui.theme.White


@Composable fun RecipesScreen(
    navigation: NavController
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ScreenTitle(
            title="What would you like to cook today?",
            subtitle="Good morning, Tomislav"
        )
        SearchBar(
            iconResource = R.drawable.ic_search,
            labelText = "Search"
        )
        RecipeCategories()
        RecipeHeader()
        RecipesContainer(navigation)
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            iconResource = R.drawable.ic_plus,
            text = "Add new recipe"
        )
    }
}

@Composable fun ScreenTitle(
    title: String, subtitle: String
) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = subtitle, style = TextStyle(
                color = Color.Magenta,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            ), modifier = Modifier.padding(horizontal = 15.dp)
        )
        Text(
            text = title,
            style = TextStyle(color = Color.Black, fontSize = 26.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText: String,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        placeholderColor = DarkGray,
        textColor = DarkGray,
        unfocusedLabelColor = DarkGray,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
) {
    val searchInput = remember { mutableStateOf("") }
    TextField(
        value = searchInput.value,
        onValueChange = { searchInput.value = it },
        label = {
            Text(labelText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = labelText,
                tint = DarkGray,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable fun RecipeCategories() {
    val currentActiveButton = remember { mutableStateOf(0) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)
    ) {
        TabButton(
            text = "All",
            isActive = currentActiveButton.value == 0,
            modifier = Modifier.weight(1f)
        ) {
            currentActiveButton.value = 0
        }
        TabButton(
            text = "Breakfast",
            isActive = currentActiveButton.value == 1,
            modifier = Modifier.weight(1f)
        ) {
            currentActiveButton.value = 1
        }
        TabButton(
            text = "Lunch",
            isActive = currentActiveButton.value == 2,
            modifier = Modifier.weight(1f)
        ) {
            currentActiveButton.value = 2
        }
    }
}

@Composable fun TabButton(
    text: String, isActive: Boolean, modifier: Modifier, onClick: () -> Unit
) {
    Button(shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if (isActive) ButtonDefaults.buttonColors(
            contentColor = White, containerColor = Pink
        ) else ButtonDefaults.buttonColors(contentColor = DarkGray, containerColor = LightGray),
        modifier = modifier,
        onClick = { onClick() }) {
        Text(text)
    }
}

@Composable fun IconButton(
    @DrawableRes iconResource: Int,
    text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = Pink)
) {
    Button(
        onClick = { },
        colors = colors,
    ) {
        Row {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = text
            )
            Spacer(Modifier.width(2.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            )
        }
    }
}

@Composable fun Chip(
    text: String,
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Magenta,
) {
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = textColor,
                fontSize = 12.sp
            )
        )
    }
}

@Composable
fun RecipeHeader() {
    val headerString = ""
    Row(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Text(
            text = headerString, style = MaterialTheme.typography.bodySmall.copy(
                color = DarkGray
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Filled.Face, contentDescription = "Recipes")
    }
}

@Composable
fun RecipesContainer(navigation: NavController) {
    LazyRow {
        item { Spacer(modifier = Modifier.width(16.dp)) }
        item { RecipeCard(0, navigation) }
        item { Spacer(modifier = Modifier.width(8.dp)) }
        item { RecipeCard(1, navigation) }
        item { Spacer(modifier = Modifier.width(8.dp)) }
        item { RecipeCard(2, navigation) }
        item { Spacer(modifier = Modifier.width(8.dp)) }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(
    id: Int,
    navigation: NavController
) {
    @DrawableRes val imageResource: Int = recipes[id].image
    val title: String = recipes[id].title
    Card(
        modifier = Modifier
            .height(326.dp)
            .width(215.dp)
            .clip(RoundedCornerShape(12.dp)),
        onClick = {
            navigation.navigate(
                route = Routes.getRecipeDetailsPath(id)
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(painter = painterResource(id = imageResource),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.Bottom
            ){
                Text( text = title,
                    style = TextStyle(
                        color = White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Row(){
                    Chip(text = "30 min",backgroundColor = White ,textColor = Pink )
                    Spacer(modifier = Modifier.width(4.dp))
                    Chip(text = " 4 ingredients", backgroundColor = White, textColor = Pink)
                }
            }
        }
    }
}