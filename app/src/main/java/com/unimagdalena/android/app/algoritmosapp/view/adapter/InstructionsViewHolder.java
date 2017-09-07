package com.unimagdalena.android.app.algoritmosapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.unimagdalena.android.app.algoritmosapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alber on 8/16/2017.
 */

class InstructionsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvName)
    TextView name;

    @BindView(R.id.tvDescription)
    TextView description;

    InstructionsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }
}
