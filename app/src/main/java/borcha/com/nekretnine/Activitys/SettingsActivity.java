package borcha.com.nekretnine.Activitys;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import borcha.com.nekretnine.R;

/**
 * Created by androiddevelopment on 24.6.17..
 */

public class SettingsActivity extends PreferenceActivity {

    private SharedPreferences podesavnja;
    private boolean toastPoruka;
    private boolean snackPoruka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.podesavanja);

        podesavnja=getPreferences(MODE_PRIVATE);
        toastPoruka=podesavnja.getBoolean("chb_toast_ukljucen",true);
        snackPoruka=podesavnja.getBoolean("snackbar_ukljucen",true);


    }


    public void setNotifikacijaPoruka(boolean ukljuceno) {
        SharedPreferences podes=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prepravi=podes.edit();
        prepravi.putBoolean("sw_notifikacija_ukljucena",ukljuceno);
        prepravi.commit();

    }
    public boolean jelNotifikacionaPorukaUkljucena() {

        return snackPoruka;
    }

    public void setToastPoruka(boolean ukljuceno) {
        SharedPreferences podes=getPreferences(MODE_ENABLE_WRITE_AHEAD_LOGGING);
        SharedPreferences.Editor prepravi=podes.edit();
        prepravi.putBoolean("chb_toast_ukljucen",ukljuceno);
        prepravi.commit();

    }
    public boolean jelToastPorukaUkljucena() {
        return toastPoruka;
    }


    private void setujTemuIzSettings(int _tema) {

        switch(_tema){
            case 0:
                getApplication().setTheme(R.style.AppTheme);
                break;
            case 1:
                getApplication().setTheme(R.style.MojaTemaPlava);
                break;

            case 2:
                getApplication().setTheme(R.style.MojaTemaCrvena);
                break;

            case 3:
                getApplication().setTheme(R.style.MojaTemaZelena);
                break;
        }


    }
}
