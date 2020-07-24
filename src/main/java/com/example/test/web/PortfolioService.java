package com.example.test.web;


import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class PortfolioService {

    public PortfolioResponseDTO getPortfolio(String id) {
        int n = ThreadLocalRandom.current().nextInt(0,2);
        switch (n) {
            case 1:
                return new PortfolioResponseDTO();
            default:
                return null;
        }
    }
}

