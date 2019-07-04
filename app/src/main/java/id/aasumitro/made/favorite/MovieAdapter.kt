package id.aasumitro.made.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by A. A. Sumitro on 04/07/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class MovieAdapter (
    private val data: ArrayList<Movie>,
    private val listener: MovieClickListener
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_placeholder, parent, false)
        return MovieViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(data[position], listener)

    override fun getItemCount(): Int = data.count()

}
