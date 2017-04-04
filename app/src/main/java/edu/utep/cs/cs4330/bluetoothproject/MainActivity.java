package edu.utep.cs.cs4330.bluetoothproject;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enabled = false;
    }

    public boolean isBluetoothEnabled(View view){
        BluetoothAdapter bt = BluetoothAdapter.getDefaultAdapter();
        if(bt != null && bt.isEnabled()){
            showToast("Bluetooth is enabled.");
            enabled = true;
            return true;
        }
        showToast("Bluetooth is disabled.");
        enabled = false;
        return false;
    }

    public void enableBluetooth(View view){

//        BluetoothAdapter bt = BluetoothAdapter.getDefaultAdapter();
//        bt.enable();

        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
//        showToast("Bluetooth enabled: "+enabled);

    }

    /** Show a toast message. */
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
