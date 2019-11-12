package com.team15.picture_manager.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.team15.picture_manager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private ConstraintLayout constraintLayout;
    private BottomNavigationView bottomNavigationView;
    private PhotosFragment photosFragment;
    private AlbumsFragment albumsFragment;
    private FavoriteFragment favoriteFragment;
    private Fragment[] fragments;
    private int lastfragment = 0;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view){
        photosFragment = new PhotosFragment();
        albumsFragment = new AlbumsFragment();
        favoriteFragment = new FavoriteFragment();
        fragments = new Fragment[]{photosFragment,albumsFragment,favoriteFragment};
        constraintLayout = (ConstraintLayout) view.findViewById(R.id.contrainlayout);
        getChildFragmentManager().beginTransaction().add(R.id.contrainlayout,photosFragment).show(photosFragment).commit();
        bottomNavigationView = (BottomNavigationView)view.findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    /*   底部导航栏的点击响应事件  */
    private  BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_photos:
                    if (lastfragment != 0){
                        switchFragment(lastfragment,0);
                        lastfragment = 0;
                    }
                    return true;
                case R.id.navigation_albums:
                    if (lastfragment != 1){
                        switchFragment(lastfragment,1);
                        lastfragment = 1;
                    }
                    return true;
                case R.id.navigation_favorite:
                    if (lastfragment != 2){
                        switchFragment(lastfragment,2);
                        lastfragment = 2;
                    }
                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    /*   切换fragment  */
    private void switchFragment(int lastfragment,int index){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);
        if(fragments[index].isAdded() == false){
            transaction.add(R.id.contrainlayout,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
}