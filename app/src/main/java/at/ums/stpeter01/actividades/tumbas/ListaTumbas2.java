package at.ums.stpeter01.actividades.tumbas;

import android.app.ActionBar;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;

import android.widget.SimpleCursorAdapter;

import at.ums.stpeter01.sqlite.BDAdapter;

import static at.ums.stpeter01.sqlite.BDAdapter.*;

/**
 * Created by luna-aleixos on 18.03.2016.
 *
 * Ejemplo obtenido en:
 * http://developer.android.com/intl/es/guide/topics/ui/layout/listview.html#Example
 *
 */
public class ListaTumbas2 extends ListActivity
        implements LoaderManager.LoaderCallbacks<Cursor {
    //Este es el Adaptador que será usado para mostrar lla lista de datos
    SimpleCursorAdapter mAdapter;

    //Datos
    static final String[] PROJECTION = new String[]{mTumbasID, mTumbasNombre, mTumbasCementerio,
            mTumbasCampo, mTumbasCodigo, mTumbasFila, mTumbasNumero};

    //Criterio
    static final String SELECTION = "((" +
            mTumbasID + " NOTNULL) AND (" +
            mTumbasID + " != '' ))";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Para el cursor adapter, especificar que columns va en cada vista
        String[] fromColumns = {mTumbasNombre};
        int[] toViews = {android.R.id.text1};

        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        mAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, null,
                fromColumns, toViews, 0);
        setListAdapter(mAdapter);

        // Prepare the loader.  Either re-connect with an existing one,
        // or start a new one.
        getLoaderManager().initLoader(0, null, this);
    }

    // Called when a new Loader needs to be created
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // Now create and return a CursorLoader that will take care of
        // creating a Cursor for the data being displayed.
        return new CursorLoader(this, ContactsContract.Data.CONTENT_URI,
                PROJECTION, SELECTION, null, null);
    }

    // Called when a previously created loader has finished loading
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Swap the new cursor in.  (The framework will take care of closing the
        // old cursor once we return.)
        mAdapter.swapCursor(data);
    }

    // Called when a previously created loader is reset, making the data unavailable
    public void onLoaderReset(Loader<Cursor> loader) {
        // This is called when the last Cursor provided to onLoadFinished()
        // above is about to be closed.  We need to make sure we are no
        // longer using it.
        mAdapter.swapCursor(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something when a list item is clicked
    }

}