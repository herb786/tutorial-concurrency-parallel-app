package com.hacaller.threads;

import com.hacaller.business.LaureateCaseConsumer;
import com.hacaller.business.LaureateCasePicker;
import com.hacaller.business.LaureateException;

/**
 * Created by Herbert Caller on 10/11/2018.
 */
public abstract class LaureateRunnableFactory implements Runnable, LaureateCaseConsumer {

    LaureateCasePicker casePicker;

    public LaureateRunnableFactory() {
    }

    public LaureateRunnableFactory(LaureateCasePicker casePicker) {
        this.casePicker = casePicker;
        this.casePicker.setConsumer(this);
    }

    @Override
    public void run() {
        try {
            casePicker.apply();
        } catch (LaureateException e) {
            e.printStackTrace();
        }
    }

}
