package com.example.arihantdistributors;

import com.example.arihantdistributors.R.color;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class customDialog extends Dialog {

    customDialog(Context context) {
        super(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Resources res = getContext().getResources();
        final int id = res.getIdentifier("titleDivider", "id", "android");
        final View titleDivider = findViewById(id);
        if (titleDivider != null) {
            titleDivider.setBackgroundColor(Color.parseColor("#FFE0B2"));
        final int id1 = res.getIdentifier("title", "id", "android");
        final View title = findViewById(id1);
        
        }
    }
}