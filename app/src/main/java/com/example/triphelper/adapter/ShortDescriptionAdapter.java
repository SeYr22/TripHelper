package com.example.triphelper.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.recyclerview.widget.RecyclerView;

import com.example.triphelper.R;
import com.example.triphelper.struct.ShortDescription;

import java.util.ArrayList;
import java.util.List;

public class ShortDescriptionAdapter extends RecyclerView.Adapter<ShortDesctiptionViewHolder>
        implements Filterable {
    private List<ShortDescription> descriptionList = new ArrayList<>();
    private List<ShortDescription> descriptionListFull;
    public void setItems(List<ShortDescription> descriptionListCurr) {
        descriptionList.addAll(descriptionListCurr);
        descriptionListFull = new ArrayList<>(descriptionListCurr); // !!!!!!!!!!!!!!!!!!!!!!
        notifyDataSetChanged();
    }

    public void clearItems() {
        descriptionList.clear();
        notifyDataSetChanged();
    }
    @Override
    public ShortDesctiptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.short_decription_layout, parent, false);
        return new ShortDesctiptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShortDesctiptionViewHolder holder, int position) {
        holder.bind(descriptionList.get(position));
    }

    @Override
    public int getItemCount() {
        return descriptionList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<ShortDescription> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filteredList.addAll(descriptionListFull);
            } else{
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(int i = 0; i < descriptionListFull.size(); i++){
                    ShortDescription currItem = descriptionListFull.get(i);
                    if(currItem.getName().toLowerCase().contains(filterPattern)
                    || currItem.getShortDectiprion().toLowerCase().trim().contains(filterPattern)
                    || (currItem.getName() + currItem.getShortDectiprion()).toLowerCase().trim().contains(filterPattern)
                    || ( currItem.getShortDectiprion() + currItem.getName()).toLowerCase().trim().contains(filterPattern)){
                        filteredList.add(currItem);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        descriptionList.clear();
        descriptionList.addAll((List)filterResults.values);
        notifyDataSetChanged();
        }
    };
}
