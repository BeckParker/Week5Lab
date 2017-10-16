/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 679810
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action == null) {
            if (session.getAttribute("username") != null) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        } else {
            if (action.equals("logout")) {
                session.invalidate();
                response.sendRedirect("ShoppingList");
            }
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action != null) {
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
            if (action.equals("register")) {
                String name = request.getParameter("name");
                session.setAttribute("username", name);
            } else if (action.equals("add")) {
                String item = request.getParameter("item");
                if (list != null) {
                    list.add(item);
                } else {
                    list = new ArrayList<String>();
                    list.add(item);
                }
                session.setAttribute("list", list);
            } else if (action.equals("delete")) {
                String selected = request.getParameter("selected");
                if (selected != null) {
                    list.remove(Integer.parseInt(selected));
                    session.setAttribute("list", list);
                }
            }
        }
        response.sendRedirect("ShoppingList");
    }
    
}
