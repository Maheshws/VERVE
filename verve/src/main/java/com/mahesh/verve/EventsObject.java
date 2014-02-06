package com.mahesh.verve;

/**
 * Created by Mahesh on 1/28/14.
 */
public class EventsObject {
    int event_id;
    String event_name, event_rules, event_description, image_name, event_type;

    public EventsObject(int event_id, String event_name, String event_rules, String event_description, String image_name, String event_type) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_rules = event_rules;
        this.event_description = event_description;
        this.image_name = image_name;
        this.event_type = event_type;
    }

    public int getEvent_id() {
        return event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_rules() {
        return event_rules;
    }

    public String getEvent_description() {
        return event_description;
    }

    public String getImage_name() {
        return image_name;
    }

    public String getEvent_type() {
        return event_type;
    }
}
