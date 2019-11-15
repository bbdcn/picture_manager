package com.team15.picture_manager.ui.albums_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.team15.picture_manager.R;
import com.team15.picture_manager.ui.activity.MainActivity;

public class AlbumsFragment extends Fragment {
    public AlbumsFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_albums, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView_albums_1 = view.findViewById(R.id.imageView_albums_1);
        imageView_albums_1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_albumsFragment_to_browserFragment));

        /*   设置底部导航栏显示  */
        MainActivity mainActivity = (MainActivity) getActivity();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) mainActivity.findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
