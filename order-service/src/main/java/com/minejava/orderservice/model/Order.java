package com.minejava.orderservice.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    // Define fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItemsList;

}
