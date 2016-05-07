package jc.com.geoscz.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import jc.com.geoscz.entity.Categoria;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class DALCategoria {
    private SQLiteDatabase db;
    public static final String TABLA = "Categoria";
    public static final String COLUMNAS = "idCategoria,nombre,descripcion";
    public static final String CREATE_TABLA = "CREATE TABLE " + TABLA + " (idCategoria integer NOT NULL PRIMARY KEY AUTOINCREMENT,nombre text,descripcion text)";

    public DALCategoria(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;
    }

    public long insert(Categoria categoria) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("nombre", categoria.getNombre());
        nuevoRegistro.put("descripcion", categoria.getDescripcion());

        long res = db.insert(TABLA, null, nuevoRegistro);
        Log.i("insert:", res + "|" + categoria.toString());
        return res;
    }

    public long update(Categoria categoria) {
        String whereClause = "idCategoria = ?";
        String[] whereArgs = new String[] {categoria.getIdCategoria()+""};

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("nombre", categoria.getNombre());
        nuevoRegistro.put("descripcion", categoria.getDescripcion());

        long res = db.update(TABLA, nuevoRegistro, whereClause, whereArgs);
        Log.i("update:", res + "|" + categoria.toString());
        return res;
    }

    public ArrayList<Categoria> getAll() {

        ArrayList<Categoria> listCategoria = new ArrayList<>();
        Cursor c = db.query(TABLA, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                Categoria n = new Categoria();

                n.setIdCategoria(c.getInt(c.getColumnIndex("idCategoria")));
                n.setNombre(c.getString(c.getColumnIndex("nombre")));
                n.setDescripcion(c.getString(c.getColumnIndex("descripcion")));

                listCategoria.add(n);

            } while (c.moveToNext());
        }
        Log.i("get:", listCategoria.toString());

        return listCategoria;
    }

}
