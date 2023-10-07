package com.kavarera.practicebusinesscard

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavarera.practicebusinesscard.ui.theme.PracticeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeBusinessCardTheme {
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

@Composable
fun BusinessCard(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AboutMe(name = stringResource(R.string.rafli_iskandar_kavarera), title = stringResource(R.string.student_freelancer_mobile_dev))
        Spacer(modifier = Modifier.width(20.dp))
        ContactMe(numberPhone = "080808080808", email ="user@example.com" , email2 ="user2@example.com" )
    }
}

@Composable
fun AboutMe(name: String, title: String,modifier: Modifier=Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_profile_user),
            contentDescription = stringResource(R.string.profile_image),
        )
        Text(
            text = name,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = title,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactMe(numberPhone: String,
              email: String,
              email2: String,
              modifier: Modifier=Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Icon(Icons.Rounded.Phone, contentDescription = stringResource(R.string.phone_icon) )
            Text(
                text=numberPhone
            )
        }
        Row {
            Icon(Icons.Rounded.Email, contentDescription = stringResource(R.string.email_icon) )
            Text(
                text=email
            )
        }
        Row {
            Icon(Icons.Rounded.Email, contentDescription = stringResource(R.string.email_icon) )
            Text(
                text=email2
            )
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PracticeBusinessCardTheme {
        BusinessCard()
    }
}