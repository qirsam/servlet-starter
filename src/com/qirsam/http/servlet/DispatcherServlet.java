package com.qirsam.http.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static com.qirsam.http.utils.UrlPath.DISPATCHER;

@WebServlet(DISPATCHER)
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("flights") //include/forward check
//                .include(req, resp);
//        var writer = resp.getWriter();
//
//        resp.setContentType("text/html");
////        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        writer.write("forwarded requests ");
//        System.out.println();
        resp.sendRedirect("/flights");
    }
}
