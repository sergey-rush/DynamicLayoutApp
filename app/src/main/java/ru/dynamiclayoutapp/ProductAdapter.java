package ru.dynamiclayoutapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by rash on 25.08.2017.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;       
        TextView tvPrice;

        public ProductViewHolder(View view) {
            super(view);

            tvName = (TextView) view.findViewById(R.id.tvName);
            tvPrice = (TextView) view.findViewById(R.id.tvPrice);
        }
    }


    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    ViewGroup parent;

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = parent;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);

        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvPrice.setText(product.Price);
        holder.tvName.setText(product.Name);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
