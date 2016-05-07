package jc.com.geoscz.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import jc.com.geoscz.entity.Uvs;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class DALUvs {

    private SQLiteDatabase db;
    public static final String TABLA = "Uvs";
    public static final String COLUMNAS = "idUvs,OBJECTID,idTipo,ANILLO,DIST_MUN,ET_UV,latitud,longitud";
    public static final String CREATE_TABLA = "CREATE TABLE " + TABLA + " (idUvs integer,OBJECTID text,idTipo text,ANILLO integer,DIST_MUN text,ET_UV text,latitud double,longitud double)";

    public DALUvs(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;
    }

    public long insert(Uvs uvs) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("idUvs", uvs.getIdUvs());
        nuevoRegistro.put("OBJECTID", uvs.getOBJECTID());
        nuevoRegistro.put("idTipo", uvs.getIdTipo());
        nuevoRegistro.put("ANILLO", uvs.getANILLO());
        nuevoRegistro.put("DIST_MUN", uvs.getDIST_MUN());
        nuevoRegistro.put("ET_UV", uvs.getET_UV());
        nuevoRegistro.put("latitud", uvs.getLatitud());
        nuevoRegistro.put("longitud", uvs.getLongitud());

        long res = db.insert(TABLA, null, nuevoRegistro);
        Log.i("insert:", res + "|" + uvs.toString());
        return res;
    }

    public ArrayList<Uvs> getAll() {

        ArrayList<Uvs> list = new ArrayList<>();
        Cursor c = db.query(TABLA, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {

                Uvs n = new Uvs();
                n.setIdUvs(c.getInt(c.getColumnIndex("idUvs")));
                n.setOBJECTID(c.getString(c.getColumnIndex("OBJECTID")));
                n.setIdTipo(c.getString(c.getColumnIndex("idTipo")));
                n.setANILLO(c.getInt(c.getColumnIndex("ANILLO")));
                n.setDIST_MUN(c.getString(c.getColumnIndex("DIST_MUN")));
                n.setET_UV(c.getString(c.getColumnIndex("ET_UV")));
                n.setLatitud(c.getDouble(c.getColumnIndex("latitud")));
                n.setLongitud(c.getDouble(c.getColumnIndex("longitud")));

                list.add(n);

            } while (c.moveToNext());
        }
        Log.i("get:", list.toString());

        return list;
    }

}
