package math.projetobento.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import math.projetobento.Centro;
import math.projetobento.R;
import math.projetobento.gerenciadores.Capitulo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Inicio.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Inicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Inicio extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Capitulo c;
    private TextView txt;
    private boolean b = false;
    private ImageView play;

    private OnFragmentInteractionListener mListener;

    public Inicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Inicio.
     */
    // TODO: Rename and change types and number of parameters
    public static Inicio newInstance(String param1, String param2) {
        Inicio fragment = new Inicio();
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
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        setComponentes();

        play = getView().findViewById(R.id.imginicio);
        Picasso.get().load(R.drawable.fmain).placeholder(R.drawable.fmain).centerCrop().fit().into(play);

        getView().setBackgroundColor(c.getCor());

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mandaToque();
            }
        });
    }

    public void setComponentes() {
        c = (Capitulo) getArguments().getSerializable("capitulo");
        play = getView().findViewById(R.id.imginicio);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(boolean b);
    }

    public void mandaToque(){
        if (!b) {
            Intent t = new Intent(getActivity().getBaseContext(), Centro.class);
            t.putExtra("Clique", true);
            getActivity().startActivity(t);
            b = true;
        }
    }
}
