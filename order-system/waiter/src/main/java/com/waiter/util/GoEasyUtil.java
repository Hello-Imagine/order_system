package com.waiter.util;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

public class GoEasyUtil {

    public static void publish(String channel, String contentJson) {
        GoEasy goEasy = new GoEasy("rest-hangzhou.goeasy.io",
                "BC-39a32d080309433cad62d463a4eea5a0");
        goEasy.publish(channel, contentJson, new PublishListener() {
            @Override
            public void onSuccess() {
                System.out.println("publish success");
            }

            @Override
            public void onFailed(GoEasyError error) {
                super.onFailed(error);
            }
        });
    }

}
