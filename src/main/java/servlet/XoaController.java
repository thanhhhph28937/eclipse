//package servlet;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import repository.ViecCanLamRepo;
//@WebServlet("/congviec/delete")
//public class XoaController extends HttpServlet{
//  ViecCanLamRepo repo=new ViecCanLamRepo();
//      @Override
//    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	  Long id=Long.valueOf(req.getParameter("id"));
//      	repo.xoa(id);
//      	resp.sendRedirect("/congviec/hienthi");
//    	}
//   
//}
