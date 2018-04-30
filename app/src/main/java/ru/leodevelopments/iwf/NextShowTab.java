package ru.leodevelopments.iwf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import leodevelopments.iwf.R;

public class NextShowTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.next_show, null);
        WebView lv = (WebView) view.findViewById(R.id.webview);
        lv.loadUrl("http://resling.tv");
        return view;
    }
}

