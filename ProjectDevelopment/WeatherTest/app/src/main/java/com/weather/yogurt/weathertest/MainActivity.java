package com.weather.yogurt.weathertest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    final android.os.Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1){
                textView.setText(msg.obj.toString());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.button);
        String httpUrl = "http://apis.baidu.com/apistore/weatherservice/cityinfo";
        String httpArg = "cityname=";
        final String address=httpUrl + "?" + httpArg;

        textView= (TextView) findViewById(R.id.textview);

        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HttpURLConnection connection=null;
                        try {
                            //城市列表    和天气
                            //URL url=new URL("http://api.heweather.com/x3/citylist?search=allchina&key=e19045cee31b460ba8844999a6a13167");
                            URL url=new URL("http://10.13.4.198/allchina.xml");
                            connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setReadTimeout(8000);
                            connection.setConnectTimeout(8000);
                            //connection.connect();
                            InputStream in= connection.getInputStream();
                            BufferedReader reader=new BufferedReader(new InputStreamReader(in, "UTF-8"));
                            String line;
                            StringBuilder response=new StringBuilder();
                            while ((line=reader.readLine())!=null){
                                response.append(line);
                            }
                            parseXMLWithPull(response.toString());
                        }catch (Exception e){
                            e.printStackTrace();
                            }
                        }
                }).start();
            }
        });
    }
private void parseJSONCityData(String jsonData){
    jsonData.replaceAll("特别行政区","香港");
    try {
        JSONArray jsonArray=new JSONArray(jsonData);
        StringBuilder info=new StringBuilder();
        String pro=null;
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            String city=jsonObject.getString("city");
            String country=jsonObject.getString("cnty");
            String province=jsonObject.getString("prov");
            String lat=jsonObject.getString("lat");
            String lon=jsonObject.getString("lon");
            if (city.equals("北京")||city.equals("上海")||city.equals("天津")||city.equals("重庆")||city.equals("香港")||city.equals("澳门"))
                pro=city;
            if (province.equals("直辖市")||province.equals("特别行政区")) province=pro;
            info.append(country+"-->"+province+"-->"+city+"  lat"+lat+"  lon"+lon+"\n");
        }
        Message message=new Message();
        message.what=1;
        message.obj=info;
        handler.sendMessage(message);
    }catch (Exception e){
        e.printStackTrace();
    }
}

private void parseXMLWithPull(String xmlData){
    try {
        XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
        XmlPullParser xmlPullParser=factory.newPullParser();
        xmlPullParser.setInput(new StringReader(xmlData));
        int eventType=xmlPullParser.getEventType();
        String cityCode="";
        String townName_PinYin="";
        String town="";
        String city="";
        String province="";
        StringBuilder parsedData=new StringBuilder();
        while (eventType!=xmlPullParser.END_DOCUMENT){
            String nodeName=xmlPullParser.getName();
            switch (eventType){
                case XmlPullParser.START_TAG:{
                    if ("id".equals(nodeName)){
                        cityCode=xmlPullParser.nextText();
                    }else if ("town_pinyin".equals(nodeName)){
                        townName_PinYin=xmlPullParser.nextText();
                    }else if ("town_chinese".equals(nodeName)){
                        town=xmlPullParser.nextText();
                    }else if ("city".equals(nodeName)){
                        city=xmlPullParser.nextText();
                    }else if ("province".equals(nodeName)){
                        province=xmlPullParser.nextText();
                    }
                    break;
                }

                case XmlPullParser.END_TAG:{
                    if ("app".equals(nodeName)){
                        //Log.d("MainActivity","cityCode:"+cityCode+", townName:"+town+", city:"+city+", province:"+province);
                        parsedData.append(cityCode+",town:"+town+",city:"+city+",province:"+province+"\n");

                    }
                    break;
                }
               default:
                   break;
            }
            eventType=xmlPullParser.next();
        }
        Message msg=new Message();
        msg.what=1;
        msg.obj=parsedData;
        handler.sendMessage(msg);

    }catch (Exception e){
        e.printStackTrace();
    }
}

}
