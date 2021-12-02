package com.capacitorjs.plugins.paxstore;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.UUID;

public class Printer extends Plugin {
    BluetoothAdapter mBluetoothAdapter;
    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice;
    // needed for communication to bluetooth device / network
    OutputStream mmOutputStream;
    InputStream mmInputStream;

    @PluginMethod
    public Set<BluetoothDevice> findBT(PluginCall call) {
        try {
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

            if (mBluetoothAdapter == null) {
                call.reject("No bluetooth adapter available");
            }

            if (!mBluetoothAdapter.isEnabled()) {
                Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(call, enableBluetooth, 0);
            }

            return mBluetoothAdapter.getBondedDevices();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setBT(String address) {
        try {
            mmDevice = mBluetoothAdapter.getRemoteDevice(address);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openBT() throws IOException {
        try {
            // Standard SerialPortService ID
            UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
            mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
            mmSocket.connect();
            mmOutputStream = mmSocket.getOutputStream();
            mmInputStream = mmSocket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeBT() throws IOException {
        try {
            mmOutputStream.close();
            mmInputStream.close();
            mmSocket.close();
            System.out.println("Bluetooth Closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTxt(String str) throws IOException {
        try {
            mmOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            System.out.println("Data sent.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
