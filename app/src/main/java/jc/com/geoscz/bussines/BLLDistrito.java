package jc.com.geoscz.bussines;



        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.util.Log;


        import java.util.ArrayList;

        import jc.com.geoscz.data.DALDistrito;
        import jc.com.geoscz.data.SQLiteHelper;
        import jc.com.geoscz.entity.Distrito;

/**
 * Created by DavorLimachi on 7/30/15.
 */
public class BLLDistrito {
    private SQLiteHelper dbsqLiteHelper;

    public BLLDistrito(Context context) {
        dbsqLiteHelper = new SQLiteHelper(context, null);
    }

    public long insert(Distrito distrito) {
        long val = -1;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALDistrito dalDistrito= new DALDistrito(sqLiteDatabase);
        val = dalDistrito.insert(distrito);
        if (val > 0) {
            dbsqLiteHelper.commit();
        }
        dbsqLiteHelper.endTransaction();
        return val;
    }


    public ArrayList<Distrito> getAll() {
        ArrayList<Distrito> arrayList;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALDistrito dalDistrito = new DALDistrito(sqLiteDatabase);
        arrayList = dalDistrito.getAll();
        dbsqLiteHelper.endTransaction();
        return arrayList;
    }

    public void imprimirDistritos() {
        ArrayList<Distrito> arrayList = getAll();
        for (int i = 0; i < arrayList.size(); i++) {
            Log.d("-------------------------------------------",arrayList.get(i).toString());
        }
    }


}

