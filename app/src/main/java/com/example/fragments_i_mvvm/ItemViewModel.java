package com.example.fragments_i_mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    private static final MutableLiveData<String> dadesLiveData = new MutableLiveData<>();

    //Definir un set i get de l'atribut
    public void setDadesLiveData(String item){
        dadesLiveData.setValue(item);
    }
    public LiveData<String> getDadesLiveData(){
        return dadesLiveData;
    }

}
