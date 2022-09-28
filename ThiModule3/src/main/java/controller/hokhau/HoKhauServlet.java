package controller.hokhau;

import model.hokhau.GiaDinh;
import model.hokhau.HoKhau;
import service.hokhau.IGiaDinhService;
import service.hokhau.IHoKhauService;
import service.hokhau.Impl.GiaDinhServiceImpl;
import service.hokhau.Impl.HoKhauServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HoKhauServlet", value = "/hokhau")
public class HoKhauServlet extends HttpServlet {
    static List<HoKhau> hoKhauList = new ArrayList<>();
    static IHoKhauService hoKhauService = new HoKhauServiceImpl();
    static IGiaDinhService giaDinhService = new GiaDinhServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                updateDanhsach(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<HoKhau> hoKhauList = hoKhauService.findAll();
        request.setAttribute("hoKhauList", hoKhauList);
        List<GiaDinh> giaDinhList = giaDinhService.findAll();
        request.setAttribute("giaDinhList", giaDinhList);
        try {
            request.getRequestDispatcher("hokhau/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        List<GiaDinh> giaDinhList = giaDinhService.findAll();
        request.setAttribute("giaDinhList", giaDinhList);

        HoKhau hoKhau = hoKhauService.findById(id);
        request.setAttribute("hoKhau", hoKhau);
        request.getRequestDispatcher("hokhau/edit.jsp").forward(request, response);

    }

    private void updateDanhsach(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idHk = Integer.parseInt(request.getParameter("idHk"));
        String name = request.getParameter("name");
        String number = (request.getParameter("number"));
        String startDate = (request.getParameter("date"));
        String address = (request.getParameter("address"));
        HoKhau hoKhau = new HoKhau(id, idHk, name, number, startDate, address);
        hoKhauService.edit(hoKhau);
        response.sendRedirect("/hokhau");
    }
}
