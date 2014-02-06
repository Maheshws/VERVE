package com.mahesh.verve;

/**
 * Created by Mahesh on 1/28/14.
 */

import android.app.Application;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;


@ReportsCrashes(
        formKey = "", // This is required for backward compatibility but not used
        formUri = "http://verveoverheat.in/appfiles/logs/report.php"
)
public class VERVEApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }
}
