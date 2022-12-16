package com.deliysuf.disneydeneme;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.deliysuf.disneydeneme.databinding.OnerilenLayoutBinding;

import java.util.List;

public class OnerilenlerAdapter extends RecyclerView.Adapter<OnerilenlerAdapter.CardViewHolder> {
    private Context mcontext;
    private List<FilmlerOnerilen> onerilenList;

    public OnerilenlerAdapter(Context mcontext, List<FilmlerOnerilen> onerilenList) {
        this.mcontext = mcontext;
        this.onerilenList = onerilenList;
    }
    public class CardViewHolder extends RecyclerView.ViewHolder{
      private OnerilenLayoutBinding binding ;
        public CardViewHolder(@NonNull OnerilenLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OnerilenLayoutBinding binding =
                OnerilenLayoutBinding.
                inflate(LayoutInflater.from(mcontext),
                        parent,false);
        return new CardViewHolder(binding);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        FilmlerOnerilen film = onerilenList.get(position);
        holder.binding
                .oner.
                setImageResource(mcontext.
                        getResources().getIdentifier(film.
                                getAd(),"drawable",mcontext.
                                getOpPackageName()));
    }

    @Override
    public int getItemCount() {

        return onerilenList.size();
    }
    }
