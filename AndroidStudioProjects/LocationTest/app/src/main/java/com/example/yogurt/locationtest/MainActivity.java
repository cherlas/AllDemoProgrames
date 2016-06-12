package com.example.yogurt.locationtest;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView locationTextView,formattedLocation;
    private LocationManager locationManager;
    private String provider;
    private LocationListener locationListener;
    public static final int SHOW_LOCATION=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationTextView = (TextView) findViewById(R.id.position_text_view);
        formattedLocation= (TextView) findViewById(R.id.formatted_location);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //provider=LocationManager.GPS_PROVIDER;
        //获取所有可用的位置提供器
        List<String> providerList = locationManager.getProviders(true);
        if (providerList.contains(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
        } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            //没有位置提供器时
            Toast.makeText(this, "No Location to Use", Toast.LENGTH_SHORT).show();
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            showLocation(location);
        }

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                showLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(provider, 500, 1, locationListener);


    }

    private void showLocation(final Location location) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder sb=new StringBuilder();
                    sb.append("http://maps.googleapis.com/maps/api/geocode/json?latlng=");
                    sb.append(location.getLatitude());
                    sb.append(",");
                    sb.append(location.getLongitude());
                    sb.append("&sensor=false");

                    URL url=new URL(sb.toString());
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    InputStream in=connection.getInputStream();
                    String line="";
                    StringBuilder response=new StringBuilder();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    while ((line=reader.readLine())!=null){
                        response.append(line);
                    }

                    JSONObject jsonObject=new JSONObject(response.toString());
                    JSONArray jsonArray=jsonObject.getJSONArray("results");
                    if (jsonArray.length()>0){
                        JSONObject subObject=jsonArray.getJSONObject(0);
                        //取出格式化信息
                        String address=subObject.getString("formatted_address");
                        Message message=new Message();
                        message.obj=address;
                        message.what=SHOW_LOCATION;

                        handler.sendMessage(message);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        String currentLocation = "Latitude is " + location.getLatitude() + "\n" + "longitude is " + location.getLongitude();
        locationTextView.setText(currentLocation);
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SHOW_LOCATION:
                    formattedLocation.setText(msg.obj.toString());
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            //关闭程序时移除监听器
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.removeUpdates(locationListener);
        }
    }
}
