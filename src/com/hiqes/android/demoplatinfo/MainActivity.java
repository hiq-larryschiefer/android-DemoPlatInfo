package com.hiqes.android.demoplatinfo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.hiqes.android.utility_library.PlatformInfo;

public class MainActivity extends Activity {
    private static final String LOG_TAG = "HiQES Platform Info Demo";
    private TextView mPidText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPidText = (TextView)findViewById(R.id.pid_text);
    }

    @Override
    protected void onStart() {
        String pidStr = "UNAVAILABLE";

        super.onStart();
        try {
            //Class<?> cls = Class.forName("com.hiqes.android.utility_library.PlatformInfo");
            PlatformInfo pi = new PlatformInfo();
            int pid = pi.getSystemServerPid();
            pidStr = Integer.toString(pid);
        } catch (Throwable e) {
            String errStr = "HiQES PlatformInfo library not available: " + e.toString(); 
            Log.e(LOG_TAG, errStr);
            Toast.makeText(this, errStr, Toast.LENGTH_SHORT).show();
        }

        Log.d(LOG_TAG, "SystemServer PID is " + pidStr);
        mPidText.setText(pidStr);
    }
}
