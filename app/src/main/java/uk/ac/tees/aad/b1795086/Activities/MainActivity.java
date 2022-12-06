package uk.ac.tees.aad.b1795086.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import uk.ac.tees.aad.b1795086.Model.ReciepeAdapter;
import uk.ac.tees.aad.b1795086.Model.ReciepeInformation;
import uk.ac.tees.aad.b1795086.Model.RecipeModel;
import uk.ac.tees.aad.b1795086.NetworkRequest.RequestHandler;
import uk.ac.tees.aad.b1795086.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView  recyclerView;
    Toolbar toolbar;
    ArrayList<RecipeModel> recipeModel;
    ReciepeAdapter reciepeAdapter;
    static String tags = "";
    String urls;

    Button button1,button2,button3,button4;
    public static ArrayList<ReciepeInformation> information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.Meat);
        button2 = findViewById(R.id.Rice);
        button3 = findViewById(R.id.Fish);
        button4 = findViewById(R.id.Soup);

        information = new ArrayList<>();
        Intent intent = getIntent();
     //   toolbar = findViewById(R.id.toolbar);
        Bundle b = intent.getExtras();
        if(b!=null)
        {
            tags = b.getString("tags");
            urls = "https://api.spoonacular.com/recipes/random?number=20&tage="+tags+"&apiKey=21fb507128e049e1ab0dadc9b288425a";
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tags = "Meat";
                recreate();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tags = "Rice";
                recreate();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tags = "Fish";
                recreate();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tags = "Soup";
                recreate();
            }
        });
        recyclerView = findViewById(R.id.rec);
        recipeModel = new ArrayList<>();
        reciepeAdapter = new ReciepeAdapter(recipeModel,MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(reciepeAdapter);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urls, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try
                {
                    JSONArray array = response.getJSONArray("recipes");
                    for(int i = 0;i<array.length();i++) {
                        JSONObject my = array.getJSONObject(i);
                        String x = my.getString("title");
                        String img = my.getString("image");
                        String Summary = my.getString("summary");
                        Summary = Summary.replaceAll("<b>"," ");
                        Summary = Summary.replaceAll("</b>"," ");
                        Summary = Summary.replaceAll("<a>"," ");
                        Summary = Summary.replaceAll("</a>","");

                        String Vegetarian = my.getString("vegetarian");
                        String gluten = my.getString("glutenFree");
                        String dairyfree = my.getString("dairyFree");
                        String timetotal = my.getString("readyInMinutes");
                        String description = my.getString("instructions");
                        description = description.replaceAll("<ol>","");
                        description = description.replaceAll("</ol>","");
                        description = description.replaceAll("<li>","");
                        description = description.replaceAll("</li>","");

                     //   Toast.makeText(MainActivity.this,my.getString("instructions"),Toast.LENGTH_LONG).show();


                        information.add(i,new ReciepeInformation(x,Summary,img,"Mexican Cousine",timetotal,gluten,Vegetarian,dairyfree,description));

                        recipeModel.add(new RecipeModel(img, x));
                }
                    reciepeAdapter.notifyDataSetChanged();
                }
                catch (Exception e)
                {

                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tool_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.one:
                Intent intent = new Intent(MainActivity.this,UploadRecipe.class);
                startActivity(intent);
                break;
            case R.id.two:
                Intent secondintent = new Intent(MainActivity.this,CustomRecipe.class);
                startActivity(secondintent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}