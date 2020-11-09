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

public class TruCuuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_tracuu_fragment, container, false);

        return view;
    }


}