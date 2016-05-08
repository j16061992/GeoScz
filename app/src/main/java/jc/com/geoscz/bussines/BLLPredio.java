package jc.com.geoscz.bussines;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import jc.com.geoscz.data.DALActEco;
import jc.com.geoscz.data.DALPredio;
import jc.com.geoscz.data.SQLiteHelper;
import jc.com.geoscz.entity.ActEco;
import jc.com.geoscz.entity.Predio;

/**
 * Created by cesar on 07-05-16.
 */
public class BLLPredio {

    private SQLiteHelper dbsqLiteHelper;

    public BLLPredio(Context context) {
        dbsqLiteHelper = new SQLiteHelper(context, null);
    }

    public long insert(Predio predio) {
        long val = -1;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALPredio dalPredio= new DALPredio(sqLiteDatabase);
        val = dalPredio.insert(predio);
        if (val > 0) {
            dbsqLiteHelper.commit();
            System.out.println("========================================================================== INSERTO");
        }
        dbsqLiteHelper.endTransaction();
        return val;
    }


    public ArrayList<Predio> getAll() {
        ArrayList<Predio> arrayList;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALPredio dalPredio= new DALPredio(sqLiteDatabase);
        arrayList = dalPredio.getAll();
        dbsqLiteHelper.endTransaction();
        return arrayList;
    }
    public void imprimir() {
        ArrayList<Predio> arrayList = getAll();
        for (int i = 0; i < arrayList.size() ; i++) {
            Log.d("GGGG ", "----------------------------------------------------------++++++++++++++++++++++++++++++++++++++++++++"+arrayList.get(i).toString());
        }
    }

    public long delete(String subClase) {
        long val = -1;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALPredio dalPredio= new DALPredio(sqLiteDatabase);
        val = dalPredio.delete(subClase);
        if (val > 0) {
            dbsqLiteHelper.commit();
        }
        dbsqLiteHelper.endTransaction();
        return val;
    }


}
