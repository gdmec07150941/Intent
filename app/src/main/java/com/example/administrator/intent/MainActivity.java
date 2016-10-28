package com.example.administrator.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.url);
        editText2 = (EditText) findViewById(R.id.phone);
        textView1 = (TextView) findViewById(R.id.textview1);
    }
    public void componentname(View view){
        ComponentName componentName = new ComponentName(this, IntentDemo2.class);
        Intent intent1 = new Intent();
        intent1.setComponent(componentName);
        startActivity(intent1);
    }
    public void intentfilter(View view){
        String action = "action_demo";
        Intent intent2 = new Intent();
        intent2.setAction(action);
        startActivity(intent2);
    }
    public void view(View view){
        Intent intent3 = new Intent();
        intent3.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(editText1.getText().toString());
        intent3.setData(uri);
        startActivity(intent3);
    }
    public void dial(View view){
        Intent intent4 = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:"+editText2.getText().toString());
        intent4.setData(uri);
        startActivity(intent4);
    }
    public void startactivityforresult(View view){
        Bundle bundle = new Bundle();
        bundle.putString("value",editText1.getText().toString());
        Intent intent5 = new Intent(MainActivity.this,IntentDemo2.class);
        intent5.putExtras(bundle);
        startActivityForResult(intent5, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                Bundle bundle = data.getExtras();
                textView1.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
