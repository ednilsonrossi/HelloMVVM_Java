package br.edu.ifsp.hellomvvmjava.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Random;

public class MainViewModel extends ViewModel {
    private final List<String> messages = List.of(
            "Hello, World!",
            "Olá, Mundo!",
            "¡Hola, Mundo!",
            "Bonjour, le Monde!",
            "Hallo, Welt!"
    );

    private MutableLiveData<String> _message = new MutableLiveData<>();
    public final LiveData<String> message = _message;

    public LiveData<String> getMessage() {
        return message;
    }

    public void loadMessage(){
        Random random = new Random();
        int position = random.nextInt(5);
        _message.setValue(messages.get(position));
    }
}
