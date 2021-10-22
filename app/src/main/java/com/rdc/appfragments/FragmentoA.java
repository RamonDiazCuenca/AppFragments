package com.rdc.appfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoA extends Fragment {

    private EnviarMensaje mensaje;
    private final static String KEY_ETTEXTO = "key_ettexto";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_a, container, false);

        view.findViewById(R.id.enviar).setOnClickListener(v ->{

            TextView tv = view.findViewById(R.id.texto);
            String msg = tv.getText().toString();
            mensaje.enviarDato(msg);
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mensaje = (EnviarMensaje) context;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        EditText ettexto = getActivity().findViewById(R.id.texto);
        CharSequence mensajeet = ettexto.getText().toString();
        outState.putCharSequence(KEY_ETTEXTO,mensajeet);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if(savedInstanceState != null){

            CharSequence mensajerecibidoet = savedInstanceState.getCharSequence(KEY_ETTEXTO);

            EditText ettexto = getActivity().findViewById(R.id.texto);

            ettexto.setText(mensajerecibidoet);
        }
    }
}
