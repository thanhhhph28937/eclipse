package filter;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.NguoiDung;
import repository.NguoidungRepo;


@WebFilter({"/congviec/delete","/congviec/add"})
public class AdminFilter implements Filter{
NguoidungRepo nguoidungRepo=new NguoidungRepo();
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest r=(HttpServletRequest) req;
		HttpServletResponse re=(HttpServletResponse) resp;
		HttpSession ss=r.getSession();
		
		Optional<NguoiDung> nguoiDung= (Optional<NguoiDung>) ss.getAttribute("auth");
		
		
			if(nguoiDung!=null) {
		
		if("truong phong".equalsIgnoreCase(nguoiDung.get().getCv().getTencv())) chain.doFilter(req, resp);
		else {
//			req.setAttribute("error", 0);
//			chain.doFilter(req, resp);
			
			re.sendRedirect("/thanh_duanxuong/login");
		}
			}
else {
			
//			req.setAttribute("error", 0);
//			chain.doFilter(req, resp);
			
			re.sendRedirect("/thanh_duanxuong/login");
			
		}
		
			}
		
	}



	
    



