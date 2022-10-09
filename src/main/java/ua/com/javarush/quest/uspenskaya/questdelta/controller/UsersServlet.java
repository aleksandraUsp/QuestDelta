package ua.com.javarush.quest.uspenskaya.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.uspenskaya.questdelta.entities.User;
import ua.com.javarush.quest.uspenskaya.questdelta.service.UserService;
import ua.com.javarush.quest.uspenskaya.questdelta.util.Jsp;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "users", value = "/users")
public class UsersServlet extends HttpServlet {
    UserService userService=UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<User> users = userService.getAll();
        req.setAttribute("users", users);
        Jsp.forward(req,resp,"users");
    }

}
