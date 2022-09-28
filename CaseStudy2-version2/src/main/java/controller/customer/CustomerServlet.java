package controller.customer;

import model.customer.Customer;
import model.customer.CustomerType;
import service.customer.CustomerServiceImpl;
import service.customer.CustomerTypeImpl;
import service.customer.ICustomerService;
import service.customer.ICustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    static List<Customer> customerList = new ArrayList<>();
    static List<CustomerType> customerTypeList = new ArrayList<>();
    static ICustomerService customerService = new CustomerServiceImpl();
    static ICustomerTypeService customerTypeService = new CustomerTypeImpl();

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
                    deleteCustomer(request,response);
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
                saveCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
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

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList",customerTypeList);
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        String phoneSearch = request.getParameter("phoneSearch");
        customerList = customerService.findByName(nameSearch,phoneSearch);
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/list.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idType = Integer.parseInt(request.getParameter("idType"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id,idType, name, birthday, gender, idCard, phoneNumber, email, address);
        customerService.edit(customer);
        response.sendRedirect("/customer");
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        int id = Integer.parseInt(request.getParameter("id"));
        int idType = Integer.parseInt(request.getParameter("idType"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(idType, name, birthday, gender, idCard, phoneNumber, email, address);

//        customerService.create(customer);
//        response.sendRedirect("/customer");
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList",customerTypeList);
        Map<String,String> mapValidate = customerService.create(customer);
        if (mapValidate.isEmpty()){
            List<Customer> customerList = customerService.findAll();
            request.setAttribute("customerList", customerList);
            request.setAttribute("mess","them moi thanh cong");
            request.getRequestDispatcher("customer/list.jsp").forward(request,response);
        }else {
            request.setAttribute("mess","them moi that bai");
            request.setAttribute("mapValidate",mapValidate);
            request.getRequestDispatcher("customer/create.jsp").forward(request,response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        customerService.delete(id);
        response.sendRedirect("/customer");
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        customerService.delete(id);
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("customer/list.jsp").forward(request,response);
        }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
