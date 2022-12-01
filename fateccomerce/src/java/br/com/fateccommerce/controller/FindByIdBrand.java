/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.fateccommerce.controller;

import br.com.fateccommerce.DAO.BrandDAOImpl;
import br.com.fateccommerce.DAO.GenericDAO;
import br.com.fateccommerce.model.Brand;
import java.io.IOException;
import java.io.PrintWriter;
import javax.script.ScriptEngine;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "FindByIdBrand", urlPatterns = {"/FindByIdBrand"})
public class FindByIdBrand extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-88591");
        Integer idBrand = Integer.parseInt(request.getParameter("idBrand"));
        try {
            GenericDAO dao = new BrandDAOImpl();
            Brand oBrand = (Brand) dao.findById(idBrand);
            if (oBrand.getIdBrand() == idBrand) {
                request.setAttribute("brand", oBrand);
                request.getRequestDispatcher("brand/save.jsp").forward(request, response);
            } else {
                request.setAttribute("response", "Marca não encontrada.");
                request.getRequestDispatcher("brand/save.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Marca! Erro:" + ex.getMessage());
            ex.printStackTrace();
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
