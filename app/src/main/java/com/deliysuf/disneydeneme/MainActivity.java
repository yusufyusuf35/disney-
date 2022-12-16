package com.deliysuf.disneydeneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.deliysuf.disneydeneme.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Afis> liste = new ArrayList<>();
        ArrayList<FilmlerOnerilen> onerilenler = new ArrayList<>();
        ArrayList<FilmlerYeni> yeniFilmler = new ArrayList<>();
        Afis afis1 = new Afis("nightmares");
        Afis afis2 = new Afis("joker");
        Afis afis3 = new Afis("nana");
        Afis afis4 = new Afis("newworld");
        Afis afis5 = new Afis("ghost");
        FilmlerOnerilen oner1 = new FilmlerOnerilen("desperado");
        FilmlerOnerilen oner2 = new FilmlerOnerilen("fight");
        FilmlerOnerilen oner3 = new FilmlerOnerilen("scarface");
        FilmlerOnerilen oner4 = new FilmlerOnerilen("starwarsdizi");
        FilmlerOnerilen oner5 = new FilmlerOnerilen("brooklyn");
        FilmlerYeni yeni1 = new FilmlerYeni("breakingnad");
        FilmlerYeni yeni2 = new FilmlerYeni("brooklyn");
        FilmlerYeni yeni3 = new FilmlerYeni("dahmer");
        FilmlerYeni yeni4 = new FilmlerYeni("days");
        FilmlerYeni yeni5 = new FilmlerYeni("dexter");
        FilmlerYeni yeni6 = new FilmlerYeni("office");
        FilmlerYeni yeni7 = new FilmlerYeni("wall");
        liste.add(afis1);
        liste.add(afis2);
        liste.add(afis3);
        liste.add(afis4);
        liste.add(afis5);
        onerilenler.add(oner1);
        onerilenler.add(oner2);
        onerilenler.add(oner3);
        onerilenler.add(oner4);
        onerilenler.add(oner5);
        yeniFilmler.add(yeni1);
        yeniFilmler.add(yeni2);
        yeniFilmler.add(yeni3);
        yeniFilmler.add(yeni4);
        yeniFilmler.add(yeni5);
        yeniFilmler.add(yeni6);
        yeniFilmler.add(yeni7);
        YenilerAdapder yadapter = new YenilerAdapder(this,yeniFilmler);
        binding.yeniRecycler.setAdapter(yadapter);
        binding.yeniRecycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        OnerilenlerAdapter oadapter = new OnerilenlerAdapter(this,onerilenler);
        binding.onerilenRecycler.setAdapter(oadapter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        binding.onerilenRecycler.setLayoutManager(manager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this,liste);
        binding.viewPager2.setAdapter(adapter);
        binding.viewPager2.setClipChildren(false);
        binding.viewPager2.setClipToPadding(false);
        binding.viewPager2.setOffscreenPageLimit(3);
        binding.viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(20));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);

            }

        });
        binding.viewPager2.setPageTransformer(compositePageTransformer);
    }
}