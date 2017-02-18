package ru.leodevelopments.iwf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import leodevelopments.iwf.R;


public class SuperstarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.superstar_page_layout);

        ImageView imageView = (ImageView) findViewById(R.id.deryabin_image_header);
        Picasso.with(this)
                .load("http://www.resling.tv/roster/main/deryabin.png")
                .into(imageView);

    }

}