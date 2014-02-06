package com.mahesh.verve;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Mahesh on 1/30/14.
 */
public class HomeSliderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Activity parent;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HomeSliderFragment newInstance(int sectionNumber) {
        HomeSliderFragment fragment = new HomeSliderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_new, container, false);
        ImageView imgv = (ImageView) rootView.findViewById(R.id.imageView);
        try {
            UtilitiesMethod utils = new UtilitiesMethod();
            imgv.setImageBitmap(utils.decodeSampledBitmapFromResource(getResources(), R.drawable.home_img1, 480, 640));
        } catch (Exception e) {
        }
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        parent = activity;
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    public void onResume() {
        super.onResume();
        ((MainActivity) parent).setActionBarTitle(getString(R.string.title_section2));
    }
}

