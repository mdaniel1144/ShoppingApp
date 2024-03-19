package com.example.shoppingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppingapp.Data.MyData;
import com.example.shoppingapp.R;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Pattern;

public class fragment_register extends Fragment {


    private  EditText m_UserFirstname;
    private  EditText m_UserLastname;
    private  EditText m_UserPhone;
    private  EditText m_UserMail;
    private  EditText m_UserPassword;
    private  EditText m_UserConfirmPassword;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        m_UserFirstname = view.findViewById(R.id.editTextUserFirstName);
        m_UserLastname = view.findViewById(R.id.editTextUserLastName);
        m_UserPhone = view.findViewById(R.id.editTextUserPhone);
        m_UserMail = view.findViewById(R.id.editTextUserMail);
        m_UserPassword = view.findViewById(R.id.editTextTextPassword);
        m_UserConfirmPassword = view.findViewById(R.id.editTextConfrimPassword);

        Button register = view.findViewById(R.id.buttonRegistretion);
        register.setOnClickListener(this::OnClickRegistration);

        return view;
    }

    private void OnClickRegistration(View view)
    {
        boolean isValid = validtionInput();
        Bundle bundle = new Bundle();

        if (isValid == false)
        {
            Toast.makeText(getActivity(), "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
        else
        {
            for (Dictionary<String, String> user : MyData.s_User) {
                String mail = user.get("Mail");
                if (mail.equals(m_UserMail.getText().toString())) {
                    Toast.makeText(getActivity(), "This user is already exist", Toast.LENGTH_SHORT).show();
                    isValid = false;
                    break;
                }
            }
            if(isValid == true){
                MyData.s_User.add(new Hashtable<String, String>() {{ put("Mail", m_UserMail.getText().toString().trim()); put("FirstName" , m_UserFirstname.getText().toString().trim()); put("LastName" , m_UserLastname.getText().toString().trim()); put("Password" ,m_UserPassword.getText().toString().trim() );}});
            }
            Navigation.findNavController(view).navigate(R.id.action_fragment_register_to_fragment_Login, null);
        }
    }

    private boolean validtionInput()
    {
        boolean isValid = true;
        String RegexText = "^[a-zA-Z0-9]+";
        String RegexPassword = "^[a-zA-Z0-9]{8,}$";
        String RegexMail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String RegexPhone = "^05[02487][0-9]{7}";
        if(!Pattern.matches(RegexText , m_UserFirstname.getText().toString().trim())) {
            isValid = false;
            m_UserFirstname.setError("It must include only letters");
        }
        if(!Pattern.matches(RegexText , m_UserLastname.getText().toString().trim())) {
            isValid = false;
            m_UserLastname.setError("It must include only letters");
        }
        if(!Pattern.matches(RegexPhone , m_UserPhone.getText().toString().trim())) {
            isValid = false;
            if(!Pattern.matches("^05[02487][0-9]*" , m_UserPhone.getText().toString().trim()))
                m_UserPhone.setError("The prefix is illegal - It must start with 050/052/054/058/057");
            else
                m_UserPhone.setError("It must include 10 digit");
        }
        if(!Pattern.matches(RegexMail , m_UserMail.getText().toString().trim())) {
            isValid = false;
            m_UserMail.setError("This mail in not valid");
        }
        if(!Pattern.matches(RegexPassword , m_UserPassword.getText().toString().trim())) {
            isValid = false;
            m_UserPassword.setError("It must include at least 8 chars{ A-Z , a-z , 0-9}");
        }
        if(!m_UserPassword.getText().toString().equals(m_UserConfirmPassword.getText().toString().trim())) {
            isValid = false;
            m_UserConfirmPassword.setError("It must be same to Password");
        }
        return  isValid;
    }
}