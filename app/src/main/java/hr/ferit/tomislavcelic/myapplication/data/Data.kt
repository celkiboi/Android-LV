package hr.ferit.tomislavcelic.myapplication.data

import hr.ferit.tomislavcelic.myapplication.R

val recipes = listOf(
    Recipe(
        id = 0,
        image = R.drawable.strawberry_pie_1,
        title = "Strawberry Pie",
        category = "Dessert",
        cookingTime = "50 min",
        energy = "620 kcal",
        rating = "4,9",
        description = "This dessert is very tasty and not difficult to prepare. Alsi you can replace strawberries with any other berry you like.",
        reviews = "reviews 0",
        ingredients = listOf(
            Ingredient(
                image = R.drawable.eggs,
                title = "Eggs",
                subtitle = "4"
            ),
            Ingredient(
                image = R.drawable.flour,
                title = "Flour",
                subtitle = "450g"
            ),
            Ingredient(
                image = R.drawable.juice,
                title = "Lemon juice",
                subtitle = "150 g"
            ),
            Ingredient(
                image = R.drawable.mint,
                title = "Mint",
                subtitle = "2 pcs"
            )
        )
    ),
    //Koristio sam ChatGPT da smisli opise za ovo, ostalo sam napravio ja, Tomislav Celic
    Recipe(
        id = 1,
        image = R.drawable.apple_pie,
        title = "Apple Pie",
        category = "Dessert",
        cookingTime = "1 hr 15 min",
        energy = "720 kcal",
        rating = "4.8",
        description = "A classic apple pie with a golden, flaky crust and a delicious apple filling. Perfect for any occasion.",
        reviews = "reviews 0",
        ingredients = listOf(
            Ingredient(
                image = R.drawable.eggs,
                title = "Eggs",
                subtitle = "4"
            ),
            Ingredient(
                image = R.drawable.flour,
                title = "Flour",
                subtitle = "450g"
            ),
            Ingredient(
                image = R.drawable.juice,
                title = "Lemon juice",
                subtitle = "150 g"
            ),
            Ingredient(
                image = R.drawable.mint,
                title = "Mint",
                subtitle = "2 pcs"
            )
        )
    ),
    //Koristio sam ChatGPT da smisli opise za ovo, ostalo sam napravio ja, Tomislav Celic
    Recipe(
        id = 2,
        image = R.drawable.baklava,
        title = "Baklava",
        category = "Dessert",
        cookingTime = "1 hr 30 min",
        energy = "800 kcal",
        rating = "4.7",
        description = "A sweet and nutty pastry made with layers of phyllo dough, chopped nuts, and honey syrup. A delightful Middle Eastern treat.",
        reviews = "reviews 0",
        ingredients = listOf(
            Ingredient(
                image = R.drawable.eggs,
                title = "Eggs",
                subtitle = "4"
            ),
            Ingredient(
                image = R.drawable.flour,
                title = "Flour",
                subtitle = "450g"
            ),
            Ingredient(
                image = R.drawable.juice,
                title = "Lemon juice",
                subtitle = "150 g"
            ),
            Ingredient(
                image = R.drawable.mint,
                title = "Mint",
                subtitle = "2 pcs"
            )
        )
    )
)