package javachessgui;

import javafx.application.Platform;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static javachessgui.Javachessgui.*;

public class MyRunnable implements Runnable {

    public String kind;
    public InputStream std_in;
    public OutputStream std_out;
    public String command;
    public Board b;


    public void run() {

        int i = 0;

        String total_buffer = "";
        String buffer = "";

        if (kind.equals("system_message")) {

            try {
                Thread.sleep(timer);
            } catch (InterruptedException ex) {

            }

            Platform.runLater(new Runnable() {

                public void run() {


                    message_text.setStyle("-fx-opacity: 0;" + message_text_style);

                }

            });

            return;

        }

        if (kind.equals("do_deep")) {

            b.game.do_deep();

            return;

        }

        if (kind.equals("update_deep")) {

            b.game.update_deep();

            return;

        }

        if (kind.equals("engine_read")) {

            while (!Thread.currentThread().isInterrupted()) {

                try {

                    char chunk = (char) std_in.read();

                    if (chunk == '\n') {
                        //total_buffer=buffer+"\n"+total_buffer;
                        b.consume_engine_out(buffer);
                        buffer = "";
                    } else {
                        buffer += chunk;
                    }

                } catch (IOException ex) {

                    System.out.println("engine read IO exception");

                }

            }

            return;

        }

    }
}
