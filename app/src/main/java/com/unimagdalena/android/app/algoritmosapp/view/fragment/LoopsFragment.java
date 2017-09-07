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
public class LoopsFragment extends Fragment {

    @BindView(R.id.rvLoops)
    RecyclerView rvLoops;
    Unbinder unbinder;

    public LoopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loops, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Example> exampleFor = new ArrayList<>();
        exampleFor.add(new Example(1, "(+) Imprimir los números de 1 al 10 en forma ascendente.\n\n" +
                "Para (X = 1, hasta 5, 1) \n" +
                "\t\t\tEscriba(X);\n" +
                "Fin_Para\n\n" +
                "El ciclo lo controla la variable X la cual va a empezar en 1 entra a ejecutar la instrucción Escriba (X) o sea 1, 2, 3, 4, 5  el valor de la variable se va incrementando automáticamente de uno en uno hasta llegar al valor 6 se sale del ciclo. Note que cuando el ciclo es creciente o ascendente el valor inicial debe ser menor al valor final y el incremento debe ser ascendente."));
        exampleFor.add(new Example(2, "(+) Escribir los números pares de menores o iguales a 9.\n\n" +
                "Para (X = 2, hasta 9, 2)\n" +
                "\t\t\tExcriba(X)\n" +
                "Fin_Para\n\n" +
                "Este ejemplo la variable inicia en 2 que es el primer par, y como el incremento es de 2 pasara al número 4, 6 etc.  O sea, se escribirá los numero 2 4 6 8 el quinto incremento pasa de 8 a 10 lo cual es superior al valor final con lo cual se terminaría el ciclo. Recuerde el valor del incremento es importante."));
        exampleFor.add(new Example(3, "(+) Imprima los números de 1 al 10 en forma inversa, o sea 10, 9, … 3, 2, 1.\n\n" +
                "Para (X = 10, hasta 1, -1)\n" +
                "\t\t\tEscriba(X)\n" +
                "Fin_Para\n\n" +
                "En este ejemplo es un ciclo decreciente, para lo cual el valor inicial debe ser mayor al valor final y el incremento debe ser negativo para que reste."));

        ArrayList<Example> exampleWhile = new ArrayList<>();
        exampleWhile.add(new Example(1, "(+) Escribir los números pares de menores o iguales a 9.\n\n" +
                "X = 2\n" +
                "MQ (X  <= 9) haga\n" +
                "\t\t\tEscriba(X)\n" +
                "\t\t\tX = X + 2\n" +
                "Fin_MQ\n\n" +
                "En este caso la variable inicialmente toma el valor de 2, luego llega al ciclo MQ, como la condición 2 <= 9 es verdadero, entra al ciclo y luego escribe X o sea 2. Nota: En estos ciclos en donde se parte de un valor inicial a uno final siempre se debe incrementar la variable o sea X = X + 2 para que pueda en algún momento llegar al final o sea a tomar el valor mayor o igual a 9 o sea en la segunda iteración el valor de X será 4, entonces escribirá 2, 4, 6, 8 y en la quinta iteración el valor de X pasa a 10 con lo cual la condición se convierte en falsa y se sale del ciclo."));
        exampleWhile.add(new Example(2, "(+) Hacer un programa que lea números y los sume, hasta que el valor digitado sea negativo.\n\n" +
                "s = 0\n" +
                "Sw = 0\n" +
                "MQ (Sw = 0) haga\n" +
                "\t\t\tLea (a)\n" +
                "\t\t\tSi (a < 0) entonces\n" +
                "\t\t\t\t\t\tSw = 1\n" +
                "\t\t\tSi_No\n" +
                "\t\t\t\t\t\ts = s + a\n" +
                "\t\t\tFin_Si\n" +
                "Fin_MQ\n" +
                "Escriba (\"La suma de los números leídos es: \", s)\n\n" +
                "Este ejemplo muestra un ciclo que no llega a ningún valor final, se acaba con una condición dada el cual no podría hacerse con un ciclo para, s es la variable que acumulara la suma, Sw es la variable que controla el ciclo lo igualamos a cero, para que entre al ciclo. Dentro del ciclo se lee el valor de la variable a, si el valor de la variable es negativo, entonces el valor de la variable Sw se cambia 1 para finalizar el ciclo e imprimir el resultado de la suma, en caso contrario se almacena el valor de numero aumentado la variable s y como Sw no cambia se procede a leer otro valor, esto se realizará hasta que el usuario digite el valor negativo."));

        ArrayList<Example> exampleDoWhile = new ArrayList<>();
        exampleDoWhile.add(new Example(1, "(+) Se desea simular un cajero automático, mostrando un menú de opciones que sean 1 retirar, 2 consignar, 3 salir al menú se continuara mostrando hasta que sea igual a 3.\n\n" +
                "Haga\n" +
                "\t\t\tEscriba (\"1. Retirar\")\n" +
                "\t\t\tEscriba (\"2. Consignar\")\n" +
                "\t\t\tEscriba (\"3. Salir\")\n" +
                "\t\t\tLea(op)\n" +
                "Hasta (op = 3)"));

        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("Para", "En esta se conoce el número de iteraciones o veces que se repite la acción, antes de iniciar la ejecución del ciclo. El ciclo lo controla una variable, y debe tener un valor inicial, un valor final y un incremento (positivo o negativo).\n\n" +
                "Para (<variable> = <valor inicial>, hasta <valor final>, <incremento>)\n" +
                "\t\t\t<acción>\n" +
                "Fin_Para", exampleFor));
        instructions.add(new Instruction("Mientras Que (MQ)", "Este se repite un número determinado de veces, para esto la instrucción se acompaña de una condición, la cual debe cumplirse para seguir la ejecución del ciclo, de lo contrario este se termina.\n\n" +
                "MQ (<condición>) haga\n" +
                "\t\t\t<acciones>\n" +
                "Fin_MQ", exampleWhile));
        instructions.add(new Instruction("Repita - Hasta", "Este repite un proceso una cantidad de veces, determinada por un condicional, que lo ejecuta hasta que la condicional se cumpla. Una característica importante de esta estructura es que permite realizar el proceso cuando menos una vez, ya que la condición se evalúa al final del proceso. Este ciclo también lo puede se puede llamar Haga - Hasta.\n\n" +
                "Repita\n" +
                "\t\t\t<acción>\n" +
                "Hasta <condición>", exampleDoWhile));

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

        rvLoops.setAdapter(instructionsAdapter);
        rvLoops.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvLoops.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
