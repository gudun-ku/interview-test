package com.example.test.web;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class ResponseController {

    private final PortfolioService portfolioService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> packageType(@NonNull @RequestParam(value = "productSystemUserId", required = true) String productSystemUserId)  {
        List<Product> productsList = new ArrayList<>();
        PortfolioResponseDTO portfolioResponseDTO = portfolioService.getPortfolio(productSystemUserId);
        if (portfolioResponseDTO == null) {
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
