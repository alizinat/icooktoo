
package uk.ac.tees.aad.b1795086.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mikhaellopez.circularimageview.CircularImageView;

import uk.ac.tees.aad.b1795086.Model.UploadRecipeModel;
import uk.ac.tees.aad.b1795086.R;

public class UploadRecipe extends AppCompatActivity {

   // CircularImageView imageView;
    //private static final int ImagePicker=1;
    //private Uri mimage

    CircularImageView imageView;
    private static final int ImagePicker=1;
    private Uri mimage;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    Button uploadbutton;
    EditText dish, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe);

        getSupportActionBar().hide();

        dish = findViewById(R.id.dishNames);
        description = findViewById(R.id.descriptionsfood);

        imageView = findViewById(R.id.recipeImg);
       // button = findViewById(R.id.upload);

        uploadbutton = findViewById(R.id.uploadbutton);


        storageReference = FirebaseStorage.getInstance().getReference("uploadRec");
        databaseReference = FirebaseDatabase.getInstance().getReference("uploadRec");

        uploadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              UploadToFirebase();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageSelection();
            }
        });

    }

    private String ExtensionGrabber(Uri uri)
    {
        ContentResolver cresolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cresolver.getType(mimage));
    }

    private void UploadToFirebase() {
        if(mimage!= null)
        {
            StorageReference reference = storageReference.child(System.currentTimeMillis()
                    + "." + ExtensionGrabber(mimage));

            reference.putFile(mimage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            String dishname = dish.getText().toString();
                            String des = description.getText().toString();

                            UploadRecipeModel uploadRecipeModel = new UploadRecipeModel(des,dishname,uri.toString(),FirebaseAuth.getInstance().getCurrentUser().getEmail());


                            String myemail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

                            String UploadID = databaseReference.push().getKey();

                            FirebaseAuth.getInstance().getCurrentUser().getDisplayName();


                            databaseReference.child(UploadID).setValue(uploadRecipeModel);

                            Toast.makeText(UploadRecipe.this,"Uploaded",Toast.LENGTH_LONG).show();
                            dish.setText("");
                            description.setText("");
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(UploadRecipe.this,"Failed To load", Toast.LENGTH_LONG).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                    Toast.makeText(UploadRecipe.this,"Uploading",Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void ImageSelection() {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,ImagePicker);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null)
        {
            if(data.getData()!=null)
            {
                mimage = data.getData();
                imageView.setImageURI(mimage);

            }
            else
            {
                Toast.makeText(UploadRecipe.this, "Error Uploading File", Toast.LENGTH_SHORT).show();
            }
        }
    }
}