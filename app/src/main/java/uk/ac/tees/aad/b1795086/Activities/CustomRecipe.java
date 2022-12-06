package uk.ac.tees.aad.b1795086.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import uk.ac.tees.aad.b1795086.Model.UploadRecipeModel;
import uk.ac.tees.aad.b1795086.Model.UserRecipeAdapter;
import uk.ac.tees.aad.b1795086.R;

public class CustomRecipe extends AppCompatActivity {

    ArrayList<UploadRecipeModel> list;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    UserRecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_recipe);


        list = new ArrayList<>();
        recyclerView = findViewById(R.id.myreac);
        database = FirebaseDatabase.getInstance();
        adapter = new UserRecipeAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        database.getReference().child("uploadRec").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snapshot1: snapshot.getChildren())
                {
                    UploadRecipeModel model = snapshot1.getValue(UploadRecipeModel.class);
                   list.add(model);
                    Toast.makeText(CustomRecipe.this,snapshot1.toString(),Toast.LENGTH_LONG).show();


                }
                adapter.notifyDataSetChanged();
               // Toast.makeText(CustomRecipe.this, snapshot.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}