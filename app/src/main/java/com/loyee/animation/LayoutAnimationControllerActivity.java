package com.loyee.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by loyee on 17-1-17.
 */

public class LayoutAnimationControllerActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutanimation);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        ArrayList<HashMap<String, Object>> gridList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> item = new HashMap<String, Object>();
        item.put("img", R.mipmap.ic_launcher);
        item.put("str", "One");
        gridList.add(item);

        item = new HashMap<String, Object>();
        item.put("img", R.mipmap.ic_launcher);
        item.put("str", "Two");
        gridList.add(item);

        item = new HashMap<String, Object>();
        item.put("img", R.mipmap.ic_launcher);
        item.put("str", "Three");
        gridList.add(item);

        item = new HashMap<String, Object>();
        item.put("img", R.mipmap.ic_launcher);
        item.put("str", "Four");
        gridList.add(item);

        item = new HashMap<String, Object>();
        item.put("img", R.mipmap.ic_launcher);
        item.put("str", "Five");
        gridList.add(item);

        item = new HashMap<String, Object>();
        item.put("img", R.mipmap.ic_launcher);
        item.put("str", "Six");
        gridList.add(item);

        item = new HashMap<String, Object>();
        item.put("img", R.mipmap.ic_launcher);
        item.put("str", "Seven");
        gridList.add(item);

        SimpleAdapter gridAdapter = new SimpleAdapter(this, gridList, R.layout.grid_item,
                new String[]{"img", "str"}, new int[]{R.id.itemImage, R.id.itemText});
        gridview.setAdapter(gridAdapter);

        Animation animation = (Animation) AnimationUtils.loadAnimation(LayoutAnimationControllerActivity.this, R.anim.list_anim);
        LayoutAnimationController lac = new LayoutAnimationController(animation);
        lac.setOrder(LayoutAnimationController.ORDER_RANDOM);
        lac.setDelay(0.5f);//注意这个地方是以秒为单位，是浮点型数据，所以要加f
        gridview.setLayoutAnimation(lac);

    }
}
