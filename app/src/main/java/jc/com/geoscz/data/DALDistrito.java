package jc.com.geoscz.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import jc.com.geoscz.entity.Distrito;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class DALDistrito {

    private SQLiteDatabase db;
    public static final String TABLA = "Distrito";
    public static final String COLUMNAS = "idDistrito,OBJECTID,idTipo,nombre,area";
    public static final String CREATE_TABLA = "CREATE TABLE " + TABLA + " (idCategoria integer,OBJECTID text,idTipo text,nombre text,area text)";

    public DALDistrito(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;
    }

    public long insert(Distrito distrito) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("idDistrito", distrito.getIdDistrito());
        nuevoRegistro.put("OBJECTID", distrito.getOBJECTID());
        nuevoRegistro.put("idTipo", distrito.getIdTipo());
        nuevoRegistro.put("nombre", distrito.getNombre());
        nuevoRegistro.put("area", distrito.getArea());

        long res = db.insert(TABLA, null, nuevoRegistro);
        Log.i("insert:", res + "|" + distrito.toString());
        return res;
    }

    public ArrayList<Distrito> getAll() {

        ArrayList<Distrito> list = new ArrayList<>();
        Cursor c = db.query(TABLA, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {

                Distrito n = new Distrito();
                n.setIdDistrito(c.getInt(c.getColumnIndex("idDistrito")));
                n.setOBJECTID(c.getString(c.getColumnIndex("OBJECTID")));
                n.setIdTipo(c.getString(c.getColumnIndex("idTipo")));
                n.setNombre(c.getString(c.getColumnIndex("nombre")));
                n.setArea(c.getString(c.getColumnIndex("area")));

                list.add(n);

            } while (c.moveToNext());
        }
        Log.i("get:", list.toString());

        return list;
    }

}
