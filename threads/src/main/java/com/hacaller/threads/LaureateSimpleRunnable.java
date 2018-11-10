package com.hacaller.threads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.hacaller.business.LaureateCaseConsumer;
import com.hacaller.business.LaureateCasePicker;
import com.hacaller.business.LaureateException;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateSimpleRunnable extends LaureateRunnableFactory {

    Handler uiHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            processLaureateCaseResultOnUI(msg.obj);
        }
    };

    LaureateCaseListener listener;

    public LaureateSimpleRunnable(LaureateCasePicker casePicker, LaureateCaseListener listener) {
        super(casePicker);
        this.listener = listener;
    }

    void sendMessageToUI(Object o){
        Message m =  uiHandler.obtainMessage(casePicker.getLaureateCase().ordinal(), o);
        m.sendToTarget();
    }


    void processLaureateCaseResultOnUI(Object o){
        listener.onTaskCompleted(o);
    }

    @Override
    public void processLaureateCaseResult(Object o) {
        sendMessageToUI(o);
    }

}
