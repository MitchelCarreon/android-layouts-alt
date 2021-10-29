package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.ualr.layoutassignment.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money
    public void calculateTotal(){
        Float sum = 0.0f;
        if (this.binding.product01.isChecked())sum += Float.parseFloat(this.binding.prod01Field.getText().toString());
        if (this.binding.product02.isChecked())sum += Float.parseFloat(this.binding.prod02Field.getText().toString());
        if (this.binding.product03.isChecked())sum += Float.parseFloat(this.binding.prod03Field.getText().toString());
        if (this.binding.product04.isChecked())sum += Float.parseFloat(this.binding.prod04Field.getText().toString());

        this.binding.totalDisp.setText("$ " + sum.toString());

    }
    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        super.onCreate(savedInstanceState);


        this.binding.calcTotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });
    }
}