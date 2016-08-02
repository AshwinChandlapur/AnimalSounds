package com.example.ashwinchandlapur.animals;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class FirstFragment2 extends Fragment {
    TextView t;

    private static final String TAG = "FirstFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_fragment2, container, false);


        ImageButton btn=(ImageButton)view.findViewById(R.id.btn);
        //ImageButton btn1=(ImageButton)view.findViewById(R.id.btn1);
       // Button btn = (Button) view.findViewById(R.id.btn);
        final MediaPlayer sound= MediaPlayer.create(view.getContext(),R.raw.horse);
        sound.start();


       t=(TextView)view.findViewById(R.id.tv);

        Typeface myFont = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Kaushan.otf");
        t.setTypeface(myFont);



        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager()
                        .beginTransaction();
				/*
				 * IMPORTANT: We use the "root frame" defined in
				 * "root_fragment.xml" as the reference to replace fragment
				 */
                trans.replace(R.id.root_frame, new SecondFragment());
                sound.stop();
				/*
				 * IMPORTANT: The following lines allow us to add the fragment
				 * to the stack and return to it later, by pressing back
				 */
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);

                trans.commit();
            }
        });

    //    btn1.setOnClickListener(new OnClickListener() {

      //      @Override
      //      public void onClick(View v) {
       //         FragmentTransaction trans = getFragmentManager()
       //                 .beginTransaction();
				/*
				 * IMPORTANT: We use the "root frame" defined in
				 * "root_fragment.xml" as the reference to replace fragment
				 */
       //         trans.replace(R.id.root_frame, new FirstFragment());
      //          sound.stop();
				/*
				 * IMPORTANT: The following lines allow us to add the fragment
				 * to the stack and return to it later, by pressing back
				 */
        //        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
       //         trans.addToBackStack(null);

        //        trans.commit();
       //     }
        //});

        return view;
    }



}