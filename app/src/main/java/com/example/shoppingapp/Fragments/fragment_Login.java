package com.example.shoppingapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppingapp.Activitys.MainActivity;
import com.example.shoppingapp.Activitys.User;
import com.example.shoppingapp.R;


public class fragment_Login extends Fragment {
    private User m_User;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__login, container, false);

        //m_User = new ViewModelProvider(requireActivity()).get(User);

        EditText UserMail = view.findViewById(R.id.editTextLoginMailUser);
        EditText UserPassword = view.findViewById(R.id.editTextLoginPassword);
        Button buttonLogin = view.findViewById(R.id.ButtonLogin);
        Button buttonRegister = view.findViewById(R.id.ButtonRegister);

        buttonLogin.setOnClickListener(v -> {
            String userMail = UserMail.getText().toString().trim();
            String password = UserPassword.getText().toString().trim();

            //Example: userMail = "nir@gmail.com" , password = "12345678"
            //userMail = "nir@gmail.com";
            //password = "12345678";
            User isValidUser = User.CheckValidUser(userMail, password);
            if (isValidUser != null) {
                if (getActivity() instanceof MainActivity) {
                    // Create a bundle and put the username in it
                    Bundle bundle = new Bundle();
                    bundle.putString("UserFullName", isValidUser.GetFullName());
                    bundle.putInt("UserCartCount", 0);
                    // Navigate to the MainPageFragment with the bundle
                    Navigation.findNavController(v).navigate(R.id.action_fragment_Login_to_fragment_product, bundle);
                }
            } else {
                Toast.makeText(getActivity(), "Invalid Mail Or Password", Toast.LENGTH_SHORT).show();
            }
        });

        // Implement navigation to SignUpFragment
        buttonRegister.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_fragment_Login_to_fragment_register);
        });

        return view;
    }
}