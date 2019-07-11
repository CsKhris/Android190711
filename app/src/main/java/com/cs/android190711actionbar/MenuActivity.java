package com.cs.android190711actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageView = (ImageView)findViewById(R.id.imageview);

        // imageView가 Context Menu를 사용할 수 있도록 설정
        registerForContextMenu(imageView);
    }

    // 문자열을 받아서 Toast로 출력해주는 Method
    private void toast(String message){Toast.makeText(MenuActivity.this, message, Toast.LENGTH_LONG).show();
    }

    // Context Menu를 만들어주는 Method를 재정의
    // 두번째 매개변수가 Context Menu를 사용하는 View
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, "우진이 물어뜯기!");
        menu.add(0,1,0, "병복이 물어뜯기!");
        menu.add(0,2,0, "현빈이 물어뜯기!");
        menu.add(0,3,0, "정연이 물어뜯기!");
        menu.add(0,4,0, "혜정이 물어뜯기!");
    }

    // Context Menu를 눌렀을 때 호출될 Method
    @Override
    public boolean onContextItemSelected(MenuItem item){
        // Menu의 ID를 이용하여 분기
        switch (item.getItemId()) {
            case 0:
                toast("우진이를 물어뜯으면 저글링이 죽습니다.");
                break;
            case 1:
                toast("병복이는 컴퓨터라 딱딱해서 물어뜯을 수 없습니다.");
                break;
            case 2:
                toast("현빈이는 맛이 없어서 물어뜯기 싫습니다.");
                break;
            case 3:
                toast("정연이는 광주에서 와서 물어뜯을 수 없습니다.");
                break;
            case 4:
                toast("혜정이네 고양이가 너무 강려크해서 물어뜯을 수 없습니다.");
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lab, menu);
        return true;
    }

    // Menu를 선택했을 때 호출되는 Method
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menu1:
                toast("너 지금 뭐 눌렀냐");
                break;
            case R.id.menu2:
                toast("누르지마");
                break;
            case R.id.menu3:
                toast("누르지 말라고 해따...");
                break;
        }
        return true;
    }
}
