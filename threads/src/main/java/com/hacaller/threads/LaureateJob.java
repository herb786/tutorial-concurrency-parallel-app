package com.hacaller.threads;

import com.hacaller.business.LaureateQuery;

/**
 * Created by Herbert Caller on 10/11/2018.
 */
public class LaureateJob {

    LaureateQuery query;
    LaureateCaseListener listener;

    public LaureateJob(LaureateQuery query, LaureateCaseListener listener) {
        this.query = query;
        this.listener = listener;
    }

    public LaureateQuery getLaureateQuery() {
        return query;
    }

    public LaureateCaseListener getListener() {
        return listener;
    }
}
