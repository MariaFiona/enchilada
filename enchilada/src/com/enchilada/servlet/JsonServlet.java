package com.enchilada.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enchilada.json.generator.JsonDataProvider;

@WebServlet("/sprintbook/enchilada.json")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    JsonDataProvider jdp = new JsonDataProvider();

	    HttpServletResponse resp = (HttpServletResponse) response;
        resp.getWriter().write(jdp.generateJsonData());
        resp.getWriter().flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
