package com.qirsam.http.servlet;

import com.qirsam.http.entity.Ticket;
import com.qirsam.http.service.TicketService;
import com.qirsam.http.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static com.qirsam.http.utils.UrlPath.TICKETS;

@WebServlet(TICKETS)
public class TicketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var flightId = Integer.valueOf(req.getParameter("flightId"));
        req.setAttribute("tickets", ticketService.findAllByFlightId(flightId));

        req.getRequestDispatcher(JspHelper.get("tickets"))
                .forward(req, resp);

//        resp.setContentType("text/html");     //перевел на jstl
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        try (var writer = resp.getWriter()) {
//            writer.write("<h1>Купленные билеты</h1>");
//            writer.write("<ul>");
//            ticketService.findAllByFlightId(flightId).forEach(ticketDto -> writer.write("""
//                    <li>
//                        %s
//                    </li>
//                    """.formatted(ticketDto.getSeatNo())));
//            writer.write("</ul>");
//        }
    }
}
