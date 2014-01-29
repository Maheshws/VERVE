package com.mahesh.verve;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahesh on 1/28/14.
 */
public class FunEventsListViewFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static String HEADER_BAR;
    private Activity parent;

    private List<EventsObject> allfunEvents = new ArrayList<EventsObject>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events_list_view, container, false);
    }

    public static FunEventsListViewFragment newInstance(int sectionNumber) {
        FunEventsListViewFragment fragment = new FunEventsListViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        parent = activity;
        HEADER_BAR = getString(R.string.title_section7);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
        ((MainActivity) parent).setActionBarTitle(HEADER_BAR);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (allfunEvents.isEmpty()) {
            UtilitiesMethod utils = new UtilitiesMethod();
            utils.fillMyFunEvents(allfunEvents, getActivity());
        }
        populateListView();

        registerClickCallback();

    }

    private void populateListView() {
        ArrayAdapter<EventsObject> adapter = new MyBlogListAdapter(this.getActivity(), R.layout.item_events, allfunEvents);
        ListView list = (ListView) getActivity().findViewById(R.id.EventslistView);
        list.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) getActivity().findViewById(R.id.EventslistView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                EventsObject clickedEvent = allfunEvents.get(position);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, EventViewFragment.newInstance(clickedEvent))
                        .addToBackStack(null)
                        .commit();

            }
        });

    }

    private class MyBlogListAdapter extends ArrayAdapter<EventsObject> {
        ImageView imageView;
        EventsObject current;

        public MyBlogListAdapter(Context context, int resource, List<EventsObject> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = getLayoutInflater(null).inflate(R.layout.item_events, parent, false);
            }

            current = allfunEvents.get(position);

            TextView Titletext = (TextView) view.findViewById(R.id.event_name_textview);
            Titletext.setText(current.getEvent_name());

            return view;
        }

    }

}
