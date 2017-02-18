package ru.leodevelopments.iwf;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import leodevelopments.iwf.R;

public class RosterActivity extends AppCompatActivity {

    private RosterAdapter adapter;
    private List<Roster> rosterList;
    public DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster_activivty_layout);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
//                Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
//                return true;
                if (menuItem.getItemId() == R.id.contacts_menu_button) {
                    Intent intent = new Intent(RosterActivity.this, ContactsActivity.class);
                    startActivity(intent);

                }
                if (menuItem.getItemId() == R.id.roster_menu_button) {
                    Intent intent = new Intent(RosterActivity.this, RosterActivity.class);
                    startActivity(intent);

                }
                if (menuItem.getItemId() == R.id.show_menu_button) {
                    Intent intent = new Intent(RosterActivity.this, SuperstarActivity.class);
                    startActivity(intent);

                }

                return false;
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.eretic);
        Picasso.with(this)
                .load("http://www.resling.tv/roster/main/deryabin.png")
                .into(imageView);

        initCollapsingToolbar();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        rosterList = new ArrayList<>();
        adapter = new RosterAdapter(this, rosterList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Picasso.with(this).load("http://www.wrestlingfederation.ru/images/logo.jpg")
                    .into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{

                R.id.eretic,
                R.drawable.rave,
                R.drawable.white,
                R.drawable.flexx,
                R.drawable.freddy,
                R.drawable.schykin,
                R.drawable.sallivan,
                R.drawable.joker,
                R.drawable.spike,
                R.drawable.vertigo,
                R.drawable.vulkan};

        Roster a = new Roster("Еретик", 13, covers[0]);
        rosterList.add(a);

        a = new Roster("Рейв", 8, covers[1]);
        rosterList.add(a);

        a = new Roster("Сергей Белый", 11, covers[2]);
        rosterList.add(a);

        a = new Roster("Флекс Блудберг", 12, covers[3]);
        rosterList.add(a);

        a = new Roster("Фредди Мачетте", 14, covers[4]);
        rosterList.add(a);

        a = new Roster("Алексей Щукин", 1, covers[5]);
        rosterList.add(a);

        a = new Roster("Серж Салливан", 11, covers[6]);
        rosterList.add(a);

        a = new Roster("Джокер", 14, covers[7]);
        rosterList.add(a);

        a = new Roster("Спайк Дайсмен", 11, covers[8]);
        rosterList.add(a);

        a = new Roster("Вертиго", 17, covers[9]);
        rosterList.add(a);

        a = new Roster("Вулкан", 17, covers[10]);
        rosterList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
