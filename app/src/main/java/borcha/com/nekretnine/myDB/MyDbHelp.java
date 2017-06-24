package borcha.com.nekretnine.myDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import borcha.com.nekretnine.myDB.dbmodel.Nekretnina;
import borcha.com.nekretnine.myDB.dbmodel.Slika;


/**
 * Created by borcha on 02.06.17..
 */

public class MyDbHelp extends OrmLiteSqliteOpenHelper {

    private static final String DBNAME="dbsablon.db";
    private static final int DB_VER=1;

    private Dao<Nekretnina, Integer> daoNekretnina=null;
    private Dao<Slika, Integer> daoSlika = null;
    

    public MyDbHelp(Context context) {
           super(context, DBNAME, null,DB_VER);
    }



    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource conn) {

        Log.i(MyDbHelp.class.getName(), "onCreate");
        try {
            TableUtils.createTable(conn, Nekretnina.class);
            TableUtils.createTable(conn, Slika.class);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource conn, int oldVersion, int newVersion) {

        Log.i(MyDbHelp.class.getName(), "onUpdate");
        try {
            TableUtils.dropTable(conn,Nekretnina.class,true);
            TableUtils.dropTable(conn,Slika.class,true);

            onCreate(database,conn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public Dao<Nekretnina,Integer> getDaoNekretnina() throws SQLException {

        if(daoNekretnina==null) {
            daoNekretnina = getDao(Nekretnina.class);
        }

        return daoNekretnina;
    }



    public Dao<Slika,Integer> getDaoSlika() throws SQLException {

        if(daoSlika==null){
            daoSlika=getDao(Slika.class);
        }

        return daoSlika;
    }

    @Override
    public void close() {
        Log.i("baza","Zatvorena");
        daoSlika=null;
        daoNekretnina=null;

        super.close();
    }


}
