package at.ums.stpeter01.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

import static at.ums.stpeter01.sqlite.BDNombres.*;

/**
 * Created by luna-aleixos on 15.03.2016.
 */
public class BDAdapter {

    /**
     * Definimos constante con el nombre de la tabla
     */
    public static final String mTUMBAS = Tablas.TUMBAS;
    public static final String mTRABAJOCABECERA = Tablas.TRABAJO_CABECERA;

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String mTumbasID = ColumnasTumbas.ID;
    public static final String mTumbasCodigo = ColumnasTumbas.COD_TUMBA;
    public static final String mTumbasNombre = ColumnasTumbas.NOMBRE;
    public static final String mTumbasCementerio = ColumnasTumbas.CEMENTERIO;
    public static final String mTumbasCampo = ColumnasTumbas.CAMPO;
    public static final String mTumbasFila = ColumnasTumbas.FILA;
    public static final String mTumbasNumero = ColumnasTumbas.NUMERO;

    public static final String mTrCabID = ColumnasTrabajoCabecera.ID;
    public static final String mTrCabDescripcion = ColumnasTrabajoCabecera.DESCRIPCION_TRABAJO;
    public static final String mTrCabFecha = ColumnasTrabajoCabecera.FECHA;
    public static final String mTrCabCodigo = ColumnasTrabajoCabecera.COD_TRABAJO;
    public static final String mTrCabTumba = ColumnasTrabajoCabecera.TUMBA;


    private Context contexto;
    private BDHelper dbHelper;
    private SQLiteDatabase db;

    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la BD
     */

    private String[] columnasTumbas = new String[]{mTumbasID, mTumbasNombre, mTumbasCementerio,
            mTumbasCampo, mTumbasCodigo, mTumbasFila, mTumbasNumero};


    private String[] columnasTrabajoCabecera = new String[]{mTrCabID, mTrCabDescripcion,
                                mTrCabFecha,mTrCabCodigo, mTrCabTumba};

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
     * TUMBAS
     */


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


    /**
     * TRABAJO CABECERA
     */

    /**
     * Devuelve cursor con todos los registros y columnas de la tabla Tumbas
     */
    public Cursor getCursorTrabajoCabecera() throws SQLException{
        Cursor c = db.query(true,mTRABAJOCABECERA,columnasTrabajoCabecera,null,null,null,null,null,null);

        return c;
    }

    /**
     * Devuelve cursor con todas las columnas de un registro
     */
    public Cursor getRegistroTrabajoCabecera(long id) throws SQLException{

        String condicion = mTrCabID + "=" + id;

        Cursor c = db.query(true,mTRABAJOCABECERA,columnasTrabajoCabecera,condicion,null,null,null,null,null);

        //Nos movemos al primer registro de la consulta
        if (c != null){
            c.moveToFirst();
        }
        return c;

    }

}
