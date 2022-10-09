package ua.com.javarush.quest.uspenskaya.questdelta.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import ua.com.javarush.quest.uspenskaya.questdelta.entities.Role;
import ua.com.javarush.quest.uspenskaya.questdelta.entities.User;
import ua.com.javarush.quest.uspenskaya.questdelta.service.AvatarService;
import ua.com.javarush.quest.uspenskaya.questdelta.service.UserService;
import ua.com.javarush.quest.uspenskaya.questdelta.util.Jsp;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@MultipartConfig (fileSizeThreshold = 1<<20)
@WebServlet(name = "user", value = "/user")
public class UserServlet extends HttpServlet {

    UserService userService=UserService.USER_SERVICE;
    private static volatile AtomicInteger UID=new AtomicInteger(1);
    private final AvatarService avatarService= AvatarService.INSTANCE;

    @Override
    public void init()  {
        getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> stringId = Optional.ofNullable(req.getParameter("id"));
        if (stringId.isPresent()){
            long id=Long.parseLong(stringId.get());
            Optional<User> user = userService.get(id);
            user.ifPresent(value -> req.setAttribute("user", value));
        }
        Jsp.forward(req,resp,"user");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id=getId(req);
        Part data=req.getPart("image");
        String image="avatar-"+id+UID.getAndIncrement();
        avatarService.uploadAvatar(image, data.getInputStream());
        User user=User.with()
                .id(id)
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .image(image)
                .role(Role.valueOf(req.getParameter("role")))
                .get();
        postUser(req, user);
        Jsp.redirect(resp, "users");
    }

    protected void postUser(HttpServletRequest req, User user){
        boolean present=userService.get(user.getId()).isPresent();
        if (present && req.getParameter("update")!=null) {
            userService.update(user);
        } else if (present && req.getParameter("delete")!=null){
            userService.delete(user);
        }else if (!present && req.getParameter("creat")!=null){
            userService.create(user);
        } else{
            throw new UnsupportedOperationException("not found cmd");
        }
    }

    protected  long getId(HttpServletRequest req){
        return req.getParameter("id") !=null?
                Long.parseLong(req.getParameter("id"))
                : 0L;
    }

}
