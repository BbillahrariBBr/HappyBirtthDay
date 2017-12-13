package com.example.bakibillah.happybirtthday;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by BakiBillah on 12/13/2017.
 *
 */

@SuppressLint("Registered")

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        ActionBar actionBar = super.getSupportActionBar();
        if (actionBar == null) {
            throw new NullPointerException("Action bar was not initialized");
        }
        return actionBar;
    }
}
