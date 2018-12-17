package wiki.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiki.baes.Action;
import wikiVO.NoticeVO;

public class wiki_noticeLestAction implements Action {

   @Override
   public void excute(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
        String url = "notice/noticeLest.jsp";       
         NoticeDAO DAO =NoticeDAO.getInstance();
         ArrayList<NoticeVO> List=DAO.noticeLest();
         request.setAttribute("noticeLest", List);            
         request.getRequestDispatcher(url).forward(request, response);
   }
}