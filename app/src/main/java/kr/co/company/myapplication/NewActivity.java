package kr.co.company.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class NewActivity extends AppCompatActivity {
    int [][] ImageId = { {R.drawable.i0,R.drawable.g0},
            {R.drawable.i1,R.drawable.g1},
            {R.drawable.i2,R.drawable.g2},
            {R.drawable.i3,R.drawable.g3},
            {R.drawable.i4,R.drawable.g4},
            {R.drawable.i5,R.drawable.g5},
            {R.drawable.i6,R.drawable.g6},
            {R.drawable.i7,R.drawable.g7},
            {R.drawable.i8,R.drawable.g8},
            {R.drawable.i9,R.drawable.g9},
            {R.drawable.i10,R.drawable.g10},
            {R.drawable.i11,R.drawable.g11},
            {R.drawable.i12,R.drawable.g12},
            {R.drawable.i13,R.drawable.g13},
            {R.drawable.i14,R.drawable.g14},
            {R.drawable.i15,R.drawable.g15},
            {R.drawable.i16,R.drawable.g16},
            {R.drawable.i17,R.drawable.g17},
            {R.drawable.i18,R.drawable.g18},
            {R.drawable.i19,R.drawable.g19},
            {R.drawable.i20,R.drawable.g20},
            {R.drawable.i21,R.drawable.g21},
            {R.drawable.i22,R.drawable.g22},
            {R.drawable.i23,R.drawable.g23},
            {R.drawable.i24,R.drawable.g24},
            {R.drawable.i25,R.drawable.g25},
            {R.drawable.i26,R.drawable.g26},
            {R.drawable.i27,R.drawable.g27},
            {R.drawable.i28,R.drawable.g28},
            {R.drawable.i29,R.drawable.g29},
            {R.drawable.i30,R.drawable.g30},
            {R.drawable.i31,R.drawable.g31},
            {R.drawable.i32,R.drawable.g32},
            {R.drawable.i33,R.drawable.g33},
            {R.drawable.i34,R.drawable.g34},
            {R.drawable.i35,R.drawable.g35},
            {R.drawable.i36,R.drawable.g36},
            {R.drawable.i37,R.drawable.g37},
            {R.drawable.i38,R.drawable.g38},
            {R.drawable.i39,R.drawable.g39},
            {R.drawable.i40,R.drawable.g40},
            {R.drawable.i41,R.drawable.g41},
            {R.drawable.i42,R.drawable.g42},
            {R.drawable.i43,R.drawable.g43},
            {R.drawable.i44,R.drawable.g44},
            {R.drawable.i45,R.drawable.g45},
            {R.drawable.i46,R.drawable.g46},
            {R.drawable.i47,R.drawable.g47},
            {R.drawable.i48,R.drawable.g48},
            {R.drawable.i49,R.drawable.g49},
            {R.drawable.i50,R.drawable.g50},
            {R.drawable.i51,R.drawable.g51},
            {R.drawable.i52,R.drawable.g52},
            {R.drawable.i53,R.drawable.g53},
            {R.drawable.i54,R.drawable.g54},
            {R.drawable.i55,R.drawable.g55},
            {R.drawable.i56,R.drawable.g56},
            {R.drawable.i57,R.drawable.g57},
            {R.drawable.i58,R.drawable.g58},
            {R.drawable.i59,R.drawable.g59},
            {R.drawable.i60,R.drawable.g60},
            {R.drawable.i61,R.drawable.g61},
            {R.drawable.i62,R.drawable.g62},
            {R.drawable.i63,R.drawable.g63},
            {R.drawable.i64,R.drawable.g64},
            {R.drawable.i65,R.drawable.g65},
            {R.drawable.i66,R.drawable.g66},
            {R.drawable.i67,R.drawable.g67},
            {R.drawable.i68,R.drawable.g68},
            {R.drawable.i69,R.drawable.g69},
            {R.drawable.i70,R.drawable.g70},
            {R.drawable.i71,R.drawable.g71},
            {R.drawable.i72,R.drawable.g72},
            {R.drawable.i73,R.drawable.g73},
            {R.drawable.i74,R.drawable.g74},
            {R.drawable.i75,R.drawable.g75},
            {R.drawable.i76,R.drawable.g76},
            {R.drawable.i77,R.drawable.g77},
            {R.drawable.i78,R.drawable.g78},
            {R.drawable.i79,R.drawable.g79},
            {R.drawable.i80,R.drawable.g80},
            {R.drawable.i81,R.drawable.g81},
            {R.drawable.i82,R.drawable.g82},
            {R.drawable.i83,R.drawable.g83},
            {R.drawable.i84,R.drawable.g84},
            {R.drawable.i85,R.drawable.g85},
            {R.drawable.i86,R.drawable.g86},
            {R.drawable.i87,R.drawable.g87},
            {R.drawable.i88,R.drawable.g88},
            {R.drawable.i89,R.drawable.g89},
            {R.drawable.i90,R.drawable.g90},
            {R.drawable.i91,R.drawable.g91},
            {R.drawable.i92,R.drawable.g92},
            {R.drawable.i93,R.drawable.g93},
            {R.drawable.i94,R.drawable.g94},
            {R.drawable.i95,R.drawable.g95},
            {R.drawable.i96,R.drawable.g96},
            {R.drawable.i97,R.drawable.g97},
            {R.drawable.i98,R.drawable.g98},
            {R.drawable.i99,R.drawable.g99},
            {R.drawable.i100,R.drawable.g100},
            {R.drawable.i101,R.drawable.g101},
            {R.drawable.i102,R.drawable.g102},
            {R.drawable.i103,R.drawable.g103},
            {R.drawable.i104,R.drawable.g104},
            {R.drawable.i105,R.drawable.g105},
            {R.drawable.i106,R.drawable.g106},
            {R.drawable.i107,R.drawable.g107},
            {R.drawable.i108,R.drawable.g108},
            {R.drawable.i109,R.drawable.g109},
            {R.drawable.i110,R.drawable.g110},
            {R.drawable.i111,R.drawable.g111},
            {R.drawable.i112,R.drawable.g112},
            {R.drawable.i113,R.drawable.g113},
            {R.drawable.i114,R.drawable.g114},
            {R.drawable.i115,R.drawable.g115},
            {R.drawable.i116,R.drawable.g116},
            {R.drawable.i117,R.drawable.g117},
            {R.drawable.i118,R.drawable.g118},
            {R.drawable.i119,R.drawable.g119},
            {R.drawable.i120,R.drawable.g120},
            {R.drawable.i121,R.drawable.g121},
            {R.drawable.i122,R.drawable.g122},
            {R.drawable.i123,R.drawable.g123},
            {R.drawable.i124,R.drawable.g124},
            {R.drawable.i125,R.drawable.g125},
            {R.drawable.i126,R.drawable.g126},
            {R.drawable.i127,R.drawable.g127},
            {R.drawable.i128,R.drawable.g128},
            {R.drawable.i129,R.drawable.g129},
            {R.drawable.i130,R.drawable.g130},
            {R.drawable.i131,R.drawable.g131},
            {R.drawable.i132,R.drawable.g132},
            {R.drawable.i133,R.drawable.g133},
            {R.drawable.i134,R.drawable.g134},
            {R.drawable.i135,R.drawable.g135},
            {R.drawable.i136,R.drawable.g136},
            {R.drawable.i137,R.drawable.g137},
            {R.drawable.i138,R.drawable.g138},
            {R.drawable.i139,R.drawable.g139},
            {R.drawable.i140,R.drawable.g140},
            {R.drawable.i141,R.drawable.g141},
            {R.drawable.i142,R.drawable.g142},
            {R.drawable.i143,R.drawable.g143},
            {R.drawable.i144,R.drawable.g144},
            {R.drawable.i145,R.drawable.g145},
            {R.drawable.i146,R.drawable.g146},
            {R.drawable.i147,R.drawable.g147},
            {R.drawable.i148,R.drawable.g148},
            {R.drawable.i149,R.drawable.g149},
            {R.drawable.i150,R.drawable.g150},
            {R.drawable.i151,R.drawable.g151},
            {R.drawable.i152,R.drawable.g152},
            {R.drawable.i153,R.drawable.g153},
            {R.drawable.i154,R.drawable.g154},
            {R.drawable.i155,R.drawable.g155},
            {R.drawable.i156,R.drawable.g156},
            {R.drawable.i157,R.drawable.g157},
            {R.drawable.i158,R.drawable.g158},
            {R.drawable.i159,R.drawable.g159},
            {R.drawable.i160,R.drawable.g160},
            {R.drawable.i161,R.drawable.g161},
            {R.drawable.i162,R.drawable.g162},
            {R.drawable.i163,R.drawable.g163},
            {R.drawable.i164,R.drawable.g164},
            {R.drawable.i165,R.drawable.g165},
            {R.drawable.i166,R.drawable.g166},
            {R.drawable.i167,R.drawable.g167},
            {R.drawable.i168,R.drawable.g168},
            {R.drawable.i169,R.drawable.g169},
            {R.drawable.i170,R.drawable.g170},
            {R.drawable.i171,R.drawable.g171},
            {R.drawable.i172,R.drawable.g172},
            {R.drawable.i173,R.drawable.g173},
            {R.drawable.i174,R.drawable.g174},
            {R.drawable.i175,R.drawable.g175},
            {R.drawable.i176,R.drawable.g176},
            {R.drawable.i177,R.drawable.g177},
            {R.drawable.i178,R.drawable.g178},
            {R.drawable.i179,R.drawable.g179},
            {R.drawable.i180,R.drawable.g180},
            {R.drawable.i181,R.drawable.g181},
            {R.drawable.i182,R.drawable.g182},
            {R.drawable.i183,R.drawable.g183},
            {R.drawable.i184,R.drawable.g184}}; //2차원배열
    ImageView iv;
    String name,server,serverkor,Id;
    int count=0;
    public boolean commit =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemset);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        Id = intent.getExtras().getString("id");
        name = intent.getExtras().getString("name");
        server = intent.getExtras().getString("server");
        serverkor = codeChange(server);
        TextView UserName = findViewById(R.id.charname);
        TextView Home = findViewById(R.id.mytext);
        UserName.setText(name);
        try {
            refreshTask rT=new refreshTask();
            rT.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Home 텍스트뷰 클릭
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //휴지통 버튼 누를때
        Button backBtn = (Button) findViewById(R.id.laydel);
        backBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemDBH dbm = ItemDBH.getInstance(NewActivity.this);
                Log.d("Asyncthread : ", server+name);
                dbm.deleteDB(NewActivity.this,Id);
                Toast.makeText(NewActivity.this, name+" 데이터 삭제", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NewActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //새로고침 버튼 누를때
        Button refBtn = (Button) findViewById(R.id.refresh);
        refBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { //새로고침. 어싱크, 다시 파일 만들고... 파일 읽고 db넣고...
                refreshTask rT=new refreshTask();
                rT.execute();
            }
        });
        //iv=(ImageView)findViewById(R.id.it0); //온오프기능
        //iv.setOnClickListener(new MyListener());
    } //end onCreate
    @Override
    //뒤로가기 버튼 누를때
    public void onBackPressed() {
        Intent intents = new Intent(NewActivity.this,MainActivity.class);
        startActivity(intents);
        super.onBackPressed();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 0, 0, "홈으로");
        menu.add(0, 1, 0, "데이터삭제");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int choiceItem = item.getItemId();
        switch(choiceItem){
            case 0: //홈으로
                Intent intents = new Intent(this,MainActivity.class);
                startActivity(intents);
                finish();
                break;
            case 1: //데이터삭제
                ItemDBH dbm = ItemDBH.getInstance(NewActivity.this);
                dbm.deleteDB(NewActivity.this,Id);
                Toast.makeText(this, name+" 데이터 삭제", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public ImageView ivdata(int i){
        ImageView iv=null;
        if(i==0){
            iv=(ImageView)findViewById(R.id.it0);
        }
        else if(i==1){
            iv=(ImageView)findViewById(R.id.it1);
        }
        else if(i==2){
            iv=(ImageView)findViewById(R.id.it2);
        }
        else if(i==3){
            iv=(ImageView)findViewById(R.id.it3);
        }
        else if(i==4){
            iv=(ImageView)findViewById(R.id.it4);
        }
        else if(i==5){
            iv=(ImageView)findViewById(R.id.it5);
        }
        else if(i==6){
            iv=(ImageView)findViewById(R.id.it6);
        }
        else if(i==7){
            iv=(ImageView)findViewById(R.id.it7);
        }
        else if(i==8){
            iv=(ImageView)findViewById(R.id.it8);
        }
        else if(i==9){
            iv=(ImageView)findViewById(R.id.it9);
        }
        else if(i==10){
            iv=(ImageView)findViewById(R.id.it10);
        }
        else if(i==11){
            iv=(ImageView)findViewById(R.id.it11);
        }
        else if(i==12){
            iv=(ImageView)findViewById(R.id.it12);
        }
        else if(i==13){
            iv=(ImageView)findViewById(R.id.it13);
        }
        else if(i==14){
            iv=(ImageView)findViewById(R.id.it14);
        }
        else if(i==15){
            iv=(ImageView)findViewById(R.id.it15);
        }
        else if(i==16){
            iv=(ImageView)findViewById(R.id.it16);
        }
        else if(i==17){
            iv=(ImageView)findViewById(R.id.it17);
        }
        else if(i==18){
            iv=(ImageView)findViewById(R.id.it18);
        }
        else if(i==19){
            iv=(ImageView)findViewById(R.id.it19);
        }
        else if(i==20){
            iv=(ImageView)findViewById(R.id.it20);
        }
        else if(i==21){
            iv=(ImageView)findViewById(R.id.it21);
        }
        else if(i==22){
            iv=(ImageView)findViewById(R.id.it22);
        }
        else if(i==23){
            iv=(ImageView)findViewById(R.id.it23);
        }
        else if(i==24){
            iv=(ImageView)findViewById(R.id.it24);
        }
        else if(i==25){
            iv=(ImageView)findViewById(R.id.it25);
        }
        else if(i==26){
            iv=(ImageView)findViewById(R.id.it26);
        }
        else if(i==27){
            iv=(ImageView)findViewById(R.id.it27);
        }
        else if(i==28){
            iv=(ImageView)findViewById(R.id.it28);
        }
        else if(i==29){
            iv=(ImageView)findViewById(R.id.it29);
        }
        else if(i==30){
            iv=(ImageView)findViewById(R.id.it30);
        }
        else if(i==31){
            iv=(ImageView)findViewById(R.id.it31);
        }
        else if(i==32){
            iv=(ImageView)findViewById(R.id.it32);
        }
        else if(i==33){
            iv=(ImageView)findViewById(R.id.it33);
        }
        else if(i==34){
            iv=(ImageView)findViewById(R.id.it34);
        }
        else if(i==35){
            iv=(ImageView)findViewById(R.id.it35);
        }
        else if(i==36){
            iv=(ImageView)findViewById(R.id.it36);
        }
        else if(i==37){
            iv=(ImageView)findViewById(R.id.it37);
        }
        else if(i==38){
            iv=(ImageView)findViewById(R.id.it38);
        }
        else if(i==39){
            iv=(ImageView)findViewById(R.id.it39);
        }
        else if(i==40){
            iv=(ImageView)findViewById(R.id.it40);
        }
        else if(i==41){
            iv=(ImageView)findViewById(R.id.it41);
        }
        else if(i==42){
            iv=(ImageView)findViewById(R.id.it42);
        }
        else if(i==43){
            iv=(ImageView)findViewById(R.id.it43);
        }
        else if(i==44){
            iv=(ImageView)findViewById(R.id.it44);
        }
        else if(i==45){
            iv=(ImageView)findViewById(R.id.it45);
        }
        else if(i==46){
            iv=(ImageView)findViewById(R.id.it46);
        }
        else if(i==47){
            iv=(ImageView)findViewById(R.id.it47);
        }
        else if(i==48){
            iv=(ImageView)findViewById(R.id.it48);
        }
        else if(i==49){
            iv=(ImageView)findViewById(R.id.it49);
        }
        else if(i==50){
            iv=(ImageView)findViewById(R.id.it50);
        }
        else if(i==51){
            iv=(ImageView)findViewById(R.id.it51);
        }
        else if(i==52){
            iv=(ImageView)findViewById(R.id.it52);
        }
        else if(i==53){
            iv=(ImageView)findViewById(R.id.it53);
        }
        else if(i==54){
            iv=(ImageView)findViewById(R.id.it54);
        }
        else if(i==55){
            iv=(ImageView)findViewById(R.id.it55);
        }else if(i==56){
            iv=(ImageView)findViewById(R.id.it56);
        }
        else if(i==57){
            iv=(ImageView)findViewById(R.id.it57);
        }
        else if(i==58){
            iv=(ImageView)findViewById(R.id.it58);
        }
        else if(i==59){
            iv=(ImageView)findViewById(R.id.it59);
        }
        else if(i==60){
            iv=(ImageView)findViewById(R.id.it60);
        }
        else if(i==61){
            iv=(ImageView)findViewById(R.id.it61);
        }
        else if(i==62){
            iv=(ImageView)findViewById(R.id.it62);
        }
        else if(i==63){
            iv=(ImageView)findViewById(R.id.it63);
        }
        else if(i==64){
            iv=(ImageView)findViewById(R.id.it64);
        }
        else if(i==65){
            iv=(ImageView)findViewById(R.id.it65);
        }
        else if(i==66){
            iv=(ImageView)findViewById(R.id.it66);
        }
        else if(i==67){
            iv=(ImageView)findViewById(R.id.it67);
        }
        else if(i==68){
            iv=(ImageView)findViewById(R.id.it68);
        }
        else if(i==69){
            iv=(ImageView)findViewById(R.id.it69);
        }
        else if(i==70){
            iv=(ImageView)findViewById(R.id.it70);
        }
        else if(i==71){
            iv=(ImageView)findViewById(R.id.it71);
        }
        else if(i==72){
            iv=(ImageView)findViewById(R.id.it72);
        }
        else if(i==73){
            iv=(ImageView)findViewById(R.id.it73);
        }
        else if(i==74){
            iv=(ImageView)findViewById(R.id.it74);
        }
        else if(i==75){
            iv=(ImageView)findViewById(R.id.it75);
        }
        else if(i==76){
            iv=(ImageView)findViewById(R.id.it76);
        }
        else if(i==77){
            iv=(ImageView)findViewById(R.id.it77);
        }
        else if(i==78){
            iv=(ImageView)findViewById(R.id.it78);
        }
        else if(i==79){
            iv=(ImageView)findViewById(R.id.it79);
        }
        else if(i==80){
            iv=(ImageView)findViewById(R.id.it80);
        }
        else if(i==81){
            iv=(ImageView)findViewById(R.id.it81);
        }
        else if(i==82){
            iv=(ImageView)findViewById(R.id.it82);
        }
        else if(i==83){
            iv=(ImageView)findViewById(R.id.it83);
        }
        else if(i==84){
            iv=(ImageView)findViewById(R.id.it84);
        }
        else if(i==85){
            iv=(ImageView)findViewById(R.id.it85);
        }
        else if(i==86){
            iv=(ImageView)findViewById(R.id.it86);
        }
        else if(i==87){
            iv=(ImageView)findViewById(R.id.it87);
        }
        else if(i==88){
            iv=(ImageView)findViewById(R.id.it88);
        }
        else if(i==89){
            iv=(ImageView)findViewById(R.id.it89);
        }
        else if(i==90){
            iv=(ImageView)findViewById(R.id.it90);
        }
        else if(i==91){
            iv=(ImageView)findViewById(R.id.it91);
        }
        else if(i==92){
            iv=(ImageView)findViewById(R.id.it92);
        }
        else if(i==93){
            iv=(ImageView)findViewById(R.id.it93);
        }
        else if(i==94){
            iv=(ImageView)findViewById(R.id.it94);
        }
        else if(i==95){
            iv=(ImageView)findViewById(R.id.it95);
        }
        else if(i==96){
            iv=(ImageView)findViewById(R.id.it96);
        }
        else if(i==97){
            iv=(ImageView)findViewById(R.id.it97);
        }
        else if(i==98){
            iv=(ImageView)findViewById(R.id.it98);
        }
        else if(i==99){
            iv=(ImageView)findViewById(R.id.it99);
        }
        else if(i==100){
            iv=(ImageView)findViewById(R.id.it100);
        }
        else if(i==101){
            iv=(ImageView)findViewById(R.id.it101);
        }
        else if(i==102){
            iv=(ImageView)findViewById(R.id.it102);
        }
        else if(i==103){
            iv=(ImageView)findViewById(R.id.it103);
        }
        else if(i==104){
            iv=(ImageView)findViewById(R.id.it104);
        }
        else if(i==105){
            iv=(ImageView)findViewById(R.id.it105);
        }
        else if(i==106){
            iv=(ImageView)findViewById(R.id.it106);
        }
        else if(i==107){
            iv=(ImageView)findViewById(R.id.it107);
        }
        else if(i==108){
            iv=(ImageView)findViewById(R.id.it108);
        }
        else if(i==109){
            iv=(ImageView)findViewById(R.id.it109);
        }
        else if(i==110){
            iv=(ImageView)findViewById(R.id.it110);
        }
        else if(i==111){
            iv=(ImageView)findViewById(R.id.it111);
        }
        else if(i==112){
            iv=(ImageView)findViewById(R.id.it112);
        }
        else if(i==113){
            iv=(ImageView)findViewById(R.id.it113);
        }
        else if(i==114){
            iv=(ImageView)findViewById(R.id.it114);
        }
        else if(i==115){
            iv=(ImageView)findViewById(R.id.it115);
        }
        else if(i==116){
            iv=(ImageView)findViewById(R.id.it116);
        }
        else if(i==117){
            iv=(ImageView)findViewById(R.id.it117);
        }
        else if(i==118){
            iv=(ImageView)findViewById(R.id.it118);
        }
        else if(i==119){
            iv=(ImageView)findViewById(R.id.it119);
        }
        else if(i==120){
            iv=(ImageView)findViewById(R.id.it120);
        }
        else if(i==121){
            iv=(ImageView)findViewById(R.id.it121);
        }
        else if(i==122){
            iv=(ImageView)findViewById(R.id.it122);
        }
        else if(i==123){
            iv=(ImageView)findViewById(R.id.it123);
        }
        else if(i==124){
            iv=(ImageView)findViewById(R.id.it124);
        }
        else if(i==125){
            iv=(ImageView)findViewById(R.id.it125);
        }
        else if(i==126){
            iv=(ImageView)findViewById(R.id.it126);
        }
        else if(i==127){
            iv=(ImageView)findViewById(R.id.it127);
        }
        else if(i==128){
            iv=(ImageView)findViewById(R.id.it128);
        }
        else if(i==129){
            iv=(ImageView)findViewById(R.id.it129);
        }
        else if(i==130){
            iv=(ImageView)findViewById(R.id.it130);
        }
        else if(i==131){
            iv=(ImageView)findViewById(R.id.it131);
        }
        else if(i==132){
            iv=(ImageView)findViewById(R.id.it132);
        }
        else if(i==133){
            iv=(ImageView)findViewById(R.id.it133);
        }
        else if(i==134){
            iv=(ImageView)findViewById(R.id.it134);
        }
        else if(i==135){
            iv=(ImageView)findViewById(R.id.it135);
        }
        else if(i==136){
            iv=(ImageView)findViewById(R.id.it136);
        }
        else if(i==137){
            iv=(ImageView)findViewById(R.id.it137);
        }
        else if(i==138){
            iv=(ImageView)findViewById(R.id.it138);
        }
        else if(i==139){
            iv=(ImageView)findViewById(R.id.it139);
        }
        else if(i==140){
            iv=(ImageView)findViewById(R.id.it140);
        }
        else if(i==141){
            iv=(ImageView)findViewById(R.id.it141);
        }
        else if(i==142){
            iv=(ImageView)findViewById(R.id.it142);
        }
        else if(i==143){
            iv=(ImageView)findViewById(R.id.it143);
        }
        else if(i==144){
            iv=(ImageView)findViewById(R.id.it144);
        }
        else if(i==145){
            iv=(ImageView)findViewById(R.id.it145);
        }
        else if(i==146){
            iv=(ImageView)findViewById(R.id.it146);
        }
        else if(i==147){
            iv=(ImageView)findViewById(R.id.it147);
        }
        else if(i==148){
            iv=(ImageView)findViewById(R.id.it148);
        }
        else if(i==149){
            iv=(ImageView)findViewById(R.id.it149);
        }
        else if(i==150){
            iv=(ImageView)findViewById(R.id.it150);
        }
        else if(i==151){
            iv=(ImageView)findViewById(R.id.it151);
        }
        else if(i==152){
            iv=(ImageView)findViewById(R.id.it152);
        }
        else if(i==153){
            iv=(ImageView)findViewById(R.id.it153);
        }
        else if(i==154){
            iv=(ImageView)findViewById(R.id.it154);
        }
        else if(i==155){
            iv=(ImageView)findViewById(R.id.it155);
        }
        else if(i==156){
            iv=(ImageView)findViewById(R.id.it156);
        }
        else if(i==157){
            iv=(ImageView)findViewById(R.id.it157);
        }
        else if(i==158){
            iv=(ImageView)findViewById(R.id.it158);
        }
        else if(i==159){
            iv=(ImageView)findViewById(R.id.it159);
        }
        else if(i==160){
            iv=(ImageView)findViewById(R.id.it160);
        }
        else if(i==161){
            iv=(ImageView)findViewById(R.id.it161);
        }
        else if(i==162){
            iv=(ImageView)findViewById(R.id.it162);
        }
        else if(i==163){
            iv=(ImageView)findViewById(R.id.it163);
        }
        else if(i==164){
            iv=(ImageView)findViewById(R.id.it164);
        }
        else if(i==165){
            iv=(ImageView)findViewById(R.id.it165);
        }
        else if(i==166){
            iv=(ImageView)findViewById(R.id.it166);
        }
        else if(i==167){
            iv=(ImageView)findViewById(R.id.it167);
        }
        else if(i==168){
            iv=(ImageView)findViewById(R.id.it168);
        }
        else if(i==169){
            iv=(ImageView)findViewById(R.id.it169);
        }
        else if(i==170){
            iv=(ImageView)findViewById(R.id.it170);
        }
        else if(i==171){
            iv=(ImageView)findViewById(R.id.it171);
        }
        else if(i==172){
            iv=(ImageView)findViewById(R.id.it172);
        }
        else if(i==173){
            iv=(ImageView)findViewById(R.id.it173);
        }
        else if(i==174){
            iv=(ImageView)findViewById(R.id.it174);
        }
        else if(i==175){
            iv=(ImageView)findViewById(R.id.it175);
        }
        else if(i==176){
            iv=(ImageView)findViewById(R.id.it176);
        }
        else if(i==177){
            iv=(ImageView)findViewById(R.id.it177);
        }
        else if(i==178){
            iv=(ImageView)findViewById(R.id.it178);
        }
        else if(i==179){
            iv=(ImageView)findViewById(R.id.it179);
        }
        else if(i==180){
            iv=(ImageView)findViewById(R.id.it180);
        }
        else if(i==181){
            iv=(ImageView)findViewById(R.id.it181);
        }
        else if(i==182){
            iv=(ImageView)findViewById(R.id.it182);
        }
        else if(i==183){
            iv=(ImageView)findViewById(R.id.it183);
        }
        else if(i==184){
            iv=(ImageView)findViewById(R.id.it184);
        }

        return iv;
    }
    public class refreshTask extends AsyncTask<String, Void, ArrayList<String>> {
        customAnimationDialog progressDialog = new customAnimationDialog(NewActivity.this);
        OkHttpClient client = new OkHttpClient();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override //검색되는 동안, 인터넷, 파일화 등등
        protected ArrayList<String> doInBackground(String... params) {
            count=0;
            String dir = NewActivity.this.getFilesDir().getAbsolutePath();
            File file = new File(dir, Id+".txt");
            file.delete();
            Log.d("Asyncthread : ", server+name+"파일 삭제");
            final Timeline times = new Timeline();
            ArrayList<String> itemList = new ArrayList<String>();
            try {
                String code=null;
                itemList=times.timeLines(server,name);
                if(itemList.size()>0){
                    Log.d("Asyncthread : ", "아이템리스트불러오기"+itemList.size());
                    try{
                        FileOutputStream fos = openFileOutput(Id+".txt", Context.MODE_PRIVATE);
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
        @Override //여기는 이제 캐릭터 아바타가 나오게 할 예정
        protected void onPostExecute(ArrayList<String> result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            //final ItemDBH dbms = ItemDBH.getInstance(NewActivity.this);
            MyAsyncTask mProcessTask = new MyAsyncTask();
            mProcessTask.execute();
        }
    }
    public class MyAsyncTask extends AsyncTask<String, Void, ArrayList<String>> {
        customAnimationDialog progressDialog = new customAnimationDialog(NewActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //show dialog
            progressDialog.show();
        }
        @Override //검색되는 동안, 인터넷, 파일화 등등
        protected ArrayList<String> doInBackground(String... params) {
            final ItemDBH dbm = ItemDBH.getInstance(NewActivity.this);
            Log.i("DBH : ", "db객체");
            try{
                FileInputStream fis = openFileInput(Id+".txt");
                byte[] data = new byte[fis.available()];
                Log.i("fis : ", "파일에 접근함"+data.toString());
                while (fis.read(data) != -1) {                    ;                } // fres 스트림을 읽어 data 버퍼 저장
                fis.close();
                Log.i("fiss : ", "파일불러왔음"+data.toString());
                String code = new String(data);
                if(code!=""){
                    String[] codes = code.split("\n");
                    for (int c = 0; c < codes.length; c++) {
                        int gets=dbm.updatecode(NewActivity.this, codes[c], 1);
                        if(gets>-1&&gets<185){
                            iv=ivdata(gets);
                            iv.setImageResource(ImageId[gets][1]);
                            count++;
                        }
                    }
                }else{Log.i("fis : ", "파일이 비었음");}
            }
            catch (Exception e) {
                e.printStackTrace();
                Log.i("receiveMsg : ", "파일 없음");
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            super.onPostExecute(result);
            TextView c=findViewById(R.id.count);
            c.setText(count+"/185");
            progressDialog.dismiss();
        }
    }
    public String codeChange(String s){
        if(s.equals("cain")){
            return "카인";
        }
        else if(s.equals("diregie")){
            return "디레지에";
        }
        else if(s.equals("siroco")){
            return "시로코";
        }
        else if(s.equals("prey")){
            return "프레이";
        }
        else if(s.equals("casillas")){
            return "카시야스";
        }
        else if(s.equals("hilder")){
            return "힐더";
        }
        else if( s.equals("anton")){
            return "안톤";
        }
        else if(s.equals("bakal")){
            return "바칼";
        }
        return "";
    }}