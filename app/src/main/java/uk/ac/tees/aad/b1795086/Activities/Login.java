package uk.ac.tees.aad.b1795086.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import uk.ac.tees.aad.b1795086.R;

public class Login extends AppCompatActivity {

    Button Login;
    Button SignUp;
    EditText email,pass;
    FirebaseAuth auth;
    TextView fgtext;
    TextView RegesterText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        auth = FirebaseAuth.getInstance();

        Login = findViewById(R.id.Next);
        SignUp = findViewById(R.id.button3);

        email = findViewById(R.id.editTextTextEmailAddresss);
        pass = findViewById(R.id.passwords);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currentemail = email.getText().toString();
                String currentpass = pass.getText().toString();

                if(currentemail.isEmpty())
                {
                    email.setError("Enter the Email");
                    email.requestFocus();
                    return;
                }
                if(currentpass.isEmpty())
                {
                    pass.setError("Enter the pass");
                    pass.requestFocus();
                    return;
                }


                auth.signInWithEmailAndPassword(currentemail,currentpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                           // Toast.makeText(uk.ac.tees.aad.icooktoo_app.Login.this,"Login Succr",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Login.this,MainActivity.class);
                            intent.putExtra("tags","Apple");
                            startActivity(intent);}

                        else
                        {
                           // Toast.makeText(uk.ac.tees.aad.icooktoo_app.Login.this,"Wrong Credentials",Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });

    }
}