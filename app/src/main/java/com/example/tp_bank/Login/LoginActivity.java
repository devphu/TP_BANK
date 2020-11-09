package com.example.tp_bank.Login;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_bank.Dao.UserDao;
import com.example.tp_bank.MainFragMent.CaiDatFragMent;
import com.example.tp_bank.MainFragMent.GiaoDichFragMent;
import com.example.tp_bank.MainFragMent.TrangChuFragMent;
import com.example.tp_bank.MainFragMent.TruCuuFragment;
import com.example.tp_bank.Model.User;
import com.example.tp_bank.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    UserDao userDao;
    ArrayList<User> users;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        init();
        degsinBottom();
    }

    //    public void init() {
//        users = new ArrayList<>();
//        userDao = new UserDao(LoginActivity.this);
//        username = findViewById(R.id.edtUserNameLogin);
//        password = findViewById(R.id.edtPasswordLogin);
//        btnLogin = findViewById(R.id.btnLogin);
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                userDao = new UserDao(LoginActivity.this);
//                users = userDao.readAll();
//                String tk = username.getText().toString();
//                String mk = password.getText().toString();
//                for (int i = 0; i < users.size(); i++) {
//                    if (users.get(i).getUsername().equals(tk) && users.get(i).getPassword().equals(mk)) {
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        Toast.makeText(LoginActivity.this, "Chào Mừng Bạn Đến Với Chúng Tôi", Toast.LENGTH_SHORT).show();
//                        startActivity(intent);
//
//                    }
//                }
//            }
//        });
//    }
    public void degsinBottom() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        final Menu menu = bottomNavigationView.getMenu();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_trangChu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new TrangChuFragMent()).commit();
                        item = menu.findItem(R.id.nav_trangChu);
                        item.setChecked(true);
                        break;
                    case R.id.nav_giaoDich:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new GiaoDichFragMent()).commit();
                        item = menu.findItem(R.id.nav_giaoDich);
                        item.setChecked(true);
                        break;
                    case R.id.nav_traCuu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new TruCuuFragment()).commit();
                        item = menu.findItem(R.id.nav_traCuu);
                        item.setChecked(true);
                        break;
                    case R.id.nav__caiDat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new CaiDatFragMent()).commit();
                        item = menu.findItem(R.id.nav__caiDat);
                        item.setChecked(true);
                        break;
                }
                return false;
            }
        });
    }
}