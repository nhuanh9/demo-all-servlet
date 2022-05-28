package controller;

import model.Class;
import model.Student;
import service.ClassService;
import service.ClassServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    ClassService classService = new ClassServiceImpl();
    StudentService studentService = new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classId = request.getParameter("classId");
        String findName = request.getParameter("findName");
        List<Class> classes = classService.findAll();
        request.setAttribute("classes", classes);
        List<Student> students = studentService.findAll();
        if (classId != null) {
            students = studentService.findAllByClass(Integer.parseInt(classId));
        }
        if (findName != null) {
            students = studentService.findAllByNameContains(findName);
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
