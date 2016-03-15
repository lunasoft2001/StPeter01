package at.ums.stpeter01;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.sql.SQLException;

public class ListaTumbas extends ListActivity {


    public static final String C_MODO = "modo" ;
    public static final int C_VISUALIZAR = 551 ;


    private BDAdapter dbAdapter;
    private Cursor cursor;
    private TumbasCursorAdapter tumbasAdapter;
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tumbas);

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
            cursor = dbAdapter.getCursorTumbas();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        startManagingCursor(cursor);
        tumbasAdapter = new TumbasCursorAdapter(this, cursor);
        lista.setAdapter(tumbasAdapter);
    }

    private void visualizar(long id){ //ojo con este valor puede ser string
        // Llamamos a la Actividad TumbasFormulario indicando el modo visualización y el identificador del registro
        Intent i = new Intent(ListaTumbas.this, TumbasFormulario.class);
        i.putExtra(C_MODO,C_VISUALIZAR);
        i.putExtra(BDAdapter.mTumbasID, id);

        startActivityForResult(i, C_VISUALIZAR);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        visualizar(id);
    }
}
