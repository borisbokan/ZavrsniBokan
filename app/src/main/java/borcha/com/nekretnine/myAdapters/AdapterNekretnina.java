package borcha.com.nekretnine.myAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import borcha.com.nekretnine.R;
import borcha.com.nekretnine.myDB.dbmodel.Nekretnina;


/**
 * Created by androiddevelopment on 13.6.17..
 */

public class AdapterNekretnina extends ArrayAdapter<Nekretnina> {

    LayoutInflater lyInflater;
    Context cont;
    TextView txvNaziv,txvOpis;
    ImageView imgSlika;

    public AdapterNekretnina(Context context, List<Nekretnina> _listaNekretnina){
        super(context, R.layout.lista_stavka_nekretnina,_listaNekretnina);
        cont=context;
    }


    @NonNull
    @Override
    public View getView(int position, View vi,  ViewGroup parent) {
        lyInflater=(LayoutInflater)cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vi=lyInflater.inflate(R.layout.lista_stavka_nekretnina,null);
        Nekretnina nekretnina=getItem(position);


        txvNaziv=(TextView)vi.findViewById(R.id.txvNazivStavkka_lista);
        txvOpis=(TextView)vi.findViewById(R.id.txtOpisStavkka_lista);
        imgSlika=(ImageView)vi.findViewById(R.id.imgSlika_gvstavka);

        txvNaziv.setText(nekretnina.getNaziv());
        txvOpis.setText(nekretnina.getOpis().toString());
        imgSlika.setImageResource(R.mipmap.ic_home);

        return vi;
    }
}
