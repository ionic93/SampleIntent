package com.example.sampleintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMenu(View view) {
        //버튼 자체에 onClick 이벤트를 설정하려면 반드시 매개변수에 View를 넣어야함
        //Intent(액티비티 클래스를 구현하는 컨텍스트(context) 보통 this를 사용, 호출할 액티비티 클래스)
        //startActivityForResult = 지정한 액티비티로 왕복행
        //startActivity = 지정한 액티비티로 편도행
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

    @Override
    //갔다가 돌아왔을때 동작하는 메서드
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(this, "요청코드: "+REQUEST_CODE_MENU+
                    " / 결과코드: "+resultCode, Toast.LENGTH_SHORT).show();
        }
        if (resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            Toast.makeText(this, "전달된 name: " + name, Toast.LENGTH_SHORT).show();
        }
    }
}