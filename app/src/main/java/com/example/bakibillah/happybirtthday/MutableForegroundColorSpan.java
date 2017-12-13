package com.example.bakibillah.happybirtthday;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/**
 * Created by BakiBillah on 12/11/2017.
 */

public class MutableForegroundColorSpan extends CharacterStyle implements UpdateAppearance {
    public static final String TAG = "MutableForegroundColorSpan";

    private int mColor;


    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setColor(mColor);
    }
}
