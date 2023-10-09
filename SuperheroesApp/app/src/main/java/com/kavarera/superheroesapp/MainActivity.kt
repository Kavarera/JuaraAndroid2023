package com.kavarera.superheroesapp

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavarera.superheroesapp.model.Hero
import com.kavarera.superheroesapp.model.heroes
import com.kavarera.superheroesapp.ui.theme.SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroesApp(modifier: Modifier=Modifier){
    Scaffold(
        topBar = { TopBar() }
    ) {p->
        LazyColumn(contentPadding = p){
            items(heroes){
                HeroItem(
                    hero=it,
                    modifier =Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(text = stringResource(id = hero.name), style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                ))
                Text(
                    text= stringResource(id = hero.description),
                    style = TextStyle(
                        fontSize = 12.sp,
                    ),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            HeroIcon(heroIcon = hero.image)

        }
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroIcon:Int,
    modifier: Modifier=Modifier
){
    Image(painter = painterResource(id = heroIcon), contentDescription ="hero icon",
        modifier= modifier
            .size(100.dp)
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier=Modifier){
CenterAlignedTopAppBar(title = {
    Text(text = "SuperHeroes")
}
, modifier=modifier)
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    SuperheroesAppTheme {
        SuperHeroesApp()
    }
}