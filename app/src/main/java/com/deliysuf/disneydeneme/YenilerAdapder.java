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

public class YenilerAdapder extends RecyclerView.Adapter<YenilerAdapder.YeniCardViewHolder> {
    private Context mcontext;
    private List<FilmlerYeni> yeniFilmList;

    public YenilerAdapder(Context mcontext, List<FilmlerYeni> yeniFilmList) {
        this.mcontext = mcontext;
        this.yeniFilmList = yeniFilmList;
    }
    public class YeniCardViewHolder extends RecyclerView.ViewHolder{
        private OnerilenLayoutBinding binding ;
        public YeniCardViewHolder(@NonNull OnerilenLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public YeniCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OnerilenLayoutBinding binding =
                OnerilenLayoutBinding.
                        inflate(LayoutInflater.from(mcontext),
                                parent,false);
        return new YeniCardViewHolder(binding);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onBindViewHolder(@NonNull YeniCardViewHolder holder, int position) {
        FilmlerYeni film = yeniFilmList.get(position);
        holder.binding
                .oner.
                setImageResource(mcontext.
                        getResources().getIdentifier(film.
                                getAd(),"drawable",mcontext.
                                getOpPackageName()));
    }

    @Override
    public int getItemCount() {
        return yeniFilmList.size();
    }


}
