package com.kavarera.practicecomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavarera.practicecomposebasic.ui.theme.PracticeComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageArticle(
                        title = getString(R.string.article_title),
                        desc1 = getString(R.string.description_1) ,
                        desc2 = getString(R.string.description_2) )
                }
            }
        }
    }
}

@Composable
fun ComposableQuandrant(){
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)){
            InfoCard(title = stringResource(R.string.text_composable),
                description = stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
                backgroundColor =Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            InfoCard(title = stringResource(R.string.image_composable),
                description = stringResource(R.string.creates_a_composable_that_lays_out_and_draws_a_given_painter_class_object),
                backgroundColor =Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)){
            InfoCard(title = stringResource(R.string.row_composable),
                description = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_horizontal_sequence),
                backgroundColor =Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )

            InfoCard(title = stringResource(R.string.column_composable),
                description = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence),
                backgroundColor =Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun InfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier=Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text=title,
            modifier = Modifier.padding(bottom=16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text=description,
            textAlign= TextAlign.Justify
        )
    }
}


@Composable
fun TaskComplete(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = "All task completed",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text="Nice work!",
            textAlign= TextAlign.Center
        )
    }
}

@Composable
fun PageArticle(title: String,
                desc1: String,
                desc2: String,
                modifier: Modifier=Modifier
){
    Column(
        verticalArrangement = Arrangement.Top
    ) {
        BannerImage()
        TitleText(text = title)
        DescriptionText(description = desc1)
        DescriptionText(description = desc2)

    }
}

@Composable
fun BannerImage(){
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = null,
        )
}

@Composable
fun TitleText(text: String){
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun DescriptionText(description: String){
    Text(
        text = description,
        fontSize = 16.sp,
        textAlign = TextAlign.Justify
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PracticeComposeBasicTheme {
        ComposableQuandrant()
    }
}