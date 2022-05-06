package com.minejava.inventoryservice;

import com.minejava.inventoryservice.model.Inventory;
import com.minejava.inventoryservice.repository.InventoryRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	// bean to load data at initial runtime
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("skuCode_BH66");
			inventory1.setQuantity(122);

			// Another object
			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("skuCode_XXX");
			inventory2.setQuantity(10);


			// Save them in a db!
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
		
	}

}
