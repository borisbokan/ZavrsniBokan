package borcha.com.nekretnine.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import borcha.com.nekretnine.R;
import borcha.com.nekretnine.myAdapters.AdapterNekretnina;
import borcha.com.nekretnine.myDB.MySqlNekretnine.MySqlNekretnine;
import borcha.com.nekretnine.myDB.dbmodel.Nekretnina;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView lsLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inDodajNekretninu=new Intent(getBaseContext(),DodavanjeIspravka.class);
                inDodajNekretninu.putExtra("tip_ope",DodavanjeIspravka.TIP_OPERACIJE_NOVO);

                startActivity(inDodajNekretninu);


//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //***********************************
        lsLista=(ListView)findViewById(R.id.lsLista);

        puniInicijalnePodatek();



    }

    private void puniInicijalnePodatek() {

        MySqlNekretnine dbNekretnine=new MySqlNekretnine(this);
        List<Nekretnina> lista=dbNekretnine.getSveNekretnine();
        AdapterNekretnina adNekretnine=new AdapterNekretnina(this,lista);
        lsLista.setAdapter(adNekretnine);


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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_svenekretnine) {



            Toast.makeText(this,"Klik sve nekretnine",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_settings) {
            Intent settings=new Intent(this,SettingsActivity.class);
            startActivity(settings);

            Toast.makeText(this,"Klik sve nekretnine",Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
