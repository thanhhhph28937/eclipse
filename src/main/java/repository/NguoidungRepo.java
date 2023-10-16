package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.NguoiDung;
import model.ViecCanLam;
import utility.HibernateUtil;

public class NguoidungRepo {
       public List<NguoiDung> getall(){
//    	   List<NguoiDung> ds=new ArrayList();
//    	   Session ss=HibernateUtil.getSession();
////    	   org.hibernate.query.Query<NguoiDung> query=ss.createQuery("select v from NguoiDung v",NguoiDung.class);
//    	   ds=query.getResultList();
//    	   ss.close();
//    	   return ds;
    	   return HibernateUtil.getSession().createQuery("from NguoiDung").getResultList();
       }
       public Optional<NguoiDung> getby2gt(String user,String pass) {
    	   return getall().stream().filter(i->{
    		   if(i.getTen().equalsIgnoreCase(user)&&i.getPass().equalsIgnoreCase(pass)) 
    			   return true;
    	   return false;
    			   }).findFirst();
       }
}
