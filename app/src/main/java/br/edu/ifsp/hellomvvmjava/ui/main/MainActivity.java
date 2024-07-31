package br.edu.ifsp.hellomvvmjava.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import br.edu.ifsp.hellomvvmjava.R;
import br.edu.ifsp.hellomvvmjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.message.observe(this, string -> {
            binding.textMessage.setText(string);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.loadMessage();
    }
}