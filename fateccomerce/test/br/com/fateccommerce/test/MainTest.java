/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccommerce.test;

import java.sql.Connection;

import br.com.fateccommerce.util.ConnectionFactory;

/**
 *
 * @author joou
 */
public class MainTest {

	public static void main(String[] args) {
//        Category oCategory = new Category();;
//        oCategory.setIdCategory(1);
//        oCategory.setNameCategory("Carne");
//        oCategory.setDescriptionCategory("Coisa maravilhosa de comer, se mal passada");
//
//        System.out.println("Categoria.\nId: " + oCategory.getIdCategory() + "\nNome da "
//                + "categoria: " + oCategory.getNameCategory() + "\nDescrição: " + oCategory.getDescriptionCategory());
//
//        Brand oBrand = new Brand();
//        oBrand.setIdBrand(1);
//        oBrand.setNameBrand("Friboi");
//        oBrand.setDescriptionBrand("Carnes bovinas.");
//
//        System.out.println("Marca.\nId: " + oBrand.getIdBrand() + "\nNome da "
//                + "marca: " + oBrand.getNameBrand() + "\nDescrição: " + oBrand.getDescriptionBrand());
//
//        Product oProduct = new Product();
//        oProduct.setIdProduct(1);
//        oProduct.setNameProduct("Picanha por KG");
//        oProduct.setDescriptionProduct("Melhor corte");
//        oProduct.setCostPriceProduct(45.50);
//        oProduct.setSalePriceProduct(49.99);
//        oProduct.setBrand(oBrand);
//        oProduct.setCategory(oCategory);
//
//        System.out.println("Produto.\nId: " + oProduct.getIdProduct() + "\nNome do "
//                + "produto: " + oProduct.getNameProduct() + "\nDescrição: " + oProduct.getDescriptionProduct()
//                + "\nValor de custo: " + +oProduct.getCostPriceProduct() + "\nValor de venda: "
//                + +oProduct.getSalePriceProduct() + "\nNome da marca: " + oProduct.getBrand().getNameBrand()
//                + "\nNome da categoria: " + oProduct.getCategory().getNameCategory());

		Connection conn = null;

		try {
			conn = ConnectionFactory.getConnection();
			System.out.println("Conectado com sucesso");
		} catch (Exception ex) {
			System.out.println("Deu ruim");
			ex.printStackTrace();
		}
	}
}
