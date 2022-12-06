package uk.ac.tees.aad.b1795086.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uk.ac.tees.aad.b1795086.R;

public class UserRecipeAdapter extends RecyclerView.Adapter<UserRecipeAdapter.viewholder> {

    Context context;
    ArrayList<UploadRecipeModel> arrayList;

    public UserRecipeAdapter(Context context, ArrayList<UploadRecipeModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.firebase_reciepe,parent,false);
        return new UserRecipeAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        Glide.with(context).load(arrayList.get(position).getImagePath()).into(holder.imageresource);
        holder.Description.setText(arrayList.get(position).getDescription());
        holder.DishTitle.setText(arrayList.get(position).getDishName());
        holder.email.setText("Uploaded by  " +arrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class viewholder extends RecyclerView.ViewHolder
    {

        ImageView imageresource;
        TextView Description;
        TextView DishTitle;
        TextView email;




        public viewholder(@NonNull View itemView) {
            super(itemView);


          imageresource = itemView.findViewById(R.id.imageView3);
          Description = itemView.findViewById(R.id.descriptions);
          DishTitle = itemView.findViewById(R.id.dishname);
          email = itemView.findViewById(R.id.emails);





        }
    }
}
