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
    public ResponseEntity<List<Product>> packageType(@NonNull @RequestParam(value = "productSystemUserId", required = true) String productSystemUserId) throws CustomException {
        List<Product> productsList = new ArrayList<>();
        PortfolioResponseDTO portfolioResponseDTO = portfolioService.getPortfolio(productSystemUserId);
        log.info(portfolioResponseDTO.getPackages().toString());
        if(portfolioResponseDTO.getPackages().containsKey("PRIVILEGE2")){
            productsList.add(new Product("Card1"));
            productsList.add(new Product("Card2"));
        }else if(portfolioResponseDTO != null){
            productsList.add(new Product("Card1"));
        }else if(portfolioResponseDTO == null) {
            throw new CustomException(404,"Получение типа пакета предложения ну удалось, продукт отсутсвует");
        }else{
            throw new CustomException(500,"Внутренняя ошибка сервера");
        }
        return ResponseEntity.ok(productsList);
    }
}
