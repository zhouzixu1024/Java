package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompanyDao;
import dao.CompanyDaoImp;
import entity.Company;

/**
 * Servlet implementation class Companyinsert
 */
@WebServlet("/Companyinsert.do")
public class Companyinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 接收页面请求的参数 
		String name = request.getParameter("name");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String position = request.getParameter(" position");
		Company comp = new Company(name,sex,position);
		CompanyDao dao = new CompanyDaoImp();
		PrintWriter  pw = response.getWriter();
		if(dao.insertCompany(comp) == 1){
			request.setAttribute("msg", "成功");
			request.getRequestDispatcher("Companyinsert.do").forward(request, response);
		}else{
			pw.write("失败");
		}
		pw.close();
		
		
		
	}

}
