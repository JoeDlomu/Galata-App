package com.example.joe.myrestaurent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager mPager;
    private int currentPage = 0;
    private final Integer[] pizzaPics= {R.drawable.french_toast_large, R.drawable.menemen_large, R.drawable.tea};
    private ArrayList<Integer> PizzaArray = new ArrayList<Integer>();
    private RecyclerView recyclerViewSpecials;

    private List<ProductContent> productObjectsList;
    private View view;


    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        view = inflater.inflate(R.layout.fragment_home, container, false);

        init();
        productObjectsList = new ArrayList<>();
        recyclerViewSpecials = (RecyclerView)view.findViewById(R.id.recyclerViewSpecials);
        recyclerViewSpecials.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewSpecials.setLayoutManager(llm);

        initializeAdapter();

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

    private void init(){
        for(int x = 0; x < pizzaPics.length; x++){
            PizzaArray.add(pizzaPics[x]);
        }

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new menuAdapter(getContext(),PizzaArray));

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == pizzaPics.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);
    }

    private void initializeAdapter(){

        ProductContent productContent = new ProductContent();

        productContent.productID = 0;
        productContent.productName = "SINGLE CAKE";
        productContent.productPrice = "R 30";
        productContent.productPhoto = R.drawable.single_cake;
        productObjectsList.add(productContent);

        productContent = new ProductContent();
        productContent.productID = 1;
        productContent.productName = "Cappuccino";
        productContent.productPrice = "R 15";
        productContent.productPhoto = R.drawable.cappuccino;
        productObjectsList.add(productContent);

        productContent = new ProductContent();
        productContent.productID = 2;
        productContent.productName = "COKERTME CHICKEN STRIPS";
        productContent.productPrice = "R 19";
        productContent.productPhoto = R.drawable.cokertme_chicken_strips;
        productObjectsList.add(productContent);

        productContent = new ProductContent();
        productContent.productID = 3;
        productContent.productName = "CREAM DOUGNUTS";
        productContent.productPrice = "R 20";
        productContent.productPhoto = R.drawable.cream_dougnuts;
        productObjectsList.add(productContent);

        productContent = new ProductContent();
        productContent.productID = 4;
        productContent.productName = "CROISSANT";
        productContent.productPrice = "R 21";
        productContent.productPhoto = R.drawable.croissant;
        productObjectsList.add(productContent);

        SpecialsAdapter adapter = new SpecialsAdapter(getContext(), productObjectsList);
        recyclerViewSpecials.setAdapter(adapter);

    }
}
