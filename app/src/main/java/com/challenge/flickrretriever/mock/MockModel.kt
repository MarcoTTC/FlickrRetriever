package com.challenge.flickrretriever.mock

import android.net.Uri
import com.challenge.flickrretriever.model.Thumb

val mockThumb = Thumb(
    uri = Uri.parse(
        "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg"
    ),
    contentDescription = ""
)
val mockThumbList = (1..15).map {
    mockThumb
}