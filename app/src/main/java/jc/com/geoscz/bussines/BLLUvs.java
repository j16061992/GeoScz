package jc.com.geoscz.bussines;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import jc.com.geoscz.data.DALDistrito;
import jc.com.geoscz.data.DALUvs;
import jc.com.geoscz.data.SQLiteHelper;
import jc.com.geoscz.entity.Distrito;
import jc.com.geoscz.entity.Uvs;

/**
 * Created by DavorLimachi on 7/30/15.
 */
public class BLLUvs {
    private SQLiteHelper dbsqLiteHelper;

    public BLLUvs(Context context) {
        dbsqLiteHelper = new SQLiteHelper(context, null);
    }

    public long insert(Uvs uvs) {
        long val = -1;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALUvs dalUvs= new DALUvs(sqLiteDatabase);
        val = dalUvs.insert(uvs);
        if (val > 0) {
            dbsqLiteHelper.commit();
        }
        dbsqLiteHelper.endTransaction();
        return val;
    }


    public ArrayList<Uvs> getAll() {
        ArrayList<Uvs> arrayList;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALUvs dalUvs= new DALUvs(sqLiteDatabase);
        arrayList = dalUvs.getAll();
        dbsqLiteHelper.endTransaction();
        return arrayList;
    }

    public void imprimirDistritos() {
        ArrayList<Uvs> arrayList = getAll();
        for (int i = 0; i < arrayList.size(); i++) {
            Log.d("-------------------------------------------",arrayList.get(i).toString());
        }
    }


}

