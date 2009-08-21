package com.jimmythrasher.bbpink;

import javax.microedition.media;

import net.rim.device.api.ui.component;

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
    }

    protected void stop() {
        try {
            if (player != null)
                player.stop();
         } catch (MediaException pe) {
         } catch (IOException ioe) {
         }
    }

    protected void play() {
        try {
            player = Manager.createPlayer("http://abc.wav"); //TODO embedded MP3 resource
            player.setLoopCount(-1);
            player.start();
        } catch (MediaException pe) {
        } catch (IOException ioe) {
        }

    }

    private boolean playing;
    private Player  player;

    public static void main(String[] args) {
        Main instance = new Main();
        instance.enterEventDispatcher();
    }
}
