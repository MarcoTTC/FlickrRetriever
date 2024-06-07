package com.challenge.flickrretriever

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.challenge.flickrretriever.mock.mockThumb
import com.challenge.flickrretriever.mock.mockThumbList
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
                    flickrRetriever()
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
fun thumbItem(modifier: Modifier = Modifier, thumb: Thumb ) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(thumb.uri)
            .build(),
        alignment = Alignment.CenterStart,
        placeholder = painterResource(id = R.drawable.placeholder),
        contentDescription = ""
    )
}

@Preview(showBackground = true)
@Composable
fun thumbItemPreview() {
    FlickrRetrieverTheme {
        thumbItem(
            thumb = mockThumb
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
            thumbItem(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 4.dp,
                        bottom = 4.dp,
                        start = 4.dp,
                        end = 4.dp
                    ),
                thumbList[index]
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun thumbsGridLayoutPreview() {
    FlickrRetrieverTheme {
        thumbsGridLayout(
            thumbList = mockThumbList
        )
    }
}

@Composable
fun flickrRetriever() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        searchBar(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    top = 12.dp,
                    bottom = 6.dp,
                    start = 18.dp,
                    end = 18.dp
                )
        )
        thumbsGridLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    top = 6.dp,
                    bottom = 12.dp,
                    start = 18.dp,
                    end = 18.dp
                ),
            thumbList = mockThumbList
        )
    }
}

@Preview(showBackground = true)
@Composable
fun flickrRetrieverPreview() {
    FlickrRetrieverTheme {
        flickrRetriever()
    }
}