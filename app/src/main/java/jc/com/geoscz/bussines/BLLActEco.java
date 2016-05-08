package jc.com.geoscz.bussines;



        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.util.Log;

        import java.util.ArrayList;

        import jc.com.geoscz.data.DALActEco;
        import jc.com.geoscz.data.DALCategoria;
        import jc.com.geoscz.data.DALDistrito;
        import jc.com.geoscz.data.SQLiteHelper;
        import jc.com.geoscz.entity.ActEco;
        import jc.com.geoscz.entity.Categoria;
        import jc.com.geoscz.entity.Distrito;

/**
 * Created by cesar on 07-05-16.
 */
public class BLLActEco {

    private SQLiteHelper dbsqLiteHelper;

    public BLLActEco(Context context) {
        dbsqLiteHelper = new SQLiteHelper(context, null);
    }

    public long insert(ActEco actEco) {
        long val = -1;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALActEco dalActEco= new DALActEco(sqLiteDatabase);
        val = dalActEco.insert(actEco);
        if (val > 0) {
            dbsqLiteHelper.commit();
        }
        dbsqLiteHelper.endTransaction();
        return val;
    }


    public ArrayList<ActEco> getAll(int categoria) {
        ArrayList<ActEco> arrayList;
        SQLiteDatabase sqLiteDatabase = dbsqLiteHelper.beginTransaction();
        DALActEco dalActEco = new DALActEco(sqLiteDatabase);
        arrayList = dalActEco.getAll(categoria);
        dbsqLiteHelper.endTransaction();
        return arrayList;
    }


}
