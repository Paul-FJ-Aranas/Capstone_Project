package paularanas.com.capstone_project.ui;

import android.net.Uri;
import android.os.Bundle;
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
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_space_view, container, false);
        VideoView video = (VideoView) view.findViewById(R.id.space_to_garden);
        String videoUriPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.space_to_oregon_garden;
        MediaController mediaController = new MediaController(getActivity());
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
        mediaController.requestFocus();
        video.setVideoURI(Uri.parse(videoUriPath));
        video.start();


        return view;

    }
}


