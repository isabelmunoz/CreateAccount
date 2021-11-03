package com.example.createaccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.widget.Toast;

import com.example.createaccount.databinding.ActivityCreateAccountBinding;

public class CreateAccountActivity extends AppCompatActivity {

    private ActivityCreateAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        setContentView(binding.getRoot());
        setClickListener();
    }

    private void setClickListener() {
        binding.btnCrearCuenta.setOnClickListener(v -> {
            registrarUsuario();
        });
    }

    private void registrarUsuario() {
        if(isValidValues()){
            Toast.makeText(this,"usuario creado",Toast.LENGTH_LONG).show();
        }
    }

    private boolean isValidValues() {

        isNotEmptyEditText(binding.etPassword,"El Password no puede estar en blanco");
        isNotEmptyEditText(binding.etEmail,"El Email no puede estar en blanco");
        isNotEmptyEditText(binding.etApellido,"El Apellido no puede estar en blanco");
        isNotEmptyEditText(binding.etNombre,"El Nombre no puede estar en blanco");
        return true;
    }

    private boolean isNotEmptyEditText(AppCompatEditText editText,String errorMessage) {
        if(editText.getText().toString().isEmpty()){
            editText.setError(errorMessage);
            editText.requestFocus();
            return false;
        }
        return true;
    }


    private void initBinding() {
        binding=ActivityCreateAccountBinding.inflate(getLayoutInflater());
    }
}