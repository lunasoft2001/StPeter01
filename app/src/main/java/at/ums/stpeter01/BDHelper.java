package at.ums.stpeter01;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import at.ums.stpeter01.BDNombres.*;

/**
 * Created by luna-aleixos on 15.03.2016.
 * Es el controlador de la base de datos
 */
public class BDHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String nombreBD = "stPeter01";
    private static CursorFactory factory = null;

    public BDHelper(Context context){
        super(context, nombreBD, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL("CREATE TABLE "  + Tablas.TUMBAS +
                "( " +
                ColumnasTumbas.ID +" INT PRIMARY KEY," +
                ColumnasTumbas.COD_TUMBA + " TEXT NOT NULL," +
                ColumnasTumbas.NOMBRE + " TEXT NOT NULL," +
                ColumnasTumbas.CEMENTERIO +" TEXT," +
                ColumnasTumbas.CAMPO + " TEXT," +
                ColumnasTumbas.FILA + " TEXT," +
                ColumnasTumbas.NUMERO + " TEXT)");

        db.execSQL("CREATE UNIQUE INDEX _id ON " + Tablas.TUMBAS + "(_id ASC)");

        Log.i(this.getClass().toString(), "La tabla " + Tablas.TUMBAS +" ha sido creada");

        /**
         * Insertamos datos iniciales
         */
        //Tumba 1
        ContentValues valoresTumba = new ContentValues();
        valoresTumba.put(ColumnasTumbas.ID, 1);
        valoresTumba.put(ColumnasTumbas.COD_TUMBA, "P 01-01-01");
        valoresTumba.put(ColumnasTumbas.NOMBRE, "pepito 1");
        valoresTumba.put(ColumnasTumbas.CEMENTERIO, "St. Peter");
        valoresTumba.put(ColumnasTumbas.CAMPO, "01");
        valoresTumba.put(ColumnasTumbas.FILA, "01");
        valoresTumba.put(ColumnasTumbas.NUMERO, "01");
        db.insertOrThrow(Tablas.TUMBAS, null, valoresTumba);

        //Tumba 2
        valoresTumba.put(ColumnasTumbas.ID, 2);
        valoresTumba.put(ColumnasTumbas.COD_TUMBA, "P 01-01-02");
        valoresTumba.put(ColumnasTumbas.NOMBRE, "pepito 2");
        valoresTumba.put(ColumnasTumbas.CEMENTERIO, "St. Peter");
        valoresTumba.put(ColumnasTumbas.CAMPO, "01");
        valoresTumba.put(ColumnasTumbas.FILA, "01");
        valoresTumba.put(ColumnasTumbas.NUMERO, "02");
        db.insertOrThrow(Tablas.TUMBAS, null, valoresTumba);

        //Tumba 3
        valoresTumba.put(ColumnasTumbas.ID, 3);
        valoresTumba.put(ColumnasTumbas.COD_TUMBA, "P 01-02-01");
        valoresTumba.put(ColumnasTumbas.NOMBRE, "pepito 3");
        valoresTumba.put(ColumnasTumbas.CEMENTERIO, "St. Peter");
        valoresTumba.put(ColumnasTumbas.CAMPO, "01");
        valoresTumba.put(ColumnasTumbas.FILA, "02");
        valoresTumba.put(ColumnasTumbas.NUMERO, "01");
        db.insertOrThrow(Tablas.TUMBAS, null, valoresTumba);

        //Tumba 4
        valoresTumba.put(ColumnasTumbas.ID, 4);
        valoresTumba.put(ColumnasTumbas.COD_TUMBA, "P 02-01-01");
        valoresTumba.put(ColumnasTumbas.NOMBRE, "pepito 41");
        valoresTumba.put(ColumnasTumbas.CEMENTERIO, "St. Peter");
        valoresTumba.put(ColumnasTumbas.CAMPO, "02");
        valoresTumba.put(ColumnasTumbas.FILA, "01");
        valoresTumba.put(ColumnasTumbas.NUMERO, "01");
        db.insertOrThrow(Tablas.TUMBAS, null, valoresTumba);

        Log.i(this.getClass().toString(), "Datos iniciales insertados");

        Log.i(this.getClass().toString(), "Base de datos " + nombreBD + " creada");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
