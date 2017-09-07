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
public class ConditionalsFragment extends Fragment {

    @BindView(R.id.rvConditionals)
    RecyclerView rvConditionals;
    Unbinder unbinder;

    public ConditionalsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conditionals, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Example> exampleSimple = new ArrayList<>();
        exampleSimple.add(new Example(1, "(+) " +
                "Si (a < 20) entonces\n" +
                "\t\t\t\t\tescriba(\"Saldo excedido\")\n" +
                "\t\t\tFin_Si\n\n" +
                "En este caso solo se muestra saldo excedido si la variable (a) toma un valor mayor a 20, en este caso la condición (a < 20) es verdadera."));
        exampleSimple.add(new Example(2, "(+) " +
                "Si (A < B)\n" +
                "\t\t\t\t\tX = A * 2 + B\n" +
                "\t\t\tFin_Si\n\n" +
                "En este caso solo asignara el valor a la varible X si el valor que toma la variable A es mayor a la variable B."));

        ArrayList<Example> exampleDoubles = new ArrayList<>();
        exampleDoubles.add(new Example(1, "(+) " +
                "Si (X > 20 ) entonces\n" +
                "\t\t\t\t\tX = X + 2\n" +
                "\t\t\tSi_No\n" +
                "\t\t\t\t\tX = X – 2\n" +
                "\t\t\tFin_Si\n\n" +
                "Si el valor que toma la variable X es mayor a 20, al valor anterior se le " +
                "sumara 2, ejemplo si X tuviera un valor a 22 entones el nuevo valor de X " +
                "será 24.\n" +
                "En caso que el valor de la variable X sea menor o igual a 20, al valor que " +
                "trae la variable se le restara 2, ejemplo si X tuviera un valor de 19 el " +
                "nuevo valor de X será 17."));
        exampleDoubles.add(new Example(2, "(+) " +
                "Si (Sw = 0) entonces\n" +
                "\t\t\t\t\tLea(A)\n" +
                "\t\t\t\t\tX = A * 2\n" +
                "\t\t\tSi_No\n" +
                "\t\t\t\t\tX = 20\n" +
                "\t\t\tFin_Si\n\n" +
                "Si el valor de la variable Sw = 0 es verdadera entonces se ejecutaran 2 " +
                "instrucciones, se pedirá el valor de la variable A y luego el valor de la variable X" +
                "tomara el valor de la variable A multiplicada por 2. En caso contrario o sea que el " +
                "valor de la variable sea diferente de cero, el valor de la variable X tomara el valor " +
                "de 20."));

        ArrayList<Example> exampleMultiplies = new ArrayList<>();
        exampleMultiplies.add(new Example(1, "(+) Lea un número y diga si es mayor, menor o igual a cero.\n\n" +
                "Lea (A)\n" +
                "Si (A > 0 ) entonces\n" +
                "\t\t\tEscriba(\"El número es mayor a 0\")\n" +
                "Si_No\n" +
                "\t\t\tSi (A < 0) entonces\n" +
                "\t\t\t\t\t\tEscriba(\"El número es menor a 0\")\n" +
                "\t\t\tSi_No\n" +
                "\t\t\t\t\t\tEscriba(\"El número es igual a 0\")\n" +
                "\t\t\tFin_SI\n" +
                "Fin_SI\n\n" +
                "La variable A se le pide al usuario, luego si el valor de la variable tomara un " +
                "valor igual a 5 al entrar a la primera pregunta esta seria verdadera, entonces escribirá \"El número es " +
                "mayor a 0\". Si el valor de la variable fuera -3 al entrar a la primera pregunta y como el valor es " +
                "menor que 0 pasa al Si_No y entra a preguntar Si A < 0 lo cual es verdadero entonces escribiría " +
                "\"El número es menor a 0\". Adicionalmente, si el valor de la variable A sea 0 entra a la primera " +
                "pregunta y pasa al Si_No porque la condición es falsa, luego entra a la pregunta A < 0 pero como es " +
                "falsa se va al Si_No y escribe \"El número es igual a 0\". Note que en Si anidados el ultimo Si_No " +
                "queda por descarte no es necesario formular otra pregunta Si (A = 0)."));

        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("Simples", "Se ejecuta una determinada acción cuando se cumple determinada condición. En otras palabra la condición es evaluada en forma verdadera.\n\n" +
                "Si (condición) entonces\n" +
                "\t\t\t(acción)\n" +
                "Fin_Si", exampleSimple));
        instructions.add(new Instruction("Dobles", "Son aquellos que permiten elegir entre dos opciones o alternativas posibles de una condición dada. En caso que la condición sea verdadera se ejecuta la acción uno, en caso contrario se ejecutara la acción dos. La figura de abajo detalla el concepto. Recuerde que solo se ejecutara una acción (sea la uno o la dos) NUNCA las dos.\n\n" +
                "Si (condición) entonces\n" +
                "\t\t\t(acción uno)\n" +
                "Si_No\n" +
                "\t\t\t(acción dos)\n" +
                "Fin_Si", exampleDoubles));
        instructions.add(new Instruction("Múltiples", "Son aquellos que permiten elegir cuando hay mas de dos elecciones o alternativas posibles. Recuerde cada Si debe tener un Fin_Si Asociado.\n\n" +
                "Si (condición) entonces\n" +
                "\t\t\t(instrucción)\n" +
                "Si_No\n" +
                "\t\t\tSi (condición 2) entonces \n" +
                "\t\t\t\t\t\t(instrucción)\n" +
                "\t\t\tSi_No \n" +
                "\t\t\t.\n" +
                "\t\t\t.\n" +
                "\t\t\t.\n" +
                "Fin_Si", exampleMultiplies));

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

        rvConditionals.setAdapter(instructionsAdapter);
        rvConditionals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvConditionals.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
