package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.ViecCanLam;
import utility.HibernateUtil;

public class ViecCanLamRepo {
      public List<ViecCanLam> getall(){
    	   List<ViecCanLam> ds=new ArrayList();
    	   Session ss=HibernateUtil.getSession();
    	   org.hibernate.query.Query<ViecCanLam> query=ss.createQuery("select v from ViecCanLam v",ViecCanLam.class);
    	   ds=query.getResultList();
    	   ss.close();
    	   return ds;
       }
      public Long them(ViecCanLam viecmoi) {
    	  Long id=null;
    	  Session ss=HibernateUtil.getSession();
    	  Transaction tran=ss.beginTransaction();
    	 id= (Long) ss.save(viecmoi);
    	 tran.commit();
    	 ss.close();
    	 return id;
    	  
      }
     
      public void hoanthanh(Long id) {
    	  Session ss=HibernateUtil.getSession();
    	  Transaction tran=ss.beginTransaction();
    	  ViecCanLam viecCanLam=ss.get(ViecCanLam.class, id);
    	  viecCanLam.setTinhTrang(1);
    	  ss.update(viecCanLam);
    	  tran.commit();
    	  ss.close();
      }
       public void xoa(Long id) {
    	   Session ss=HibernateUtil.getSession();
    	   Transaction tran=ss.beginTransaction();
    	   ViecCanLam viecCanLam=ss.get(ViecCanLam.class, id);
    	   ss.delete(viecCanLam);
    	   tran.commit();
    	   ss.close();
    	   
       }
       public ViecCanLam ct(Long id) {
    	   List<ViecCanLam> ds=new ArrayList();
    	   Session ss=HibernateUtil.getSession();
    	   org.hibernate.query.Query<ViecCanLam> query=ss.createQuery("select v from ViecCanLam v",ViecCanLam.class);
    	   ds=query.getResultList();
    	   ss.close();
    	   for (ViecCanLam x : ds) {
			if(x.getId().equals(id)) return x;
		}
    	   return null;
       }
}
