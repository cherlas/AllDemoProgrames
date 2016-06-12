package com.weather.yogurt.weathertest2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView weather;
    private String jsonData="{\n" +
            "    \"HeWeather data service 3.0\": [\n" +
            "        {\n" +
            "            \"aqi\": {\n" +
            "                \"city\": {\n" +
            "                    \"aqi\": \"98\",\n" +
            "                    \"co\": \"1\",\n" +
            "                    \"no2\": \"38\",\n" +
            "                    \"o3\": \"140\",\n" +
            "                    \"pm10\": \"103\",\n" +
            "                    \"pm25\": \"45\",\n" +
            "                    \"qlty\": \"良\",\n" +
            "                    \"so2\": \"11\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"basic\": {\n" +
            "                \"city\": \"西安\",\n" +
            "                \"cnty\": \"中国\",\n" +
            "                \"id\": \"CN101110101\",\n" +
            "                \"lat\": \"34.285000\",\n" +
            "                \"lon\": \"108.969000\",\n" +
            "                \"update\": {\n" +
            "                    \"loc\": \"2016-05-22 16:52\",\n" +
            "                    \"utc\": \"2016-05-22 08:52\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"daily_forecast\": [\n" +
            "                {\n" +
            "                    \"astro\": {\n" +
            "                        \"sr\": \"05:37\",\n" +
            "                        \"ss\": \"19:44\"\n" +
            "                    },\n" +
            "                    \"cond\": {\n" +
            "                        \"code_d\": \"104\",\n" +
            "                        \"code_n\": \"305\",\n" +
            "                        \"txt_d\": \"阴\",\n" +
            "                        \"txt_n\": \"小雨\"\n" +
            "                    },\n" +
            "                    \"date\": \"2016-05-22\",\n" +
            "                    \"hum\": \"34\",\n" +
            "                    \"pcpn\": \"1.2\",\n" +
            "                    \"pop\": \"92\",\n" +
            "                    \"pres\": \"1014\",\n" +
            "                    \"tmp\": {\n" +
            "                        \"max\": \"24\",\n" +
            "                        \"min\": \"15\"\n" +
            "                    },\n" +
            "                    \"vis\": \"10\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"73\",\n" +
            "                        \"dir\": \"东风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"7\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"astro\": {\n" +
            "                        \"sr\": \"05:36\",\n" +
            "                        \"ss\": \"19:45\"\n" +
            "                    },\n" +
            "                    \"cond\": {\n" +
            "                        \"code_d\": \"101\",\n" +
            "                        \"code_n\": \"100\",\n" +
            "                        \"txt_d\": \"多云\",\n" +
            "                        \"txt_n\": \"晴\"\n" +
            "                    },\n" +
            "                    \"date\": \"2016-05-23\",\n" +
            "                    \"hum\": \"33\",\n" +
            "                    \"pcpn\": \"2.5\",\n" +
            "                    \"pop\": \"92\",\n" +
            "                    \"pres\": \"1014\",\n" +
            "                    \"tmp\": {\n" +
            "                        \"max\": \"26\",\n" +
            "                        \"min\": \"16\"\n" +
            "                    },\n" +
            "                    \"vis\": \"10\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"249\",\n" +
            "                        \"dir\": \"东风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"4\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"astro\": {\n" +
            "                        \"sr\": \"05:36\",\n" +
            "                        \"ss\": \"19:45\"\n" +
            "                    },\n" +
            "                    \"cond\": {\n" +
            "                        \"code_d\": \"100\",\n" +
            "                        \"code_n\": \"101\",\n" +
            "                        \"txt_d\": \"晴\",\n" +
            "                        \"txt_n\": \"多云\"\n" +
            "                    },\n" +
            "                    \"date\": \"2016-05-24\",\n" +
            "                    \"hum\": \"20\",\n" +
            "                    \"pcpn\": \"0.0\",\n" +
            "                    \"pop\": \"28\",\n" +
            "                    \"pres\": \"1004\",\n" +
            "                    \"tmp\": {\n" +
            "                        \"max\": \"28\",\n" +
            "                        \"min\": \"16\"\n" +
            "                    },\n" +
            "                    \"vis\": \"10\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"199\",\n" +
            "                        \"dir\": \"东风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"8\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"astro\": {\n" +
            "                        \"sr\": \"05:35\",\n" +
            "                        \"ss\": \"19:46\"\n" +
            "                    },\n" +
            "                    \"cond\": {\n" +
            "                        \"code_d\": \"104\",\n" +
            "                        \"code_n\": \"305\",\n" +
            "                        \"txt_d\": \"阴\",\n" +
            "                        \"txt_n\": \"小雨\"\n" +
            "                    },\n" +
            "                    \"date\": \"2016-05-25\",\n" +
            "                    \"hum\": \"13\",\n" +
            "                    \"pcpn\": \"0.2\",\n" +
            "                    \"pop\": \"75\",\n" +
            "                    \"pres\": \"1010\",\n" +
            "                    \"tmp\": {\n" +
            "                        \"max\": \"22\",\n" +
            "                        \"min\": \"17\"\n" +
            "                    },\n" +
            "                    \"vis\": \"10\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"353\",\n" +
            "                        \"dir\": \"东风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"2\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"astro\": {\n" +
            "                        \"sr\": \"05:35\",\n" +
            "                        \"ss\": \"19:47\"\n" +
            "                    },\n" +
            "                    \"cond\": {\n" +
            "                        \"code_d\": \"305\",\n" +
            "                        \"code_n\": \"305\",\n" +
            "                        \"txt_d\": \"小雨\",\n" +
            "                        \"txt_n\": \"小雨\"\n" +
            "                    },\n" +
            "                    \"date\": \"2016-05-26\",\n" +
            "                    \"hum\": \"27\",\n" +
            "                    \"pcpn\": \"0.1\",\n" +
            "                    \"pop\": \"53\",\n" +
            "                    \"pres\": \"1014\",\n" +
            "                    \"tmp\": {\n" +
            "                        \"max\": \"23\",\n" +
            "                        \"min\": \"14\"\n" +
            "                    },\n" +
            "                    \"vis\": \"10\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"251\",\n" +
            "                        \"dir\": \"东风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"2\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"astro\": {\n" +
            "                        \"sr\": \"05:34\",\n" +
            "                        \"ss\": \"19:47\"\n" +
            "                    },\n" +
            "                    \"cond\": {\n" +
            "                        \"code_d\": \"104\",\n" +
            "                        \"code_n\": \"104\",\n" +
            "                        \"txt_d\": \"阴\",\n" +
            "                        \"txt_n\": \"阴\"\n" +
            "                    },\n" +
            "                    \"date\": \"2016-05-27\",\n" +
            "                    \"hum\": \"24\",\n" +
            "                    \"pcpn\": \"0.0\",\n" +
            "                    \"pop\": \"1\",\n" +
            "                    \"pres\": \"1011\",\n" +
            "                    \"tmp\": {\n" +
            "                        \"max\": \"21\",\n" +
            "                        \"min\": \"12\"\n" +
            "                    },\n" +
            "                    \"vis\": \"10\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"148\",\n" +
            "                        \"dir\": \"东风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"10\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"astro\": {\n" +
            "                        \"sr\": \"05:34\",\n" +
            "                        \"ss\": \"19:48\"\n" +
            "                    },\n" +
            "                    \"cond\": {\n" +
            "                        \"code_d\": \"104\",\n" +
            "                        \"code_n\": \"101\",\n" +
            "                        \"txt_d\": \"阴\",\n" +
            "                        \"txt_n\": \"多云\"\n" +
            "                    },\n" +
            "                    \"date\": \"2016-05-28\",\n" +
            "                    \"hum\": \"19\",\n" +
            "                    \"pcpn\": \"0.0\",\n" +
            "                    \"pop\": \"0\",\n" +
            "                    \"pres\": \"1005\",\n" +
            "                    \"tmp\": {\n" +
            "                        \"max\": \"27\",\n" +
            "                        \"min\": \"16\"\n" +
            "                    },\n" +
            "                    \"vis\": \"10\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"242\",\n" +
            "                        \"dir\": \"东风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"4\"\n" +
            "                    }\n" +
            "                }\n" +
            "            ],\n" +
            "            \"hourly_forecast\": [\n" +
            "                {\n" +
            "                    \"date\": \"2016-05-22 16:00\",\n" +
            "                    \"hum\": \"35\",\n" +
            "                    \"pop\": \"0\",\n" +
            "                    \"pres\": \"1013\",\n" +
            "                    \"tmp\": \"30\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"110\",\n" +
            "                        \"dir\": \"东南风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"8\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"date\": \"2016-05-22 19:00\",\n" +
            "                    \"hum\": \"47\",\n" +
            "                    \"pop\": \"18\",\n" +
            "                    \"pres\": \"1014\",\n" +
            "                    \"tmp\": \"28\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"161\",\n" +
            "                        \"dir\": \"东南风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"6\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"date\": \"2016-05-22 22:00\",\n" +
            "                    \"hum\": \"70\",\n" +
            "                    \"pop\": \"70\",\n" +
            "                    \"pres\": \"1016\",\n" +
            "                    \"tmp\": \"26\",\n" +
            "                    \"wind\": {\n" +
            "                        \"deg\": \"220\",\n" +
            "                        \"dir\": \"西南风\",\n" +
            "                        \"sc\": \"微风\",\n" +
            "                        \"spd\": \"7\"\n" +
            "                    }\n" +
            "                }\n" +
            "            ],\n" +
            "            \"now\": {\n" +
            "                \"cond\": {\n" +
            "                    \"code\": \"104\",\n" +
            "                    \"txt\": \"阴\"\n" +
            "                },\n" +
            "                \"fl\": \"25\",\n" +
            "                \"hum\": \"42\",\n" +
            "                \"pcpn\": \"0\",\n" +
            "                \"pres\": \"1014\",\n" +
            "                \"tmp\": \"24\",\n" +
            "                \"vis\": \"10\",\n" +
            "                \"wind\": {\n" +
            "                    \"deg\": \"50\",\n" +
            "                    \"dir\": \"东北风\",\n" +
            "                    \"sc\": \"4-5\",\n" +
            "                    \"spd\": \"23\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"status\": \"ok\",\n" +
            "            \"suggestion\": {\n" +
            "                \"comf\": {\n" +
            "                    \"brf\": \"舒适\",\n" +
            "                    \"txt\": \"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。\"\n" +
            "                },\n" +
            "                \"cw\": {\n" +
            "                    \"brf\": \"不宜\",\n" +
            "                    \"txt\": \"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。\"\n" +
            "                },\n" +
            "                \"drsg\": {\n" +
            "                    \"brf\": \"舒适\",\n" +
            "                    \"txt\": \"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。\"\n" +
            "                },\n" +
            "                \"flu\": {\n" +
            "                    \"brf\": \"较易发\",\n" +
            "                    \"txt\": \"相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。\"\n" +
            "                },\n" +
            "                \"sport\": {\n" +
            "                    \"brf\": \"较适宜\",\n" +
            "                    \"txt\": \"阴天，较适宜进行各种户内外运动。\"\n" +
            "                },\n" +
            "                \"trav\": {\n" +
            "                    \"brf\": \"适宜\",\n" +
            "                    \"txt\": \"天气较好，温度适宜，总体来说还是好天气哦，这样的天气适宜旅游，您可以尽情地享受大自然的风光。\"\n" +
            "                },\n" +
            "                \"uv\": {\n" +
            "                    \"brf\": \"最弱\",\n" +
            "                    \"txt\": \"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weather= (TextView) findViewById(R.id.text);
        try {
            parseJsonData(jsonData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJsonData(String jsonData) throws JSONException {

        JSONArray jsonArray=new JSONArray(jsonData.substring(jsonData.indexOf("["),jsonData.lastIndexOf("]")+1));
        JSONObject jsonObject=jsonArray.getJSONObject(0);
        String status=jsonObject.getString("status");
        JSONObject basic=jsonObject.getJSONObject("basic");
        String city=basic.getString("city");
        String cnty=basic.getString("cnty");
        weather.setText(status+"    "+cnty+"    "+city);

    }
}
