package com.timshinlee.bottomnavigationwithviewpager;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SampleFragment extends Fragment {
    private static final String TAG = "SampleFragment";
    private View mView;
    private static final String POSITION = "position";
    private int mPosition;
    private static final String[] TITLES = {"Home", "Dashboard", "Notifications"};
    private static final int[] BACKGROUNDS = {Color.BLUE, Color.YELLOW, Color.GREEN};

    public SampleFragment() {
    }

    public static SampleFragment newInstance(int position) {
        final SampleFragment fragment = new SampleFragment();
        final Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: ");
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_sample, container, false);
            mPosition = getArguments().getInt(POSITION, 0);
            initView();
        }
        return mView;
    }

    private void initView() {
        final TextView text = mView.findViewById(R.id.text);
        text.setText(TITLES[mPosition]);
        text.setBackgroundColor(BACKGROUNDS[mPosition]);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView: ");
    }
}
