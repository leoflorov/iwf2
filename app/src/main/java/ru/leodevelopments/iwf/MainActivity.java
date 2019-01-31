package ru.leodevelopments.iwf;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import leodevelopments.iwf.R;


public class MainActivity extends AppCompatActivity {

    public DrawerLayout mDrawerLayout;
    private static final String TAG = "MyMessage";
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable final Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        /*Создадим тулбар и экшнбар приложения*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            }
            assert actionBar != null;
            actionBar.setDisplayHomeAsUpEnabled(true);


        /* Тут определим боковое меню приложения */
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

            NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();
//                Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                return true;
//                    if (menuItem.getItemId() == R.id.contacts_menu_button) {
//                        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
//                        startActivity(intent);
//                    }

                    if (menuItem.getItemId() == R.id.roster_menu_button) {
                        Intent intent = new Intent(MainActivity.this, RosterActivity.class);
                        startActivity(intent);
                    }

                    if (menuItem.getItemId() == R.id.show_menu_button) {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    return false;
                }
            });

            Log.i(TAG, "OnCreate");

/*            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, BuyTicketsActivity.class);
                    startActivity(intent);
                }
            });*/

/* Добавим новомодный нижниий тулбар для удобной навигации по меню */


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.action_roster:
                             /*   fragment = new RosterFragment();
                                break; и так далее*/
                            case R.id.action_show:

                            case R.id.action_tickets:

                        }
                        return true;
                    }
                });

            DesignDemoPagerAdapter adapter = new DesignDemoPagerAdapter(getSupportFragmentManager());
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
            viewPager.setAdapter(adapter);
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
            tabLayout.setupWithViewPager(viewPager);
        }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class DesignDemoFragment extends Fragment {
        private static final String TAB_POSITION = "tab_position";

        public DesignDemoFragment() {

        }

        public static DesignDemoFragment newInstance(int tabPosition) {
            DesignDemoFragment fragment = new DesignDemoFragment();
            Bundle args = new Bundle();
            args.putInt(TAB_POSITION, tabPosition);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Bundle args = getArguments();
            int tabPosition = args.getInt(TAB_POSITION);

            ArrayList<String> items = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                items.add("Tab #" + tabPosition + " item #" + i);
            }

            View v = inflater.inflate(R.layout.activity_main, container, false);
            RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new RecyclerAdapter(items));

            return v;
        }
    }

    static class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {
        static final int int_items = 2;

        DesignDemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new NextShowTab();
                case 1:
                    return new NewsTab();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "ШОУ";
                case 1:
                    return "НОВОСТИ";
            }

            return null;

        }
    }
}
