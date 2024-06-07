package com.challenge.flickrretriever

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.challenge.flickrretriever.model.Thumb
import com.challenge.flickrretriever.ui.theme.FlickrRetrieverTheme

class MainActivity : ComponentActivity() {
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
fun thumbItem(thumb: Thumb) {

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

@Preview
@Composable
fun thumbsGridLayoutPreview() {
    FlickrRetrieverTheme {
        thumbsGridLayout()
    }
}