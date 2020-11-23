package kr.co.company.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;

import android.widget.Toast;
import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {
    private Spinner server = null;
    private ArrayAdapter<String> mSpinnerAdapter = null;
    private List<JParsing> userList;
    private DBAdapter adapter;
    private String Name="";
    private String Id="";
    public String servername="cain";
    public String serverkor="cain";
    ListView list;
    public boolean commit =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ItemDBH dbm = ItemDBH.getInstance(MainActivity.this);
        ImageView iv=findViewById(R.id.neople);
        server= findViewById(R.id.server);
        getSupportActionBar().hide();
        server.setPrompt("서버선택");
        ListView list = (ListView)findViewById(R.id.list);
        final EditText chname = findViewById(R.id.myedit);
        userList=new ArrayList<JParsing>();
        adapter = new DBAdapter(getApplicationContext(),userList);
        TextView c=findViewById(R.id.channel);
        c.setText(adapter.recommendCh());
        list.setAdapter(adapter);
        try{
            String chaname,chaid,svname;
            Cursor cursor=dbm.selectUser(this);
            if (cursor != null && cursor.getCount() != 0){
                while(cursor.moveToNext()){
                    chaid=cursor.getString(0);
                    svname=cursor.getString(1);
                    chaname = cursor.getString(2);
                    JParsing user = new JParsing(chaid,svname,chaname);
                    userList.add(0,user);
                    Log.d("user : ", ""+userList.size());
                }}cursor.close();
        }

        catch (Exception e){;}
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                String ids = userList.get(position).getUserId();
                String name = userList.get(position).getUserName();
                String servern = userList.get(position).codeChange();
                intent.putExtra("id",ids);
                intent.putExtra("server",servern);
                intent.putExtra("name",name); /*송신*/
                startActivity(intent);
                finish();
            }
        });
        server.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String s=parent.getItemAtPosition(position).toString();
                if(position==0){
                    servername="cain";
                    serverkor="카인";
                }
                else if(position==1){
                    servername="diregie";
                    serverkor="디레지에";
                }
                else if(position==2){
                    servername="siroco";
                    serverkor="시로코";
                }
                else if(position==3){
                    servername="prey";
                    serverkor="프레이";
                }
                else if(position==4){
                    servername="casillas";
                    serverkor="카시야스";
                }
                else if(position==5){
                    servername="hilder";
                    serverkor="힐더";
                }
                else if(position==6){
                    servername="anton";
                    serverkor="안톤";
                }
                else if(position==7){
                    servername="bakal";
                    serverkor="바칼";
                }
                }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        Button startBtn = (Button) findViewById(R.id.mybutton); //버튼 입력 시 파일 유무 확인
        startBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Name = chname.getText().toString();
                try {
                    MyAsyncTask mProcessTask = new MyAsyncTask();
                    mProcessTask.execute();
                    String utfname = URLEncoder.encode(chname.getText().toString(), "UTF-8");

                    Log.i("Name : ", utfname);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("DBMsg : ", "오류발견");
                }
            }
        });
        iv.setOnClickListener(new MyListener());
        chname.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode,KeyEvent event){
                if(keyCode==event.KEYCODE_ENTER){
                    chname.clearFocus();
                    Name = chname.getText().toString();
                    Name=Name.replace("\n","");
                    try {
                        MyAsyncTask mProcessTask = new MyAsyncTask();
                        mProcessTask.execute();
                        String utfname = URLEncoder.encode(chname.getText().toString(), "UTF-8");
                        Log.i("Name : ", utfname);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i("DBMsg : ", "오류발견");
                    }
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    //AsyncTask 생성 - 모든 네트워크 로직을 여기서 작성
    public class MyAsyncTask extends AsyncTask<String, Void, ArrayList<String>> {
        customAnimationDialog progressDialog = new customAnimationDialog(MainActivity.this);

        OkHttpClient client = new OkHttpClient();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override //검색되는 동안, 인터넷, 파일화 등등
        protected ArrayList<String> doInBackground(String... params) {
            final Timeline times = new Timeline();
            String id=times.chaId(servername,Name);
            Id=id;
            ArrayList<String> itemList = new ArrayList<String>();
            try {
                String code=null;
                itemList=times.timeLines(servername,Name);
                if(itemList.size()>0){
                Log.d("Asyncthread : ", "아이템리스트불러오기"+itemList.size());
                try{
                    FileOutputStream fos = openFileOutput(id+".txt", Context.MODE_PRIVATE);
                    for(int i=0;i<itemList.size();i++){
                        fos.write((itemList.get(i)+"\n").getBytes());
                    }
                    Log.d("FileMsg : ", "데이터파일생성========");
                    fos.close();
                    }catch (Exception e){;}
                }
                else{
                    commit=false;
                }
                return itemList;
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("receiveMsg : ", "변환실패========");
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            final ItemDBH dbms = ItemDBH.getInstance(MainActivity.this);
            dbms.insertUser(MainActivity.this,Id,serverkor,Name);
            if(commit){
                Toast.makeText(MainActivity.this, "데이터 추출완료", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "데이터 추출실패", Toast.LENGTH_SHORT).show();
                Log.d("Asyncthread : ", serverkor+Name);
                dbms.deleteDB(MainActivity.this,Id);
            }
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    class MyListener implements OnClickListener{
        @Override
        public void onClick(View v){
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developers.neople.co.kr/"));
            startActivity(myIntent);
        }
    }
}