package com.loyee.animation;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.animation.BaseInterpolator;

/**
 * Created by loyee on 17-1-17.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
public class MyInterpolator extends BaseInterpolator {
    @Override
    public float getInterpolation(float v) {
        Log.v("tag","-----------------------------v="+v);
        return v*v*v;
    }
}
