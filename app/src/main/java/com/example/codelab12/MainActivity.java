package com.example.codelab12;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codelab11.R;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button zeroBtn ;
    private Button countBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView) findViewById(R.id.show_count);
        zeroBtn = (Button) findViewById(R.id.button);
        countBtn = (Button) findViewById(R.id.button_count)       ;

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void resetCount(View view){
        mCount= 0 ;
        mShowCount.setText(Integer.toString(mCount));
        zeroBtn.setBackgroundColor(Color.parseColor("#B2ADB3"));

    }

    public void countUp(View view) {
        mCount++;

        if(mCount==1){
            zeroBtn.setBackgroundColor(Color.parseColor("#EE83CF"));
        }

        if(mCount%2 ==0){
            countBtn.setBackgroundColor(Color.parseColor("#60DC82"));
        }else{
            countBtn.setBackgroundColor(Color.parseColor("#C560DC"));
        }

        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

}