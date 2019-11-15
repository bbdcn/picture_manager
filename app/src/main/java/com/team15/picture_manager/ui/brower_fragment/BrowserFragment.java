package com.team15.picture_manager.ui.brower_fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.team15.picture_manager.R;
import com.team15.picture_manager.ui.activity.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class BrowserFragment extends Fragment {


    public BrowserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browser, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*   点击缩略图跳转到图片原图显示界面  */

        /*    此处待实现功能使用适配器将所有图片的缩略图依次填充至fragment中
        *     点击某个图片，应跳转至相应图片的原图显示界面
        * */
        ImageView imageView = view.findViewById(R.id.imageView_brower_1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_browserFragment_to_checkFragment);
            }
        });

        MainActivity mainActivity = (MainActivity) getActivity();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) mainActivity.findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.GONE);
    }
}
