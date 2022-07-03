package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    static List<Product> productList = new ArrayList<>();
    static IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                request.getRequestDispatcher("product/create.jsp").forward(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                try {
                    showDeleteForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    findAll(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productService.findById(id);
        RequestDispatcher dispatcher;
        if (productList == null) {
            dispatcher = request.getRequestDispatcher("product/error-404.jsp");
        } else {
            request.setAttribute("productList", productList);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productService.findById(id);
        request.setAttribute("productList",productList);
        request.getRequestDispatcher("product/edit.jsp").forward(request,response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        productList = productService.findAll();
        request.setAttribute("productList",productList);
        request.getRequestDispatcher("product/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                saveProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                try {
                    findAll(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> productList = productService.findById(id);
        RequestDispatcher dispatcher;
        if (productList == null) {
            dispatcher = request.getRequestDispatcher("product/error-404.jsp");
        } else {
            productList.remove(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String productor = request.getParameter("productor");

        Product product = new Product(id, name, price, description, productor);
        productService.create(product);
        response.sendRedirect("/product");
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String productor = request.getParameter("productor");

        Product product = new Product(id, name, price, description, productor);
        productService.create(product);
        response.sendRedirect("/product");
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
//}
