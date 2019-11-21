package com.team15.picture_manager.ui.edit_fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.team15.picture_manager.R;
import com.team15.picture_manager.ui.activity.MainActivity;
import com.team15.picture_manager.util.SimpleDoodleView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {
    Bitmap bitmap = null;

    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*   设置底部导航栏隐藏  */
        MainActivity mainActivity = (MainActivity) getActivity();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) mainActivity.findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.GONE);

        ViewGroup simpleContainer = (ViewGroup) view.findViewById(R.id.container_simple_doodle);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.student);
        SimpleDoodleView simpleDoodleView = new SimpleDoodleView(getActivity(),bitmap);

        simpleContainer.addView(simpleDoodleView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        /*Button btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir = getApplicationContext().getFilesDir().getAbsolutePath() + "/student/";
                String picName = "student";

                String state = Environment.getExternalStorageState();
                //如果状态不是mounted，无法读写
                if (!state.equals(Environment.MEDIA_MOUNTED)) {
                    return;
                }
                try {
                    File f = new File(dir + picName + ".png");//图片路径
                    FileOutputStream out = new FileOutputStream(f);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });*/
    }
}
