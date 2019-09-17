package com.db.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bv.handler.ProductDBHandler;
import com.bv.model.Products;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddServlet() {
        super();
        
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String productname = request.getParameter("productname");
		String manufacturername = request.getParameter("manufacturername");
		String price = request.getParameter("price");

		Products products = new Products();
		products.setProductname(productname);
		products.setManufacturername(manufacturername);
		System.out.println(manufacturername);
		products.setPrice(Double.parseDouble(price));

		int status = ProductDBHandler.addProduct(products);
		if(status>0)
		{
			out.print("<h2>Records inserted successfully!!!</h2>");
		}
		else
		{
			out.print("Error! in inserting the records");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
