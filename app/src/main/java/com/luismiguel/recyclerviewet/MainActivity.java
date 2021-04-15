package com.luismiguel.recyclerviewet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvLsPallet;
    String [] pallet = {"165","160","150","110","186","170","140","101","140","126","190","172","113","171","109","146","119","155","136","187","111","102","170","113","142","131","143","198","191","110"};
    String [] temperatura = {"4.4","-2.4","2.4","1.4","3.4","1.6","4.6","2.7","0.7","-2.7","1.8","4.3","-1.4","0.6","3.7","0.4","2.2","0.7","2.3","-3.9","-4","-4.5","4.2","2.2","0.8","0.4","0.9","-1","4.8","4.9"};
    int [] rutaPallet = {0,0,1,1,0,1,1,1,0,1,0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,1,1,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvLsPallet = findViewById(R.id.rvLsPalletOrden);
        List<PalletTempModel> palletTempModelList = new ArrayList<PalletTempModel>();

        for(int i= 0; i < 30; i++){
            PalletTempModel palletTempModel = new PalletTempModel();
            palletTempModel.numePallet = pallet[i];
            palletTempModel.temperatura = temperatura[i];
            palletTempModel.rutaPallet = rutaPallet[i];
            palletTempModelList.add(palletTempModel);
        }

        OrdenTempAdapter ordenTempAdapter = new OrdenTempAdapter(getApplicationContext());
        ordenTempAdapter.setPalletTempModelList(palletTempModelList);

        rvLsPallet.setHasFixedSize(true);
        rvLsPallet.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvLsPallet.setAdapter(ordenTempAdapter);
    }
}