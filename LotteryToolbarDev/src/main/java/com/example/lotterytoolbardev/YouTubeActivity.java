package com.example.lotterytoolbardev;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity {

    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);

        // Get Reference to the YouTube Player View
        youTubePlayerView = findViewById(R.id.youtubePlayerView);

        // Fetch YouTube video ID
        Intent intent = getIntent();
        String videoID = intent.getStringExtra(MainActivity.YOUTUBEID);
        playVideo(videoID, youTubePlayerView);
    }

    public void playVideo(final String videoId, YouTubePlayerView youTubePlayerView) {

        // Initialize YouTube Player View
        // Google YouTube API key (to retrieve from https://console.developers.google.com/)
        youTubePlayerView.initialize(APIKey.API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.cueVideo(videoId);
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {
                        Log.d("YouTube", "Initialization of the player fails!");

                    }
                });

    }
}