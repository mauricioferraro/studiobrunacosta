package bruna.Util;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	
	private static SessionFactory session = buildSessionFactoy();

	private static SessionFactory buildSessionFactoy() {
	
		try {
			Configuration cfg = new Configuration();
			
			cfg.configure("hibernate.cfg.xml"); 
			return cfg.buildSessionFactory();
			
			
		}catch (Throwable e	){
			
			System.out.println("Deu Erro na Conexão" + e);
			
			throw new ExceptionInInitializerError();
			
		}
		
		
		
	}

	public static Session getSession() {
		return session;
	}
	

}
