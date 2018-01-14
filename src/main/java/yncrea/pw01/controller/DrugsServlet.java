package yncrea.pw01.controller;

import yncrea.pw01.model.Drug;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/drugs")
public class DrugsServlet extends HttpServlet {

    private List<Drug> drugs;


    @Override
    public void init() throws ServletException {
        drugs = new ArrayList<>();
        drugs.add(new Drug("Drug1","Lab1"));
        drugs.add(new Drug("Drug2","Lab2"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lab = req.getParameter("lab");
        drugs.add(new Drug(name,lab));
        resp.sendRedirect(req.getServletContext().getContextPath()+"/drugs") ;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("drugs",drugs);
        req.getRequestDispatcher("DrugsList.jsp").forward(req,resp);
    }
}
