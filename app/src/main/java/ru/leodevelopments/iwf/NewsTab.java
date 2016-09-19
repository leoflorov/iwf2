package ru.leodevelopments.iwf;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import leodevelopments.iwf.R;



public class NewsTab extends Fragment {

    public Elements title;
    private ArrayList<String> titleList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_layout, null);

        lv = (ListView) getView().findViewById(R.id.listView1);
        new NewThread().execute();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, titleList);

    }

    public class NewThread extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... arg) {

            Document doc;
            try {
                doc = Jsoup.connect("http://www.wrestlingfederation.ru/").get();
                title = doc.select(".title");
                titleList.clear();
                for (Element titles : title) {
                    titleList.add(titles.text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            lv.setAdapter(adapter);
        }
    }
}
