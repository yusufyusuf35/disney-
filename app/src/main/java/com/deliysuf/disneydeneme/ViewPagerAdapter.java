package com.deliysuf.disneydeneme;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.deliysuf.disneydeneme.databinding.SlideItemContainerBinding;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewCardViewHolder> {
    private Context mcontext;
    private List<Afis> afisList;

    public ViewPagerAdapter(Context mcontext, List<Afis> afisList) {
        this.mcontext = mcontext;
        this.afisList = afisList;
    }
    public class ViewCardViewHolder extends RecyclerView.ViewHolder {
      SlideItemContainerBinding binding;
        public ViewCardViewHolder(@NonNull SlideItemContainerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SlideItemContainerBinding binding =
                SlideItemContainerBinding.
                        inflate(LayoutInflater.
                                from(mcontext),parent,false);

        return new ViewCardViewHolder(binding);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onBindViewHolder(@NonNull ViewCardViewHolder holder, int position) {
     Afis afis = afisList.get(position);
     SlideItemContainerBinding t = holder.binding;
     t.images.setImageResource(mcontext.getResources().getIdentifier(afis.getAd(),"drawable",mcontext.getOpPackageName()));
    }

    @Override
    public int getItemCount() {
        return afisList.size();
    }


}
