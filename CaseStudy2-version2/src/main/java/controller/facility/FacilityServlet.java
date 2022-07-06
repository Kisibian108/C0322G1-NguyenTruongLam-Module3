package controller.facility;

import model.customer.Customer;
import model.customer.CustomerType;
import model.facility.Facility;
import model.facility.FacilityType;
import model.facility.RentType;
import service.facility.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {

    static IFacilityService facilityService = new FacilityServiceImpl();
    static IFacilityTypeService facilityTypeService = new FacilityTypeServiceImpl();
    static IRentTypeService rentTypeService = new RentTypeImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showCreateForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showFormEdit(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteFacility(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    findByName(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            default:
                try {
                    findAll(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
                saveFacility(request, response);
                break;
            case "edit":
                updateFacility(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            default:
                try {
                    findAll(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Facility> facilityList = facilityService.findAll();
        request.setAttribute("facilityList", facilityList);
        List<FacilityType> facilityTypes = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypes);
        List<RentType> rentTypes = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypes);
        request.getRequestDispatcher("facility/list.jsp").forward(request, response);
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Facility> facilityList = new ArrayList<>();
        List<FacilityType> facilityTypes = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypes);
        List<RentType> rentTypes = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypes);
        String nameSearch = request.getParameter("nameSearch");
        facilityList = facilityService.findByName(nameSearch);
        request.setAttribute("facilityList", facilityList);
        request.getRequestDispatcher("facility/list.jsp").forward(request, response);
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        facilityService.delete(id);
        List<Facility> facilityList = facilityService.findAll();
        request.setAttribute("facilityList", facilityList);
        List<FacilityType> facilityTypes = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypes);
        List<RentType> rentTypes = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypes);
        request.getRequestDispatcher("facility/list.jsp").forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<FacilityType> facilityTypes = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypes);
        List<RentType> rentTypes = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypes);
        Facility facility = facilityService.findById(id);
        request.setAttribute("facility", facility);
        request.getRequestDispatcher("facility/edit.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        List<Facility> facilityList = new ArrayList<>();
//        facilityList = facilityService.findAll();
//        request.setAttribute("facilityList", facilityList);
        List<FacilityType> facilityTypes = facilityTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypes);
        List<RentType> rentTypes = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypes);
        request.getRequestDispatcher("facility/create.jsp").forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        facilityService.delete(id);
        response.sendRedirect("/facility");
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxpeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int facilityType = Integer.parseInt(request.getParameter("facilityType"));
        String standardRoom = request.getParameter("standardroom");
        String convenience = request.getParameter("convenient");
        double poolArea = Double.parseDouble(request.getParameter("poolarea"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        String facilityFree = request.getParameter("facilityfree");

        Facility facility = new Facility(id, name, area, cost, maxPeople, rentType, facilityType, standardRoom, convenience, poolArea, floor, facilityFree);
        facilityService.edit(facility);
        response.sendRedirect("/facility");
    }

    private void saveFacility(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxpeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int facilityType = Integer.parseInt(request.getParameter("facilityType"));
        String standardRoom = request.getParameter("standardroom");
        String convenience = request.getParameter("convenient");
        double poolArea = Double.parseDouble(request.getParameter("poolarea"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        String facilityFree = request.getParameter("facilityfree");

        Facility facility = new Facility(id, name, area, cost, maxPeople, rentType, facilityType, standardRoom, convenience, poolArea, floor, facilityFree);
        facilityService.create(facility);
        response.sendRedirect("/facility");
    }
}
