package com.hacaller.threads;

import android.os.Looper;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateCaseThread implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new CustomThread(r);
    }

    class CustomThread extends Thread {

        public CustomThread(Runnable target) {
            super(target);
        }

        @Override
        public synchronized void start() {
            super.start();
            Looper.prepare();
            Looper.loop();
        }


    }
}
