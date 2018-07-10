package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

  
public class SessionFilter implements Filter{
	
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fchain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String username = null;
          
        HttpSession session = request.getSession(false);
        if (null != session) {
        	 username = (String) session.getAttribute("username");
        }
        if(username == null) {
        	response.sendRedirect(request.getContextPath());
        }else {
        	fchain.doFilter(req, res);
        }
        

	}


	}

