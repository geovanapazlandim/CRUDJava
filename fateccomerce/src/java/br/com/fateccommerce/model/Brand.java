/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccommerce.model;

/**
 *
 * @author joou
 */
public class Brand {

    private Integer idBrand;
    private String nameBrand;
    private String descriptionBrand;

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        if ((idBrand) > 0 && (idBrand) < 11) {
            this.idBrand = idBrand;
        } else {
            System.out.println("O ID deve ser entre 1 e 10.");
        }
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        if (nameBrand.trim().length() > 1) {
            this.nameBrand = nameBrand;
        } else {
            System.out.println("O nome deve ter mais que 1 caractere");
        }
    }

    public String getDescriptionBrand() {
        return descriptionBrand;
    }

    public void setDescriptionBrand(String descriptionBrand) {
        this.descriptionBrand = descriptionBrand;
    }
}
