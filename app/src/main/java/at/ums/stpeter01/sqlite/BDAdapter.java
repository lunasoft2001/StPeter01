package at.ums.stpeter01.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by luna-aleixos on 15.03.2016.
 */
public class BDAdapter {

    /**
     * Definimos constante con el nombre de la tabla
     */
    public static final String mTUMBAS = BDNombres.Tablas.TUMBAS;

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String mTumbasID = BDNombres.ColumnasTumbas.ID;
    public static final String mTumbasCodigo = BDNombres.ColumnasTumbas.COD_TUMBA;
    public static final String mTumbasNombre = BDNombres.ColumnasTumbas.NOMBRE;
    public static final String mTumbasCementerio = BDNombres.ColumnasTumbas.CEMENTERIO;
    public static final String mTumbasCampo = BDNombres.ColumnasTumbas.CAMPO;
    public static final String mTumbasFila = BDNombres.ColumnasTumbas.FILA;
    public static final String mTumbasNumero = BDNombres.ColumnasTumbas.NUMERO;


    private Context contexto;
    private BDHelper dbHelper;
    private SQLiteDatabase db;

    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la BD
     */

    private String[] columnasTumbas = new String[]{mTumbasID, mTumbasNombre, mTumbasCementerio,
                               mTumbasCampo, mTumbasCodigo, mTumbasFila, mTumbasNumero};

    public BDAdapter(Context context){
        this.contexto = context;
    }

    public BDAdapter abrir() throws SQLException{
        dbHelper = new BDHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar(){
        dbHelper.close();
    }

    /**
     * Devuelve cursor con todos los registros y columnas de la tabla Tumbas
     */
    public Cursor getCursorTumbas() throws SQLException{
        Cursor c = db.query(true,mTUMBAS,columnasTumbas,null,null,null,null,null,null);

        return c;
    }

    /**
     * Devuelve cursor con todas las columnas de un registro
     */
    public Cursor getRegistroTumbas(long id) throws SQLException{

        String condicion = mTumbasID + "=" + id;

        Cursor c = db.query(true,mTUMBAS,columnasTumbas,condicion,null,null,null,null,null);

        //Nos movemos al primer registro de la consulta
        if (c != null){
            c.moveToFirst();
        }
        return c;

    }

}