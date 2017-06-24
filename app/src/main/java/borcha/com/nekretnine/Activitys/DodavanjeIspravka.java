package borcha.com.nekretnine.Activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import borcha.com.nekretnine.R;

/**
 * Created by androiddevelopment on 24.6.17..
 */

public class DodavanjeIspravka extends AppCompatActivity {


    public static final int TIP_OPERACIJE_NOVO = 0;
    public static final int TIP_OPERACIJE_ISPRAVKA = 1;

    int tipOepracije=0;
    int idNekretnine=0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodavanje_ispravka_nekretnine);

        tipOepracije=getIntent().getIntExtra("tip_ope",0);
        idNekretnine=getIntent().getIntExtra("id_nek",0);



    }
}
