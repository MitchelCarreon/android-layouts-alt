package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.LinearLayout;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ualr.layoutassignment.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    public void calculateTotal() {
        Float sum = 0.0f;
        Float discountRate = 0.5f;

        LinearLayout cboxes = this.binding.prodCboxes;
        for (int i = 0; i < cboxes.getChildCount(); ++i) {
            MaterialCheckBox curr_cbox = (MaterialCheckBox) cboxes.getChildAt(i);
            if (curr_cbox.isChecked()) {
                TextInputEditText prod_field = (TextInputEditText) ((TextInputLayout) this.binding.prodFields.getChildAt(i)).getEditText();

                assert prod_field != null;
                String user_input = prod_field.getText().toString();
                if (user_input.matches("[0-9]+")) sum += Float.parseFloat(user_input);
            }
        }

        if (this.binding.discountButton.isChecked()) sum -= (sum * discountRate);

        this.binding.totalDisp.setText(getResources().getString(R.string.dollar_symbol) + " " + sum.toString());
    }

    public void clearAll() {
        LinearLayout fields = this.binding.prodFields;
        for (int i = 0; i < fields.getChildCount(); ++i)
            ((TextInputLayout) fields.getChildAt(i)).getEditText().setText("");

        LinearLayout cboxes = this.binding.prodCboxes;
        for (int i = 0; i < cboxes.getChildCount(); ++i)
            ((MaterialCheckBox) cboxes.getChildAt(i)).setChecked(false);

        this.binding.discountToggleGroup.clearChecked();
        this.binding.totalDisp.setText(getResources().getString(R.string.money_disp_placeholder));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        super.onCreate(savedInstanceState);


        // LISTENERS
        this.binding.calcTotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });
        this.binding.resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });


    }

    // To be implemented
    public void toActivity(View view) {
        Intent intent = new Intent(this, additional_content.class);
        startActivity(intent);
    }
}
