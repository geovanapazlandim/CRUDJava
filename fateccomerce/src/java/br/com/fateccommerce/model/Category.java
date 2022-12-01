/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccommerce.model;

/**
 *
 * @author joou
 */
public class Category {

    private Integer idCategory;
    private String nameCategory;
    private String descriptionCategory;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        if ((idCategory) > 0) {
            this.idCategory = idCategory;
        } else {
            System.out.println("O ID não pode ser nulo.");
        }
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }
}
