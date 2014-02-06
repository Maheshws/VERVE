package com.mahesh.verve;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by Mahesh on 1/3/14.
 */
public class AboutVERVEActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_verve_activity);
        TextView aboutText = (TextView) findViewById(R.id.aboutText);
        String message = "Heat was, is and always will be one of the most powerful driving forces on the face of the planet. An inexhaustible form of energy, an undefined source or a sinewy kinetic. Call it whatever you want! Heat has its undistinguished roots prevailing in every chapter of life. Be it Sports, Technical, Cultural or Literary event…The soaring heat will capture the very essence of VERVE 2014.<br><br>The theme will display a host of refreshing new ideas, enthralling line of speakers, eye-popping performances and absorbing art forms. So, come expecting the unexpected as VERVE 2014 will bring out the HEAT in you! With a magnitude of energique events that have been designed to suit every demographic and excite the passion in you, VERVE 2014 invites you to challenge yourself once again.<br><br>In its 15th year now, VERVE has grown tremendously and established a covetous inter college reputation of its own. Heat signifies something new, something big and something powerful. So let’s take VERVE to even higher limits through its synergy. Let go the Expected! <br><br><b>LET US OVERHEAT!</b>";
        aboutText.setText(Html.fromHtml(message));
    }
}
