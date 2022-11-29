package uk.ac.tees.aad.b1795086.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import uk.ac.tees.aad.b1795086.R;

public class Registration extends AppCompatActivity {

    FirebaseAuth auth;

    EditText UserEmail, UserPassword,UserName;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        UserEmail = findViewById(R.id.editTextTextEmailAddress);
        UserPassword = findViewById(R.id.password);
        UserName = findViewById(R.id.personName);

        Register = findViewById(R.id.Next);
        auth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRegistration();
            }
        });

    }

    public void UserRegistration()
    {

        String email = UserEmail.getText().toString();
        String password = UserPassword.getText().toString();
        String name = UserName.getText().toString();

        if(email.isEmpty())
        {
            UserEmail.setError("Required");
            UserEmail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            UserPassword.setError("Required");
            UserPassword.requestFocus();
            return;
        }

        if(name.isEmpty())
        {
            UserName.setError("Required");
            UserName.requestFocus();
            return;
        }

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    // Model model = new Model()
                   // Toast.makeText(uk.ac.tees.aad.icooktoo_app.Register.this,"sdd", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registration.this, Login.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(Registration.this,"un sucessfull", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}