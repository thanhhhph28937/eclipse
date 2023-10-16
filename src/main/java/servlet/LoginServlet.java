package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NguoiDung;
import model.ViecCanLam;
import repository.NguoidungRepo;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	NguoidungRepo nguoidungRepo=new NguoidungRepo();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=req.getParameter("ten");
		System.out.println(user);
		if(user==null)user="";
		String pass=req.getParameter("pass");
		if(pass==null) pass="";
		System.out.println(user+"ss"+pass);
	    System.out.println(nguoidungRepo.getby2gt(user, pass));

		 if(nguoidungRepo.getby2gt(user, pass).isPresent()) {
			    
				req.getSession().setAttribute("auth", nguoidungRepo.getby2gt(user, pass));
				
				resp.sendRedirect("/thanh_duanxuong/congviec/hienthi");
				
		 }
			
			else {
				req.setAttribute("mes", "Dang nhap sai moi dang nhap lai");
				req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
			}
		}
		
		
		
		

	}


