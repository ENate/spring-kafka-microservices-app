package com.minejava.inventoryservice.repository;

import java.util.List;

import com.minejava.inventoryservice.model.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
    
}
