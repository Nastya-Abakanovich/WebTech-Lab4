package by.bsuir.lab4.controllers;


import by.bsuir.lab4.entity.User;
import by.bsuir.lab4.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            String login = req.getParameter("LogUserLogin");
            String password = req.getParameter("LogUserPassword");
            User user = new User(login, password);
            UserService userService = new UserService();
            User foundUser = userService.findUser(user);
            if (foundUser != null) {
                req.getSession(true).setAttribute("userId", foundUser.getId());
                req.getSession().setAttribute("userLogin", foundUser.getLogin());
                req.getSession().setAttribute("userRole", foundUser.getRole());

                res.sendRedirect("Controller?COMMAND=GET_ROOMS");
            } else {
                System.out.println("There is no such user");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
