package com.toreo.torero;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * Simple fragments taken from MainActivity default placeholderfragments
 */
public class Solicita extends Fragment {

    /* The fragment argument representing the section number for this
            * fragment.
    */
    private static final String ARG_SECTION_NUMBER = "section_number";
    // This final can affect the reset function of this section
    EditText nameField;
    EditText lastField;
    EditText streetField;
    EditText numField;
    EditText coloniaField;
    EditText delegField;
    Button buttonSumbit;
    Spinner delegSpinner;
    Spinner finalSpinner;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Solicita newInstance(int sectionNumber) {
        Solicita fragment = new Solicita();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Solicita() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_solicita, container, false);
        nameField = (EditText) rootView.findViewById(R.id.EditTextName);
        lastField = (EditText) rootView.findViewById(R.id.EditTextLast);
        streetField = (EditText) rootView.findViewById(R.id.EditTextStreet);
        numField = (EditText) rootView.findViewById(R.id.EditTextNumb);
        coloniaField = (EditText) rootView.findViewById(R.id.EditTextColonia);
        delegField = (EditText) rootView.findViewById(R.id.EditTextDelegacion);
        delegSpinner = (Spinner) rootView.findViewById(R.id.spinnerDelegacion);
        finalSpinner= (Spinner) rootView.findViewById(R.id.spinnerJuzgado);
        buttonSumbit = (Button) rootView.findViewById(R.id.ButtonSendForm);
        delegSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String firstChoice =delegSpinner.getSelectedItem().toString().replaceFirst("\\s", "");
                int fid = getResources().getIdentifier(firstChoice, "array", getActivity().getBaseContext().getPackageName());
                ArrayAdapter adapter = ArrayAdapter.createFromResource(
                       getActivity(), fid, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                finalSpinner.setAdapter(adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonSumbit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = nameField.getText().toString();
                String lastName = lastField.getText().toString();
                String street = streetField.getText().toString();
                String number = numField.getText().toString();
                String colonia = coloniaField.getText().toString();
                String delegacion = delegField.getText().toString();
                String numSpin = finalSpinner.getSelectedItem().toString();
                Intent sendingIntent = new Intent(getActivity(), ConfirmarActivity.class);
                sendingIntent.putExtra("name", name);
                sendingIntent.putExtra("last", lastName);
                sendingIntent.putExtra("street", street);
                sendingIntent.putExtra("number", number);
                sendingIntent.putExtra("colonia", colonia);
                sendingIntent.putExtra("delegacion", delegacion);
                sendingIntent.putExtra("juzgado", numSpin);
                startActivity(sendingIntent);
            }

        });
        return rootView;
    }
}
