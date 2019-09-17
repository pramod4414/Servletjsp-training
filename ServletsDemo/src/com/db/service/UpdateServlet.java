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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();  
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        
	        String productname=request.getParameter("productname");
	        String manufacturername= request.getParameter("manufacturername"); 
	        String price1 = request.getParameter("price");
	        int price =Integer.parseInt(price1);

	    	Products products = new Products();
	    	products.setId(id);
			products.setProductname(productname);
			products.setManufacturername(manufacturername);
			products.setPrice(price);
			
			int status=ProductDBHandler.updateProducts(products);
			
			if(status > 0 )
			{
				response.sendRedirect("products.html");
			}
			else
			{
				out.print(" unable to update");
			}
	        
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
