package at.ums.stpeter01.sqlite;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by luna-aleixos on 18.03.2016.
 * DBHelper importando la base de datos desde assets
 * requiere la siguiente linea en gradle
 *     compile 'com.readystatesoftware.sqliteasset:sqliteassethelper:+'
 *
 */
public class ExternalDbHelper extends SQLiteAssetHelper {

    //Creamos las variables generales de la Base de datos

    private static final int version = 2;
    private static final String nombreBD = "stPeter01.db";

    public ExternalDbHelper(Context contexto) {
        super(contexto, nombreBD, null, version);
    }

}
