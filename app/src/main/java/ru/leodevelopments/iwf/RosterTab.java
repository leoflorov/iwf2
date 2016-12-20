package ru.leodevelopments.iwf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;

import leodevelopments.iwf.R;

import static android.R.attr.contextClickable;
import static android.R.attr.id;


public class RosterTab extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.superstars_layout, container, false);

//        Context c = getActivity().getApplicationContext();
//        Picasso.with(c).load("http://www.wrestlingfederation.ru/roster/mini/lokomotiv.jpg")
//                .fit().into(img);
//        GridView gridview = (GridView) view.findViewById(R.id.gridview);
  return view;
    }

}