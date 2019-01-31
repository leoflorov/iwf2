package ru.leodevelopments.iwf;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;


//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.OnMapReadyCallback;

import leodevelopments.iwf.R;

//import static android.support.design.R.styleable.View;

//public class ContactsActivity extends AppCompatActivity implements OnMapReadyCallback {
////
////    public int mLockManger;
////
////    @Override
////    protected void onCreate(@Nullable final Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.contacts_layout);}
////
////        public void onClickCardView (View view) {
////            Uri uri = Uri.parse("http://www.resling.tv"); // missing 'http://' will cause crashed
////            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////            startActivity(intent);
////
////            LocationManager mLockManager = (LocationManager) getSystemService(LOCATION_SERVICE);
////
////            final MapFragment mapFragment = (MapFragment) getFragmentManager()
////                    .findFragmentById(R.id.map);
////            mapFragment.getMapAsync(this);
////        }
////    @Override
////    public void onMapReady(GoogleMap googleMap) {
////
////        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
////            // TODO: Consider calling
////            //    ActivityCompat#requestPermissions
////            // here to request the missing permissions, and then overriding
////            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
////            //                                          int[] grantResults)
////            // to handle the case where the user grants the permission. See the documentation
////            // for ActivityCompat#requestPermissions for more details.
////            return;
////        }
////        googleMap.setMyLocationEnabled(true);
////
////        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
////
////        googleMap.getUiSettings().setZoomControlsEnabled(true);
////
////    }
////
////    private int dpToPx() {
////        Resources r = getResources();
////        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, r.getDisplayMetrics()));
////    }
////}