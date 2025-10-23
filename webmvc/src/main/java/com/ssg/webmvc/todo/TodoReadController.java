package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoReadController" , urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/todo/read doGet()");

        // /todo/read?tno=123
        Long tno = Long.parseLong(request.getParameter("tno"));
        TodoDTO dto = TodoService.INSTANCE.get(tno);

        request.setAttribute("dto", dto);
        request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request,response);


    }

}
