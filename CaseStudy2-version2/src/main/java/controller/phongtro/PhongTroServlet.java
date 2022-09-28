package controller.phongtro;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.*;
import model.phongtro.PhongTro;
import model.phongtro.ThanhToan;
import model.product.Category;
import model.product.Product;
import service.phongtro.IPhongTroService;
import service.phongtro.IThanhToanService;
import service.phongtro.Impl.PhongTroServiceImpl;
import service.phongtro.Impl.ThanhToanServiceImpl;
import service.product.CategoryServiceImpl;
import service.product.ICategoryService;
import service.product.IProductService;
import service.product.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PhongTroServlet", value = "/phongtro")
public class PhongTroServlet extends HttpServlet {

    static List<PhongTro> phongTroList = new ArrayList<>();
    static IPhongTroService phongTroService = new PhongTroServiceImpl();
    static IThanhToanService thanhToanService = new ThanhToanServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                try {
                    deleteDanhSach(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                findByName(request, response);
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
                updateDanhsach(request, response);
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
        List<PhongTro> phongTroList = phongTroService.findAll();
        request.setAttribute("phongTroList", phongTroList);
        List<ThanhToan> thanhToanList = thanhToanService.findAll();
        request.setAttribute("thanhToanList", thanhToanList);
        try {
            request.getRequestDispatcher("phongtro/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThanhToan> thanhToanList = thanhToanService.findAll();
        request.setAttribute("thanhToanList", thanhToanList);
        String rentSearch = request.getParameter("rentSearch");
        String nameSearchS = request.getParameter("nameSearch");
        String phoneSearch = request.getParameter("phoneSearch");
        phongTroList = phongTroService.findByName(rentSearch, nameSearchS, phoneSearch);
        request.setAttribute("phongTroList", phongTroList);
        request.getRequestDispatcher("phongtro/list.jsp").forward(request, response);

    }

    private void deleteDanhSach(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        phongTroService.delete(id);
        List<PhongTro> phongTroList = phongTroService.findAll();
        request.setAttribute("phongTroList", phongTroList);
        List<ThanhToan> thanhToanList = thanhToanService.findAll();
        request.setAttribute("thanhToanList", thanhToanList);

        request.getRequestDispatcher("phongtro/list.jsp").forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        List<ThanhToan> thanhToanList = thanhToanService.findAll();
        request.setAttribute("thanhToanList", thanhToanList);

        PhongTro phongTro = phongTroService.findById(id);
        request.setAttribute("phongTro", phongTro);
        request.getRequestDispatcher("phongtro/edit.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThanhToan> thanhToanList = thanhToanService.findAll();
        request.setAttribute("thanhToanList", thanhToanList);

        List<PhongTro> phongTroList = phongTroService.findAll();
        request.setAttribute("phongTroList", phongTroList);
        request.getRequestDispatcher("phongtro/create.jsp").forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        phongTroService.delete(id);
        response.sendRedirect("/phongtro");
    }

    private void updateDanhsach(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String idRent = (request.getParameter("idRent"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String startDate = (request.getParameter("startDate"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        String note = request.getParameter("note");
        PhongTro phongTro = new PhongTro(id,idRent, name, phone, startDate, payment, note);
        phongTroService.edit(phongTro);
        response.sendRedirect("/phongtro");
    }

    private void saveDanhSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRent = (request.getParameter("idRent"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String startDate = (request.getParameter("startDate"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        String note = request.getParameter("note");
        PhongTro phongTro = new PhongTro(idRent, name, phone, startDate, payment, note);

//        phongTroService.create(phongTro);
//        response.sendRedirect("/phongtro");
        List<ThanhToan> thanhToanList = thanhToanService.findAll();
        request.setAttribute("thanhToanList", thanhToanList);
        Map<String,String> mapValidate = phongTroService.create(phongTro);
        if (mapValidate.isEmpty()){
            List<PhongTro> phongTroList = phongTroService.findAll();
            request.setAttribute("phongTroList", phongTroList);
            request.setAttribute("mess","them moi thanh cong");
            request.getRequestDispatcher("phongtro/list.jsp").forward(request,response);
        }else {
            request.setAttribute("mess","them moi that bai");
            request.setAttribute("mapValidate",mapValidate);
            request.getRequestDispatcher("phongtro/create.jsp").forward(request,response);
        }

    }
}
