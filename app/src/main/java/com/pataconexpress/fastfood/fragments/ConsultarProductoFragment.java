package com.pataconexpress.fastfood.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.pataconexpress.fastfood.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConsultarProductoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConsultarProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarProductoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //atributos
    private Button buttonConsultar;
    private Button buttonCancelar;
    private EditText editTextNombre;
    private EditText editTextDescripcion;
    private Spinner spinnerCategoria;
    private EditText editTextPrecio;
    private String[] categoria = {"Seleccione"};

    private OnFragmentInteractionListener mListener;

    public ConsultarProductoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultarProductoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultarProductoFragment newInstance(String param1, String param2) {
        ConsultarProductoFragment fragment = new ConsultarProductoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultar_producto, container, false);
        // Capturar los datos
        buttonConsultar = (Button) view.findViewById(R.id.buttonConsultar);
        buttonCancelar = (Button) view.findViewById(R.id.buttonCancelarCons);
        editTextNombre = (EditText) view.findViewById(R.id.editTextNombreCons);
        editTextDescripcion = (EditText) view.findViewById(R.id.editTextNombreCons);
        spinnerCategoria = (Spinner) view.findViewById(R.id.spinnerCategoriaCons);
        editTextPrecio = (EditText) view.findViewById(R.id.editTextPrecioCons);

        //Evento Click en registrar
        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Enviar los datos al spinner
        spinnerCategoria.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,categoria));


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
