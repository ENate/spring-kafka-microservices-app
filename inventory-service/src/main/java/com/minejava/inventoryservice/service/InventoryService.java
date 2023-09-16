package com.minejava.inventoryservice.service;

import java.util.List;

import com.minejava.inventoryservice.dto.InventoryResponse;
import com.minejava.inventoryservice.repository.InventoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    // call interface
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows // Not for production!!
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Wait Started....");
        // Simulate slow behaviour
        // Thread.sleep(10000);
        log.info("Wait Ended");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
        .map(inventory -> 
            InventoryResponse.builder()
            .skuCode(inventory.getSkuCode())
            .isInStock(inventory.getQuantity() > 0)
            .build()
        ).toList();
    }
    
}
