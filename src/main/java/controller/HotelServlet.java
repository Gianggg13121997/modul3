package controller;

import model.Hotel;
import service.HotelService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "hotelservlet", value = "/hotel")
public class HotelServlet extends HttpServlet {
    private HotelService hotelService = new HotelService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hotel> hotels = hotelService.getAll();
        req.setAttribute("hotels", hotels);
        RequestDispatcher rd = req.getRequestDispatcher("/view/home.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameGuest = req.getParameter("nameGuest");
        String phone = req.getParameter("phone");
        String date = req.getParameter("date");
        int typePayment = Integer.parseInt(req.getParameter("typePayment"));
        String note = req.getParameter("note");

        Hotel hotel = new Hotel(0, nameGuest, phone, date, typePayment, note);
        hotelService.addHotel(hotel);

        resp.sendRedirect(req.getContextPath() + "/hotel");
    }
}

