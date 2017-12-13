package com.example.bakibillah.happybirtthday;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class BurakWishActivity extends AppCompatActivity {
    Button play;
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burak_wish);
        play=(Button)this.findViewById(R.id.buttonPlayB);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoView vid=(VideoView)findViewById(R.id.video_viewB);
                vid.setMediaController(new MediaController(BurakWishActivity.this));
                Uri video = Uri.parse("android.resource://com.example.bakibillah.happybirtthday/raw/burak");
                vid.setVideoURI(video);
                vid.requestFocus();
                vid.start();
            }
        });
    }
}
