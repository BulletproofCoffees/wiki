package wiki.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiVO.WikiVO;

public class Wiki_UpdateAction2 implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "WikiServlet?command=wikiUpdate_form2";
		
		WikiVO vo = new WikiVO();		
		vo.setTitle(request.getParameter("title"));		
		System.out.println(request.getParameter("title"));
		
		response.sendRedirect(url);

	}

}
