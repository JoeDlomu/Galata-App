package com.example.joe.myrestaurent;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joe on 09/01/2017.
 */

public class SpecialsAdapter extends RecyclerView.Adapter<SpecialsAdapter.ViewHolder> {

    Context sContext;
    List<ProductContent> productContents;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView sCardView;
        ImageView productImage;
        TextView productName;
        TextView productPrice;

        public ViewHolder(View v){
            super(v);

            sCardView = (CardView)v.findViewById(R.id.cardViewSpecials);
            productImage = (ImageView)v.findViewById(R.id.imageViewProduct);
            productName = (TextView)v.findViewById(R.id.textviewProductName);
            productPrice = (TextView)v.findViewById(R.id.textviewProductPrice);
        }
    }

    SpecialsAdapter(Context sContext, List<ProductContent> productContents){
        this.sContext = sContext;
        this.productContents = productContents;
    }

    @Override
    public SpecialsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.specials_cardview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SpecialsAdapter.ViewHolder holder, int position) {
        final String name = productContents.get(position).productName;
        final String price = productContents.get(position).productPrice;
        final int image = productContents.get(position).productPhoto;

        holder.productName.setText(name);
        holder.productPrice.setText(price);
        holder.productImage.setImageResource(image);
    }



    @Override
    public int getItemCount() {
        return productContents.size();
    }
}
