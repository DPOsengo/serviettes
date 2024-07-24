/*
 * Copyright (c) 2014, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.bigcorp.booking.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Autre exemple de Servlet, utilisant un paramètre de requête
 */
@WebServlet("/bienvenue")
public class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
                out.println("<html>"
                        + "<head><title>Booking</title></head>");
                out.println("<body  bgcolor=\"#800339\" style=' background: rgb(119,8,26); background: linear-gradient(180deg, rgba(119,8,26,1) 0%, rgba(176,3,40,0.9962184702982756) 35%, rgba(110,6,42,1) 100%); color:#fff3b5; display:flex; flex-direction:column; justify-content:center; align-items: center; margin: 0;'>");
                out.println("<h2 style='font-weight:700; font-size:90; text-transform:uppercase;'>Salut, " + username + "!</h2>");
                out.println("<h3 style='text-align: center;'>Request Headers</h3>");
                out.println("<table border='1' style='border-color: #f2eedf; width: 50%; margin: 0 auto; margin-bottom: 10rem; border-collapse: collapse; color: #fff3b5;'>");
                out.println("<tr><th style='padding: 8px; background-color: #333;'>Header Name</th><th style='padding: 8px; background-color: #333;'>Header Value</th></tr>");

                Enumeration<String> headerNames = request.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String headerName = headerNames.nextElement();
                    String headerValue = request.getHeader(headerName);
                    out.println("<tr><td style='padding: 8px;'>" + headerName + "</td><td style='padding: 8px;'>" + headerValue + "</td></tr>");
                }

                out.println("</body></html>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "La serviette de bienvenue vous dit bonjour.";

    }
}
