package com.unimagdalena.android.app.algoritmosapp.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.unimagdalena.android.app.algoritmosapp.view.adapter.InstructionsAdapter;

/**
 * Created by alber on 8/15/2017.
 */

public class Example implements MultiItemEntity {

    private int index;
    private String description;

    public Example(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getItemType() {
        return InstructionsAdapter.TYPE_EXAMPLE;
    }
}
