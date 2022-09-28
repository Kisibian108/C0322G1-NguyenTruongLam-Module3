package controller.employee;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.*;
import model.facility.Facility;
import model.facility.FacilityType;
import model.facility.RentType;
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
        String action = request.getParameter("action");
        {
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    try {
                        showFormCreate(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "edit":
                    try {
                        showEditForm(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    try {
                        deleteEmployee(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "search":
                    try {
                        findEmployeeByName(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
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
    }

    private void findEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String nameSearch = request.getParameter("nameSearch");
//        String phoneSearch = request.getParameter("phoneSearch");
        List<Division> divisionList = disivionService.findAll();
        request.setAttribute("divisionList", divisionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Position> positionList = positionService.findAll();
        request.setAttribute("positionList", positionList);

        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);

        employeeList = employeeService.findByName(nameSearch);
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        employeeService.delete(id);

        List<Division> divisionList = disivionService.findAll();
        request.setAttribute("divisionList", divisionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Position> positionList = positionService.findAll();
        request.setAttribute("positionList", positionList);

        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);

        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list.jsp").forward(request,response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));

        List<Division> divisionList = disivionService.findAll();
        request.setAttribute("divisionList", divisionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Position> positionList = positionService.findAll();
        request.setAttribute("positionList", positionList);

        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);

        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("employee/edit.jsp").forward(request, response);

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        List<Division> divisionList = disivionService.findAll();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        List<Position> positionList = positionService.findAll();
        request.setAttribute("positionList", positionList);
        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("employee/create.jsp").forward(request, response);
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
            request.getRequestDispatcher("employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        {
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    saveEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request,response);
                    break;
                case "delete":
                    try {
                        showFormDelete(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "search":
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
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        employeeService.delete(id);
        response.sendRedirect("/employee");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = (request.getParameter("phoneNumber"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");

        Employee employee = new Employee(id, name, birthday, idCard, salary, phoneNumber, email, address, position, education, division, username);
        employeeService.edit(employee);
        response.sendRedirect("/employee");
    }

    private void saveEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = (request.getParameter("phoneNumber"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");

        Employee employee = new Employee( name, birthday, idCard, salary, phoneNumber, email, address, position, education, division, username);
        employeeService.create(employee);
        response.sendRedirect("/employee");
    }
}
//}<%--private int id;--%>
//<%--private String name;--%>
//<%--private String birthday;--%>
//<%--private String idCard;--%>
//<%--private double salary;--%>
//<%--private String phoneNumber;--%>
//<%--private String email;--%>
//<%--private String address;--%>
//<%--private int positionId;--%>
//<%--private int educationDegreeId;--%>
//<%--private int divisionId;--%>
//<%--private String username;--%>
