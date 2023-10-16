package utility;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Chucvu;
import model.NguoiDung;
import model.ViecCanLam;

public class HibernateUtil {
	private static final SessionFactory FACTORY;

	static {
		Configuration conf = new Configuration();

		Properties properties = new Properties();
		properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
		properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.put(Environment.URL, DBMetaData.getConnectString());
		properties.put(Environment.SHOW_SQL, "true"); // Hiển thị câu lệnh SQL thực hiện
		// properties.put(Environment.HBM2DDL_AUTO, "create"); // tự động sinh db

		conf.setProperties(properties);
		conf.addAnnotatedClass(ViecCanLam.class);
		conf.addAnnotatedClass(NguoiDung.class);
		conf.addAnnotatedClass(Chucvu.class);
		   

		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(conf.getProperties())
				.build();
		FACTORY = conf.buildSessionFactory(registry);
	}
	
	public static SessionFactory getFactory() {
		return FACTORY;
	}

	public static synchronized Session getSession() {
		return FACTORY.openSession();
	}
	
	public static void main(String[] args) {
		getFactory().openSession().createQuery("from NguoiDung").getResultList().forEach(System.out::println);
		System.out.println("Hibernate run successfully!");
	}
}
