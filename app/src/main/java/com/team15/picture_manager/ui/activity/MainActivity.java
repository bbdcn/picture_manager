package com.team15.picture_manager.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.team15.picture_manager.R;

public class MainActivity extends AppCompatActivity {
    /*
    private Fragment fragment;
    private BottomNavigationView bottomNavigationView;
    private PhotosFragment photosFragment;
    private AlbumsFragment albumsFragment;
    private FavoriteFragment favoriteFragment;
    private Fragment[] fragments;
    private int lastfragment = 0;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment)fragmentManager.findFragmentById(R.id.fragment);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        /*   将navigation添加到Activity的fragment中，并将back事件委托给navigation */
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
        return NavHostFragment.findNavController(fragment).navigateUp();
    }

    /*
    private void initView(){
        photosFragment = new PhotosFragment();
        albumsFragment = new AlbumsFragment();
        favoriteFragment = new FavoriteFragment();
        fragments = new Fragment[]{photosFragment,albumsFragment,favoriteFragment};
        fragment = (Fragment) findViewById(R.id.fragment);
        getSupportFragmentManager().beginTransaction().add(R.id.contrainlayout,photosFragment).show(photosFragment).commit();
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    /*   底部导航栏的点击响应事件  */
    /*
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
    /*
    private void switchFragment(int lastfragment,int index){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);
        if(fragments[index].isAdded() == false){
            transaction.add(R.id.contrainlayout,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
    */
}
