package ua.com.javarush.quest.uspenskaya.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.uspenskaya.questdelta.util.Jsp;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Привет! Тебя ждут интересные приключения! Полный вперед!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        Jsp.forward(request,response,"hello");
    }

    public void destroy() {
    }
}