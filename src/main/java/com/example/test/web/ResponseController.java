package com.example.test.web;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class ResponseController {

    private final PortfolioService portfolioService;

    @GetMapping("/product/{productSystemUserId}")
    public ResponseEntity<List<Product>> packageType(@NonNull @PathVariable(value = "productSystemUserId") String productSystemUserId)  {
        List<Product> productsList = new ArrayList<>();
        PortfolioResponseDTO portfolioResponseDTO = portfolioService.getPortfolio(productSystemUserId);
        if (portfolioResponseDTO == null) {
            log.info("!!! Portfolio not found !!!");
            return ResponseEntity.notFound().header("Error","Получение типа пакета предложения ну удалось, продукт отсутсвует").build();
        }
        // here might be NPE if portfolioResponseDTO is null
        log.info(portfolioResponseDTO.getPackages().toString());
        if(portfolioResponseDTO.getPackages().containsKey("PRIVILEGE2")){
            productsList.add(new Product("Card1"));
            productsList.add(new Product("Card2"));
        } else {
            productsList.add(new Product("Card1"));
        }
        return ResponseEntity.ok(productsList);
    }
}
