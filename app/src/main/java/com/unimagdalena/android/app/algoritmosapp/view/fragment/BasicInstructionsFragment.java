package com.unimagdalena.android.app.algoritmosapp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.unimagdalena.android.app.algoritmosapp.R;
import com.unimagdalena.android.app.algoritmosapp.model.Example;
import com.unimagdalena.android.app.algoritmosapp.model.Instruction;
import com.unimagdalena.android.app.algoritmosapp.view.adapter.InstructionsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicInstructionsFragment extends Fragment {

    @BindView(R.id.rvBasicInstructions)
    RecyclerView rvBasicInstructions;
    Unbinder unbinder;

    public BasicInstructionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic_instructions, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Example> exampleWrite = new ArrayList<>();
        exampleWrite.add(new Example(1, "(+) Escriba(\"El resultado es\") muestra en el dispositivo de salida la frase que se encuentre entre comillas, toda frase debe ir dentro de comillas."));
        exampleWrite.add(new Example(2, "(+) Escriba(N) muestra en el dispositivo de salida el valor que tenga la variable N."));
        exampleWrite.add(new Example(3, "(+) Escriba(\"El saldo es: \", X) muestra en el dispositivo de salida la frase más el valor de la variable X que tenga en el momento."));
        exampleWrite.add(new Example(4, "(-) Escriba(El resultado es) es un error para el algoritmo no muestra \"El resultado es\", se asume que imprime el valor de 3 varibles : El, resultado y es."));

        ArrayList<Example> exampleRead = new ArrayList<>();
        exampleRead.add(new Example(1, "(+) Lea(N) permite recibir el valor a través de la variable N."));
        exampleRead.add(new Example(2, "(-) Lea(\"El valor de\") error nunca se lee una frase o constante, solo se deben leer variables."));
        exampleRead.add(new Example(3, "(-) Lea(\"El valor de\", x), error nunca coloque una contante o frase y una variable."));

        ArrayList<Example> exampleAssignation = new ArrayList<>();
        exampleAssignation.add(new Example(1, "(+) X = 2 - la variable X toma el valor de 2."));
        exampleAssignation.add(new Example(2, "(+) X = A * 2 - El valor de X toma el valor  de la variable a multiplicada por 2."));
        exampleAssignation.add(new Example(3, "(-) 2 = A - Error una contante no puede tomar el valor de la variable A."));

        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("Escriba/Write", "Se manda el resultado o mensaje, por medio de algún dispositivo de salida del computador. Se pueden mostrar mensajes, variables ambos al mismo tiempo.", exampleWrite));
        instructions.add(new Instruction("Lea/Read", "Consiste en recibir un valor o un dato, por medio de algún dispositivo de entrada a través de una variable.", exampleRead));
        instructions.add(new Instruction("Asignación", "Es el paso de valores o resultados a una zona de la memoria, esta zona será reconocida con el nombre de la variable que recibe el valor. Tenga en cuenta que la variable que recibe el valor de una constante o una fórmula matemática.", exampleAssignation));

        ArrayList<MultiItemEntity> entities = new ArrayList<>();

        for (Instruction instruction : instructions) {
            for (Example example : instruction.getExamples()) {
                instruction.addSubItem(example);
            }
            entities.add(instruction);
        }

        InstructionsAdapter instructionsAdapter = new InstructionsAdapter(entities);
        instructionsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView tvExample = view.findViewById(R.id.tvExample);

                Example example = (Example) adapter.getItem(position);

                new MaterialDialog.Builder(getContext())
                        .title(tvExample.getText())
                        .content(example.getDescription())
                        .positiveText(R.string.close)
                        .show();
            }
        });

        rvBasicInstructions.setAdapter(instructionsAdapter);
        rvBasicInstructions.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvBasicInstructions.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
