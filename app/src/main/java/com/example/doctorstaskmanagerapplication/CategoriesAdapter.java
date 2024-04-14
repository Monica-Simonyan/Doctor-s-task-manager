package com.example.doctorstaskmanagerapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * <code>CategoriesAdapter</code> sets the recyclerview that displays the categories of patients
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {
    Context context;
    ArrayList<Categories> categories;

    /**
     * initializes the fields of a <code>CategoriesAdapter</code> object
     * @param context      the <code>Context</code> context
     * @param categories   the <code>Arraylist<Categories></code> categories
     */
    public CategoriesAdapter(Context context, ArrayList<Categories> categories){
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_view, parent, false);
        return new CategoriesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.MyViewHolder holder, int position) {
        holder.categoryName.setText(categories.get(position).getCategories());
    }


    /**
     * returns the size of the <code>ArrayList<Categories></code>
     * @return the size of the <code>ArrayList<Categories></code>
     */
    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView categoryName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.categoryName);

            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if()
                }
            });

             */
        }
    }
}
