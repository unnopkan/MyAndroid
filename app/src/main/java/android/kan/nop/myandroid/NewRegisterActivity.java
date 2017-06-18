package android.kan.nop.myandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewRegisterActivity extends AppCompatActivity {

    //Explicit
    private ImageView imageView;
    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;
    private String nameString, userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        // Initial View
        initialView();

        // Back Controller
        backController();

        // NewRegister Controller
        newRegisterController();

    }   // Main Method

    private void newRegisterController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get Value From Edit Text
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                // Check Space
                if (nameString.equals("") || userString.equals("") || passwordString.equals("") ) {
                    // Have Space
                    MyAlert myAlert = new MyAlert(NewRegisterActivity.this);
                    myAlert.myDialog("Have Space", "Please Fill All Blank");

                } else {
                    // No Space
                }


            }
        });
    }

    private void backController() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initialView() {
        imageView = (ImageView) findViewById(R.id.btnBack);
        nameEditText = (EditText) findViewById(R.id.edtName);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        button = (Button) findViewById(R.id.btnNewRegister);
    }

}   // Main Class
