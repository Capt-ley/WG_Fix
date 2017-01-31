package mydemoapp.com.mydemoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String apartmentname;
    TextView apartment;
    ImageView building;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        apartmentname = intent.getExtras().getString("apartment");
        setTitle("Dashboard");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        apartment = (TextView) findViewById(R.id.textView2);
        building = (ImageView) findViewById(R.id.imagebuilding);
        building.setVisibility(View.VISIBLE);
        apartment.setVisibility(View.VISIBLE);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





    }

    @Override
    public void onResume(){
        super.onResume();

        apartment.setText("Register your feedback on the apartment  "+apartmentname);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.livingroom) {

            Intent intent = new Intent(getApplicationContext(), LivingRoomActivity.class);
            startActivity(intent);


        } else if (id == R.id.studentroom) {

            Intent intent = new Intent(getApplicationContext(), StudenRoomActivity.class);
            startActivity(intent);



        } else if (id == R.id.bathroom) {

            Intent intent = new Intent(getApplicationContext(), BathRoomActivity.class);
            startActivity(intent);


        }
        else if (id == R.id.camera) {

            Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
            startActivity(intent);


        }

        else if (id == R.id.kitchen) {


            Intent intent = new Intent(getApplicationContext(), KitchenActivity.class);
            startActivity(intent);

        }

        else if (id == R.id.translator) {
            building.setVisibility(View.GONE);
            apartment.setVisibility(View.GONE);

            fragment= new Webfragment();

        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
