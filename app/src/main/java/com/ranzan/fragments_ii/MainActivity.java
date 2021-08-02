package com.ranzan.fragments_ii;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnAddA;
    private Button mBtnRemoveA;
    private Button mBtnReplaceAWithBWithBackstack;
    private Button mBtnReplaceAWithBWithoutBackstack;
    private Button mBtnAddB;
    private Button mBtnRemoveB;
    private Button mBtnReplaceBWithA;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        mBtnAddA = findViewById(R.id.btnAddA);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnReplaceAWithBWithBackstack = findViewById(R.id.btnReplaceAWithBWithBackstack);
        mBtnReplaceAWithBWithoutBackstack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        mBtnAddA.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnReplaceAWithBWithBackstack.setOnClickListener(this);
        mBtnReplaceAWithBWithoutBackstack.setOnClickListener(this);
        mBtnReplaceBWithA.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnReplaceAWithBWithBackstack:
                replaceAWithBWithBackstack();

                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                replaceAWithB();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceBWithA:
                replaceBWithA();
                break;
        }

    }

    private void replaceAWithBWithBackstack() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("fragB").commit();
    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if (fragmentB != null) {

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentB).commit();
        }
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentA).commit();
        }
    }

    private void replaceBWithA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.add(R.id.flContainer, fragmentA, "fragmentA").commit();
    }

    private void replaceAWithB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit();
    }

    private void addB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.add(R.id.flContainer, fragmentB, "fragmentB").commit();
    }

    private void addA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.add(R.id.flContainer, fragmentA, "fragmentA").commit();
    }
}