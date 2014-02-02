package com.mahesh.verve;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Mahesh on 1/28/14.
 */
public class UtilitiesMethod {
    private boolean ErrorFlag=false;
    private Context context;
    //private final String DOMAIN="http://192.168.43.147/appfiles/";
    //private final String DOMAIN="http://192.168.2.7/appfiles/";
    private final String DOMAIN="http://verveoverheat.in/appfiles/";
    private final String IMAGEURL="http://verveoverheat.in/ad_panel/pic/";
    int serverAnnouncementindex=0;
    private String ATitle,AMessage;


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
    public void getAnnouncements() {
            String URL = "getannouncements.php";
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
                    Log.e("log_utils_announcements", "Error in http connection ");
                    ErrorFlag = true;
                } else {
                    SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("announcementslist", RESULT);
                    Log.e("log_utils_announcements", RESULT);
                    editor.commit();
                }
            } catch (Exception e) {
                Log.e("log_utils_announcements", "Error in http connection " + e.toString());
                ErrorFlag = true;
            }

    }
    public boolean getAnnouncementIndex() {
        int currentAnnouncementIndex = 0;
        String URL = "getlatestindex.php";
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
                Log.e("log_utils_blog", "Error in http connection ");

                ErrorFlag = true;
            } else {

                serverAnnouncementindex = Integer.parseInt(RESULT.trim());
                SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
                SharedPreferences.Editor editor = prefs.edit();
                currentAnnouncementIndex = prefs.getInt("currentAnnouncement", 0);
                Log.e("log_utils_index",  currentAnnouncementIndex+"    "+serverAnnouncementindex);
                if (currentAnnouncementIndex < serverAnnouncementindex) {
                    editor.putInt("currentAnnouncement", serverAnnouncementindex);
                    editor.commit();
                    Log.e("log_utils_index", "new announcement available");
                    return true;
                } else
                    return false;
            }
        } catch (Exception e) {
            Log.e("log_utils_getancc", "Error in http connection " + e.toString());
            e.printStackTrace();
            ErrorFlag = true;
        }
        return false;
    }

    public void getCurrentAnnouncement() {
        String URL = "getnotifications.php";
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
                Log.e("log_utils_curr_events", "Error in http connection ");
                ErrorFlag = true;
            } else {
                try {
                    Log.e("log_utils_curr_events", RESULT);
                    JSONArray jArray = new JSONArray(RESULT);
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject json = jArray.getJSONObject(i);
                        ATitle = json.getString("title");
                        AMessage = json.getString("message");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    Log.e("log_utils_curr_events", "Error Parsing Data " + e.toString(), e);
                }
            }
        } catch (Exception e) {
            Log.e("log_utils_curr_events", "Error in http connection " + e.toString());
            ErrorFlag = true;
        }
    }

    public String getATitle() {
        return ATitle;
    }

    public String getAMessage() {
        return AMessage;

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


    public void fillMyAnnouncements(List<AnnouncementObject> allAnnouncements, Context context) {
        SharedPreferences prefs = context.getSharedPreferences("app_data", 0);
        String result = prefs.getString("announcementslist", null);
        try {
            JSONArray jArray = new JSONArray(result);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                allAnnouncements.add(new AnnouncementObject(json.getInt("id"), json.getString("title"), json.getString("message")));
            }
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag_announcement", "Error Parsing Data for announcement" + e.toString());
            e.printStackTrace();
        }
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
