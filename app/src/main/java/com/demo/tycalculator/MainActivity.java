package com.demo.tycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText value1, value2, value3;
    String strValue1, strValue2, strValue3, strAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = findViewById(R.id.compute);

        btnCompute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Computing....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        value3 = findViewById(R.id.value3);
        if(value1.getText().toString().isEmpty() || value2.getText().toString().isEmpty() || value3.getText().toString().isEmpty()){
            strValue1 = "0";
            strValue2 = "0";
            strValue3 = "0";
        }else{
            strValue1 = value1.getText().toString();
            strValue2 = value2.getText().toString();
            strValue3 = value3.getText().toString();
        }
        double rawValue1 = Double.parseDouble(strValue1);
        double rawValue2 = Double.parseDouble(strValue2);
        double rawValue3 = Double.parseDouble(strValue3);

        double result = rawValue1 * rawValue2 / rawValue3;

        strAnswer = " Calculated answer is " + (int)  result;

        Bundle args = new Bundle();
        args.putString("result", strAnswer);

        DialogFragment dialogFragmentImp = new DialogFragment();
        dialogFragmentImp.setArguments(args);
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        clearEditText();
    }
    public void clearEditText(){
        value1.getText().clear();
        value2.getText().clear();
        value3.getText().clear();
        value1.requestFocus();
    }
}