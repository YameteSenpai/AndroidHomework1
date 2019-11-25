package naillibip.firstapp.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private TextView temperatureText, feelsLikeTempText;
    private Spinner citiesSpinner;
    private Button todayBtn, tomorrowBtn;
    private ImageView cityImage;
    private ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnChangeBtnClick();
        setOnSpinnerChoosed();

    }

    private void initViews() {
        temperatureText = findViewById(R.id.temperatureTxt);
        feelsLikeTempText = findViewById(R.id.feelsLikeTempTxt);
        citiesSpinner = findViewById(R.id.citiesSpinner);

        cityImage = findViewById(R.id.cityImage);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citiesSpinner.setAdapter(adapter);
        todayBtn = findViewById(R.id.todayBtn);
        tomorrowBtn = findViewById(R.id.tomorrowBtn);
    }

    private void setOnChangeBtnClick() {

        todayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (citiesSpinner.getSelectedItem().equals(adapter.getItem(0))) {
                    temperatureText.setText("-1");
                    feelsLikeTempText.setText("-1");
                }
                if (citiesSpinner.getSelectedItem().equals(adapter.getItem(1))) {
                    temperatureText.setText("-6");
                    feelsLikeTempText.setText("-9");
                }
                if (citiesSpinner.getSelectedItem().equals(adapter.getItem(2))) {
                    temperatureText.setText("2");
                    feelsLikeTempText.setText("1");
                }
            }
        });

        tomorrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (citiesSpinner.getSelectedItem().equals(adapter.getItem(0))) {
                    temperatureText.setText("-5");
                    feelsLikeTempText.setText("-10");
                }
                else if (citiesSpinner.getSelectedItem().equals(adapter.getItem(1))) {
                    temperatureText.setText("-10");
                    feelsLikeTempText.setText("-15");
                }
                else if (citiesSpinner.getSelectedItem().equals(adapter.getItem(2))) {
                    temperatureText.setText("-5");
                    feelsLikeTempText.setText("-10");
                }
            }
        });
    }

    private void setOnSpinnerChoosed() {
        citiesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0) {
                    cityImage.setImageResource(R.drawable.moscow);

                }
                if (i==1) {
                    cityImage.setImageResource(R.drawable.spb);

                }
                if (i==2) {
                    cityImage.setImageResource(R.drawable.kazan);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}