package id.aasumitro.made.favorite

import android.net.Uri

/**
 * Created by A. A. Sumitro on 04/07/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

object Constant {

    const val IMAGE_URI = "https://image.tmdb.org/t/p/"
    const val POSTER_SIZE = "w185/"

    private const val TABLE_MOVIE = "dmxxi_movie"

    const val TABLE_MOVIE_COLUMN_ID = "dmxxi_movie_id"
    const val TABLE_MOVIE_COLUMN_TITLE = "dmxxi_movie_TITLE"
    const val TABLE_MOVIE_COLUMN_POPULARITY = "dmxxi_movie_popularity"
    const val TABLE_MOVIE_COLUMN_POSTER = "dmxxi_movie_poster"
    const val TABLE_MOVIE_COLUMN_BACKDROP = "dmxxi_movie_backdrop"
    const val TABLE_MOVIE_COLUMN_OVERVIEW = "dmxxi_movie_overview"
    const val TABLE_MOVIE_COLUMN_RELEASE = "dmxxi_movie_release"

    private const val CONTENT_AUTHORITY = "id.aasumitro.made"

    val CONTENT_URI: Uri =
            Uri.Builder()
                .scheme("content")
                .authority(CONTENT_AUTHORITY)
                .appendPath(TABLE_MOVIE)
                .build()

}
