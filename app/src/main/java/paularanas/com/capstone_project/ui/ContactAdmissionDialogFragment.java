package paularanas.com.capstone_project.ui;

import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import paularanas.com.capstone_project.R;

/**
 * Created by Paul Aranas on 7/2/2016.
 */
public class ContactAdmissionDialogFragment extends DialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_contact_admission, container, false);
        Typeface candaraFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Candara.ttf");
        TextView admissionText = (TextView) view.findViewById(R.id.admission_text);
        TextView contactText = (TextView) view.findViewById(R.id.contact_text);
        TextView hoursText = (TextView) view.findViewById(R.id.summer_hours_text);
        TextView restOfYearText = (TextView) view.findViewById(R.id.rest_of_year_hours_text);
        restOfYearText.setTypeface(candaraFont);
        restOfYearText.setText(getActivity().getText(R.string.restofyear_hours));
        hoursText.setTypeface(candaraFont);
        hoursText.setText(getActivity().getText(R.string.summer_hours));
        admissionText.setTypeface(candaraFont);
        contactText.setTypeface(candaraFont);
        admissionText.setText(getActivity().getText(R.string.admission_prices));
        contactText.setText(getActivity().getText(R.string.phone_numbers));
        getDialog().setTitle("Admission and Contact Info");
        return view;
    }
}
