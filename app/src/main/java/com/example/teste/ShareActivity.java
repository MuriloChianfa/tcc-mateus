package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.teste.Core.Base64;
import com.example.teste.Network.BroadcastPacketReceiver;
import com.example.teste.Network.Client;
import com.example.teste.Network.IOStream;
import com.example.teste.Network.Server;

import java.util.ArrayList;
import java.util.List;

public class ShareActivity extends AppCompatActivity
{
    Button btnOnOff, btnDiscover, btnSend;
    ListView listView;
    EditText writeMsg;

    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;

    BroadcastReceiver mReceiver;
    IntentFilter mIntentFilter;

    List<WifiP2pDevice> peers = new ArrayList<>();
    String[] deviceNameArray;
    WifiP2pDevice[] deviceArray;

    public static Server server;
    public static Client client;

    public static String currentConnectionType;

    Bitmap bitmap;
    ImageView imageView;
    ImageView imageViewColega;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviarinterface);

        this.bitmap = (getIntent()).getParcelableExtra("BitmapImage");

        ImageView imageView = findViewById(R.id.verImagem);
        imageView.setImageBitmap(this.bitmap);

        draw();
        addListeners();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    private void addListeners()
    {
        btnDiscover.setOnClickListener(view -> {
            if (ActivityCompat.checkSelfPermission(ShareActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(ShareActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 255);
                return;
            }

            mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener()
            {
                @Override
                public void onSuccess()
                {
                    Toast.makeText(ShareActivity.this, "Searching...", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(int reason)
                {
                    Toast.makeText(ShareActivity.this, "Error on search!", Toast.LENGTH_SHORT).show();
                }
            });
        });

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            final WifiP2pDevice device = deviceArray[i];

            WifiP2pConfig config = new WifiP2pConfig();
            config.deviceAddress = device.deviceAddress;

            if (ActivityCompat.checkSelfPermission(ShareActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(ShareActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 255);
                return;
            }

            mManager.connect(mChannel, config, new WifiP2pManager.ActionListener()
            {
                @Override
                public void onSuccess() {
                    Toast.makeText(getApplicationContext(), "Connected to " + device.deviceName, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(int i) {
                    Toast.makeText(getApplicationContext(), "Not Connected " + device.deviceName, Toast.LENGTH_SHORT).show();
                }
            });
        });

        btnSend.setOnClickListener(view -> {
            if (null == ShareActivity.currentConnectionType) {
                System.out.println("Your aren't connected!");

                Toast.makeText(getApplicationContext(), "Your aren't connected!", Toast.LENGTH_SHORT).show();
                return;
            }

            System.out.println("Sending image converted in base64 to peer...");

            byte[] data = Base64.encodeTobase64(this.bitmap);

            // https://codebeautify.org/base64-to-image-converter
            // String converted = android.util.Base64.encodeToString(data, android.util.Base64.DEFAULT);
            // System.out.println("Sent data image: ");
            // System.out.println(converted);

            try {
                if (ShareActivity.currentConnectionType.equals("Host")) {
                    ShareActivity.server.stream.write(data);
                    return;
                }

                ShareActivity.client.stream.write(data);
            } catch (Throwable exception) {
                System.out.println(exception.getMessage());

                Toast.makeText(getApplicationContext(), "An error occurred when send image!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void draw() {
        btnOnOff = findViewById(R.id.onOff);
        btnDiscover = findViewById(R.id.discover);
        btnSend = findViewById(R.id.sendButton);
        listView = findViewById(R.id.peerListView);
        writeMsg = findViewById(R.id.writeMsg);
        imageView = findViewById(R.id.verImagem);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        imageView.setMinimumHeight(size.y / 2);
        imageView.setMinimumWidth(size.x / 2);

        mManager = (WifiP2pManager) getSystemService( Context.WIFI_P2P_SERVICE );
        mChannel = mManager.initialize(this, getMainLooper(), null);

        mReceiver = new BroadcastPacketReceiver(mManager, mChannel, this);

        mIntentFilter = new IntentFilter();

        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }

    public WifiP2pManager.PeerListListener peerListListener = new WifiP2pManager.PeerListListener()
    {
        @Override
        public void onPeersAvailable(WifiP2pDeviceList peerList)
        {
            if (!peerList.getDeviceList().equals(peers)) {
                peers.clear();
                peers.addAll(peerList.getDeviceList());

                deviceNameArray = new String[peerList.getDeviceList().size()];
                deviceArray = new WifiP2pDevice[peerList.getDeviceList().size()];
                int index = 0;

                for (WifiP2pDevice device : peerList.getDeviceList()) {
                    deviceNameArray[index] = device.deviceName;
                    deviceArray[index] = device;
                    index++;
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, deviceNameArray);
                listView.setAdapter(adapter);
            }

            if (peers.size() == 0) {
                Toast.makeText(ShareActivity.this, "No devices located!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public WifiP2pManager.ConnectionInfoListener connectionInfoListener = new WifiP2pManager.ConnectionInfoListener()
    {
        @Override
        public void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo)
        {
            String connectionType = "Unrecognized";

            if (wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner) {
                connectionType = "Host";

                ShareActivity.server = new Server(handler);
                ShareActivity.server.start();
            } else if (wifiP2pInfo.groupFormed) {
                connectionType = "Client";

                ShareActivity.client = new Client(wifiP2pInfo.groupOwnerAddress, handler);
                ShareActivity.client.start();
            }

            ShareActivity.currentConnectionType = connectionType;

            Toast.makeText(getApplicationContext(), connectionType, Toast.LENGTH_SHORT ).show();
        }
    };

    public Handler handler = new Handler(msg -> {
        switch (msg.what) {
            case IOStream.MESSAGE_READ:
                byte[] readBuff = (byte[]) msg.obj;

                Log.v("img,", "" + readBuff.length);

                imageViewColega = findViewById(R.id.verImagemColega);

                Display display = getWindowManager().getDefaultDisplay();

                Point size = new Point();
                display.getSize(size);

                imageViewColega.setMinimumHeight(size.y / 2);
                imageViewColega.setMinimumWidth(size.x / 2);

                imageViewColega.setImageBitmap(Base64.decodeBase64(readBuff));
                break;

            case IOStream.MESSAGE_WRITE: break;
        }

        return true;
    });
}
