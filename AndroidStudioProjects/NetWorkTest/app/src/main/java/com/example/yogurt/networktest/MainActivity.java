package com.example.yogurt.networktest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.net.HttpURLConnection;

import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private  static final int SHOW_RESPONSE=0;
    private Button sendResquest,sendRequestClient;
    private TextView responeText;
    private final String TAG="MainActivity";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SHOW_RESPONSE:
                String response= msg.obj.toString();
                responeText.setText(response);
                break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendResquest= (Button) findViewById(R.id.send_request);
        sendRequestClient= (Button) findViewById(R.id.send_request_client);
        responeText= (TextView) findViewById(R.id.respond_text);

        sendResquest.setOnClickListener(this);
        sendRequestClient.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.send_request){
            sendRequestWithHttpURLConnection();
        }
//        if (v.getId()==R.id.send_request_client){
//            sendRequestWithHttpClient();
//        }

    }

    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection=null;
                try {
//                    URL url=new URL("http://10.13.4.198/get_data.json");
//                    httpURLConnection= (HttpURLConnection) url.openConnection();
//                    httpURLConnection.setRequestMethod("GET");
//                    httpURLConnection.setConnectTimeout(8000);
//                    httpURLConnection.setReadTimeout(8000);
//                    InputStream in=httpURLConnection.getInputStream();
//                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
//                    String line="";
//                    StringBuilder builder=new StringBuilder();
//                    while ((line=reader.readLine())!=null){
//                        builder.append(line);
//                    }
                    //parseXMLWithPull(builder.toString());
                    //parseXMLWithSAX(builder.toString());
                   // final String jsonDt="{\"city_info\":[{\"city\":\"南子岛\",\"cnty\":\"中国\",\"id\":\"CN101310230\",\"lat\":\"11.26\",\"lon\":\"114.20\",\"prov\":\"海南\"},{\"city\":\"北京\",\"cnty\":\"中国\",\"id\":\"CN101010100\",\"lat\":\"39.904000\",\"lon\":\"116.391000\",\"prov\":\"直辖市\"},{\"city\":\"海淀\",\"cnty\":\"中国\",\"id\":\"CN101010200\",\"lat\":\"39.590000\",\"lon\":\"116.170000\",\"prov\":\"直辖市\"},{\"city\":\"朝阳\",\"cnty\":\"中国\",\"id\":\"CN101010300\",\"lat\":\"39.570000\",\"lon\":\"116.290000\",\"prov\":\"直辖市\"}],\"status\":\"ok\"}";
                    final String jsonDt="[{\"city\":\"南子岛\",\"cnty\":\"中国\",\"id\":\"CN101310230\",\"lat\":\"11.26\",\"lon\":\"114.20\",\"prov\":\"海南\"},{\"city\":\"北京\",\"cnty\":\"中国\",\"id\":\"CN101010100\",\"lat\":\"39.904000\",\"lon\":\"116.391000\",\"prov\":\"直辖市\"},{\"city\":\"海淀\",\"cnty\":\"中国\",\"id\":\"CN101010200\",\"lat\":\"39.590000\",\"lon\":\"116.170000\",\"prov\":\"直辖市\"},{\"city\":\"朝阳\",\"cnty\":\"中国\",\"id\":\"CN101010300\",\"lat\":\"39.570000\",\"lon\":\"116.290000\",\"prov\":\"直辖市\"}]";

                    //parseJSONWithJSONObjects(builder.toString());
                    parseJSONWithJSONObjects(jsonDt);

//                    Message msg=new Message();
//                    msg.what=SHOW_RESPONSE;
//                    msg.obj=builder;
//                    handler.sendMessage(msg);//----------------
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (httpURLConnection!=null)
                        httpURLConnection.disconnect();
                }
            }
        }).start();
    }

    private void sendRequestWithHttpClient(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //HttpGet
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void parseXMLWithPull(String xmlData){
        try {
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser=factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType=xmlPullParser.getEventType();
            String id="";
            String name="";
            String version="";
            while (eventType!=xmlPullParser.END_DOCUMENT){
                String nodeName=xmlPullParser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:{
                        if ("id".equals(nodeName)){
                            id=xmlPullParser.nextText();
                        }else if ("name".equals(nodeName)){
                            name=xmlPullParser.nextText();
                        }else if ("version".equals(nodeName)){
                            version=xmlPullParser.nextText();
                        }
                        break;
                    }
                    //完成解析某个节点
                    case XmlPullParser.END_TAG:{
                        if ("app".equals(nodeName)){
                            Log.d(TAG,"id is "+id);
                            Log.d(TAG,"name is "+name);
                            Log.d(TAG,"version is "+version);

                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType=xmlPullParser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithSAX(String xmlData){
        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            XMLReader xmlReader=factory.newSAXParser().getXMLReader();
            ContentHanlder hanlder=new ContentHanlder();
            //将ContentHandler的实例设置到XMLReader中去
            xmlReader.setContentHandler(hanlder);
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJSONWithJSONObjects(String jsonData){
        try {
            JSONArray jsonArray=new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String city=jsonObject.getString("city");
                String cnty=jsonObject.getString("cnty");
                String prov=jsonObject.getString("prov");

                Log.d("JSON","cnty is "+cnty);
                Log.d("JSON","prov is "+prov);
                Log.d("JSON","city is "+city);
                Log.d("JSON","\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
