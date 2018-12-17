package wiki;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import wiki.baes.Action;
import wikiDAO.WikiDAO;
import wikiVO.WikiVO;

public class Wiki_UpdateAction implements Action {
		
		@Override
		public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/*String url = "WikiServlet?command=wikiList";
			HttpSession session = request.getSession();
			int suzeLimit = 5 * 1024 * 1024;
			String savePath = "wiki_images";
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath(savePath);
		    MultipartRequest multi = new MultipartRequest(request, uploadFilePath, suzeLimit, "UTF-8", new DefaultFileRenamePolicy());
				
		    	WikiVO wikiVO = new WikiVO();
				String image = multi.getFilesystemName("image");
				if(image==null) {
					image = multi.getParameter("img");
				}
				wikiVO.setKind(multi.getParameter("kind"));
				wikiVO.setTitle(multi.getParameter("title"));
				wikiVO.setContent(multi.getParameter("content"));
				wikiVO.setImage(image);
				
				wikiVO.setWseq(Integer.parseInt(multi.getParameter("wseq")));
				WikiDAO wikiDAO = WikiDAO.getInstance();
				request.setAttribute("wikiVO", wikiVO);
				wikiDAO.updateWiki(wikiVO);
				response.sendRedirect(url);*/
			
			/*String url = "WikiServlet?command=wikiList";
	        HttpSession session = request.getSession();
	        int suzeLimit = 0x500000;
	        String savePath = "wiki_images";
	        ServletContext context = session.getServletContext();
	        String uploadFilePath = context.getRealPath(savePath);
	        MultipartRequest multi = new MultipartRequest(request, uploadFilePath, suzeLimit, "UTF-8", new DefaultFileRenamePolicy());
	        WikiVO wikiVO = new WikiVO();
	        String image = multi.getFilesystemName("image");
	        if(image==null) {
				image = multi.getParameter("img");
			}
	        wikiVO.setKind(multi.getParameter("kind"));
	        wikiVO.setTitle(multi.getParameter("title"));
	        wikiVO.setContent(multi.getParameter("content"));
	        wikiVO.setImage(image);
	        wikiVO.setWseq(Integer.parseInt(multi.getParameter("wseq")));
	        WikiDAO wikiDAO = WikiDAO.getInstance();
	        request.setAttribute("wikiVO", wikiVO);
	        wikiDAO.updateWiki(wikiVO);
	        response.sendRedirect(url);
		}*/
			
			String url = "WikiServlet?command=wikiList";
			 WikiVO wikiVO = new WikiVO();
			  WikiDAO wikiDAO = WikiDAO.getInstance();
			 
			 
		        wikiVO.setContent(request.getParameter("content"));
		       
		        wikiVO.setWseq(Integer.parseInt(request.getParameter("wseq")));
		        wikiDAO.updateWiki(wikiVO);
		        response.sendRedirect(url);
		}
}
