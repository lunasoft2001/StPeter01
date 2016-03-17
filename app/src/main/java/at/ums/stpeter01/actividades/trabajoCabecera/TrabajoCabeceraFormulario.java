package at.ums.stpeter01.actividades.trabajoCabecera;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;

import java.sql.SQLException;

import at.ums.stpeter01.R;
import at.ums.stpeter01.sqlite.BDAdapter;

/**
 * al final de cada linea aparecen marcados los valores que se deben modificar al crear una actividad para otra tabla
 */


public class TrabajoCabeceraFormulario extends Activity {

    private BDAdapter dbAdapter;
    private Cursor cursor;

    //
    // Modo del formulario
    //
    private int modo;

    //
    // Identificador del registro que se edita cuando la opción es MODIFICAR
    //
    private long id;

    //
    // Elementos de la vista
    //
    private EditText codigo; // codigo
    private EditText descripcion;
    private EditText fecha;
    private EditText tumba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajo_cabecera_formulario); // activity_trabajo_cabecera_formulario

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        if (extra == null) return;

        //
        // Obtenemos los elementos de la vista
        //
        codigo = (EditText) findViewById(R.id.etIdTrabajoCabecera); //codigo ---- etIdTrabajoCabecera
        descripcion = (EditText) findViewById(R.id.etDescripcionTrabajoCabecera);
        fecha = (EditText) findViewById(R.id.etFecha);
        tumba = (EditText) findViewById(R.id.etTumba);

        //
        // Creamos el adaptador
        //

        dbAdapter = new BDAdapter(this);
        try {
            dbAdapter.abrir();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //
        // Obtenemos el indicador de registro si viene indicado
        //
        if (extra.containsKey(BDAdapter.mTrCabID)) { //mTrCabID
            id = extra.getLong(BDAdapter.mTrCabID); //mTrCabID
            consultar(id);
        }

        //
        // Establecemos el modo del formulario
        //

        establecerModo(extra.getInt(ListaTrabajoCabecera.C_MODO)); //ListaTrabajoCabecera
    }

    private void establecerModo(int m){
        this.modo = m;

        if (modo == ListaTrabajoCabecera.C_VISUALIZAR){
            this.setTitle(codigo.getText().toString()); //codigo
            this.setEdicion(false);
        }
    }

    private void consultar(long id){
        //
        // Consultamos el centro por el identificador
        //
        try {
            cursor = dbAdapter.getRegistroTrabajoCabecera(id); // .getRegistroTrabajoCabecera(id)
        } catch (SQLException e) {
            e.printStackTrace();
        }

        codigo.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTrCabCodigo))); //codigo --- mTrCabCodigo
        descripcion.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTrCabDescripcion)));
        fecha.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTrCabFecha)));
        tumba.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTrCabTumba)));

    }

    private void setEdicion(boolean opcion){
        codigo.setEnabled(opcion); //codigo
        descripcion.setEnabled(opcion);
        fecha.setEnabled(opcion);
        tumba.setEnabled(opcion);

    }


}
