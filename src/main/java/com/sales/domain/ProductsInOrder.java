package com.sales.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * Created by starnakin on 09.04.2016.
 */
@Entity
@Table(name = "products_in_order")
public class ProductsInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price_on_sell_moment")
    private Double priceOnSellMoment;

    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    public ProductsInOrder(){

    }

    public ProductsInOrder(Order order, Product product, Long quantity){
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.priceOnSellMoment = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPriceOnSellMoment() {
        return priceOnSellMoment;
    }

    public void setPriceOnSellMoment(Double priceOnSellMoment) {
        this.priceOnSellMoment = priceOnSellMoment;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ProductsInOrder that = (ProductsInOrder) o;

        return new EqualsBuilder().append(id, that.id).append(product, that.product)
                .append(priceOnSellMoment, that.priceOnSellMoment).append(quantity, that.quantity)
                .append(order, that.order).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(product).append(priceOnSellMoment).append(quantity)
                .append(order).toHashCode();
    }
}
