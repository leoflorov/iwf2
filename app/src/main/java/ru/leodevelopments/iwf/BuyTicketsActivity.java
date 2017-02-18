package ru.leodevelopments.iwf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import leodevelopments.iwf.R;

public class BuyTicketsActivity extends Activity {

    public void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.buytickets_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyTicketsActivity.this, RosterActivity.class);
                startActivity(intent);
            }
        });

        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
//                Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                return true;
                if (menuItem.getItemId() == R.id.contacts_menu_button) {
                    Intent intent = new Intent(BuyTicketsActivity.this, RosterActivity.class);
                    startActivity(intent);

                }
                return false;
            }
        });

/*        WebView ticketsWebView = (WebView) findViewById(R.id.webview);
        ticketsWebView.loadUrl("http://wrestlingfederation14-03.ticketforevent.com/ru");
        ticketsWebView.getSettings().setSupportZoom(true);
        ticketsWebView.getSettings().setBuiltInZoomControls(true);*/

    }
}




