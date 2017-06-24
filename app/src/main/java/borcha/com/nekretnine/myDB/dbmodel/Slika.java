package borcha.com.nekretnine.myDB.dbmodel;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * Created by borcha on 20.05.17..
 */
@DatabaseTable(tableName = Slika.tSlika)
public class Slika {

    public static final String tSlika="tSlika";
    public static final String tSlika_id="id";
    public static final String tSlika_path="path";
    public static final String tSlika_nekretnina="path";

    @DatabaseField(columnName = tSlika_id,generatedId = true)
    private int id;
    @DatabaseField(columnName = tSlika_path)
    private String path;
    @DatabaseField(columnName = "nekretnina",foreign = true,foreignAutoCreate = true,foreignAutoRefresh = true)
    private Nekretnina nekretnina;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Nekretnina getNekretnina() {
        return nekretnina;
    }

    public void setNekretnina(Nekretnina nekretnina) {
        this.nekretnina = nekretnina;
    }

    public Slika() { }

    public static String gettSlika() {
        return tSlika;
    }
    public static String gettSlika_id() {
        return tSlika_id;
    }

    public static String gettSlika_path() {
        return tSlika_path;
    }

    public static String gettSlika_nekretnina() {
        return tSlika_nekretnina;
    }

    public String toString() {
        return path;
    }

}
