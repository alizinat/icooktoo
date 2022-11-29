package uk.ac.tees.aad.b1795086.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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
    ArrayList<RecipeModel> recipeModel;
    ReciepeAdapter reciepeAdapter;
    static String tags = "";
    String urls;
    public static ArrayList<ReciepeInformation> informations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        informations = new ArrayList<>();
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null)
        {
            tags = b.getString("tags");
            urls = "https://api.spoonacular.com/recipes/random?number=6&tage="+tags+"&apiKey=21fb507128e049e1ab0dadc9b288425a";
        }

        recyclerView = findViewById(R.id.recyclerView);
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
                        String Summry = my.getString("summary");
                        Summry = Summry.replaceAll("<b>"," ");
                        Summry = Summry.replaceAll("</b>"," ");
                        Summry = Summry.replaceAll("<a>"," ");
                        Summry = Summry.replaceAll("</a>","");

                        String Vegetarian = my.getString("vegetarian");
                        String gluten = my.getString("glutenFree");
                        String dairyfree = my.getString("dairyFree");
                        String timetotal = my.getString("readyInMinutes");
                        String description = my.getString("instructions");
                        description = description.replaceAll("<ol>","");
                        description = description.replaceAll("</ol>","");
                        description = description.replaceAll("<li>","");
                        description = description.replaceAll("</li>","");

                        Toast.makeText(MainActivity.this,my.getString("instructions"),Toast.LENGTH_LONG).show();


                        informations.add(i,new ReciepeInformation(x,Summry,img,"Mexican Cousine",timetotal,gluten,Vegetarian,dairyfree,description));

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
}