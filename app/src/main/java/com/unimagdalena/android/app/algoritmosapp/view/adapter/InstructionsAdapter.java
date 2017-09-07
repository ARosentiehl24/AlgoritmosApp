package com.unimagdalena.android.app.algoritmosapp.view.adapter;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.unimagdalena.android.app.algoritmosapp.R;
import com.unimagdalena.android.app.algoritmosapp.model.Example;
import com.unimagdalena.android.app.algoritmosapp.model.Instruction;

import java.util.List;

/**
 * Created by alber on 8/16/2017.
 */

public class InstructionsAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_INSTRUCTION = 0;
    public static final int TYPE_EXAMPLE = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public InstructionsAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_INSTRUCTION, R.layout.instructions_item_layout);
        addItemType(TYPE_EXAMPLE, R.layout.example_item_layout);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_INSTRUCTION:

                final Instruction instruction = (Instruction) item;

                helper.setText(R.id.tvName, instruction.getTitle());
                helper.setText(R.id.tvDescription, instruction.getDescription());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        Log.d(TAG, "Level " + helper.getItemViewType() + " item pos: " + pos);
                        if (instruction.isExpanded()) {
                            Log.d(TAG, "Level 0 item isExpanded");
                            collapse(pos);
                        } else {
                            Log.d(TAG, "Level 0 item !isExpanded");
                            expand(pos);
                        }
                    }
                });

                break;
            case TYPE_EXAMPLE:

                Example example = (Example) item;

                helper.addOnClickListener(R.id.tvExample);
                helper.setText(R.id.tvExample, "Ejemplo " + example.getIndex());

                break;
        }
    }
}
