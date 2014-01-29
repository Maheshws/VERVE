package com.mahesh.verve;

import android.app.Activity;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mahesh on 1/28/14.
 */
public class EventViewFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static EventsObject currentEvent;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EventViewFragment newInstance(EventsObject eventNumber) {
        EventViewFragment fragment = new EventViewFragment();
        Bundle args = new Bundle();
        currentEvent = eventNumber;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_view, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView Titletext = (TextView) getActivity().findViewById(R.id.textEventName);
        String Ttitle=currentEvent.getEvent_name().replace("</br>","<br>");
        Ttitle=Ttitle.replace("\\'","'");
        Titletext.setText(Ttitle);

        TextView Desctext = (TextView) getActivity().findViewById(R.id.textDesc);
        String Desc=currentEvent.getEvent_description().replace("</br>","<br>");
        Desc=Desc.replace("\\'","'");
        if(Desc.equals("null"))
            Desctext.setText(Html.fromHtml(""));
        else
            Desctext.setText(Html.fromHtml(Desc));

        TextView Rulestext = (TextView) getActivity().findViewById(R.id.textEventRules);
        String Rulestxt=currentEvent.getEvent_rules().replace("</br>","<br>");
        Rulestxt=Rulestxt.replace("\\'","'");
        if(Rulestxt.equals("null"))
            Rulestext.setText(Html.fromHtml(""));
        else
            Rulestext.setText(Html.fromHtml(Rulestxt));


        ImageView imageView= (ImageView) getActivity().findViewById(R.id.imageView);
        ImageLoader imgLoader = new ImageLoader(getActivity());
        imgLoader.DisplayImage(currentEvent.getImage_name(), R.drawable.ic_launcher, imageView);
    }
}

