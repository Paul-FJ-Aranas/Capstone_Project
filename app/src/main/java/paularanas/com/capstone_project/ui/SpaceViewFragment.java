package paularanas.com.capstone_project.ui;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import paularanas.com.capstone_project.R;

/**
 * Created by Paul on 6/18/2016.
 */
public class SpaceViewFragment extends android.support.v4.app.Fragment {
    VideoView mVideoView;
    private int position = 1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null)
        {position = savedInstanceState.getInt("position");}

        View view = inflater.inflate(R.layout.fragment_space_view, container, false);
        mVideoView = (VideoView) view.findViewById(R.id.space_to_garden);
        String videoUriPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.space_to_oregon_garden;
        mVideoView.setVideoURI(Uri.parse(videoUriPath));
        //mVideoView.start();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });



            MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(mVideoView);

                mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer)
                    {
                        mVideoView.seekTo(1);
                        mVideoView.start();
                    }
                });
                if (position != 1)
                {
                    mVideoView.seekTo(position);
                    mVideoView.start();
                }
                else
                {
                    mVideoView.seekTo(1);

                }



        return view;

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        if (mVideoView != null) {
            savedInstanceState.putInt("position", mVideoView.getCurrentPosition());
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}


