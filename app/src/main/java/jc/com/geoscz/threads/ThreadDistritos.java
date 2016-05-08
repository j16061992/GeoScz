package jc.com.geoscz.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jc.com.geoscz.R;

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

        Peticion peticion=new Peticion();
        peticion.distrito=1111111;
        peticion.uv=2222222;
        peticion.subclase=33333333;
        String serverUrl = "http://192.168.43.236:8080/comercial/rest/test";

        InputStream inputStream = null;
        String result = "";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(serverUrl);
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("distrito", peticion.distrito);
            jsonObject.accumulate("uv", peticion.uv);
            jsonObject.accumulate("4", peticion.subclase);

            json = jsonObject.toString();

            StringEntity se = new StringEntity(json);
            httpPost.setEntity(se);

            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse httpResponse = httpclient.execute(httpPost);

            inputStream = httpResponse.getEntity().getContent();

            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

            Log.i("------------------------------------------------------Respuesta ThreadDistritos", result);

        } catch (Exception e) {
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

    public class Peticion{

        int distrito;
        int uv;
        int subclase;

        @Override
        public String toString() {
            return "Peticion{" +
                    "distrito=" + distrito +
                    ", uv=" + uv +
                    ", subclase=" + subclase +
                    '}';
        }
    }
}
