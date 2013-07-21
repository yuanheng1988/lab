package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import available.ClientWithResponseHandler;

public class GetDataServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7013942485246656767L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		
		String url = request.getParameter("url");
		String tool = request.getParameter("tool");
		
		try {
			 String data = ClientWithResponseHandler.GetResponseData(url,tool);
			 response.getWriter().println(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
