package id.aasumitro.made.favorite

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by A. A. Sumitro on 04/07/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

@Parcelize
data class Movie(
    var id: Long? = null,
    var title: String? = null,
    var popularity: Float? = null,
    var posterPath: String? = null,
    var backdropPath: String? = null,
    var overview: String? = null,
    var releaseDate: String? = null
) : Parcelable