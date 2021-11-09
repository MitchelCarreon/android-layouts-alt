package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class additional_content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_content);

        VideoView videoview = (VideoView) findViewById(R.id.add_on);
        setTitle("");
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.additional_content);

        videoview.setVideoURI(uri);
        videoview.start();
    }
}