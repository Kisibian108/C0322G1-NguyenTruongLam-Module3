package controller.employee;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.*;
import repository.employee.DivisionRepositoryImpl;
import service.employee.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {

    static List<Employee> employeeList = new ArrayList<>();
    static IEmployeeService employeeService = new IEmployeeServiceImpl();
    static IDisivionService disivionService = new IDevisionServiceImpl();
    static IUserService userService = new IUserServiceImpl();
    static IEducationDegreeService educationDegreeService = new IEducationDegreeServiceImpl();
    static IPositionService positionService = new IPositionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); {
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                case "search":
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
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        List<Division> divisionList = disivionService.findAll();
        request.setAttribute("divisionList", divisionList);
        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);
        List<Position> positionList = positionService.findAll();
        request.setAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        try {
            request.getRequestDispatcher("employee/employeeList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); {
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                case "search":
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
    }
}
