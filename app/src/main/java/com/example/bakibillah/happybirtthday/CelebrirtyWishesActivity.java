package com.example.bakibillah.happybirtthday;

import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class CelebrirtyWishesActivity extends AppCompatActivity {
    Button play;
    VideoView videoView;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrirty_wishes);
        play=(Button)this.findViewById(R.id.buttonPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoView vid=(VideoView)findViewById(R.id.video_view);
                vid.setMediaController(new MediaController(CelebrirtyWishesActivity.this));
                Uri video = Uri.parse("android.resource://com.example.bakibillah.happybirtthday/raw/celwish");
                vid.setVideoURI(video);
                vid.requestFocus();
                vid.start();
            }
        });
    }
}
