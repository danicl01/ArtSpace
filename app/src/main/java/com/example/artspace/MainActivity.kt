package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtPictureWithButton()
                }
            }
        }
    }
}

@Composable
fun ArtPictureWithButton(modifier: Modifier = Modifier) {
    var pictureId by remember { mutableStateOf(1) }
    var pictureResource by remember { mutableStateOf(1) }
    var paintName by remember { mutableStateOf("") }
    var paintAuthor by remember { mutableStateOf("") }
    when(pictureId) {
        1 -> {
            pictureResource = R.drawable.guernica
            paintName = stringResource(R.string.picture_1)
            paintAuthor = stringResource(R.string.author_1)
        }
        2 -> {
            pictureResource = R.drawable.el_nacimiento_de_venus
            paintName = stringResource(R.string.picture_2)
            paintAuthor = stringResource(R.string.author_2)
        }
        3 -> {
            pictureResource = R.drawable.la_mona_lisa
            paintName = stringResource(R.string.picture_3)
            paintAuthor = stringResource(R.string.author_3)
        }
        4 -> {
            pictureResource = R.drawable.la_creacion_de_adan
            paintName = stringResource(R.string.picture_4)
            paintAuthor = stringResource(R.string.author_4)
        }
        5 -> {
            pictureResource = R.drawable.la_noche_estrellada
            paintName = stringResource(R.string.picture_5)
            paintAuthor = stringResource(R.string.author_5)
        }
        else -> {
            pictureResource = R.drawable.las_meninas
            paintName = stringResource(R.string.picture_6)
            paintAuthor = stringResource(R.string.author_6)
        }
    }
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(pictureResource),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .background(color = Color.Gray.copy(alpha = 0.3f))
                .padding(16.dp)
                .width(240.dp),
            contentAlignment = Alignment.Center

        ) {
            Column {
                Text(
                    text = paintName,
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = paintAuthor,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Button(onClick = {
                pictureId = if (pictureId != 1) pictureId - 1 else 1
            }
            , modifier.width(120.dp)
            ) {
                Text(stringResource(R.string.previous_button))
            }
            Spacer(modifier = Modifier.width(32.dp))
            Button(onClick = {
                pictureId = if (pictureId == 6) 1 else pictureId + 1
                paintName = ""
            }
                , modifier.width(120.dp)
            ) {
                Text(stringResource(R.string.next_button))
            }
        }
    }

}
