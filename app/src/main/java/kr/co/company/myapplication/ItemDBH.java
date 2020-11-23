package kr.co.company.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
public class ItemDBH {
    static final String DB_Name = "myset.db";   //DB이름
    private String TABLE_Name = "None"; //Table 이름
    static final int DB_VERSION = 1;			//DB 버전
    Context myContext = null;
    private static ItemDBH myDBManager = null;
    private SQLiteDatabase mydatabase = null;
    public void getName(String name){
        this.TABLE_Name=name;
    }

    public static ItemDBH getInstance(Context context)
    {
        if(myDBManager == null)
        {
            myDBManager = new ItemDBH(context);
        }
        else{
            Log.i("DBMsg : ", "매니저있음");}
        return myDBManager;
    }
    private boolean checkTable( SQLiteDatabase db){
        int r=0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM item GROUP BY location", null);
        cursor.moveToFirst();
        if (cursor != null && cursor.getCount() != 0){
            while(cursor.moveToNext()){
                r = cursor.getInt(0);
            }}cursor.close();
        if(r>0){
            Log.i("DBMsg : ", "r:"+r);
            Log.i("DBMsg : ", "테이블있음");
            return false;
        }else{
            Log.i("DBMsg : ", "테이블없음 r: "+r);
            return true;
        }
    }

