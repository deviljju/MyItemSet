package kr.co.company.myapplication;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import java.util.Calendar;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import java.io.FileInputStream;
import okhttp3.OkHttpClient;

public class Timeline {
    Context myContext = null;
    private Calendar now = Calendar.getInstance();
    private static Timeline time = null;
    private int year = now.get(Calendar.YEAR);
    private int month = now.get(Calendar.MONTH)+1;
    private int date = now.get(Calendar.DATE);
    private int hour = now.get(Calendar.HOUR_OF_DAY);
    private int min = now.get(Calendar.MINUTE);
    private int sec = now.get(Calendar.SECOND);
    FileInputStream fis;
    private ArrayList<String> itemList = new ArrayList<String>();
    public String getTime(){
        String str=String.format("%4d%02d%02dT%02d%02d",year,month,date,hour,min);
        return str;
    }
    public String chaId(String server,String name){
        String chaId=name;
        OkHttpClient client = new OkHttpClient();
        try {
            String utfname = URLEncoder.encode(name, "UTF-8");
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.neople.co.kr/df/servers/"+server+"/characters?characterName="+utfname+"&limit=1&wordType=full&apikey=SSt46TCtHgAIz2bR9ZVUpleqz1OdlUDQ").newBuilder();
            String url = urlBuilder.build().toString();
            Log.d("getChaId : ", "urlEncoding:"+url);
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            JSONObject jsonObject=new JSONObject(response.body().string());
            String rows=jsonObject.getString("rows");
            JSONArray itemArray = new JSONArray(rows);
            JSONObject subJsonObject=itemArray.getJSONObject(0);
            chaId=subJsonObject.getString("characterId");
            Log.d("getChaId : ", chaId);
        }
        catch (Exception e){Log.d("getChaId : ", "뽑아내는데 실패"+chaId); return "카인";}
        return chaId;
    }

    public ArrayList<String> timeLines(String server,String name){
        ArrayList<String> timestamp = new ArrayList<String>();
        String sever_code=server;
        String cha_id = chaId(server,name);
        if(cha_id=="카인"){
            Log.d("itemList : ", ""+itemList.size());
            return itemList;
        }
        String time_code="504,505,506,507,508,510,511,512,513,514";
        String now1=getTime(); //검색 기준 시간을 받아옴
        String now=String.format("%4d%02d%02d",year,month,date);
        String startDate="20200101T0000";
        timestamp.add(startDate);
        if(Integer.parseInt(now)>=20200331){
            timestamp.add("20200330T2359");
            timestamp.add("20200331T0000");
        }
        if(Integer.parseInt(now)>=20200629){
            timestamp.add("20200628T2359");
            timestamp.add("20200629T0000");
        }
        else{
            if(!timestamp.contains(now1)){
                timestamp.add(now1);
        }}
        if(Integer.parseInt(now)>=20200927){
            timestamp.add("20200926T2359");
            timestamp.add("20200927T0000");
        }
        else{
            if(!timestamp.contains(now1)){
                timestamp.add(now1);
            }}
        if(Integer.parseInt(now)>=20201226){
            timestamp.add("20201225T2359");
            timestamp.add("20201226T0000");
        }
        else{
            if(!timestamp.contains(now1)){
                timestamp.add(now1);
            }}
        if(Integer.parseInt(now)>=20210326){
            timestamp.add("20210325T2359");
            timestamp.add("20210326T0000");
        }
        else{
            if(!timestamp.contains(now1)){
                timestamp.add(now1);
            }}


        for(int i=0;i<timestamp.size();i++){
            Log.d("timestamp : ", timestamp.get(i));
        }
        //타임스탬프에 기간 설정함 . 0101~0330 비교 / 0331~0629 비교 //만약 뒤에보다 now가 작으면 0331~0614로 기간설정됨
            for(int i=0;i<timestamp.size()-1;i+=2){
                String url="https://api.neople.co.kr/df/servers/"+sever_code+"/characters/"+cha_id+"/timeline?limit=100&code="+time_code+"&startDate="+timestamp.get(i)+"&endDate="+timestamp.get(i+1)+"&apikey=SSt46TCtHgAIz2bR9ZVUpleqz1OdlUDQ";
                urlParsing(server,cha_id,url);
        }//검색끝
        Log.d("timestamp : ", "아이템출력완료");
        //파일 저장은 메인에서해야하므로 리턴으로 아이템리스트를 준다.
        return itemList;
    }//timelines end

    public void urlParsing(String server, String cha_id,String urlO){
        OkHttpClient client = new OkHttpClient();  //캐릭명 : d0f2649f85b9832b70d5a01b911c5402
        String nextt="null";
        String sever_code=server;
        try {
            //기간별 타임라인 검색
            HttpUrl.Builder urlBuilder = HttpUrl.parse(urlO).newBuilder();
            String url = urlBuilder.build().toString();
            Log.d("urlParsing : ", "접속성공================================="+urlO);

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            JSONObject jsonObject=new JSONObject(response.body().string());
            String characterId=jsonObject.getString("characterId");
            try{
                String timeline=jsonObject.getString("timeline");
                JSONObject timelines=new JSONObject(timeline);
                nextt=timelines.getString("next");
                String rows=timelines.getString("rows");
                JSONArray itemArray = new JSONArray(rows);

                for(int i=0;i<itemArray.length();i++){
                    JSONObject subJsonObject=itemArray.getJSONObject(i);
                    String data=subJsonObject.getString("data");
                    JSONObject sub2 = new JSONObject(data);
                    String itemId=sub2.getString("itemId");
                    if(!itemList.contains(itemId)){
                        itemList.add(itemId);
                    }
                }Log.d("urlParsing : ", "item:"+itemList.size()+" next: "+nextt);
            }catch (Exception e){;}
            if (nextt!="null"){
                String urls="https://api.neople.co.kr/df/servers/"+sever_code+"/characters/"+cha_id+"/timeline?next="+nextt+"&apikey=SSt46TCtHgAIz2bR9ZVUpleqz1OdlUDQ";
                urlParsing(sever_code,cha_id,urls);
            }
            //return itemList;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("urlParsing : ", "변환실패========");
        }//catch
    }
}
