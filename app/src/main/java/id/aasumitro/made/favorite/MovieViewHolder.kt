package id.aasumitro.made.favorite

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import id.aasumitro.made.favorite.Constant.IMAGE_URI
import id.aasumitro.made.favorite.Constant.POSTER_SIZE
import kotlinx.android.synthetic.main.item_list_placeholder.view.*

/**
 * Created by A. A. Sumitro on 04/07/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class MovieViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(
        movie: Movie,
        listener: MovieClickListener
    ) = with(itemView) {
        Picasso.get()
            .load(IMAGE_URI + POSTER_SIZE + movie.posterPath)
            .placeholder(R.drawable.ic_cloud_download_gray_24dp)
            .error(R.drawable.ic_broken_image_gray_24dp)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(item_list_poster)
        item_list_title.text = movie.title
        item_list_container.setOnClickListener {
            listener.onMovieSelected(movie)
        }
    }

}
