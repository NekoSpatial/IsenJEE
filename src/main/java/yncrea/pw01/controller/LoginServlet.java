package yncrea.pw01.controller;


import yncrea.pw01.model.Drug;
import yncrea.pw01.model.Pharmacist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private List<Pharmacist> pharmacists;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getQueryString();
        if ("logout".equals(queryString)){
            req.getSession().removeAttribute("loggedPharmacist");
            resp.sendRedirect(req.getServletContext().getContextPath()+"/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Pharmacist pharmacistToLog = new Pharmacist(login , password);
        if (pharmacists.contains(pharmacistToLog))
        {
            req.removeAttribute("loginError");
            req.getSession().setAttribute("loggedPharmacist",pharmacistToLog);
            resp.sendRedirect(req.getServletContext().getContextPath()+"/drugs") ;
        }
        else
        {
            req.setAttribute("loginError","Invalid credentials!");
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        }

    }

    @Override
    public void init() throws ServletException {
        pharmacists = new ArrayList<>();
        pharmacists.add(new Pharmacist("pharm1","password1"));
        pharmacists.add(new Pharmacist("pharm2","password2"));
    }
}
