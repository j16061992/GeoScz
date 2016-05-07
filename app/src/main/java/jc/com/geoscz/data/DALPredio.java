package jc.com.geoscz.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import jc.com.geoscz.entity.Predio;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class DALPredio {

    private SQLiteDatabase db;
    public static final String TABLA = "Predio";
    public static final String COLUMNAS = "idPredio,latitud,longitud,idActEcoFK";
    public static final String CREATE_TABLA = "CREATE TABLE " + TABLA + " (idPredio integer NOT NULL PRIMARY KEY AUTOINCREMENT,latitud double,longitud double,idActEcoFK integer)";

    public DALPredio(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;
    }

    public long insert(Predio predio) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("latitud", predio.getLatitud());
        nuevoRegistro.put("longitud", predio.getLongitud());
        nuevoRegistro.put("idActEcoFK", predio.getIdActEcoFK());

        long res = db.insert(TABLA, null, nuevoRegistro);
        Log.i("insert:", res + "|" + predio.toString());
        return res;
    }

    public long update(Predio predio) {
        String whereClause = "idPredio = ?";
        String[] whereArgs = new String[] {predio.getIdPredio()+""};

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("latitud", predio.getLatitud());
        nuevoRegistro.put("longitud", predio.getLongitud());
        nuevoRegistro.put("idActEcoFK", predio.getIdActEcoFK());

        long res = db.update(TABLA, nuevoRegistro, whereClause, whereArgs);
        Log.i("update:", res + "|" + predio.toString());
        return res;
    }

    public ArrayList<Predio> getAll() {

        ArrayList<Predio> listCategoria = new ArrayList<>();
        Cursor c = db.query(TABLA, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                Predio n = new Predio();

                n.setIdPredio(c.getInt(c.getColumnIndex("idPredio")));
                n.setLatitud(c.getDouble(c.getColumnIndex("latitud")));
                n.setLongitud(c.getDouble(c.getColumnIndex("longitud")));
                n.setIdActEcoFK(c.getInt(c.getColumnIndex("idActEcoFK")));

                listCategoria.add(n);

            } while (c.moveToNext());
        }
        Log.i("get:", listCategoria.toString());

        return listCategoria;
    }

}
