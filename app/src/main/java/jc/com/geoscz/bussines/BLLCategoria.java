package jc.com.geoscz.bussines;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import jc.com.geoscz.data.DALCategoria;
import jc.com.geoscz.data.DALDistrito;
import jc.com.geoscz.data.SQLiteHelper;
import jc.com.geoscz.entity.Categoria;
import jc.com.geoscz.entity.Distrito;

/**
 * Created by cesar on 07-05-16.
 */
public class BLLCategoria {

    private SQLiteHelper dbsqLiteHelper;

    public BLLCategoria(Context context) {
        dbsqLiteHelper = new SQLiteHelper(context, null);
    }

    public long insert(Categoria categoria) {
        long val = -1;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALCategoria dalCategoria= new DALCategoria(sqLiteDatabase);
        val = dalCategoria.insert(categoria);
        if (val > 0) {
            dbsqLiteHelper.commit();
        }
        dbsqLiteHelper.endTransaction();
        return val;
    }


    public ArrayList<Categoria> getAll() {
        ArrayList<Categoria> arrayList;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALCategoria dalCategoria = new DALCategoria(sqLiteDatabase);
        arrayList = dalCategoria.getAll();
        dbsqLiteHelper.endTransaction();
        return arrayList;
    }


}
