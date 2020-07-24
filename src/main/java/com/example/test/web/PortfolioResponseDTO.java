package com.example.test.web;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class PortfolioResponseDTO {

    public Map<String,String> getPackages() {
        int n = ThreadLocalRandom.current().nextInt(2);
        switch (n) {
            case 0:
                return getMap2();
            default:
                return getMap1();
        }
    }

    private Map<String,String> getMap1() {
        Map<String,String> val = new HashMap<>();
        val.put("PRIVILEGE1", "PRIVILEGE");
        return val;
    }

    private Map<String,String> getMap2() {
        Map<String,String> val = new HashMap<>();
        val.put("PRIVILEGE1", "PRIVILEGE");
        val.put("PRIVILEGE2", "NOT");
        return val;
    }
}
