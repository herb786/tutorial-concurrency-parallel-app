package com.hacaller.services;

import com.hacaller.business.Laureate;

import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateServiceImplTest {

    LaureateServiceImpl laureateService;

    @Before
    public void setup() {
        laureateService = new LaureateServiceImpl();
    }

    @Test
    public void fetchLaureatesTest() {
        System.out.print("Testing car endpoint...");
        List<Laureate> list = laureateService.fetchLaureates();
        System.out.print(list.get(0).getName());
        assert(!list.isEmpty());
    }


}