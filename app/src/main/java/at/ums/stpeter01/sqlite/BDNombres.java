package at.ums.stpeter01.sqlite;

/**
 * Created by luna-aleixos on 15.03.2016.
 */
public class BDNombres {

    /**
     * Interface de las tablas para facilitar su entrada
     */
    interface Tablas{
        String TUMBAS = "tumbas";
    }

    /**
     * Interface de las columnas para facilitar su entrada
     */

    interface ColumnasTumbas{
        String ID = "_id";
        String COD_TUMBA = "tum_IdGrab";
        String NOMBRE = "tum_nombre";
        String CEMENTERIO = "tum_cementerio";
        String CAMPO = "tum_campo";
        String FILA = "tum_fila";
        String NUMERO = "tum_numero";
    }
}
