package com.mahesh.verve;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class SplashScreenActivity extends Activity {
    private static final int MAXPROGRESS = 180;
    ProgressBar progress;
    boolean first_run = true;
    Animation animFadein;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 11) {
            getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            getActionBar().hide();
        }
        setContentView(R.layout.splash_screen_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        ImageView imgv = (ImageView) findViewById(R.id.imageView);
        imgv.startAnimation(animFadein);
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#000100"));
        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(MAXPROGRESS);
        SharedPreferences prefs = getSharedPreferences("app_data", 0);
        first_run = prefs.getBoolean("first_run", true);
        new Thread(new Runnable() {
            public void run() {
                startMainActivity();
            }
        }).start();

    }

    public void startMainActivity() {
        updateProgess();
        Boolean errorFlag = false;
        if (!isNetworkAvailable() && first_run == true) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progress.setProgress(MAXPROGRESS);
                    NoConnection("No Internet Connection. Please try again later");
                }
            });

        } else if (first_run == false) {
            try {
                for (int i = 0; i < 13; i++) {
                    Thread.sleep(100);
                    updateProgess2();
                }

            } catch (Exception e) {

            }
            actionComplete();
        } else {
            try {
                UtilitiesMethod utils = new UtilitiesMethod();
                utils.setContext(getApplicationContext());
                updateProgess();
                utils.getTechEvents();
                updateProgess();
                utils.getCultEvents();
                updateProgess();
                utils.getSportsEvents();
                updateProgess();
                utils.getFunEvents();
                updateProgess();
                utils.getAnnouncements();
                updateProgess();
                utils.getSponsors();
                updateProgess();
                errorFlag = utils.getErrorFlag();
                updateProgess();
                if (!errorFlag) {
                    SharedPreferences prefs = getSharedPreferences("app_data", 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("first_run", false);
                    editor.commit();
                    updateProgess();
                    actionComplete();
                } else if (errorFlag && first_run == true) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progress.setProgress(MAXPROGRESS);
                            NoConnection("Unable to connect to server. Please try again later");
                        }
                    });

                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    actionComplete();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    protected void actionComplete() {
        updateProgess();

        SharedPreferences pref = getSharedPreferences("user_settings", 0);
        Boolean Service = pref.getBoolean("Notification", false);
        if (Service) {
            Log.d("service", "Preferences is OFF!!");
        } else {
            startService(new Intent(this, NotificationService.class));
        }
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    protected void updateProgess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.incrementProgressBy(20);
            }
        });
    }

    protected void updateProgess2() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.incrementProgressBy(10);
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void NoConnection(String msg) {
        if (!isFinishing()) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);

            dlgAlert.setMessage(msg);
            dlgAlert.setTitle("No Connection");
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    });
            AlertDialog alert = dlgAlert.create();
            alert.show();

        }
    }


}

