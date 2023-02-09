package com.example.task1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        double x,y;
        String str="";
        x=Double.parseDouble(request.getParameter("dinput1"));
        System.out.println(x);
        str=request.getParameter("btnradio");
        switch (str)
        {
            case "Rupees":
                y= x*82.665;
                System.out.println(y);
                break;
            case "Yuan":
                y=x*6.7891;
                System.out.println(y);
                break;
            case "Euro":
                y=x*0.9309;
                System.out.println(y);
                break;
            default:
                y=x*1;
                System.out.println(y);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
