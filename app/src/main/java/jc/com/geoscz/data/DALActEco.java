package jc.com.geoscz.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import jc.com.geoscz.entity.ActEco;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class DALActEco {
    private SQLiteDatabase db;
    public static final String TABLA = "ActEco";
    public static final String COLUMNAS = "id,seccion,division,grupo,clase,subClase,descripcion,idCategoriaFK";
    public static final String CREATE_TABLA = "CREATE TABLE " + TABLA + " (id integer NOT NULL PRIMARY KEY AUTOINCREMENT,seccion text,division text,grupo text,clase text,subClase text,descripcion text,idCategoriaFK integer)";

    public DALActEco(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;
    }

    public long insert(ActEco actEco) {

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("seccion", actEco.getSeccion());
        nuevoRegistro.put("division", actEco.getDivision());
        nuevoRegistro.put("grupo", actEco.getGrupo());
        nuevoRegistro.put("clase", actEco.getClase());
        nuevoRegistro.put("subClase", actEco.getSubClase());
        nuevoRegistro.put("descripcion", actEco.getDescripcion());
        nuevoRegistro.put("idCategoriaFK", actEco.getIdCategoriaFK());

        long res = db.insert(TABLA, null, nuevoRegistro);
        Log.i("insert:", res + "|" + actEco.toString());
        return res;
    }

    public long update(ActEco actEco) {
        String whereClause = "id = ?";
        String[] whereArgs = new String[] {actEco.getId()+""};

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("seccion", actEco.getSeccion());
        nuevoRegistro.put("division", actEco.getDivision());
        nuevoRegistro.put("grupo", actEco.getGrupo());
        nuevoRegistro.put("clase", actEco.getClase());
        nuevoRegistro.put("subClase", actEco.getSubClase());
        nuevoRegistro.put("descripcion", actEco.getDescripcion());
        nuevoRegistro.put("idCategoriaFK", actEco.getIdCategoriaFK());

        long res = db.update(TABLA, nuevoRegistro, whereClause, whereArgs);
        Log.i("update:", res + "|" + actEco.toString());
        return res;
    }

    public ArrayList<ActEco> getAll() {

        ArrayList<ActEco> listCategoria = new ArrayList<>();
        Cursor c = db.query(TABLA, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                ActEco n = new ActEco();

                n.setId(c.getInt(c.getColumnIndex("id")));
                n.setSeccion(c.getString(c.getColumnIndex("seccion")));
                n.setDivision(c.getString(c.getColumnIndex("division")));
                n.setGrupo(c.getString(c.getColumnIndex("grupo")));
                n.setClase(c.getString(c.getColumnIndex("clase")));
                n.setSubClase(c.getString(c.getColumnIndex("subClase")));
                n.setDescripcion(c.getString(c.getColumnIndex("descripcion")));
                n.setIdCategoriaFK(c.getInt(c.getColumnIndex("idCategoriaFK")));

                listCategoria.add(n);

            } while (c.moveToNext());
        }
        Log.i("get:", listCategoria.toString());

        return listCategoria;
    }
}
