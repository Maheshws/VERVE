package com.mahesh.verve;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        ImageView img1v= (ImageView) rootView.findViewById(R.id.imageView);
        ImageView img2v= (ImageView) rootView.findViewById(R.id.imageView2);
        ImageView img3v= (ImageView) rootView.findViewById(R.id.imageView3);
        ImageView img4v= (ImageView) rootView.findViewById(R.id.imageView4);
        ImageView img5v= (ImageView) rootView.findViewById(R.id.imageView5);
        try {
            UtilitiesMethod utils=new UtilitiesMethod();
            img1v.setImageBitmap(utils.decodeSampledBitmapFromResource(getResources(), R.drawable.home_img1, 200, 280));
            img2v.setImageBitmap(utils.decodeSampledBitmapFromResource(getResources(),R.drawable.home_img2, 200, 280));
            img3v.setImageBitmap(utils.decodeSampledBitmapFromResource(getResources(),R.drawable.home_img3, 200, 280));
            img4v.setImageBitmap(utils.decodeSampledBitmapFromResource(getResources(),R.drawable.home_img4, 200, 280));
            img5v.setImageBitmap(utils.decodeSampledBitmapFromResource(getResources(),R.drawable.home_img5, 200, 280));


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

