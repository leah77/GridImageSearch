package com.gridimagesearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ejer-Leah on 23-06-2014.
 */
public class ImageResult implements Serializable {
    private static final long serialVersionUID = 2636389073439281291L;
    private String fullUrl;
    private String thumbUrl;

    public ImageResult(JSONObject json) {
        try {
            this.fullUrl = json.getString("url");
            this.thumbUrl = json.getString("tbUrl");
        } catch (JSONException e) {
            this.fullUrl = null;
            this.thumbUrl = null ;
        }
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String toString() {
        return this.thumbUrl;
    }

    public static ArrayList<ImageResult> fromJSONArray(JSONArray array) {
        //TODO Auto-generated method stub
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new ImageResult(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
