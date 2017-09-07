package com.unimagdalena.android.app.algoritmosapp.model;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.unimagdalena.android.app.algoritmosapp.view.adapter.InstructionsAdapter;

import java.util.ArrayList;

/**
 * Created by alber on 8/15/2017.
 */

public class Instruction extends AbstractExpandableItem<Example> implements MultiItemEntity {

    private String title;
    private String description;
    private ArrayList<Example> examples;

    public Instruction(String title, String description, ArrayList<Example> examples) {
        this.title = title;
        this.description = description;
        this.examples = examples;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Example> getExamples() {
        return examples;
    }

    public void setExamples(ArrayList<Example> examples) {
        this.examples = examples;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return InstructionsAdapter.TYPE_INSTRUCTION;
    }
}
