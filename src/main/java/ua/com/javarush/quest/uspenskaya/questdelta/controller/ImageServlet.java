package ua.com.javarush.quest.uspenskaya.questdelta.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.uspenskaya.questdelta.service.AvatarService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    private final AvatarService avatarService =AvatarService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameImage = req.getRequestURI().replace("/images/", "");
        Optional<Path>file=avatarService.getAvatarPath(nameImage);
        if (file.isPresent()){
            try (ServletOutputStream outputStream=resp.getOutputStream()){
                Files.copy(file.get(), outputStream);
            }
        }
    }

}
