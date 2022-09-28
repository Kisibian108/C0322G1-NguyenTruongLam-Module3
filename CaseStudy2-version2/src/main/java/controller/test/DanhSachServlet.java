package controller.test;

import model.facility.Facility;
import model.facility.FacilityType;
import model.facility.RentType;
import model.test.BenhAn;
import model.test.BenhNhan;
import model.test.DanhSachBenhNhan;
import service.test.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DanhSachServlet", value = "/test")
public class DanhSachServlet extends HttpServlet {

    static List<DanhSachBenhNhan> danhSachBenhNhanList = new ArrayList<>();
    static List<BenhAn> benhAnList = new ArrayList<>();
    static List<BenhNhan> benhNhanList = new ArrayList<>();
    static IDanhSachService danhSachService = new DanhSachServiceImpl();
    static IBenhAnService benhAnService = new BenhAnServiceImple();
    static IBenhNhanService benhNhanService = new BenhNhanServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                try {
                    deleteDanhSach(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                findByName(request,response);
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
            case "create":
                saveDanhSach(request, response);
                break;
            case "edit":
                updateDanhsacj(request, response);
                break;
            case "delete":
                try {
                    showFormDelete(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<DanhSachBenhNhan> danhSachBenhNhanList = danhSachService.findAll();
        request.setAttribute("danhSachBenhNhanList", danhSachBenhNhanList);
        List<BenhAn> benhAnList = benhAnService.findAll();
        request.setAttribute("benhAnList", benhAnList);
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", benhNhanList);
        try {
            request.getRequestDispatcher("test/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteDanhSach(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        danhSachService.delete(id);
        List<DanhSachBenhNhan> danhSachBenhNhanList = danhSachService.findAll();
        request.setAttribute("danhSachBenhNhanList", danhSachBenhNhanList);
        List<BenhAn> benhAnList = benhAnService.findAll();
        request.setAttribute("benhAnList", benhAnList);
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", benhNhanList);
        request.getRequestDispatcher("test/list.jsp").forward(request,response);

    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<BenhAn> benhAnList = benhAnService.findAll();
        request.setAttribute("benhAnList", benhAnList);
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", benhNhanList);
        DanhSachBenhNhan danhSachBenhNhan = danhSachService.findById(id);
        request.setAttribute("danhSachBenhNhan",danhSachBenhNhan);
        request.getRequestDispatcher("test/edit.jsp").forward(request,response);

//        int id = Integer.parseInt(request.getParameter("id"));
//        List<FacilityType> facilityTypes = facilityTypeService.findAll();
//        request.setAttribute("facilityTypeList", facilityTypes);
//        List<RentType> rentTypes = rentTypeService.findAll();
//        request.setAttribute("rentTypeList", rentTypes);
//        Facility facility = facilityService.findById(id);
//        request.setAttribute("facility", facility);
//        request.getRequestDispatcher("facility/edit.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BenhAn> benhAnList = benhAnService.findAll();
        request.setAttribute("benhAnList", benhAnList);
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", benhNhanList);
        request.getRequestDispatcher("test/create.jsp").forward(request, response);

    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        danhSachService.delete(id);
        response.sendRedirect("/test");
    }

    private void updateDanhsacj(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int benhan = Integer.parseInt(request.getParameter("benhan"));
        int benhnhan = Integer.parseInt(request.getParameter("benhnhan"));
        String name = request.getParameter("name");
        String enter = request.getParameter("enter");
        String outer = request.getParameter("outer");
        String reason = request.getParameter("reason");

        DanhSachBenhNhan danhSachBenhNhan = new DanhSachBenhNhan(id, benhan, benhnhan, name, enter, outer, reason);
        danhSachService.edit(danhSachBenhNhan);
        response.sendRedirect("/test");
    }

    private void saveDanhSach(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int benhan = Integer.parseInt(request.getParameter("benhan"));
        int benhnhan = Integer.parseInt(request.getParameter("benhnhan"));
        String name = (request.getParameter("name"));
        String enter = (request.getParameter("enter"));
        String outer = (request.getParameter("outer"));
        String reason = (request.getParameter("reason"));

        DanhSachBenhNhan danhSachBenhNhan = new DanhSachBenhNhan(id, benhan, benhnhan, name, enter, outer, reason);
        danhSachService.create(danhSachBenhNhan);
        response.sendRedirect("/test");

    }
}
