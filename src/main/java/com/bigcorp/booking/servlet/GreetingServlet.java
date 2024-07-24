package com.bigcorp.booking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Une Servlet JEE
 */
@WebServlet("/welcome")
public class GreetingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Traite les requêtes GET /welcome 
	 */
	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>Booking</title></head>");
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>Welcome to the booking app servlet page !!!</h2>");
            
            String username = request.getParameter("username");
            // Integer compteur = (Integer)
            if (username != null && username.length() > 0) {
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher("/response");
                
                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            out.println("</body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "The Hello servlet says hello.";

    }
}
