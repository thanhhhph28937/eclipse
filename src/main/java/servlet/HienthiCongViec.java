//package servlet;
//
//import java.io.IOException;
//import java.util.List;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.ViecCanLam;
//import repository.ViecCanLamRepo;
//@WebServlet("/congviec/complete")
//public class HienthiCongViec extends HttpServlet{
//      ViecCanLamRepo repo=new ViecCanLamRepo();
//      
//      @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	
//    	
//    	Long id=Long.valueOf(req.getParameter("id"));
//    	repo.hoanthanh(id);
//    	resp.sendRedirect("/congviec/hienthi");
//    }
//} 
