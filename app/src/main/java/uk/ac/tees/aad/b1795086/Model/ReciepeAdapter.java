package uk.ac.tees.aad.b1795086.Model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uk.ac.tees.aad.b1795086.Activities.recipe_steps;
import uk.ac.tees.aad.b1795086.R;



public class ReciepeAdapter extends RecyclerView.Adapter<ReciepeAdapter.viewholder>{

    public ArrayList<RecipeModel> recipeModels ;
    public Context context;

    public ReciepeAdapter(ArrayList<RecipeModel> recipeModels, Context context) {
        this.recipeModels = recipeModels;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reciepe_detail,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(recipeModels.get(position).getImageSource()).into(holder.imageresource);
        holder.Description.setText(recipeModels.get(position).getDescription());

        holder.imageresource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position ==0)
                {
                   // uk.ac.tees.aad.b1795086.Activities.recipe_steps
                    Intent intent = new Intent(context.getApplicationContext(), uk.ac.tees.aad.b1795086.Activities.recipe_steps.class);
                    intent.putExtra("value",0);
                    context.startActivity(intent);

                }
                if(position ==1)
                {
                   Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",1);
                    context.startActivity(intent);

                }
                if(position ==2)
                {
                    Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",2);
                    context.startActivity(intent);

                }
                if(position ==3)
                {
                    Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",3);
                    context.startActivity(intent);

                }
                if(position ==4)
                {
                    Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",4);
                    context.startActivity(intent);

                }
                if(position ==5)
                {
                    Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",5);
                    context.startActivity(intent);

                }
                if(position ==6)
                {
                    Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",6);
                    context.startActivity(intent);

                }
                if(position == 7)
                {
                    Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",7);
                    context.startActivity(intent);

                }
                if(position ==8)
                {
                    Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",8);
                    context.startActivity(intent);

                }
                if(position ==9)
                {
                    Intent intent = new Intent(context.getApplicationContext(), recipe_steps.class);
                    intent.putExtra("value",9);
                    context.startActivity(intent);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipeModels.size();
    }

    class viewholder extends RecyclerView.ViewHolder
    {

        ImageView imageresource;
        TextView Description;




        public viewholder(@NonNull View itemView) {
            super(itemView);


            imageresource = itemView.findViewById(R.id.imageView);
            Description = itemView.findViewById(R.id.textView);





        }
    }
}
