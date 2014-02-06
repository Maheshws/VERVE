package com.mahesh.verve;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Mahesh on 1/30/14.
 */
public class ContactFragment extends Fragment {
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
    public static ContactFragment newInstance(int sectionNumber) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
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
        ((MainActivity) parent).setActionBarTitle(getString(R.string.title_section9));
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isGMaps()) {
            ImageView map123 = (ImageView) getActivity().findViewById(R.id.imageView);
            map123.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("geo:19.021652,72.870715?q=19.021652,72.87071499999(Vidyalankar Institute of Technology)");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        }
    }

    public boolean isGMaps() {
        try {
            ApplicationInfo info = getActivity().getPackageManager().getApplicationInfo("com.google.android.maps", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ApplicationInfo info = getActivity().getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }
}
