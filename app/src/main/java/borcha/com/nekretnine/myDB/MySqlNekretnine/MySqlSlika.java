package borcha.com.nekretnine.myDB.MySqlNekretnine;

import android.content.Context;


import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import borcha.com.nekretnine.myDB.MyDbHelp;
import borcha.com.nekretnine.myDB.dbmodel.Nekretnina;
import borcha.com.nekretnine.myDB.dbmodel.Slika;


/**
 * Created by borcha on 02.06.17..
 */

public class MySqlSlika extends MyDbHelp {


    private Context cont;
    private Nekretnina nekretnina;
    private Slika slika;


    private int id=0;



    /**
     * Konstruktor za unos. Nap. Ukoliko je sa Id-om ima moguce dodatne operacije kao sto su: <br> Update ili Delete.
     * @param _cont

     */
    public MySqlSlika(Context _cont){
        super(_cont);
        this.cont=_cont;

    }

    /**
     * Konstruktor sa Id-om je ukoliko saljemo u cilju update ili brisanja podatka.
     * @param _cont
     * @param _slika
     */
    public MySqlSlika(Context _cont, Slika _slika) {
        super(_cont);
        this.cont = _cont;
        this.slika=_slika;

    }


    //*************************operaciej nad bazom *****************************************************

    /**
     * Update jela
     */
    public void prepravislika() {

       int rez= 0;

        try {
            rez = getDaoSlika().update(this.slika);
            //PrepraviKategoriju.OnPrepraviKategoriju(rez);
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    /**
     * Brisanje jela
     */
    public void obrisiSlika()  {
        int rez= 0;
            try{
                rez=getDaoSlika().delete(this.slika);
                //ObrisiKategoriju.OnObrisiKategoriju(rez);


            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    /**
     * Unos novog Slikaa
     * @param _Slika
     */
    public void snimiNoviSlika(Slika _Slika) {

        if(!_Slika.equals(null)) {
            //TODO. Uraditi Sql upit za delete
            int rez = 0;
            try {
                rez = getDaoSlika().create(_Slika);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    //Vraca listu svih objekata Jelo
    public List<Slika> getSviSlika() {
        List<Slika> lista=new ArrayList<>();
        try {
            lista=getDaoSlika().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Trazi vrednost jela po ID zapisu
    public Slika getSlikaPoId(int _id) {
        Slika slika=null;
        try {
            slika= getDaoSlika().queryForId(_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slika;
    }



    //Trazi vrednost jela po ID zapisu
    public List<Slika> getSlikaPonekretnini(Nekretnina _nekretnina) {
        List<Slika> Slikaovi=null;
        try {

            QueryBuilder<Slika,Integer> query=getDaoSlika().queryBuilder();
            Where<Slika,Integer> where=query.where().eq(Slika.tSlika_nekretnina,_nekretnina);
            Slikaovi= where.query();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Slikaovi;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Slika getSlika() {
        return this.slika;
    }

    public void setSlika(Slika Slika) {
        this.slika = Slika;
    }


    public int getBrojSlika(){
        int br=0;
        try {
            br=getDaoSlika().queryForAll().size();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return br;
    }




}
