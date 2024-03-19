package com.example.shoppingapp.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shoppingapp.Activitys.CustomeAdapter;
import com.example.shoppingapp.Data.MyData;
import com.example.shoppingapp.Activitys.Product;
import com.example.shoppingapp.R;

import java.util.ArrayList;
import java.util.Dictionary;

public class fragment_Product extends Fragment {

    private ArrayList<Product> dataSetNow;
    private ArrayList<Product> dataSetRemove;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CustomeAdapter adapter;

    private Bundle m_User;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        TextView textUserName = view.findViewById(R.id.TextViewUserNameLogin);
        m_User = getArguments();
        String nameUser = m_User.getString("UserFullName");
        textUserName.setText("Hello, "+ nameUser);

        TextView logout = view.findViewById(R.id.TextViewUserLogOut);
        logout.setOnClickListener(v -> {
            m_User = null;
            Navigation.findNavController(v).navigate(R.id.action_fragment_product_to_fragment_Login, null);
        });

        view.findViewById(R.id.textviewSummryCount).setVisibility(View.INVISIBLE);


        EditText textSearch = view.findViewById(R.id.TextSearchInput);
        textSearch.addTextChangedListener(new TextWatcher(){
            private String previusInput = "";
            private boolean firstTime = true;

            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3)
            {
                String inputName = cs.toString();
                if(firstTime)
                {
                    onChangeTextSearch(inputName , true);
                    firstTime = false;
                }
                else {
                    if(inputName.length() > 0) {
                        if(previusInput.length()>inputName.length())
                        {
                            onChangeTextSearch(inputName ,false);
                        }
                        else {
                            onChangeTextSearch(inputName , true);
                        }
                    }
                    else {
                        onChangeTextSearch(inputName ,false);
                        firstTime = true;
                    }
                }
                previusInput = inputName;
                setDataSetOnAdapter();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                previusInput = editable.toString();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
            }

        });
        recyclerView =  view.findViewById(R.id.rec_viewProducts);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataSetNow = new ArrayList<Product>();
        dataSetRemove = new ArrayList<Product>();
        initializeDataSet();
        setDataSetOnAdapter();

        return  view;
    }

    private void initializeDataSet()
    {
        dataSetNow.clear();
        for (Dictionary<String , String> product:MyData.s_Prodcut){
            String name = product.get("Name");
            String price = product.get("Price");
            Integer ImageSrc = Integer.parseInt((String)product.get("ImageSRC"));
            dataSetNow.add(new Product(name ,price ,ImageSrc));
        }
    }
    private void setDataSetOnAdapter() {
        adapter = new CustomeAdapter(dataSetNow);
        recyclerView.setAdapter(adapter);
    }

    private void onChangeTextSearch(String input , boolean isUp)
    {
        String nameOnDataSet;
        if(isUp == false)
        {
            for(int i=0 ; i<dataSetRemove.size() ; i++)
            {

                nameOnDataSet = dataSetRemove.get(i).GetName().toUpperCase();
                if(nameOnDataSet.contains(input.toUpperCase()))
                {
                    dataSetNow.add(dataSetRemove.get(i));
                    dataSetRemove.remove(i);
                    i--;
                }
            }
        }
        else
        {
            for(int i=0 ; i<dataSetNow.size() ; i++)
            {
                nameOnDataSet = dataSetNow.get(i).GetName().toUpperCase();
                if(!nameOnDataSet.contains(input.toUpperCase()))
                {
                    dataSetRemove.add(dataSetNow.get(i));
                    dataSetNow.remove(i);
                    i--;
                }
            }
        }

    }
}