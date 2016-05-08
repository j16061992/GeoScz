package jc.com.geoscz.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by cesar on 07-05-16.
 */
public class ThreadDistritos extends AsyncTask {

    String respuesta = "";
    Context context;

    public ThreadDistritos(Context context) {
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        String serverUrl = "http://192.168.43.200/Hackaton/service/getDistrito.php";

        InputStream inputStream = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(serverUrl);
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("distrito","AA");
            jsonObject.accumulate("uv", "AA");
            jsonObject.accumulate("4", "AA");

            json = jsonObject.toString();

            StringEntity se = new StringEntity(json);
            httpPost.setEntity(se);

            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse httpResponse = httpclient.execute(httpPost);

            inputStream = httpResponse.getEntity().getContent();

            if(inputStream != null)
                respuesta = convertInputStreamToString(inputStream);
            else
                respuesta = "Did not work!";


            JSONArray jArray = new JSONArray(respuesta);
            for(int i=0; i<jArray.length(); i++){
                JSONObject json_data = jArray.getJSONObject(i);

                Log.i("log_tag", "****************************************************  latitud" + json_data.getDouble("latitud") +
                                ", longitud" + json_data.getDouble("longitud")
                );
            }        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }


        return null;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

}
