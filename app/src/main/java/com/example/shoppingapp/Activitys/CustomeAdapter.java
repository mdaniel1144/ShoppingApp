package com.example.shoppingapp.Activitys;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.R;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private ArrayList<Product> dataSet;


    public CustomeAdapter(ArrayList<Product> dataSet) {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewPrice;
        public ImageView imageView;
        public TextView textViewCount;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewNameProduct);
            textViewPrice = itemView.findViewById(R.id.textViewPriceProduct);
            imageView = itemView.findViewById(R.id.imageViewProduct);
            textViewCount = itemView.findViewById(R.id.textViewCountProduct);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_product, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        Button buttonPlus = view.findViewById(R.id.buttonPlus);
        Button buttonMinus = view.findViewById(R.id.buttonMinus);
        buttonPlus.setOnClickListener(v -> {
            Integer countProduct = Integer.parseInt(myViewHolder.textViewCount.getText().toString());
            countProduct += 1;
            myViewHolder.textViewCount.setText(countProduct.toString());
            OnChangeCountProduct(myViewHolder,(View)view.getParent().getParent(), 1);
            if(countProduct == 1) {
                myViewHolder.itemView.findViewById(R.id.layoutCard).setBackgroundTintList(myViewHolder.itemView.getResources().getColorStateList(R.color.blueOpacity));
            }
        });
        buttonMinus.setOnClickListener(v -> {
            Integer countProduct = Integer.parseInt(myViewHolder.textViewCount.getText().toString());
            if(countProduct >= 1) {
                countProduct -= 1;
                myViewHolder.textViewCount.setText(countProduct.toString());
                OnChangeCountProduct(myViewHolder, (View)view.getParent().getParent(),-1);
            }
            if(countProduct == 0) {
                myViewHolder.itemView.findViewById(R.id.layoutCard).setBackgroundTintList(myViewHolder.itemView.getResources().getColorStateList(R.color.orangeOpacity));
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int key) {

        holder.textViewName.setText("Name: "+dataSet.get(key).GetName());
        holder.textViewPrice.setText("Price: "+ dataSet.get(key).GetPrice() + "$");
        holder.imageView.setImageResource(dataSet.get(key).GetImage());
        holder.textViewCount.setText(dataSet.get(key).GetCountCart().toString());
        Integer countP = Integer.parseInt(holder.textViewCount.getText().toString());
        if (countP > 0 ){
            holder.itemView.findViewById(R.id.layoutCard).setBackgroundTintList(holder.itemView.getResources().getColorStateList(R.color.blueOpacity));
        }
        else
        {
            holder.itemView.findViewById(R.id.layoutCard).setBackgroundTintList(holder.itemView.getResources().getColorStateList(R.color.orangeOpacity));
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private void OnChangeCountProduct(@NonNull MyViewHolder holder ,View view , Integer count)
    {
        TextView cartCountSummry = view.findViewById(R.id.textviewSummryCount);
        Integer summryCountOnView = Integer.parseInt(cartCountSummry.getText().toString());
        summryCountOnView += count;

        for(Product product:dataSet)
        {
            if(product.GetName().equals(holder.textViewName.getText().toString().replace("Name: ", "")))
            {
                product.SetCountCart(count);
                break;
            }
        }

        if (summryCountOnView == 0)
        {
            cartCountSummry.setVisibility(View.INVISIBLE);
        }
        else
        {
            cartCountSummry.setVisibility(View.VISIBLE);
        }
        cartCountSummry.setText(summryCountOnView.toString());
    }
}