package com.james.restapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.james.restapi.R;
import com.james.restapi.model.Company;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    List<Company> companies;

    public CompanyAdapter(){
        companies = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_company, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Company company = companies.get(position);
        holder.name.setText(company.getShortName());
        holder.address.setText(company.getAddress());

        Log.d("ADAPTER", "id " + company.getOkvedId());

        Picasso.with(holder.image.getContext())
                .load("http://i.dailymail.co.uk/i/pix/2016/04/13/00/331D901800000578-3536787-image-a-11_1460503122350.jpg")
                .fit()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    public void setItems(List<Company> companies){
        this.companies = companies;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.image)
        ImageView image;

        @Bind(R.id.name)
        TextView name;

        @Bind(R.id.address)
        TextView address;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
