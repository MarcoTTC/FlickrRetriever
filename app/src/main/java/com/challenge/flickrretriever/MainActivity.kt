package com.challenge.flickrretriever

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.challenge.flickrretriever.model.Thumb
import com.challenge.flickrretriever.ui.theme.FlickrRetrieverTheme
import com.challenge.flickrretriever.viewmodel.FlickrRetrieverViewModel

class MainActivity : ComponentActivity() {

    private val flickrRetrieverViewModel: FlickrRetrieverViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlickrRetrieverTheme {
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
fun searchBar(modifier: Modifier = Modifier, value: String = "", onValueChange:(String)->Unit = {}) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@Preview
@Composable
fun searchBarPreview() {
    FlickrRetrieverTheme {
        searchBar()
    }
}

@Composable
fun thumbItem(thumb: Thumb ) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(thumb.uri)
            .build(),
        placeholder = painterResource(id = R.drawable.placeholder),
        contentDescription = ""
    )
}

@Preview(showBackground = true)
@Composable
fun thumbItemPreview() {
    FlickrRetrieverTheme {
        thumbItem(
            Thumb(
                uri = Uri.parse(
                    "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg"
                ),
                contentDescription = ""
            )
        )
    }
}

@Composable
fun thumbsGridLayout(modifier: Modifier = Modifier, thumbList: List<Thumb> = emptyList()) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = modifier
    ) {
        items(thumbList.size) { index ->
            thumbItem(thumbList[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun thumbsGridLayoutPreview() {
    FlickrRetrieverTheme {
        thumbsGridLayout(
            thumbList = (1..15).map {
                Thumb(
                    uri = Uri.parse(
                        "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg"
                    ),
                    contentDescription = ""
                )
            }
        )
    }
}