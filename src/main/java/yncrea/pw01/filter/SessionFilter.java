package yncrea.pw01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(urlPatterns = "/*")
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (Arrays.asList("/login","/index.jsp").contains(req.getServletPath()) ||
                req.getSession().getAttribute("loggedPharmacist") !=null)
        {
            filterChain.doFilter(req,servletResponse);
        }
        else if (req.getSession().getAttribute("loggedPharmacist") == null)
        {
            resp.sendRedirect(req.getServletContext().getContextPath()+"/");
        }
    }

    @Override
    public void destroy() {

    }
}
