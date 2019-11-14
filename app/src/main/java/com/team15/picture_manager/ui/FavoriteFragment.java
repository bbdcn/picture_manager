package com.team15.picture_manager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.team15.picture_manager.R;

public class FavoriteFragment extends Fragment {
    public FavoriteFragment(){
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView_favorite_1 = view.findViewById(R.id.imageView_favorite_1);
        imageView_favorite_1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_checkFragment));
    }
}
