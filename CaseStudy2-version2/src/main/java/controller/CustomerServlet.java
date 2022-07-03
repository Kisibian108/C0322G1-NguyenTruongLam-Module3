package controller;

import model.Customer;
import repository.ICustomerRepository;
import service.CustomerServiceImpl;
import service.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    static List<Customer> customerList = new ArrayList<>();
    static ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                delete(request, response);
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
            case "create":
                saveCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("date_of_birth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, address);
        customerService.edit(customer);
        response.sendRedirect("/customer");
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {


    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/customerList.jsp").forward(request, response);
    }

}
//    static List<Student> studentList = new ArrayList<>();
//    private IStudentService studentService = new StudentServiceImpl();
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                saveStudent(request, response);
//                break;
//            case "edit":
//                updateStudent(request, response);
//                break;
//            case "search":
//                break;
//            default:
//                findAll(request, response);
//                break;
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                request.getRequestDispatcher("create.jsp").forward(request, response);
//                break;
//            case "edit":
//                showFormEdit(request,response);
//                break;
//            case "search":
//                findByName(request, response);
//                break;
//            default:
//                findAll(request, response);
//                break;
//        }
//    }
//
//    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Student student = studentService.findById(id);
//        request.setAttribute("student", student);
//        request.getRequestDispatcher("edit.jsp").forward(request, response);
//    }
//
//    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String nameSearch = request.getParameter("nameSearch");
//        studentList = studentService.findByName(nameSearch);
//        request.setAttribute("studentList", studentList);
//        request.getRequestDispatcher("studentList.jsp").forward(request, response);
//    }
//
//    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        studentList = studentService.findAll();
//        request.setAttribute("studentList", studentList);
//        request.getRequestDispatcher("studentList.jsp").forward(request, response);
//    }
//
//    private void saveStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String className = request.getParameter("className");
//        int gender = Integer.parseInt(request.getParameter("gender"));
//        int score = Integer.parseInt(request.getParameter("score"));
//
//        Student student = new Student(id, name, className, gender, score);
//        studentService.create(student);
//        response.sendRedirect("/student");
//
//    }
//    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String className = request.getParameter("className");
//        int gender = Integer.parseInt(request.getParameter("gender"));
//        int score = Integer.parseInt(request.getParameter("score"));
//
//        Student student = new Student(id, name, className, gender, score);
//        studentService.edit(student);
//        response.sendRedirect("/student");
//    }