package com.mahesh.verve;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Mahesh on 1/28/14.
 */
public class UtilitiesMethod {
    private boolean ErrorFlag=false;
    private Context context;
    //private final String DOMAIN="http://192.168.2.7/appfiles/";
    private final String DOMAIN="http://verveoverheat.in/appfiles/";
    private final String IMAGEURL="http://verveoverheat.in/ad_panel/pic/";



    public void setContext(Context c) {
        context = c;
    }
    public void getTechEvents() {
            String URL = "gettechevents.php";
            String RESULT;
            String toFile = DOMAIN + URL;
            InputStream isr = null;
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(toFile);
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                isr = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(isr, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                isr.close();
                RESULT = sb.toString();
                if (RESULT == null) {
                    Log.e("log_utils_tech_events", "Error in http connection ");
                    ErrorFlag = true;
                } else {
                    SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("techeventslist", RESULT);
                    editor.commit();
                }
            } catch (Exception e) {
                Log.e("log_utils_tech_events", "Error in http connection " + e.toString());
                ErrorFlag = true;
            }

    }


    public void getCultEvents() {
        String URL = "getcultevents.php";
        String RESULT;
        String toFile = DOMAIN + URL;
        InputStream isr = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(toFile);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            isr.close();
            RESULT = sb.toString();
            if (RESULT == null) {
                Log.e("log_utils_cult_events", "Error in http connection ");
                ErrorFlag = true;
            } else {
                SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("culteventslist", RESULT);
                editor.commit();
            }
        } catch (Exception e) {
            Log.e("log_utils_cult_events", "Error in http connection " + e.toString());
            ErrorFlag = true;
        }

    }

    public void getSportsEvents() {
        String URL = "getsportsevents.php";
        String RESULT;
        String toFile = DOMAIN + URL;
        InputStream isr = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(toFile);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            isr.close();
            RESULT = sb.toString();
            if (RESULT == null) {
                Log.e("log_utils_sports_events", "Error in http connection ");
                ErrorFlag = true;
            } else {
                SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("sportseventslist", RESULT);
                editor.commit();
            }
        } catch (Exception e) {
            Log.e("log_utils_sports_events", "Error in http connection " + e.toString());
            ErrorFlag = true;
        }

    }
    public void getFunEvents() {
        String URL = "getfunevents.php";
        String RESULT;
        String toFile = DOMAIN + URL;
        InputStream isr = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(toFile);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            isr.close();
            RESULT = sb.toString();
            if (RESULT == null) {
                Log.e("log_utils_fun_events", "Error in http connection ");
                ErrorFlag = true;
            } else {
                SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("funeventslist", RESULT);
                editor.commit();
            }
        } catch (Exception e) {
            Log.e("log_utils_fun_events", "Error in http connection " + e.toString());
            ErrorFlag = true;
        }

    }

    public boolean getErrorFlag() {
        return ErrorFlag;
    }

    public void fillMyTechEvents(List<EventsObject> alltechEvents, Context context) {
        SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
        String result = prefs.getString("techeventslist", null);
        try {
            JSONArray jArray = new JSONArray(result);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                alltechEvents.add(new EventsObject(json.getInt("event_id"), json.getString("event_name"), json.getString("event_rules"), json.getString("event_description"), IMAGEURL+json.getString("image_name"), json.getString("event_type")));
            }

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag_fillTechevents", "Error Parsing Data " + e.toString());
        }

    }

    public void fillMyCultEvents(List<EventsObject> allcultEvents, Context context) {

        SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
        String result = prefs.getString("culteventslist", null);
        try {
            JSONArray jArray = new JSONArray(result);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                allcultEvents.add(new EventsObject(json.getInt("event_id"), json.getString("event_name"), json.getString("event_rules"), json.getString("event_description"), IMAGEURL+json.getString("image_name"), json.getString("event_type")));
            }

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag_fillCultevents", "Error Parsing Data " + e.toString());
        }

    }

    public void fillMyFunEvents(List<EventsObject> allfunEvents,Context context) {
        SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
        String result = prefs.getString("funeventslist", null);
        try {
            JSONArray jArray = new JSONArray(result);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                allfunEvents.add(new EventsObject(json.getInt("event_id"), json.getString("event_name"), json.getString("event_rules"), json.getString("event_description"), IMAGEURL+json.getString("image_name"), json.getString("event_type")));
            }

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag_fillFunevents", "Error Parsing Data " + e.toString());
        }
    }

    public void fillMySportsEvents(List<EventsObject> allspEvents, Context context) {
        SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
        String result = prefs.getString("sportseventslist", null);
        try {
            JSONArray jArray = new JSONArray(result);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                allspEvents.add(new EventsObject(json.getInt("event_id"), json.getString("event_name"), json.getString("event_rules"), json.getString("event_description"), IMAGEURL+json.getString("image_name"), json.getString("event_type")));
            }

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag_fillSportsevents", "Error Parsing Data " + e.toString());
        }
    }
}
