package com.kavarera.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavarera.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                LemonadeAppTheme {
                    LemonApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp(){
    var currentStep by remember{mutableStateOf(1)}
    var limitSqueezeLemon by remember{ mutableStateOf(0) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Lemonade")
                        },
                colors=TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )

                )
        }
    ) { innerPadding->
        Surface(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                when(currentStep){
                    1->{
                        Text(stringResource(R.string.tap_the_lemon_tree_to_select_a_lemon))
                        Spacer(Modifier.height(32.dp))
                        Image(
                            painter = painterResource(id = R.drawable.lemon_tree),
                            contentDescription = stringResource(R.string.lemon_tree),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    limitSqueezeLemon = (2..6).random()
                                    currentStep = 2
                                }
                        )
                    }
                    2->{
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ){
                            Text(text = stringResource(R.string.keep_tapping_the_lemon_to_squeeze_it))
                            Spacer(modifier = Modifier.height(32
                                .dp))
                            Image(
                                painter = painterResource(R.drawable.lemon_squeeze),
                                contentDescription = stringResource(R.string.lemon),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clickable {
                                        limitSqueezeLemon--
                                        if(limitSqueezeLemon==0){
                                            currentStep=3
                                        }
                                    }
                            )
                        }
                    }
                    3->{
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ){
                            Text(text = stringResource(R.string.tap_the_lemonade_to_drink_it))
                            Spacer(modifier = Modifier.height(32
                                .dp))
                            Image(
                                painter = painterResource(R.drawable.lemon_drink),
                                contentDescription = stringResource(R.string.glass_of_lemonade),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clickable {
                                        currentStep = 4
                                    }
                            )
                        }
                    }
                    else->{
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ){
                            Text(text = stringResource(R.string.tap_the_empty_glass_to_start_again) )
                            Spacer(modifier = Modifier.height(32
                                .dp))
                            Image(
                                painter = painterResource(R.drawable.lemon_restart),
                                contentDescription = stringResource(R.string.empty_glass),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clickable {
                                        currentStep = 1
                                    }
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(name: String, onStartClicked: () -> Unit) {
    Column {
        Text(text = "Welcome $name!")
        Button(
            onClick = onStartClicked
        ) {
            Text(text = "Start")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeAppTheme {
        LemonApp()
    }
}