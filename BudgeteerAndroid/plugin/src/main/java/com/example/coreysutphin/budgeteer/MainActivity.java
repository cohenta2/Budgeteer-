package com.example.coreysutphin.budgeteer;

import com.unity3d.player.UnityPlayerActivity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Intermediate class to grab the intent used to launch VR and get the username from it
 */

public class MainActivity extends UnityPlayerActivity {

    //public static String userKey = "username";
    private static String username;

    public static String getMessage()
    {
        return "Plugin Reachable";
    }

    @Override
    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        Intent intent = getIntent();

        username = intent.getStringExtra("username");


    }

    public static String getUsername() {
        return username;
    }

}
