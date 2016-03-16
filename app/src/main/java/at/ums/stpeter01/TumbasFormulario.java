package at.ums.stpeter01;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.sql.SQLException;

public class TumbasFormulario extends Activity {

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
    private EditText codigo;
    private EditText nombre;
    private EditText cementerio;
    private EditText campo;
    private EditText fila;
    private EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tumbas_formulario);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        if (extra == null) return;

        //
        // Obtenemos los elementos de la vista
        //
        codigo = (EditText) findViewById(R.id.etIdTumba);
        nombre = (EditText) findViewById(R.id.etNombreTumba);
        cementerio = (EditText) findViewById(R.id.etCementerio);
        campo = (EditText) findViewById(R.id.etCampo);
        fila = (EditText) findViewById(R.id.etFila);
        numero = (EditText) findViewById(R.id.etNumero);

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
        if (extra.containsKey(BDAdapter.mTumbasID)) {
            id = extra.getLong(BDAdapter.mTumbasID);
            consultar(id);
        }

        //
        // Establecemos el modo del formulario
        //

        establecerModo(extra.getInt(ListaTumbas.C_MODO));
    }

    private void establecerModo(int m){
        this.modo = m;

        if (modo == ListaTumbas.C_VISUALIZAR){
            this.setTitle(codigo.getText().toString());
            this.setEdicion(false);
        }
    }

    private void consultar(long id){
        //
        // Consultamos el centro por el identificador
        //
        try {
            cursor = dbAdapter.getRegistroTumbas(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        codigo.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTumbasCodigo)));
        nombre.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTumbasNombre)));
        cementerio.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTumbasCementerio)));
        campo.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTumbasCampo)));
        fila.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTumbasFila)));
        numero.setText(cursor.getString(cursor.getColumnIndex(BDAdapter.mTumbasNumero)));
    }

    private void setEdicion(boolean opcion){
        codigo.setEnabled(opcion);
        nombre.setEnabled(opcion);
        cementerio.setEnabled(opcion);
        campo.setEnabled(opcion);
        fila.setEnabled(opcion);
        numero.setEnabled(opcion);
    }


}
