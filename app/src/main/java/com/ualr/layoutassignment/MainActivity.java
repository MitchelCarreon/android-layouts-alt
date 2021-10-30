package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ualr.layoutassignment.databinding.ActivityMainBinding;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    public void calculateTotal() {
        Float sum = 0.0f;

        LinearLayout cboxes = binding.prodCboxes;
        for (int i = 0; i < cboxes.getChildCount(); ++i){
            MaterialCheckBox curr_cbox = (MaterialCheckBox)cboxes.getChildAt(i);
            if (curr_cbox.isChecked()) {
                TextInputEditText prod_field = (TextInputEditText) ((TextInputLayout) binding.prodFields.getChildAt(i)).getEditText();

                assert prod_field != null;
                String user_input = prod_field.getText().toString();
                if (!user_input.matches("")) sum += Float.parseFloat(user_input);
            }
        }

        this.binding.totalDisp.setText(getResources().getString(R.string.dollar_symbol) + " " + sum.toString());
    }

    public void clearInvoice(){
        LinearLayout fields = binding.prodFields;
        for (int i = 0; i < fields.getChildCount(); ++i) ((TextInputLayout) fields.getChildAt(i)).getEditText().setText("");

        LinearLayout cboxes = binding.prodCboxes;
        for (int i = 0; i < cboxes.getChildCount(); ++i) ((MaterialCheckBox)cboxes.getChildAt(i)).setChecked(false);
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
                clearInvoice();
            }
        });

    }
}