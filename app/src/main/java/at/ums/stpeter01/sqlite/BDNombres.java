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
        String TRABAJO_CABECERA = "trabajo_cabecera";
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

    interface ColumnasTrabajoCabecera{
        String ID = "_id";
        String DESCRIPCION_TRABAJO = "tr_cab_descripcion";
        String FECHA = "tr_cab_fecha";
        String COD_TRABAJO = "tr_cab_IdTrabajo";
        String TUMBA = "tr_cab_tumba";
    }
}
