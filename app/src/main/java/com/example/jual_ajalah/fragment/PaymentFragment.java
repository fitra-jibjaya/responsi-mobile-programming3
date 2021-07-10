package com.example.jual_ajalah.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import com.example.jual_ajalah.R;
import com.example.jual_ajalah.RedeemActivity;

public class PaymentFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;
    private TextView here;

    private ViewGroup contentFrame;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVar();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_payment, container, false);

        here = rootView.findViewById(R.id.here);
        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), RedeemActivity.class);
                startActivity(intent);
            }
        });

        initView(rootView);
        return rootView;

    }

    private void initVar() {
        mActivity = getActivity();
        mContext = mActivity.getApplicationContext();
    }


    private void initView(View rootView) {
        contentFrame = (ViewGroup) rootView.findViewById(R.id.scanner);

    }

}
