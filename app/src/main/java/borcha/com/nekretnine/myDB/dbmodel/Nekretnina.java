package borcha.com.nekretnine.myDB.dbmodel;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 13.6.17..
 */
@DatabaseTable(tableName= Nekretnina.tNekretnina)
public class Nekretnina {

    public static final String tNekretnina="tNekretnina";
    public static final String tNekretnina_id="id";
    public static final String tNekretnina_naziv="naziv";
    public static final String tNekretnina_opis="opis";
    public static final String tNekretnina_adresa="adresa";
    public static final String tNekretnina_brojTelefona="broj_tel";
    public static final String tNekretnina_brojSoba="broj_soba";
    public static final String tNekretnina_kvadratura="kvadratura";
    public static final String tNekretnina_cena="cena";


    public static final String tNekretnina_kateggorija="kateggorija";


    @DatabaseField(columnName = tNekretnina_id,generatedId = true)
    private int id;
    @DatabaseField(columnName = tNekretnina_naziv)
    private String naziv;
    @DatabaseField(columnName = tNekretnina_opis)
    private String opis;
    @DatabaseField(columnName = tNekretnina_adresa)
    private String adresa;
    @DatabaseField(columnName = tNekretnina_brojTelefona)
    private String brojTelefona;
    @DatabaseField(columnName = tNekretnina_brojSoba)
    private int brojSoba;



    @DatabaseField(columnName = tNekretnina_kvadratura)
    private float kvadrata;
    @DatabaseField(columnName = tNekretnina_cena)
    private float cena;

    @ForeignCollectionField(foreignFieldName = "nekretnina",eager = true)
    ForeignCollection<Slika> slike;

    public Nekretnina(){}

    public Nekretnina(String _naziv, String _opis,String _adresa,String _brojTelefona,int _brojSoba,float _kvadrata,float _cena){
        this.naziv=_naziv;
        this.opis=_opis;
        this.adresa=_adresa;
        this.brojTelefona=_brojTelefona;
        this.brojSoba=_brojSoba;
        this.cena=_cena;
        this.kvadrata=_kvadrata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public int getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public ForeignCollection<Slika> getSlike() {
        return slike;
    }
    public float getKvadrata() {
        return kvadrata;
    }

    public void setKvadrata(float kvadrata) {
        this.kvadrata = kvadrata;
    }
    public void setSlike(ForeignCollection<Slika> slike) {
        this.slike = slike;
    }

    public String toString(){
       return this.naziv;   }
}
