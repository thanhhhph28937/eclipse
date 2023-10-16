package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ViecCanLam;
import repository.ViecCanLamRepo;
@WebServlet({"/congviec/hienthi","/congviec/add","/congviec/complete","/congviec/delete","/congviec/detail"})
public class Themcongviec extends HttpServlet{
	ViecCanLamRepo viecCanLamRepo=new ViecCanLamRepo();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		System.out.println("request da den servlet");
		if(uri.contains("hienthi")) hienthi(req,resp);
		if(uri.contains("complete")) complete(req,resp);
		if(uri.contains("delete")) delete(req,resp);
		if(uri.contains("detail")) ct(req,resp);
		
	  	
	}
	
	void hienthi(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		List<ViecCanLam> ds=viecCanLamRepo.getall();
    	req.setAttribute("list", ds);
	 req.getRequestDispatcher("/WEB-INF/view/dscv.jsp").forward(req, resp);
	}
	void complete(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{

    	Long id=Long.valueOf(req.getParameter("id"));
    	viecCanLamRepo.hoanthanh(id);
    	List<ViecCanLam> ds=viecCanLamRepo.getall();
    	req.setAttribute("list", ds);
	 req.getRequestDispatcher("/WEB-INF/view/dscv.jsp").forward(req, resp);
	}
	void delete(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		
//		if(req.getAttribute("error")==null) {
		  Long id=Long.valueOf(req.getParameter("id"));
	      	viecCanLamRepo.xoa(id);
	      	List<ViecCanLam> ds=viecCanLamRepo.getall();
	    	req.setAttribute("list", ds);
		 req.getRequestDispatcher("/WEB-INF/view/dscv.jsp").forward(req, resp);
//		}
//		else 
//			resp.sendRedirect("/thanh_duanxuong/login");
	}
	void ct(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
	     req.setAttribute("vcl", viecCanLamRepo.ct(Long.valueOf(req.getParameter("id"))));
	     List<ViecCanLam> ds=viecCanLamRepo.getall();
	    	req.setAttribute("list", ds);
		 req.getRequestDispatcher("/WEB-INF/view/dscv.jsp").forward(req, resp);
	     
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		if(uri.contains("add")) them(req,resp);
	}
	
				
	void them(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
//		if(req.getAttribute("error")==null) {
		String ma=req.getParameter("maCongViec");
		String tieude=req.getParameter("tieuDe");
		String mota=req.getParameter("moTa");
		Date bd;
		Date kt;
		String mucdo=req.getParameter("mucDo");
		String phanloai=req.getParameter("phanLoai");
		try {
			 bd=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("duKienBatDau"));
			 kt=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("duKienKetThuc"));
		} catch (ParseException e) {
			bd=new Date();
			kt=new Date();
			e.printStackTrace();
		}
		if(bd.after(kt)||bd.after(new Date())||kt.after(new Date())) {
			req.setAttribute("mess", "Ngay bat dau hoac ngay ket thuc khong hop le");
			List<ViecCanLam> ds=viecCanLamRepo.getall();
			
	    	req.setAttribute("list", ds);
		 req.getRequestDispatcher("/WEB-INF/view/dscv.jsp").forward(req, resp);
		 return;
		}
		
		ViecCanLam viecCanLam=new ViecCanLam();
		viecCanLam.setMaCongViec(ma);
		viecCanLam.setTieuDe(tieude);
		viecCanLam.setMoTa(mota);
		viecCanLam.setDuKienBatDau(bd);
		viecCanLam.setDuKienKetThuc(kt);
		viecCanLam.setMucDo(mucdo);
		viecCanLam.setPhanLoai(phanloai);
		viecCanLam.setTinhTrang(0);
		for (ViecCanLam  x : viecCanLamRepo.getall()) {
			if(x.getMaCongViec().equalsIgnoreCase(ma)) {
				req.setAttribute("mes", "Trung ma moi nhap lai");
				List<ViecCanLam> ds=viecCanLamRepo.getall();
		    	req.setAttribute("list", ds);
			 req.getRequestDispatcher("/WEB-INF/view/dscv.jsp").forward(req, resp);
			 return;
			}
		}
		viecCanLamRepo.them(viecCanLam);
		req.getRequestDispatcher("/WEB-INF/view/dscv.jsp");
		resp.sendRedirect("hienthi");
	
	}
//	else resp.sendRedirect("/thanh_duanxuong/login");
//	}
//	

}
