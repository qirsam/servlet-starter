package com.qirsam.http.servlet;

import com.qirsam.http.dto.FlightDto;
import com.qirsam.http.service.FlightService;
import com.qirsam.http.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.qirsam.http.utils.UrlPath.CONTENT;

@WebServlet(CONTENT)
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var flightDtos = flightService.findAll();
        req.setAttribute("flights", flightDtos);
        req.getSession().setAttribute("flightsMap", flightDtos.stream()
                .collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));
        req.getRequestDispatcher(JspHelper.get("content"))
                .forward(req, resp);
    }
}
