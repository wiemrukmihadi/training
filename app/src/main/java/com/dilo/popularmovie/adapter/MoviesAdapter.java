package com.dilo.popularmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dilo.popularmovie.R;
import com.dilo.popularmovie.model.MovieItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Wiem on 6/29/16.
 */
public class MoviesAdapter extends ArrayAdapter<MovieItem> {

    private static final String TAG = MoviesAdapter.class.getSimpleName();
    final String IMAGE_URL = "http://image.tmdb.org/t/p/w185";

    public MoviesAdapter(Context context, List<MovieItem> movies) {
        super(context, R.layout.movie_grid_item, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.movie_grid_item, parent, false);
        MovieItem movieItem = getItem(position);
        String imageUrl = IMAGE_URL + movieItem.getUrlImage();
        double voteValue = movieItem.getVote();

        ImageView ivMovie = (ImageView) view.findViewById(R.id.ivMovie);
        TextView tvVote = (TextView) view.findViewById(R.id.tvVote);

        Picasso.with(getContext()).load(imageUrl).into(ivMovie);

        tvVote.setText(String.valueOf(voteValue));

        return view;
    }
}
