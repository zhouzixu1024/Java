package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Company;
import service.CompanyService;

/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/CompanyServlet.do")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyService cs = new CompanyService();
		List<Company>company = cs.CompanyAll();
		request.setAttribute("companys", company);
		request.getRequestDispatcher("demo1.jsp").forward(request, response);
	}

}
