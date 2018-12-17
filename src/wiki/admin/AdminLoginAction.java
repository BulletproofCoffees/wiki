package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wiki.baes.Action;
import wikiDAO.MemberDAO;
import wikiDAO.wiki_adminDAO;
import wikiVO.MemberVO;

public class AdminLoginAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "admin/adminLogin.jsp";
		String id = request.getParameter("workid");
	 	String pwd = request.getParameter("workpwd");	 	
	 	wiki_adminDAO dao = wiki_adminDAO.getInstance();
	 	int result = dao.admin_login(id,pwd);
	 	
		//dao�� ���̵� �ߺ�üũ Ȯ���� 
	 	String message = "";
	 	if(result  == -1)
	 	{
	 		System.out.println("���̵����");
	 		message = "��ϵ������� ���̵��Դϴ�.";
	 		request.setAttribute("message", message);
	 		url= "admin/adminLogin.jsp";
	 	}else if(result == 0)
	 	{
	 		
	 		System.out.println("�������");
	 		message = "��й�ȣ�� �ٸ��ϴ�.";
	 		request.setAttribute("message", message);
	 		url = "admin/adminLogin.jsp";
	 	}
	 	else if(result == 1){
	 		
	 		System.out.println("�α���");	 		
	 		HttpSession session = request.getSession();
	 		session.setAttribute("adminid",id);
	 		url = "WikiServlet?command=wiki_admin_index";
	 	}
	 	
		request.getRequestDispatcher(url).forward(request, response);

	}
		
}
