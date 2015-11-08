package bruna.Util;

import java.io.IOException;

import org.hibernate.SessionFactory;

import bruna.Util.HibernateUtil;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ConexaoHibernateFilter implements Filter{
	
	private SessionFactory sf;
	
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest serveletFilter, ServletResponse serveletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			
			this.sf.getCurrentSession().beginTransaction();
			chain.doFilter(serveletFilter,serveletResponse);
			this.sf.getCurrentSession().getTransaction().commit();
			this.sf.getCurrentSession().close();
			
		} catch (Throwable ex) {
			
			try {
				
					this.sf.getCurrentSession().getTransaction().rollback();
			
				
			} catch (Exception t) {
			t.printStackTrace();
			}
		}
		
		throw new ServletException();
		 	
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		
		this.sf = HibernateUtil.getSession();
		
	}

}
