package com.example.akhilesh.captutre;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    private static int VIDEO_REQUEST=101;
    private Uri videouri=null;
    private SensorManager sensorManager;
    Sensor accelerometer;
    float x,y,z;
    Toast toast;
    String message,mes;
    SensorEvent event1;
  //  Item item;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener((SensorEventListener) MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
//toast.cancel();
        toast= Toast.makeText(this, "Camera is ONNN", Toast.LENGTH_LONG);
        toast.show();
        flag=0;
    }
    public void capture(View view) {
        flag = 1;
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            //      onChanged();
//            startActivity;
            startActivityForResult(intent, VIDEO_REQUEST);
            // sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
            //   toast.show();
/*            x=item.getX();
          y=item.getY();
          z=item.getZ();
            //accelerometer
     //      toast.cancel();
       //    mes=xChanged()
         //  toast= Toast.makeText(this, "Camera is ONNN", Toast.LENGTH_LONG);
             onSensorChanged(event1);
            x= event1.values[0];
            y=event1.values[1];
            z=event1.values[2];

            if(x>1  && z<1)
            {
                toast.cancel();
                toast=Toast.makeText(this, "Camera x is inclined"+x, Toast.LENGTH_SHORT);
                toast.show();

            }
            if(z>1  && x<1)
            {
                toast.cancel();

                toast=Toast.makeText(this, "Camera Z is inclined"+z, Toast.LENGTH_SHORT);
                toast.show();


            }
            if(z>1  && x>1)
            {
                toast.cancel();
                toast= Toast.makeText(this, "Camera x is and y inclined X="+x+"  Z="+z, Toast.LENGTH_SHORT);
                toast.show();

            }
*/
        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== VIDEO_REQUEST && resultCode==RESULT_OK)
        {

            videouri=data.getData();
        }
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        x= event.values[0];
        y=event.values[1];
        z=event.values[2];
//        item=new  Item(x,y,z);
        event1=event;

        if(flag==1) {
            if (x > 1 && z < 1) {
                toast.cancel();
                toast = Toast.makeText(this, "Camera x is inclined" + x, Toast.LENGTH_SHORT);
                toast.show();

            }
            if (z > 1 && x < 1) {
                toast.cancel();

                toast = Toast.makeText(this, "Camera Z is inclined" + z, Toast.LENGTH_SHORT);
                toast.show();


            }
            if (z > 1 && x > 1) {
                toast.cancel();
                toast = Toast.makeText(this, "Camera x is and y inclined X=" + x + "  Z=" + z, Toast.LENGTH_SHORT);
                toast.show();

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
