package jp.co.recruit_lifestyle.sample;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.capricorn.ArcMenu;
import com.capricorn.RayMenu;

import java.util.List;

import jp.co.recruit.floatingview.R;
import jp.co.recruit_lifestyle.sample.fragment.FloatingViewControlFragment;


public class MainActivity extends LifecycleActivity {

    private static final int[] ITEM_DRAWABLES = { R.drawable.composer_camera, R.drawable.composer_music,
            R.drawable.composer_place, R.drawable.composer_sleep, R.drawable.composer_thought, R.drawable.composer_with };


    MutableLiveData<List<String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setContentView(R.layout.main);
//        ArcMenu arcMenu = (ArcMenu) findViewById(R.id.arc_menu);
//        ArcMenu arcMenu2 = (ArcMenu) findViewById(R.id.arc_menu_2);
//
//        initArcMenu(arcMenu, ITEM_DRAWABLES);
//        initArcMenu(arcMenu2, ITEM_DRAWABLES);
//
//        RayMenu rayMenu = (RayMenu) findViewById(R.id.ray_menu);
//        final int itemCount = ITEM_DRAWABLES.length;
//        for (int i = 0; i < itemCount; i++) {
//            ImageView item = new ImageView(this);
//            item.setImageResource(ITEM_DRAWABLES[i]);
//
//            final int position = i;
//            rayMenu.addItem(item, new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
//                }
//            });// Add a menu item
//        }
//
//
//        if (true)
//            return;

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.container, FloatingViewControlFragment.newInstance());
            ft.commit();
        }
    }


    private void initArcMenu(ArcMenu menu, int[] itemDrawables) {
        final int itemCount = itemDrawables.length;
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(this);
            item.setImageResource(itemDrawables[i]);

            final int position = i;
            menu.addItem(item, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
