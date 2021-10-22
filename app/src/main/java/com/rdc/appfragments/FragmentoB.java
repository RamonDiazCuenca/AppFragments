package com.rdc.appfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoB extends Fragment {

    private final static String KEY_TVMENSAJE = "key_tvmensaje";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_b, container, false);
        return view;
    }

    public void recibir(String dato){

        TextView tv = getActivity().findViewById(R.id.mensaje);
        tv.setText(dato);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        TextView tvmensaje = getActivity().findViewById(R.id.mensaje);
        CharSequence tvtexto = tvmensaje.getText().toString();
        outState.putCharSequence(KEY_TVMENSAJE, tvtexto);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if(savedInstanceState != null){

            CharSequence mensajerecibidotv = savedInstanceState.getCharSequence(KEY_TVMENSAJE);
            TextView tvmensaje = getActivity().findViewById(R.id.mensaje);
            tvmensaje.setText(mensajerecibidotv);
        }
    }
}
