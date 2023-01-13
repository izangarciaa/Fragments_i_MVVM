package com.example.fragments_i_mvvm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    private EditText mEtDadesPerCompartir;
    private TextView mTVDadesCompartides;
    private Button mBtnCompartirDades;

    private ItemViewModel mItemModelView;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_1, container, false);

        mEtDadesPerCompartir = v.findViewById(R.id.ET_DadesPerEnviarFrg1);
        mBtnCompartirDades = v.findViewById(R.id.BTN_EnviarDadesFrg1);
        mTVDadesCompartides= v.findViewById(R.id.TV_DadesRebudesFrg1);

        mItemModelView = new ViewModelProvider(this).get(ItemViewModel.class);


        mBtnCompartirDades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Fem un set de la variable del ModelView.
                mItemModelView.setDadesLiveData(mEtDadesPerCompartir.getText().toString());

                mTVDadesCompartides.setText(mEtDadesPerCompartir.getText().toString());

            }
        });

        return v;
    }
}