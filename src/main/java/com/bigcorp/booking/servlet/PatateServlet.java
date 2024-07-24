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


import com.bigcorp.booking.pojo.PatatePojo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Autre exemple de Servlet, utilisant un paramètre de requête
 */
@WebServlet("/patate")
public class PatateServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {
            HttpSession session = request.getSession();
            ServletContext servletContext = request.getServletContext();
            PatatePojo patatePojo = (PatatePojo) servletContext.getAttribute("patatePojo");

            if (patatePojo == null){
                patatePojo = new PatatePojo(new String[] {
                        "Bintje", "Amandine", "Agata", "Belle de Fontenay",
                        "Charlotte", "Ratte", "Vitelotte", "Yukon Gold",
                }[new Random().nextInt(8)], 375);
            } else {
                int masse = patatePojo.getMasse() + (int) (Math.random()*100);
                patatePojo.setMasse(masse);
            }
            servletContext.setAttribute("patatePojo", patatePojo);

            response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
            out.println("<html>"
                    + "<head><title>LA ZONE DES PATATES</title><style>@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@400..900&display=swap');.cpt{font-size:100;font-weight:900; font-family: Orbitron;}</style></head>");
            out.println("<body  bgcolor=\"#800339\" style='height:100vh; background: rgb(119,8,26); background: linear-gradient(180deg, rgba(119,8,26,1) 0%, rgba(176,3,40,0.9962184702982756) 35%, rgba(110,6,42,1) 100%); color:#fff3b5; display:flex; flex-direction:column; justify-content:center; align-items: center; margin: 0;'>");

                out.println("<span class='cpt'>" + patatePojo.getVariete() + "</span>");
            out.println("<span class='cpt'>" + patatePojo.getMasse() + "</span>");
                out.println("</body>");
                out.println("</html>");
            }
    }

    @Override
    public String getServletInfo() {
        return "La serviette Patate vous dit bonjour.";

    }
}
