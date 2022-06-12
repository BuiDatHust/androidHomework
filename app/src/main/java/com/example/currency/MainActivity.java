package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText amount;
    Button convertBtn ;
    TextView convertedAmount ;

    CountryItem countryItem ;
    String clickedCountryName ;

    CountryItem countryItemTo ;
    String clickedCountryNameTo ;

    private ArrayList<CountryItem> countryList ;
    private CountryAdapter mAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListCountry() ;

        amount = findViewById(R.id.amount_edit_text) ;
        convertBtn = findViewById(R.id.button) ;
        convertedAmount = findViewById(R.id.converted_amount) ;

        Spinner spinnerCountries = findViewById(R.id.spinner_countries) ;
        Spinner spinnerCountriesTo = findViewById(R.id.spinner_countries_to) ;

        mAdapter = new CountryAdapter(this,countryList) ;
        spinnerCountries.setAdapter(mAdapter);
        spinnerCountriesTo.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countryItem = (CountryItem) adapterView.getItemAtPosition(i) ;
                clickedCountryName = countryItem.getCountryName() ;
                System.out.println(countryItem);
                Toast.makeText(MainActivity.this, clickedCountryName+ " Selected", Toast.LENGTH_SHORT).show() ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerCountriesTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countryItemTo = (CountryItem) adapterView.getItemAtPosition(i) ;
                clickedCountryNameTo = countryItemTo.getCountryName() ;
                System.out.println(countryItemTo);
                Toast.makeText(MainActivity.this, clickedCountryNameTo+ " Selected", Toast.LENGTH_SHORT).show(); ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double totalConvertedAmount ;
                Double firstAmount = Double.parseDouble(amount.getText().toString()) ;

                if(clickedCountryName.equals("USA") && clickedCountryNameTo.equals("VietNam")){
                    totalConvertedAmount = firstAmount*170 ;
                    String res = String.format("%.2f",totalConvertedAmount) ;
                    convertedAmount.setText(""+ res);
                }
            }
        });

    }

    private void initListCountry() {
        countryList = new ArrayList<CountryItem>();
        countryList.add(new CountryItem("Pakistan", R.drawable.pakistan));
        countryList.add(new CountryItem("India", R.drawable.india));
        countryList.add(new CountryItem("VietNam", R.drawable.vietnam));
        countryList.add(new CountryItem("USA", R.drawable.unitedstates));
    }
}