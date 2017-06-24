package borcha.com.nekretnine.myAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import borcha.com.nekretnine.R;
import borcha.com.nekretnine.myDB.dbmodel.Slika;

/**
 * Created by androiddevelopment on 24.6.17..
 */

public class AdapterSlike extends ArrayAdapter<Slika> {


    Context cont;

    public AdapterSlike(Context context, int resource) {
        super(context, R.layout.lista_stavka_slike);
        cont=context;

    }


    @NonNull
    @Override
    public View getView(int position, View vi, ViewGroup parent) {

        LayoutInflater laIn=(LayoutInflater)cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vi=laIn.inflate(R.layout.lista_stavka_slike,null);


        return vi;
    }
}
