/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccommerce.model;

/**
 *
 * @author joou
 */
public class Product {

    private Integer idProduct;
    private String nameProduct;
    private String descriptionProduct;
    private Double costPriceProduct;
    private Double salePriceProduct;
    private Brand brand;
    private Category category;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        if ((idProduct) > 0 && (idProduct) < 11) {
            this.idProduct = idProduct;
        } else {
            System.out.println("O ID deve ser entre 1 e 10.");
        }
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Double getCostPriceProduct() {
        return costPriceProduct;
    }

    public void setCostPriceProduct(Double costPriceProduct) {
        this.costPriceProduct = costPriceProduct;
    }

    public Double getSalePriceProduct() {
        return salePriceProduct;
    }

    public void setSalePriceProduct(Double salePriceProduct) {
        this.salePriceProduct = salePriceProduct;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
