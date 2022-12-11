package by.bsuir.lab4.controllers;

import by.bsuir.lab4.entity.Room;
import by.bsuir.lab4.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetRoomsCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) {
        RoomService roomService = new RoomService();
        List<Room> rooms = roomService.getRooms();
        try {
            req.getSession().setAttribute("rooms", rooms);
            res.sendRedirect("Controller?COMMAND=GET_RESERVATIONS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
