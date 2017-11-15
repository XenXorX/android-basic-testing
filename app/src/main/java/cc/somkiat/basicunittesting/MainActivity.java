package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cc.somkiat.basicunittesting.model.User;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.userNameInput);
        email = findViewById(R.id.emailInput);
    }

    public void onSaveClick(View view) {
        ValidationRules validation = new ValidationRules();
        String message = validation.validate(new User(String.valueOf(name.getText()),
                String.valueOf(email.getText())));
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onRevertClick(View view) {
        name.setText("");
        email.setText("");
    }
}
