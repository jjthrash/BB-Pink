package com.jimmythrasher.bbpink;

import java.io.IOException;

import javax.microedition.media.Player;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.component.ButtonField;

class Main extends net.rim.device.api.ui.UiApplication {
    public Main() {
        playing = false;

        MainScreen mainScreen = new MainScreen();
        mainScreen.setTitle("PINK!");
        ButtonField button = new ButtonField("Go");
        button.setChangeListener(new FieldChangeListener() {
            public void fieldChanged(Field field, int context) {
                if (playing)
                    stop();
                else
                    play();

                playing = !playing;
            }
        });

        pushScreen(mainScreen);
    }

    protected void stop() {
        try {
            if (player != null)
                player.stop();
         } catch (Throwable pe) {
         }
    }

    protected void play() {
        try {
            player = Manager.createPlayer("file:///"); //TODO embedded MP3 resource
            player.setLoopCount(-1);
            player.start();
        } catch (Throwable pe) {
        }

    }

    private boolean playing;
    private Player  player;

    public static void main(String[] args) {
        Main instance = new Main();
        instance.enterEventDispatcher();
    }
}
