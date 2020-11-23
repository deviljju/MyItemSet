package kr.co.company.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DBAdapter extends BaseAdapter{
    private Context context;
    private List<JParsing> userList;

    public DBAdapter(Context context, List<JParsing> userList){
        this.context = context;
        this.userList = userList;
    }

    //출력할 총갯수를 설정하는 메소드
    @Override
    public int getCount() { return userList.size();    }

    //특정한 유저를 반환하는 메소드
    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    //아이템별 아이디를 반환하는 메소드
    @Override
    public long getItemId(int i) {
        return i;
    }

    //가장 중요한 부분
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.listlayout, null);

        //뷰에 다음 컴포넌트들을 연결시켜줌
        TextView userServer = (TextView)v.findViewById(R.id.listserver);
        TextView userName = (TextView)v.findViewById(R.id.listname);

        userServer.setText(userList.get(i).getUserServer());
        userName.setText(userList.get(i).getUserName());

        //이렇게하면 findViewWithTag를 쓸 수 있음 없어도 되는 문장임
        //v.setTag(userList.get(i).getUserName());

        //만든뷰를 반환함
        return v;
    }
    public String recommendCh(){
        Random rnd=new Random();
        int num=rnd.nextInt(154);
        String ch="전문직업 CH.31";
        if(num==0){ch="그란플로리스 CH. 1";}
        else if(num==1) {ch="그란플로리스 CH. 2";}
        else if(num==2)	{ch="그란플로리스 CH. 3";}
        else if(num==3)	{ch="그란플로리스 CH. 4";}
        else if(num==4)	{ch="그란플로리스 CH. 5";}
        else if(num==5)	{ch="그란플로리스 CH. 6";}
        else if(num==6)	{ch="그란플로리스 CH. 7";}
        else if(num==7)	{ch="그란플로리스 CH. 8";}
        else if(num==8)	{ch="그란플로리스 CH. 9";}
        else if(num==9)	{ch="그란플로리스 CH.10";}
        else if(num==10){ch="그란플로리스 CH.11";}
        else if(num==11){ch="그란플로리스 CH.12";}
        else if(num==12){ch="하늘성 CH.16";}
        else if(num==13){ch="하늘성 CH.17";}
        else if(num==14){ch="하늘성 CH.18";}
        else if(num==15){ch="하늘성 CH.19";}
        else if(num==16){ch="하늘성 CH.20";}
        else if(num==17)	{ch="베히모스 CH.21";}
        else if(num==18)	{ch="베히모스 CH.22";}
        else if(num==19)	{ch="베히모스 CH.23";}
        else if(num==20)	{ch="베히모스 CH.24";}
        else if(num==21)	{ch="베히모스 CH.25";}
        else if(num==22)	{ch="알프라이라 CH.26";}
        else if(num==23)	{ch="알프라이라 CH.27";}
        else if(num==24)	{ch="알프라이라 CH.28";}
        else if(num==25)	{ch="알프라이라 CH.29";}
        else if(num==26)	{ch="알프라이라 CH.30";}
        else if(num==27)	{ch="노이어페라 CH.31";}
        else if(num==28)	{ch="노이어페라 CH.32";}
        else if(num==29)	{ch="노이어페라 CH.33";}
        else if(num==30)	{ch="노이어페라 CH.34";}
        else if(num==31)	{ch="노이어페라 CH.35";}
        else if(num==32)	{ch="설산 CH. 1";}
        else if(num==33)	{ch="설산 CH. 2";}
        else if(num==34)	{ch="설산 CH. 3";}
        else if(num==35)	{ch="설산 CH. 4";}
        else if(num==36)	{ch="설산 CH. 5";}
        else if(num==37)	{ch="노스마이어 CH. 6";}
        else if(num==38)	{ch="노스마이어 CH. 7";}
        else if(num==39)	{ch="노스마이어 CH. 8";}
        else if(num==40)	{ch="노스마이어 CH. 9";}
        else if(num==41)	{ch="노스마이어 CH.10";}
        else if(num==42)	{ch="아브노바 CH.11";}
        else if(num==43)	{ch="아브노바 CH.12";}
        else if(num==44)	{ch="아브노바 CH.13";}
        else if(num==45)	{ch="아브노바 CH.14";}
        else if(num==46)	{ch="아브노바 CH.15";}
        else if(num==47)	{ch="멜트다운 CH.16";}
        else if(num==48)	{ch="멜트다운 CH.17";}
        else if(num==49)	{ch="멜트다운 CH.18";}
        else if(num==50)	{ch="멜트다운 CH.19";}
        else if(num==51)	{ch="멜트다운 CH.20";}
        else if(num==52)	{ch="역천의 폭포 CH.21";}
        else if(num==53)	{ch="역천의 폭포 CH.22";}
        else if(num==54)	{ch="역천의 폭포 CH.23";}
        else if(num==55)	{ch="역천의 폭포 CH.24";}
        else if(num==56)	{ch="역천의 폭포 CH.25";}
        else if(num==57)	{ch="안트베르 협곡 CH.26";}
        else if(num==58)	{ch="안트베르 협곡 CH.27";}
        else if(num==59)	{ch="안트베르 협곡 CH.28";}
        else if(num==60)	{ch="안트베르 협곡 CH.29";}
        else if(num==61)	{ch="안트베르 협곡 CH.30";}
        else if(num==62)	{ch="해상열차 CH. 1";}
        else if(num==63)	{ch="해상열차 CH. 2";}
        else if(num==64)	{ch="해상열차 CH. 3";}
        else if(num==65)	{ch="해상열차 CH. 4";}
        else if(num==66)	{ch="해상열차 CH. 5";}
        else if(num==67)	{ch="시간의 문 CH. 6";}
        else if(num==68)	{ch="시간의 문 CH. 7";}
        else if(num==69)	{ch="시간의 문 CH. 8";}
        else if(num==70)	{ch="시간의 문 CH. 9";}
        else if(num==71)	{ch="시간의 문 CH.10";}
        else if(num==72)	{ch="파워 스테이션 CH.11";}
        else if(num==73)	{ch="파워 스테이션 CH.12";}
        else if(num==74)	{ch="파워 스테이션 CH.13";}
        else if(num==75)	{ch="파워 스테이션 CH.14";}
        else if(num==76)	{ch="파워 스테이션 CH.15";}
        else if(num==77)	{ch="노블스카이 CH.16";}
        else if(num==78)	{ch="노블스카이 CH.17";}
        else if(num==79)	{ch="노블스카이 CH.18";}
        else if(num==80)	{ch="노블스카이 CH.19";}
        else if(num==81)	{ch="노블스카이 CH.20";}
        else if(num==82)	{ch="죽은자의 성 CH.21";}
        else if(num==83)	{ch="죽은자의 성 CH.22";}
        else if(num==84)	{ch="죽은자의 성 CH.23";}
        else if(num==85)	{ch="죽은자의 성 CH.24";}
        else if(num==86)	{ch="죽은자의 성 CH.25";}
        else if(num==87)	{ch="죽은자의 성 CH.26";}
        else if(num==88)	{ch="죽은자의 성 CH.27";}
        else if(num==89)	{ch="죽은자의 성 CH.28";}
        else if(num==90)	{ch="죽은자의 성 CH.29";}
        else if(num==91)	{ch="죽은자의 성 CH.30";}
        else if(num==92)	{ch="메트로센터 CH. 1";}
        else if(num==93)	{ch="메트로센터 CH. 2";}
        else if(num==94)	{ch="메트로센터 CH. 3";}
        else if(num==95)	{ch="메트로센터 CH. 4";}
        else if(num==96)	{ch="메트로센터 CH. 5";}
        else if(num==97)	{ch="메트로센터 CH. 6";}
        else if(num==98)	{ch="메트로센터 CH. 7";}
        else if(num==99)	{ch="메트로센터 CH. 8";}
        else if(num==100)	{ch="메트로센터 CH. 9";}
        else if(num==101)	{ch="메트로센터 CH.10";}
        else if(num==102)	{ch="메트로센터 CH.11";}
        else if(num==103)	{ch="메트로센터 CH.12";}
        else if(num==104)	{ch="메트로센터 CH.13";}
        else if(num==105)	{ch="메트로센터 CH.14";}
        else if(num==106)	{ch="메트로센터 CH. 15";}
        else if(num==107)	{ch="할렘 CH.16";}
        else if(num==108)	{ch="할렘 CH.17";}
        else if(num==109)	{ch="할렘 CH.18";}
        else if(num==110)	{ch="할렘 CH.19";}
        else if(num==111)	{ch="할렘 CH.20";}
        else if(num==112)	{ch="할렘 CH.21";}
        else if(num==113)	{ch="할렘 CH.22";}
        else if(num==114)	{ch="할렘 CH.23";}
        else if(num==115)	{ch="할렘 CH.24";}
        else if(num==116)	{ch="할렘 CH.25";}
        else if(num==117)	{ch="할렘 CH.26";}
        else if(num==118)	{ch="할렘 CH.27";}
        else if(num==119)	{ch="할렘 CH.28";}
        else if(num==120)	{ch="할렘 CH.29";}
        else if(num==121)	{ch="할렘 CH.30";}
        else if(num==122)	{ch="할렘 CH.31";}
        else if(num==123)	{ch="할렘 CH.32";}
        else if(num==124)	{ch="할렘 CH.33";}
        else if(num==125)	{ch="할렘 CH.34";}
        else if(num==126)	{ch="할렘 CH.35";}
        else if(num==127)	{ch="심연에 잠긴 하늘성 CH. 1";}
        else if(num==128)	{ch="심연에 잠긴 하늘성 CH. 2";}
        else if(num==129)	{ch="심연에 잠긴 하늘성 CH. 3";}
        else if(num==130)	{ch="심연에 잠긴 하늘성 CH. 4";}
        else if(num==131)	{ch="심연에 잠긴 하늘성 CH. 5";}
        else if(num==132)	{ch="심연에 잠긴 하늘성 CH. 6";}
        else if(num==133)	{ch="심연에 잠긴 하늘성 CH. 7";}
        else if(num==134)	{ch="심연에 잠긴 하늘성 CH. 8";}
        else if(num==135)	{ch="심연에 잠긴 하늘성 CH. 9";}
        else if(num==136)	{ch="심연에 잠긴 하늘성 CH.10";}
        else if(num==137)	{ch="심연에 잠긴 하늘성 CH.11";}
        else if(num==138)	{ch="심연에 잠긴 하늘성 CH.12";}
        else if(num==139)	{ch="심연에 잠긴 하늘성 CH.13";}
        else if(num==140)	{ch="심연에 잠긴 하늘성 CH.14";}
        else if(num==141)	{ch="심연에 잠긴 하늘성 CH.15";}
        else if(num==142)	{ch="심연에 잠긴 하늘성 CH.16";}
        else if(num==143)	{ch="심연에 잠긴 하늘성 CH.17";}
        else if(num==144)	{ch="심연에 잠긴 하늘성 CH.18";}
        else if(num==145)	{ch="심연에 잠긴 하늘성 CH.19";}
        else if(num==146)	{ch="심연에 잠긴 하늘성 CH.20";}
        else if(num==147)	{ch="망자의 협곡 CH. 6";}
        else if(num==148)	{ch="망자의 협곡 CH. 7";}
        else if(num==149)	{ch="망자의 협곡 CH. 8";}
        else if(num==150)	{ch="망자의 협곡 CH. 9";}
        else if(num==151)	{ch="망자의 협곡 CH.10";}
        else if(num==152)	{ch="거래-경매장 CH.61";}
        else if(num==153)	{ch="거래-경매장 CH.62";}
        return ch;
    }
}
