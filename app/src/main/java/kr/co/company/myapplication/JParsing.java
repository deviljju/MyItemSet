package kr.co.company.myapplication;

public class JParsing { //class 명은 json을 파싱하려고 만들었지만 다른 방법을 찾아서 user객체로 씀
    private String userName;
    private String userServer;
    private String userId;
    public String getUserId(){
        return userId;
    }
    public String getUserName(){
        return userName;
    }
    public  void setUserName(String userName){
        this.userName=userName;
    }
    public  String getUserServer(){
        return userServer;
    }
    public void setUserServer(String userServer){
        this.userServer=userServer;
    }
    public String codeChange(){
        String s=userServer;
        if(s.equals("카인")){
            return "cain";
        }
        else if(s.equals("디레지에")){
            return "diregie";
        }
        else if(s.equals("시로코")){
            return "siroco";
        }
        else if(s.equals("프레이")){
            return "prey";
        }
        else if(s.equals("카시야스")){
            return "casillas";
        }
        else if(s.equals("힐더")){
            return "hilder";
        }
        else if( s.equals("안톤")){
            return "anton";
        }
        else if(s.equals("바칼")){
            return "bakal";
        }
        return "";
    }
    public JParsing(String userId,String userServer, String userName) {
        this.userId=userId;
        this.userServer = userServer;
        this.userName = userName;
    }
}