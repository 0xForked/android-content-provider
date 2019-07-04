package id.aasumitro.made.favorite

import android.annotation.SuppressLint
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.aasumitro.made.favorite.Constant.TABLE_MOVIE_COLUMN_BACKDROP
import id.aasumitro.made.favorite.Constant.TABLE_MOVIE_COLUMN_ID
import id.aasumitro.made.favorite.Constant.TABLE_MOVIE_COLUMN_OVERVIEW
import id.aasumitro.made.favorite.Constant.TABLE_MOVIE_COLUMN_POPULARITY
import id.aasumitro.made.favorite.Constant.TABLE_MOVIE_COLUMN_POSTER
import id.aasumitro.made.favorite.Constant.TABLE_MOVIE_COLUMN_RELEASE
import id.aasumitro.made.favorite.Constant.TABLE_MOVIE_COLUMN_TITLE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.component_empty.*
import android.content.Intent
import android.widget.Toast


class MainActivity : AppCompatActivity(), MovieClickListener {

    private val mMovies = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchFavorite()
        initRecyclerView()
        initListener()
        initSwipeRefresh()
    }

    @SuppressLint("Recycle")
    private fun fetchFavorite() {
        val mCursor = contentResolver.query(
            Constant.CONTENT_URI,
            null,
            null,
            null,
            null
        ) as Cursor

        if (mCursor.moveToFirst()) {
            do {
                val id = mCursor.getLong(mCursor.getColumnIndexOrThrow(TABLE_MOVIE_COLUMN_ID))
                val title = mCursor.getString(mCursor.getColumnIndexOrThrow(TABLE_MOVIE_COLUMN_TITLE))
                val popularity = mCursor.getFloat(mCursor.getColumnIndexOrThrow(TABLE_MOVIE_COLUMN_POPULARITY))
                val posterPath = mCursor.getString(mCursor.getColumnIndexOrThrow(TABLE_MOVIE_COLUMN_POSTER))
                val backdropPath = mCursor.getString(mCursor.getColumnIndexOrThrow(TABLE_MOVIE_COLUMN_BACKDROP))
                val overview = mCursor.getString(mCursor.getColumnIndexOrThrow(TABLE_MOVIE_COLUMN_OVERVIEW))
                val releaseDate = mCursor.getString(mCursor.getColumnIndexOrThrow(TABLE_MOVIE_COLUMN_RELEASE))
                mMovies.add(Movie(id,title,popularity,posterPath,backdropPath,overview,releaseDate))
            } while (mCursor.moveToNext())
        }

        mCursor.close()
    }

    private fun initRecyclerView() {
        movie_recycler_view.setHasFixedSize(true)
        val mLayoutManager : RecyclerView.LayoutManager =
            GridLayoutManager(this, 2)
        movie_recycler_view.layoutManager = mLayoutManager
        movie_recycler_view.itemAnimator = DefaultItemAnimator()

        if (mMovies.isEmpty()) {
            movie_recycler_view.visibility = View.GONE
            layout_error.visibility = View.VISIBLE
        } else {
            movie_recycler_view.visibility = View.VISIBLE
            layout_error.visibility = View.GONE
            movie_recycler_view.adapter = MovieAdapter(mMovies, this)
        }
    }

    private fun initSwipeRefresh() {
        swipe_refresh.setOnRefreshListener {
            mMovies.clear()
            fetchFavorite()
            initRecyclerView()
            swipe_refresh.isRefreshing = false
        }
    }

    private fun initListener() {
        open_damovie.setOnClickListener {
            val launchIntent =
                packageManager
                    .getLaunchIntentForPackage(
                        "id.aasumitro.made"
                    ) as Intent
            startActivity(launchIntent)
        }
    }

    override fun onMovieSelected(movie: Movie?) {
//        val launchIntent = Intent()
//        launchIntent.component = ComponentName(
//            "id.aasumitro.made",
//            "id.aasumitro.made.ui.detail.DetailActivity"
//        )
//        launchIntent.let {
//            launchIntent.putExtra(DATA_ENTITY, MOVIE)
//            launchIntent.putExtra(EXTRA_DATA, movie)
//            startActivity(it)
//        }

        Toast.makeText(this, movie?.title, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val DATA_ENTITY = "DATA_ENTITY"
        const val EXTRA_DATA = "EXTRA_DATA"
        const val MOVIE = "MOVIE"
    }

}
