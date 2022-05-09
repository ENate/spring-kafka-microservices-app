package com.minejava.inventoryservice.service;

import java.util.List;

import com.minejava.inventoryservice.dto.InventoryResponse;
import com.minejava.inventoryservice.repository.InventoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    // call interface
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
        .map(inventory -> 
            InventoryResponse.builder()
            .skuCode(inventory.getSkuCode())
            .isInStock(inventory.getQuantity() > 0)
            .build()
        ).toList();
    }
    
}
