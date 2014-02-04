package com.mahesh.verve;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by Mahesh on 1/28/14.
 */
public class SponsorsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SponsorsFragment newInstance(int sectionNumber) {
        SponsorsFragment fragment = new SponsorsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sponsors, container, false);

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
        new Thread(new Runnable() {
            public void run() {
                UtilitiesMethod utils=new UtilitiesMethod();
                utils.setContext(getActivity());
                utils.getSponsors();
                final String contentHTML=utils.getSponsorsList();
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    WebView contentView = (WebView) getActivity().findViewById(R.id.webView);
                    contentView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                    contentView.getSettings().setLoadWithOverviewMode(true);
                    contentView.getSettings().setUseWideViewPort(true);
                    contentView.getSettings().setBuiltInZoomControls(false);
                    contentView.setBackgroundColor(Color.TRANSPARENT);
                    contentView.loadDataWithBaseURL(null, contentHTML, "text/html", "UTF-8", null);
                }
            });

            }
        }).start();


    }
}

