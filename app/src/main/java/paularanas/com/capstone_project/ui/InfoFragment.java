package paularanas.com.capstone_project.ui;

<<<<<<< HEAD
import android.graphics.Typeface;
=======
>>>>>>> bab024aac91d14e0308359db51e3f9a278c4d5c5
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import paularanas.com.capstone_project.R;

/**
 * Created by Paul on 6/18/2016.
 */
public class InfoFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
<<<<<<< HEAD
        Typeface corbelFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Corbel.ttf");
        Typeface candaraFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Candara.ttf");
=======

>>>>>>> bab024aac91d14e0308359db51e3f9a278c4d5c5
        ImageView aboutGardenImage = (ImageView) view.findViewById(R.id.about_garden_image);
        aboutGardenImage.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.about_image));

        TextView aboutText = (TextView) view.findViewById(R.id.garden_about_text);
        aboutText.setText(getActivity().getResources().getString(R.string.about_body_text));
<<<<<<< HEAD
        aboutText.setTypeface(corbelFont);

=======
>>>>>>> bab024aac91d14e0308359db51e3f9a278c4d5c5

        TextView summerHoursTextView = (TextView) view.findViewById(R.id.summer_hours);
        TextView offseasonHoursTextView = (TextView) view.findViewById(R.id.offseason_hours);

        summerHoursTextView.setText(getActivity().getResources().getString(R.string.summer_hours));
        offseasonHoursTextView.setText(getActivity().getResources().getString(R.string.restofyear_hours));
<<<<<<< HEAD
        summerHoursTextView.setTypeface(candaraFont);
        offseasonHoursTextView.setTypeface(candaraFont);
=======
>>>>>>> bab024aac91d14e0308359db51e3f9a278c4d5c5

        TextView _365DaysTextView = (TextView) view.findViewById(R.id._365days_text);
        //TextView phoneNumbersTextView = (TextView) view.findViewById(R.id.phone_numbers);

        _365DaysTextView.setText(getActivity().getResources().getString(R.string.about_365days_text));
<<<<<<< HEAD
        _365DaysTextView.setTypeface(candaraFont);
=======
>>>>>>> bab024aac91d14e0308359db51e3f9a278c4d5c5
       // phoneNumbersTextView.setText(getActivity().getResources().getString(R.string.phone_numbers));





        return view;

    }
}


