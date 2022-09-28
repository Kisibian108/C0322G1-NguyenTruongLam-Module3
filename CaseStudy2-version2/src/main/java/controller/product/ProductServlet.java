package controller.product;

import model.product.Category;
import model.product.Product;
import model.test.BenhAn;
import model.test.BenhNhan;
import model.test.DanhSachBenhNhan;
import service.product.CategoryServiceImpl;
import service.product.ICategoryService;
import service.product.IProductService;
import service.product.ProductServiceImpl;
import service.test.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    static List<Product> productList = new ArrayList<>();
    static IProductService productService = new ProductServiceImpl();
    static ICategoryService categoryService = new CategoryServiceImpl();

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
                deleteDanhSach(request, response);
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
                showFormDelete(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        try {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        String nameSearch = request.getParameter("nameSearch");
        productList = productService.searchByName(nameSearch);
        request.setAttribute("productList", productList);
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }

    private void deleteDanhSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        productService.delete(id);
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);

        request.getRequestDispatcher("product/list.jsp").forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);

        Product product = productService.findById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("product/edit.jsp").forward(request,response);

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        productService.delete(id);
        response.sendRedirect("/product");
    }

    private void updateDanhsach(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));

        Product product = new Product(id, name, price, quantity, color, description, category);
        productService.edit(product);
        response.sendRedirect("/product");
    }

    private void saveDanhSach(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = (request.getParameter("name"));
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = (request.getParameter("color"));
        String description = (request.getParameter("description"));
        int category = Integer.parseInt(request.getParameter("category"));

        Product product = new Product( name, price, quantity, color, description, category);
        productService.create(product);
        response.sendRedirect("/product");

    }
}