    public void insertUser(Context context,String id,String servername,String name){
        mydatabase = context.openOrCreateDatabase(DB_Name, context.MODE_PRIVATE,null);
        try{
            mydatabase.execSQL("INSERT OR REPLACE INTO user(_id,server,name) values('"+id+"','"+servername+"','"+name+"')");
            Log.i("DBMsg : ", "insert:"+id);
        }catch(SQLiteException e){
            e.printStackTrace();
            Log.i("DBMsg : ", "Update Failed");
        }
    }
    public void close(Context context){
        mydatabase = context.openOrCreateDatabase(DB_Name, context.MODE_PRIVATE,null);
        mydatabase.close();
    }
    public Cursor selectUser(Context context){
        Cursor cursors;
        cursors = mydatabase.rawQuery("SELECT * FROM user", null);
        return cursors;
    }
    public void insertDB(SQLiteDatabase mydatabase){
        //제사장
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('34797b92fcbc66fcb86d490934ae1303',0,0)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('081d9219035a3fe5912c4e3735508142',0,1)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('7fd3263d52d0e24576d981ebdc47add1',0,2)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('c5c83d9c4b552d6208245cefc58cd67e',0,3)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('a62e4f4e87bc0fc5b6a02e5d0822285c',0,4)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8e69862ea23bbb7c99b4692973e19b10',0,5)");
        //마법사
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('9354e9b70817f5315f0d42501b463f60',0,6)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('a114f11a376f8def22de8cd8d4397f7c',0,7)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('bd6e6a67fbfeb18320bf8093f06cc3c7',0,8)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2dd9acb683a62d1443ef92ccb1a99c34',0,9)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8c74c821255d86f66a42e993e77abbd3',0,10)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('e3fa3afc77a4da47f3dcf871a4c6464d',0,11)");
        //무희
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('b4545fc902750d51102a091319bbfc83',0,12)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('3872c16434aed8e7bbb010280ede0850',0,13)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('f4c81d9caef284d06ff9ea02ccb1b044',0,14)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('0be4773fe978dbdd803d06e4bc2d9776',0,15)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('998592e472485393d29420e7a739f029',0,16)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('386d0e43da5233fab6028804a34f2932',0,17)");
        //그림자
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('22a5933a2736a711c2bfcad7322a623e',0,18)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('3d3161f248ef5e6ed2d1eeb9b5446d28',0,19)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ff7f1b74c167fc8aaeeede3ed2f1c77a',0,20)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('10dbd9f4b8f332664c33b76a13305d10',0,21)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('28dab0af03c5119e0b63e5f78dc91aa7',0,22)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('797fa631b20018166886706cb86648f6',0,23)");
        //집행자
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('78026473046b75847c008c2faa740cb9',0,24)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('f496b895505ea6302d990a9869530103',0,25)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2f6fe603453f4066b1c24e9a54bd2f7d',0,26)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('75e5260fda66742c0f05fb41ffa03d68',0,27)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('7e693cdea438a54291f5cf494b5f09fd',0,28)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('f0e4e08cd5e895c74ec1906a4dc236cb',0,29)");
        //베테랑
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ea7619426683f2edbcc6b2651d438d79',0,30)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('c40d2977d03a7656fe858579c2530a04',0,31)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('786acb2ca6431f1fbd29ce33c0f7843f',0,32)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('7e1ede6e49d2715c67bc4a5a8b96e15f',0,33)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('63e54c65377fd7b2c660a726e9e3ab80',0,34)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2d8ef3cf0c87e8a2bed6ed59848cb2e3',0,35)");
        //사막
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('efed1b3100d2abda90b26119acba1b84',0,36)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ec3983c86e084fd38f7551153450dfbf',0,37)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ae42ac7d0cb2aad8b83bf58bcb499b56',0,38)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('991913dfae244337b3ff06cabfef0eee',0,39)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ee80dc4be059e87c19732be146aa957d',0,40)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('892598da1a3ae04c12702c189fb5baec',0,41)");
        //트로피카
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('3761008a46d01e9d6dbd5d77b6c3e165',0,42)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('a4610bc3ab02d64af5f38b7d7dd45e0b',0,43)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('e33a7a9aebdf187907d0a0977cb87b23',0,44)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('fa24d6a3e1261dd29216bc9dd9107098',0,45)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('13309a3bc5672bb4f540da64ef795079',0,46)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('db5f7f878090c2bc0de7fa91a32ec104',0,47)");
        //에디피
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('a57ee196541e0db113f6f3e48caa739b',0,48)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2f5acdd7a1496c8f96e29293280962ed',0,49)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('15060608692b95e2b335c54762cd67be',0,50)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('125230e058bbe65ad25b10ff0a6f071d',0,51)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('a634272704be22125066dfb6930e15fd',0,52)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('a611f2774742a8b1a2a213aaaf066f0f',0,53)");
        //개악
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('0e935269970e86d144bdaf0389aadcd4',0,54)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('e6c950d0d494055b207c1eed7593b51e',0,55)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ef296147598c75779f1153669ac36edc',0,56)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('06f0de644f29119cb7aec3b216326dad',0,57)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('b225e8ce16097be6a82952b565ca7672',0,58)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('21bd802c865a732105c1883c4c6988aa',0,59)");
        //역작
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('bb68345a23460443a05f3761f903a52d',0,60)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('3c894436df9672f92477f3de78ae9cbc',0,61)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ec31fa66cb12e360def2a4513126d6d2',0,62)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('392d70ee822c5637f8ecb9e0d423dd49',0,63)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('5f700cfedb4c3002177839a3bf127692',0,64)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('e15183e68084333b390b5eb616cc0699',0,65)");
        //구속
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('b8bb021cdee7340946495f2e7c9a4126',0,66)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('e4df5f151f39112fbf6b9d816c642f2f',0,67)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('12074c5cadd3387f79def00bdfb7404c',0,68)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8c07fa07397d14e513a80fb154f1f633',0,69)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('5db568449d3e2cfaed39832080e7528d',0,70)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('553f31379c7f665d97e60e629a13bd86',0,71)");
        //흐름
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('79a0fda77889debf6d6f5ce2274f2c7f',0,72)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('882e8164dd6711c1895526d030200250',0,73)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('38fd6a778be23237a414d5115062252a',0,74)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('91ae40407418fe3682d39d8f3034fedb',0,75)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('349af6128d7d88fc5d1356aca5bbf2e8',0,76)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('62d62b7531e09610bee17e45df2f74c9',0,77)");
        //선택
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ccc01f949b9be7732ebf90401e9d6dd4',0,78)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('b281ed888094e708d5cbf30f71a34c74',0,79)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('0074f1dee0de62f1ea4bbe183a23d049',0,80)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('4677045206fb6ccd0ba55fc2eac65241',0,81)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ec5ce2a1f589de2f91640253e72aea41',0,82)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8a712d558498c23a9aa1ea0517391f32',0,83)");
        //대자연
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2ba3e0c8bb4662c3a383b841a0aae316',0,84)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('baf124579507400a603b2a4c746482b5',0,85)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('beda39d809a0df2a6e314481590180e3',0,86)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8e1379998738521c445da694877fc88b',0,87)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('97fdbc3d22c2b983a3a69ccfc9edc2bb',0,88)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('831fef9bc88638e7df5575883ed32a82',0,89)");
        //술식
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('83a90f63e8753b409ea7059d35099816',0,90)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('677f0a5c7d742933ddff42b935377705',0,91)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('777cc0388e21e1fc87355568d309d934',0,92)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('301bd15b827ffe3ab72a6181d33f21ae',0,93)");
        //먼동
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('3adaa72c296d7c05b63111d2183d25be',0,94)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('f765a2c6d5a352eea26c930b4ac002dc',0,95)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('d6f33782f34039670394faf46429bc12',0,96)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('836c39afd1d4c97c0c0e08a4516e58f7',0,97)");
        //트앵
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('6466876944e1fdef5098d13f8d65f0d1',0,98)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('488b6c2c54f029ff2fd88d875c0bf2e8',0,99)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('c54888203ba8125d7d1079df893041c2',0,100)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ba6884c830f3ee2865e21a688c6f21ec',0,101)");
        //정령사
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('476fde8df4c575bb07ed65dfa8e354c8',0,102)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2478dbd8b9d68e651df67bc9a1f3c8fa',0,103)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('13d4c8409741f7cb4b273640969ae237',0,104)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('339a2c347e8c4c69bb6a77f4e0d968b8',0,105)");
        //군신
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('d1a84411f3f90550dd898ce9747b1056',0,106)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('aa441e3ae68e73d464f10f6e11e89098',0,107)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('e8339821b962569895a1dcd569ef1ed8',0,108)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('e98db581d86ffc2098c66049b019cf83',0,109)");
        //영보
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('370c0d826b0cee4c22e70cadbe39254e',0,110)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('0a417fc8f0588e579377be78298dbb7d',0,111)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('d3f1be6b88482b833ff69c3134cffbf1',0,112)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('a540a3704f3015701c046575f21950d1',0,113)");
        //시간전쟁
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8d962518bb1a88346c95f3cf061e8a97',0,114)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('00fc487d65673903cabda8b21a2ceb38',0,115)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('dca32f90a9a9fb049709bdd18622791b',0,116)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('28532be7516724b79a6825aaf0a03235',0,117)");
        //싱크로
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('28c58ddd69572e8407996b1792ee323a',0,118)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('d563a033184eca2823192ead5e8da912',0,119)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('237b18584ee0ec4ae16b27acc091e326',0,120)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('297a7f90713900aeb6804f39b4df02ef',0,121)");

        //심연
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('81a49b255427241e432b4f8bc8e79430',0,122)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('0b5668da99c6dd6207887f336e523e71',0,123)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('faac667b094734568db66d4c0af663f4',0,124)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('cd5895092f186bc87dbb8b540271c9d3',0,125)");
        //황혼여행
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('bc7c4e3a0050ef4aea85988a83642634',0,126)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('4e28aa6397e262a21b385e4e17eb0863',0,127)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('89a0e7652c40aaacb3f13c810097dd9e',0,128)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('c4c2cf7f1ee32babea0679124c4b654c',0,129)");
        //기구
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8510a6b8ef21003c625d1ef0931e8a40',0,130)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('26cd8c6f3296bb4335604c1ea02582cd',0,131)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('da5e4132290136b6bae3d1d8e2692446',0,132)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('33727ea5e4d52bf641bd15ba2556bc75',0,133)");
        //분노
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2f15190f0615de75cf4cdae922e70bc9',0,134)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8f833c773b16a1236d31a0c6a3f09cff',0,135)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('880219804acccc7d1deff35843742c31',0,136)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('d5aa285ea041ca244da5c0d6103ac8f8',0,137)");
        //흑마술
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('d56008e8c9fc2208dc933e4735200cdc',0,138)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('b5f385f622665794605cd7fa94a67bb9',0,139)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('96f8258abe5a61b45cd95aeb75e7296b',0,140)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('44becbbee44c861cdf8df571d4fd2aed',0,141)");
        //시간여행
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('bf0bcb8aa7ae39381730dab959f73bfc',0,142)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('19f152ef5b53761c5ac058d735e9aace',0,143)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2663b5e40549791e69a2a8a024943efb',0,144)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('74a1e80dc0d3302523f0ead3824f6fa0',0,145)");
        //함성
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2e08623069832fc50c9dcfad3a7476c6',0,146)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('4ec68a286d263752266de671d1a5ec4a',0,147)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('dd8fb29cc2d99113e208efc67474b52e',0,148)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('4b897931e2f8da03285e51849f0164d1',0,149)");
        //광란
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('4f9b33ab2503c2625772b22fb3cbac7b',0,150)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('2b0d249f743023bebc653fd5b7bcac8e',0,151)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('486f00eae262f4afc4a47d8187e368c2',0,152)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('147e35acab785cc70a363286d38689c0',0,153)");
        //나락
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8147eaaaac72c2d533421dc5460dbf11',0,154)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('b89ed6af0153823f530f9a07e4225d46',0,155)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('825c40401d213613835587dc8f721376',0,156)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('dca766f2875f2ca7df989f32394679c1',0,157)");
        //차원여행
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('34ee102e1e23475196f6947c79b2739e',0,158)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('e79a8bcf880c6467f10b4f3530f64f4a',0,159)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ecfc048f1bcb1b9aa4156126cd1a3448',0,160)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('5d1784fa174f6ccd6bc21a0f85a8d74a',0,161)");
        //주사위
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('88a33fb3d366f187e85e43a381275952',0,162)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('631feec15f8c5c24ea2357d4f1207678',0,163)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('1c93cac5af6dbd1212e646f87c558ed3',0,164)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('88186ce9a9fc02dfb274f225acd406b4',0,165)");
        //비극
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('f658400818fa831bf451e4ef2dbc55f4',0,166)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('4a64c839121cc75e1fe33dbcc2aa3351',0,167)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('830fc9494e0d30f05c49355b272d03de',0,168)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('c549adc567f46e47f536a1e26e7f9d0b',0,169)");
        //넥스
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('3fe9e9e540b65844adae13ada5025247',0,170)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('7c87b625b21477e443dc35eab24d0e3a',0,171)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('c078a040a9923bed5434b6724949a2bf',0,172)");
        //암살자
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('4cde1612f452e6a0e84ed5c6ebbbe822',0,173)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('b81cf915cd65fbc1dee48cf39acf8d6e',0,174)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('bda386b3abeaff22af5c3a4f4c47269c',0,175)");
        //록시
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('0e43f5008fbf8d8abd15a0c2893f2318',0,176)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('bfc2b3c13bfdfa0103c1f345cce0932d',0,177)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('b29ea1df7ca789d0cfca44f735fbd649',0,178)");
        //수문장
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('22cbfee023aa4c61acca31edc1497f24',0,179)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('055e9d2ed3606309ddd7c74135fc5cd3',0,180)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('48b4f7fe798b5f7552da88f401a7e1a7',0,181)");
        //로도스
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('cf81559556f6438af545b371ac6f40b8',0,182)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('8973711d2adffd06322b75534e1c560a',0,183)");
        mydatabase.execSQL("INSERT INTO item(_id,get,location) values"+"('ee09d1ac3e05182aad29399e0a462b52',0,184)");

        Log.i("DBMsg : ", "테이블 추가끝");
    }
    public void deleteDB(Context context,String id){
        try{
        mydatabase = context.openOrCreateDatabase(DB_Name, context.MODE_PRIVATE,null);
        mydatabase.execSQL("DELETE FROM user WHERE _id='"+id+"';");
        String dir = context.getFilesDir().getAbsolutePath();
        File file = new File(dir, id+".txt");
        boolean d0 = file.delete();
        Log.w("Delete Check", "File deleted: " + dir + "/myFile " + d0);
        Log.i("DBMsg : ", "Delete index:"+id);}
        catch (Exception e){}
    }
    public int updatecode(Context context,String str,Integer i){
        mydatabase = context.openOrCreateDatabase(DB_Name, context.MODE_PRIVATE,null);
        Cursor cursor;
        int r=0;
        try{
            mydatabase.execSQL("UPDATE item SET get = "+i+" WHERE _id='"+str+"';");
            cursor=mydatabase.rawQuery("SELECT location FROM item WHERE get=1 and _id='"+str+"'",null);
            if (cursor != null && cursor.getCount() != 0){
            while(cursor.moveToNext()){
                r = cursor.getInt(0);
            }}
            else{return -1;}
            cursor.close();
            Log.i("DBMsg : ", "Update:"+str+"  get:"+r);
        }catch(SQLiteException e){
            e.printStackTrace();
            Log.i("DBMsg : ", "Update Failed");
        }
        return r;
    }
    private ItemDBH(Context context)
    {
        myContext = context;
        //DB Open
        mydatabase = context.openOrCreateDatabase(DB_Name, context.MODE_PRIVATE,null);
        //Table 생성
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS item" +
                "(" + "_id TEXT PRIMARY KEY," +
                "get INTEGER," +
                "location INTEGER);");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS user" +
                "(" + "_id TEXT PRIMARY KEY," +
                "server TEXT,"+
                "name TEXT);");
        if(checkTable(mydatabase)){
            insertDB(mydatabase);
        }else{
            Log.i("DBMsg : ", "테이블 이미 있음, insert안함");}
    }
    }
