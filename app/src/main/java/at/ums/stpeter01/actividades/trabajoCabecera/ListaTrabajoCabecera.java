package at.ums.stpeter01.actividades.trabajoCabecera;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.sql.SQLException;

import at.ums.stpeter01.R;
import at.ums.stpeter01.actividades.tumbas.TumbasCursorAdapter;
import at.ums.stpeter01.actividades.tumbas.TumbasFormulario;
import at.ums.stpeter01.sqlite.BDAdapter;

public class ListaTrabajoCabecera extends ListActivity {


    public static final String C_MODO = "modo" ;
    public static final int C_VISUALIZAR = 551 ;


    private BDAdapter dbAdapter;
    private Cursor cursor;
    private TrabajoCabeceraCursorAdapter trabajoCabeceraAdapter ;
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_trabajo_cabecera);

        lista = (ListView) findViewById(android.R.id.list);

        dbAdapter = new BDAdapter(this);
        try {
            dbAdapter.abrir();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        consultar();
    }

    private void consultar(){
        try {
            cursor = dbAdapter.getCursorTrabajoCabecera();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        startManagingCursor(cursor);
        trabajoCabeceraAdapter = new TrabajoCabeceraCursorAdapter(this, cursor);
        lista.setAdapter(trabajoCabeceraAdapter);
    }

    private void visualizar(long id){
        // Llamamos a la Actividad TumbasFormulario indicando el modo visualización y el identificador del registro
        Intent i = new Intent(ListaTrabajoCabecera.this, TrabajoCabeceraFormulario.class);
        i.putExtra(C_MODO,C_VISUALIZAR);
        i.putExtra(BDAdapter.mTrCabID, id);

        startActivityForResult(i, C_VISUALIZAR);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        visualizar(id);
    }
}
