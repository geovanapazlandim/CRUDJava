/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fateccommerce.controller;

import br.com.fateccommerce.DAO.BrandDAOImpl;
import br.com.fateccommerce.DAO.GenericDAO;
import br.com.fateccommerce.model.Brand;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "SaveBrand", urlPatterns = {"/SaveBrand"})
public class SaveBrand extends HttpServlet {

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
        response.setContentType("text/html;charset=ISO-8859-1");
        String message = null;
        String method = null;
        Brand brand = new Brand();
        brand.setNameBrand(request.getParameter("namebrand"));
        brand.setDescriptionBrand(request.getParameter("descriptionbrand"));
        if (request.getParameter("idbrand").isEmpty()) {
            method = "save";
        } else {
            brand.setIdBrand(Integer.parseInt(request.getParameter("idbrand")));
        }

        try {
            GenericDAO dao = new BrandDAOImpl();
            if (method == "save") {
                if (dao.save(brand)) {
                    message = "Marca cadastrada com sucesso!";
                } else {
                    message = "Problemas ao cadastrar Marca!";
                }
            } else {
                if (dao.update(brand)) {
                    message = "Marca alterada com sucesso!";
                } else {
                    message = "Problemas ao alterar Marca!";
                }
            }

        } catch (Exception ex) {
            System.out.println(message + "Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            request.setAttribute("response", message);
            request.getRequestDispatcher("ListBrand").forward(request, response);
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
