package borcha.com.nekretnine.Activitys;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import borcha.com.nekretnine.R;
import borcha.com.nekretnine.myDB.MySqlNekretnine.MySqlNekretnine;
import borcha.com.nekretnine.myDB.dbmodel.Nekretnina;

/**
 * Created by androiddevelopment on 24.6.17..
 */

public class DodavanjeIspravka extends AppCompatActivity implements View.OnClickListener {


    public static final int TIP_OPERACIJE_NOVO = 0;
    public static final int TIP_OPERACIJE_ISPRAVKA = 1;

    int tipOepracije=0;
    int idNekretnine=0;
    Nekretnina nekretnina;

    EditText etxtnaziv,etxtOpis,etxtAdresa,etxtBrojtel,etxtKvadratura,etxtBrojSoba,etxtcena;
    private Button btnOdustajem,btnSnimi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodavanje_ispravka_nekretnine);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idNekretnine=getIntent().getIntExtra("id_nek",0);
        tipOepracije=getIntent().getIntExtra("id_ope",0);


        if(idNekretnine!=0){
            podesiNekretninuPoId(idNekretnine);
        }



        tipOepracije=getIntent().getIntExtra("tip_ope",0);
        idNekretnine=getIntent().getIntExtra("id_nek",0);
        etxtnaziv=(EditText)findViewById(R.id.etxtNaziv_unoisp);
        etxtOpis=(EditText)findViewById(R.id.etxtNaziv_unoisp);
        etxtAdresa=(EditText)findViewById(R.id.etxtNaziv_unoisp);
        etxtBrojtel=(EditText)findViewById(R.id.etxtNaziv_unoisp);
        etxtKvadratura=(EditText)findViewById(R.id.etxtNaziv_unoisp);
        etxtBrojSoba=(EditText)findViewById(R.id.etxtNaziv_unoisp);
        etxtcena=(EditText)findViewById(R.id.etxtNaziv_unoisp);

        btnOdustajem=(Button)findViewById(R.id.btnOdustajem_unoisp);
        btnSnimi=(Button)findViewById(R.id.btnOdustajem_unoisp);

        btnOdustajem.setOnClickListener(this);
        btnSnimi.setOnClickListener(this);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalji,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_obrisi:

                return super.onOptionsItemSelected(item);


            case R.id.action_prepravi:

                return super.onOptionsItemSelected(item);



            case R.id.action_dodajsliku:

                return super.onOptionsItemSelected(item);

        }

        return super.onOptionsItemSelected(item);

    }

    private void podesiNekretninuPoId(int _idNekr) {

        MySqlNekretnine dbnekret=new MySqlNekretnine(this);
        nekretnina=dbnekret.getNekretninaPoId(_idNekr);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.btnOdustajem_unoisp:
                finish();
                break;


            case R.id.btnSnimi_unoisp:

                DialogSnimanja();

                break;


            default:

                break;


        }

    }

    private void DialogSnimanja() {

        final AlertDialog.Builder mojdilaog=new AlertDialog.Builder(this);
        mojdilaog.setTitle("Snimanje/Ispravka");
        mojdilaog.setMessage("Da li ste sigurni u snimanje nekretnine");

        mojdilaog.setPositiveButton("Da", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                nekretnina=new Nekretnina();
                nekretnina.setNaziv(etxtnaziv.getText().toString());
                nekretnina.setOpis(etxtOpis.getText().toString());
                nekretnina.setAdresa(etxtAdresa.getText().toString());
                nekretnina.setBrojTelefona(etxtBrojtel.getText().toString());
                nekretnina.setBrojSoba(Integer.valueOf(etxtBrojSoba.getText().toString()));
                nekretnina.setKvadrata(Integer.valueOf(etxtKvadratura.getText().toString()));
                nekretnina.setCena(Float.valueOf(etxtcena.getText().toString()));

                MySqlNekretnine dbnekretnina=new MySqlNekretnine(getBaseContext());
                dbnekretnina.snimiNovoNekretnina(nekretnina);

            }
        }).setNegativeButton("Ne", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).show();


    }
}
