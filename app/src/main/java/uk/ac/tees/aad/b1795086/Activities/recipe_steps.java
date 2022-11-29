package uk.ac.tees.aad.b1795086.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import uk.ac.tees.aad.b1795086.R;

public class recipe_steps extends AppCompatActivity {

    TextView DishName,Summry,Description,Cousine,GlutenFree,Vegiatrian,DairyFree,TotalTime;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);

        DishName = findViewById(R.id.DishName);
        Summry = findViewById(R.id.Summry);
        Description = findViewById(R.id.description);
        Cousine = findViewById(R.id.textView10);
        GlutenFree = findViewById(R.id.textView8);
        Vegiatrian = findViewById(R.id.textView7);
        DairyFree = findViewById(R.id.textView6);
        TotalTime = findViewById(R.id.textView5);
        imageView = findViewById(R.id.Foodimg);

        Intent checker = getIntent();
        Bundle b = checker.getExtras();
        if(b != null)
        {
            int dish = b.getInt("value");
            if(dish==0)
            {

               DishName.setText(MainActivity.informations.get(0).getInformation());
               Summry.setText(MainActivity.informations.get(0).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(0).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(0).getDescription());
                Cousine.setText(MainActivity.informations.get(0).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(0).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(0).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(0).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(0).getTimeRequired());
            }
            if(dish==1)
            {

                DishName.setText(MainActivity.informations.get(1).getInformation());
                Summry.setText(MainActivity.informations.get(1).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(1).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(1).getDescription());
                Cousine.setText(MainActivity.informations.get(1).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(1).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(1).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(1).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(1).getTimeRequired());
            }
            if(dish==2)
            {

                DishName.setText(MainActivity.informations.get(2).getInformation());
                Summry.setText(MainActivity.informations.get(2).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(2).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(2).getDescription());
                Cousine.setText(MainActivity.informations.get(2).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(2).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(2).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(2).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(2).getTimeRequired());
            }
            if(dish==3)
            {

                DishName.setText(MainActivity.informations.get(3).getInformation());
                Summry.setText(MainActivity.informations.get(3).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(3).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(3).getDescription());
                Cousine.setText(MainActivity.informations.get(3).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(3).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(3).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(3).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(3).getTimeRequired());
            }
            if(dish==4)
            {

                DishName.setText(MainActivity.informations.get(4).getInformation());
                Summry.setText(MainActivity.informations.get(4).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(4).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(4).getDescription());
                Cousine.setText(MainActivity.informations.get(4).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(4).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(4).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(4).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(4).getTimeRequired());
            }
            if(dish==5)
            {

                DishName.setText(MainActivity.informations.get(5).getInformation());
                Summry.setText(MainActivity.informations.get(5).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(5).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(5).getDescription());
                Cousine.setText(MainActivity.informations.get(5).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(5).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(5).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(5).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(5).getTimeRequired());
            }
            if(dish==6)
            {

                DishName.setText(MainActivity.informations.get(6).getInformation());
                Summry.setText(MainActivity.informations.get(6).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(6).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(6).getDescription());
                Cousine.setText(MainActivity.informations.get(6).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(6).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(6).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(6).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(6).getTimeRequired());
            }
            if(dish==7)
            {

                DishName.setText(MainActivity.informations.get(7).getInformation());
                Summry.setText(MainActivity.informations.get(7).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(7).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(7).getDescription());
                Cousine.setText(MainActivity.informations.get(7).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(7).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(7).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(7).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(7).getTimeRequired());
            }
            if(dish==8)
            {

                DishName.setText(MainActivity.informations.get(8).getInformation());
                Summry.setText(MainActivity.informations.get(8).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(8).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(8).getDescription());
                Cousine.setText(MainActivity.informations.get(8).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(8).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(8).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(8).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(8).getTimeRequired());
            }
            if(dish==9)
            {

                DishName.setText(MainActivity.informations.get(9).getInformation());
                Summry.setText(MainActivity.informations.get(9).getSummry());
                Glide.with(getApplicationContext()).load(MainActivity.informations.get(9).getImagePath()).into(imageView);
                Description.setText(MainActivity.informations.get(9).getDescription());
                Cousine.setText(MainActivity.informations.get(9).getCounsine());
                GlutenFree.setText("Gluten Free: "+ MainActivity.informations.get(9).getGluten());
                Vegiatrian.setText("Vegitarian: "+ MainActivity.informations.get(9).getVeg());
                DairyFree.setText("DairyFree: " + MainActivity.informations.get(9).getDairy());
                TotalTime.setText("Ready in Minutues: "+MainActivity.informations.get(9).getTimeRequired());
            }
        }

    }
}