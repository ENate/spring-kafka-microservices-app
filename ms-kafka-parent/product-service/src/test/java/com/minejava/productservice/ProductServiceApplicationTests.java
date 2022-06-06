package com.minejava.productservice;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minejava.productservice.dto.ProductRequest;
import com.minejava.productservice.repository.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	// Provide mongodb docker version in deprecated object definition
	// Add container to tell db this is a db. Add static
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
	// Auto wire mock to use: auto configure mock mvc:
	@Autowired
	private MockMvc mockMvc;
	// Define static method to initialize on start up, add dynamic source
	// define Object mapper to ocnvert object requested to POJO and vice versa
	@Autowired
	private ObjectMapper objectMapper;
	// Save prduct and check size
	@Autowired
	private ProductRepository productRepository;

	/** 
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynPropertyRegistry){
		dynPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	*/
	
	@DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
  }

	// Create mock servlet environment to call our controller
	@Test
	void shouldCreateProduct() throws Exception {
		// create method to define product req obj?
		ProductRequest productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(productRequestString))
			   .andExpect(status().isCreated());
		Assertions.assertEquals(1, productRepository.findAll().size());
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
		                     .name("Iphone_13")
							 .description("Iphone_X13")
							 .price(BigDecimal.valueOf(1200))
							 .build();
	}

}
