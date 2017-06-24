package borcha.com.nekretnine.myDB.MySqlNekretnine;

import android.app.NotificationManager;
import android.content.Context;
import android.widget.Toast;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

import borcha.com.nekretnine.Activitys.SettingsActivity;
import borcha.com.nekretnine.myDB.MyDbHelp;
import borcha.com.nekretnine.myDB.dbmodel.Nekretnina;
import borcha.com.nekretnine.pomocne.infoPoruka;
import borcha.com.nekretnine.pomocne.myNotification;


/**
 * Created by borcha on 02.06.17..
 */

public class MySqlNekretnine extends MyDbHelp {

    private boolean toasUklj;
    private boolean snackBar;
    private Context cont;
    private Nekretnina nekretnina;
    private int id=0;
    NotificationManager mNotificationManager;

    /**
     * Konstruktor za unos. Nap. Ukoliko je sa Id-om ima moguce dodatne operacije kao sto su: <br> Update ili Delete.
     * @param _cont
     */
    public MySqlNekretnine(Context _cont) {
        super(_cont);
        this.cont=_cont;

        SettingsActivity podesavanja=new SettingsActivity();
        snackBar= podesavanja.jelNotifikacionaPorukaUkljucena();
        toasUklj=podesavanja.jelToastPorukaUkljucena();

         mNotificationManager = (NotificationManager)cont.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    /**
     * Konstruktor sa Id-om je ukoliko saljemo u cilju update ili brisanja podatka.
     * @param _cont
     * @param _id
     */
    public MySqlNekretnine(Context _cont, int _id) {
        super(_cont);
        this.cont=_cont;
        this.id=_id;

        SettingsActivity podesavanja=new SettingsActivity();
        snackBar= podesavanja.jelNotifikacionaPorukaUkljucena();
        toasUklj=podesavanja.jelToastPorukaUkljucena();

        mNotificationManager = (NotificationManager)cont.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public MySqlNekretnine(Context _cont, borcha.com.nekretnine.myDB.dbmodel.Nekretnina _nekretnina) {
        super(_cont);
        this.cont=_cont;
        this.nekretnina=_nekretnina;

        SettingsActivity podesavanja=new SettingsActivity();
        snackBar= podesavanja.jelNotifikacionaPorukaUkljucena();
        toasUklj=podesavanja.jelToastPorukaUkljucena();

        mNotificationManager = (NotificationManager)cont.getSystemService(Context.NOTIFICATION_SERVICE);
    }



    //*************************operaciej nad bazom *****************************************************


    public void updateNekretnina() {

        int rez=0;

        if(getId()!=0){

            try {
                rez=getDaoNekretnina().updateId(nekretnina,getId());


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else{
            infoPoruka.newInstance(cont,"Poruka o gresci","Ne postoji ID zapisa!. Ne mozete prepraviti podatak za Slika");

        }

    }

    private void uslovnaToastPoruka(String naslov, String poruka) {
        if(toasUklj){
            Toast.makeText(cont,naslov + " - " + poruka,Toast.LENGTH_LONG).show();
        }
    }

    private void uslovnaSnackbar(String naslov, String poruka) {

        if(snackBar){

            myNotification notifikacija=new myNotification(cont,naslov,poruka);
            mNotificationManager.notify(13,notifikacija.build());
        }
    }

    /**
     * Brisanje jela
     */
    public void obrisiNekretnina() {
        int rez= 0;

        try {
                rez = getDaoNekretnina().delete(this.nekretnina);
                         //ObrisiNekretnina.OnObrisiNekretnina(rez);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    /**
     * Unos novog jela
     * @param _nekretnina
     */
    public void snimiNovoNekretnina(Nekretnina _nekretnina) {

        if(!_nekretnina.equals(null)){
            //TODO. Uraditi Sql upit za delete
            int rez= 0;
            try {
                rez = getDaoNekretnina().create(_nekretnina);


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else{
            infoPoruka.newInstance(cont,"Poruka o gresci","Objekat Slika ima  null vrednsot");
        }



    }


    //Vraca listu svih objekata Slika
    public List<Nekretnina> getSviGlumci()  {
        List<Nekretnina> glumci=null;
        try {
            glumci= getDaoNekretnina().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return glumci;
    }

    //Trazi vrednost jela po ID zapisu
    public Nekretnina getNekretninaPoId(int _id)  {

        try {
            return getDaoNekretnina().queryForId(_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  Vraca listu jela po kategoriji
     */

    public List<Nekretnina> getNekretninaiPioStavkka(Nekretnina _stavkka)  {
        List<Nekretnina> glumci=null;
        try {
            QueryBuilder upit = getDaoNekretnina().queryBuilder();
            Where<Nekretnina,Integer> where=upit.where().idEq(getDaoNekretnina(),_stavkka);
            glumci=where.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return glumci;
    }

    public void setNekretnina(Nekretnina Nekretnina) {
        this.nekretnina = Nekretnina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrojNekretninaa() {
        int br = 0;
        try {
            br = getDaoNekretnina().queryForAll().size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return br;
    }


}
