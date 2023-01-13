package com.example.fragments_i_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCarregarFragment1,mBtnCarregarFragment2;

    private TextView mTvDadesCompartides;

    private ItemViewModel mItemModelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicialitzem la variable de tipus ModelView
        mItemModelView = new ViewModelProvider(this).get(ItemViewModel.class);

        //Consultar el valor del VIewModel
        mItemModelView.getDadesLiveData().observe(this, itemObservat ->{
            mTvDadesCompartides.setText(itemObservat);
        });

        CarregaFragment(new Fragment1());

        mBtnCarregarFragment1 = findViewById(R.id.BTN_Fragment1);
        mBtnCarregarFragment2 = findViewById(R.id.BTN_Fragment2);
        mTvDadesCompartides = findViewById(R.id.TV_DadesCompartides);

        mBtnCarregarFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Carreguem el fragment 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FL_ContingutFragments, new Fragment1())
                        .commit();
            }
        });
        mBtnCarregarFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FL_ContingutFragments, new Fragment2())
                        .commit();
            }
        });
    }
    private void CarregaFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_ContingutFragments, fragment)
                .commit();
    }

}