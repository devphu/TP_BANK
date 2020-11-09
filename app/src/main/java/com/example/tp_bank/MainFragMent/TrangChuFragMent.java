package com.example.tp_bank.MainFragMent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tp_bank.Dao.UserDao;
import com.example.tp_bank.MainActivity;
import com.example.tp_bank.Model.User;
import com.example.tp_bank.R;

import java.util.ArrayList;

public class TrangChuFragMent extends Fragment {
    ArrayList<User> users;
    EditText user, pass;
    Button login;
    UserDao userDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_trangchu_fragment, container, false);
        init();
        user = getActivity().findViewById(R.id.edtUserName);
        pass = getActivity().findViewById(R.id.edtPassword);
        login = getActivity().findViewById(R.id.btnLogin);


        return view;
    }

    public void init() {
        user = getActivity().findViewById(R.id.edtUserName);
        pass = getActivity().findViewById(R.id.edtPassword);
        login = getActivity().findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userDao = new UserDao(getActivity());
                users = userDao.readAll();
                String tk = user.getText().toString();
                String mk = pass.getText().toString();
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUsername().equals(tk) && users.get(i).getPassword().equals(mk)) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        Toast.makeText(getActivity(), "Chào Mừng Bạ" +
                                " Đến Với Chúng Tôi", Toast.LENGTH_SHORT).show();
                        startActivity(intent);

                    }
                }
            }


        });
    }
}
