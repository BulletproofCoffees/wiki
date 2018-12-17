package wiki.baes;

import wiki.Wiki_DetailAction;
import wiki.Wiki_IdCheckAction;
import wiki.Wiki_IndexAction;
import wiki.Wiki_InsertAction;
import wiki.Wiki_InsertFormAction;
import wiki.Wiki_JoinAction;
import wiki.Wiki_JoinFormAction;
import wiki.Wiki_JoinsuccessAction;
import wiki.Wiki_ListAction;
import wiki.Wiki_ListHAction;
import wiki.Wiki_ListSAction;
import wiki.Wiki_ListUAction;
import wiki.Wiki_LoginAction;
import wiki.Wiki_LoginFormAction;
import wiki.Wiki_LogoutAction;
import wiki.Wiki_UpdateAction;
import wiki.Wiki_UpdateFormAction;
import wiki.Wiki_UpdateFormAction2;
import wiki.Wiki_clauseAction;
import wiki.Wiki_myAction;
import wiki.Wiki_mypageAction;
import wiki.Wiki_mypageUpdateAction;
import wiki.wiki_documentSearchAction;
import wiki.wiki_documentSearchFormAction;
import wiki.admin.AdminDocumentDeleteAction;
import wiki.admin.AdminDocumentListAction;
import wiki.admin.AdminForumDeleteAction;
import wiki.admin.AdminForumDetailAction;
import wiki.admin.AdminForumListAction;
import wiki.admin.AdminIndexAction;
import wiki.admin.AdminLoginAction;
import wiki.admin.AdminLoginFormAction;
import wiki.admin.AdminMemberDeleteAction;
import wiki.admin.AdminMemberListAction;
import wiki.admin.AdminNoticeDeleteAction;
import wiki.admin.AdminNoticeDetailAction;
import wiki.admin.AdminNoticeListAction;
import wiki.admin.AdminNoticeModifiedAction;
import wiki.admin.AdminNoticeUpdateAction;
import wiki.admin.AdminNoticeUpdateFormAction;
import wiki.admin.Wiki_UpdateAction2;
import wiki.forum.wiki_forumAction;
import wiki.forum.wiki_forum_DetailAction;
import wiki.forum.wiki_forum_InsertAction;
import wiki.forum.wiki_forum_InsertFormAction;
import wiki.notice.Wiki_Notice_DetailAction;
import wiki.notice.wiki_noticeLestAction;

public class ActionFactory {
	private static ActionFactory instance =new ActionFactory();
	private ActionFactory() {
		super();
	}
	public static ActionFactory getlnstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("index")) { //占쎈문
			action = new Wiki_IndexAction();
		} else if(command.equals("clause")) { //占싸깍옙占쏙옙占쏙옙 
			action = new Wiki_clauseAction();
		} else if(command.equals("my")) { //占싸깍옙占쏙옙占쏙옙 
			action = new Wiki_myAction();
		} else if(command.equals("mypage")) { //占싸깍옙占쏙옙占쏙옙 
			action = new Wiki_mypageAction();
		} else if(command.equals("mypageupdate")) { //占싸깍옙占쏙옙占쏙옙 
			action = new Wiki_mypageUpdateAction();
		} else if(command.equals("login_form")) { //占싸깍옙占쏙옙占쏙옙 
			action = new Wiki_LoginFormAction();
		} else if(command.equals("login")) { //占싸깍옙占싸액쇽옙 
			action = new Wiki_LoginAction();
		} else if(command.equals("logout")) { //占싸그아울옙占쌓쇽옙
			action = new Wiki_LogoutAction();
			
		} else if(command.equals("join_form")) {  //占쏙옙占쏙옙占쏙옙 
			action = new Wiki_JoinFormAction();
		} else if(command.equals("id_chack_form")) { // ContractJoin占쏙옙占쏙옙 占쏙옙占�
			action = new Wiki_IdCheckAction();
		} else if(command.equals("join")) {  //占쏙옙占쌉액쇽옙 
			action = new Wiki_JoinAction();
		} else if(command.equals("joinsuccess")) { //占쏙옙占쌉쇽옙占쏙옙占쏙옙
			action = new Wiki_JoinsuccessAction();

		}else if(command.equals("wiki_notice_lest")) {  //占쏙옙占쏙옙占쏙옙占쏙옙
				action = new wiki_noticeLestAction(); 				
		} else if(command.equals("wiki_Notice_Detail")) { //占쏙옙占쏙옙占쏙옙占쌓듸옙占쏙옙占쏙옙
			action = new Wiki_Notice_DetailAction();

		}else if(command.equals("wiki_forum")) { //占쏙옙占쏙옙占쏙옙占쏙옙트
					action = new wiki_forumAction();       					
		}else if(command.equals("wiki_forum_Detail")) { //占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
			action = new wiki_forum_DetailAction(); 
		} else if(command.equals("wiki_forum_Insert_form")) {
			action = new wiki_forum_InsertFormAction();
		} else if(command.equals("wiki_forum_Insert")) {
			action = new wiki_forum_InsertAction();
		/*}else if(command.equals("wiki_forum_Update_form")) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 x
			action = new wiki_forum_UpdateFormAction(); 
		}else if(command.equals("wiki_forum_Update")) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 x
	action = new wiki_forum_UpdateAction(); */		
		} else if(command.equals("wikiList")) { // 占쏙옙占쏙옙 占쌍신깍옙
			action = new Wiki_ListAction();		
		} else if(command.equals("wikiListH")) { // 占쏙옙占쏙옙 占싸뱄옙占쏙옙
			action = new Wiki_ListHAction();	
		} else if(command.equals("wikiListS")) { // 占쏙옙占쏙옙 占쏙옙占쏙옙
			action = new Wiki_ListSAction();	
		} else if(command.equals("wikiListU")) { // 占쏙옙占쏙옙 占싱분뤄옙
			action = new Wiki_ListUAction();	
		} else if(command.equals("wikiDetail")) { //占쏙옙占쏙옙 占쏙옙占쏙옙
			action = new Wiki_DetailAction();
		} else if(command.equals("wikiInsert")) { //占쏙옙占쏙옙占쏙옙占쏙옙占쌓쇽옙
			action = new Wiki_InsertAction();
		} else if(command.equals("wikiInsert_form")) { //占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙			
			action = new Wiki_InsertFormAction();
		} else if(command.equals("wikiUpdate_form")) { //占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
			action = new Wiki_UpdateFormAction(); 
		} else if(command.equals("wikiUpdate")) { //占쏙옙占쏙옙 占쏙옙占쏙옙占쌓쇽옙
			action = new Wiki_UpdateAction();
			
			
		} else if(command.equals("wikiUpdate_form2")) { //占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
			action = new Wiki_UpdateFormAction2(); 	
		} else if(command.equals("wikiUpdate2")) { //占쏙옙占쏙옙 占쏙옙占쏙옙占쌓쇽옙
			action = new Wiki_UpdateAction2();	
			
			
		} else if(command.equals("document_search")) {
				action = new wiki_documentSearchAction();				
		}else if (command.equals("document_search_form")) { //占쏙옙占쏙옙 占싯삼옙占쏙옙
				action = new wiki_documentSearchFormAction();
				
		}
		
		if(command.equals("wiki_admin_login_form")) { //占쏙옙占쏙옙占쏙옙 占싸깍옙占쏙옙占쏙옙
			action = new AdminLoginFormAction();
		} else if(command.equals("wiki_admin_login")) { //占쏙옙占쏙옙占쏙옙 占싸깍옙占싸액쇽옙			
			action = new AdminLoginAction();
		} else if(command.equals("wiki_admin_index")) { //占쏙옙占쏙옙占쏙옙 홈			
			action = new AdminIndexAction();
			
			
			
		} else if(command.equals("admin_document_list")) {  //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙트
			action = new AdminDocumentListAction();			
			
		} else if(command.equals("admin_document_delete")) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
			action = new AdminDocumentDeleteAction();	
			//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙
			
		} else if(command.equals("admin_notice_list")) {  //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙트
			action = new AdminNoticeListAction(); 
		} else if(command.equals("wiki_adminNotice_Detail")) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙
			action = new AdminNoticeDetailAction();
		} else if(command.equals("wiki_adminNotice_delete")) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
			action = new AdminNoticeDeleteAction();
		} else if(command.equals("wiki_adminNotice_Modified")) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌓쇽옙
			action = new AdminNoticeModifiedAction();
		} else if(command.equals("wiki_adminNotice_Update_form")) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
			action = new AdminNoticeUpdateFormAction();
		} else if(command.equals("wiki_adminNotice_Update")) { //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌓쇽옙
			action = new AdminNoticeUpdateAction();
			
				
		} else if(command.equals("admin_forum_list")) {  //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙트
			action = new AdminForumListAction();
		} else if(command.equals("wiki_adminforum_Detail")) {  //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙
			action = new AdminForumDetailAction();
		} else if(command.equals("wiki_adminforum_Delete")) {  //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙트
			action = new AdminForumDeleteAction();
			
		} else if(command.equals("admin_member_list")) {  //占쏙옙占쏙옙占쏙옙 회占쏙옙 占쏙옙占쏙옙트
			action = new AdminMemberListAction();
		} else if(command.equals("admin_member_delete")) {  //占쏙옙占쏙옙占쏙옙 회占쏙옙 占쏙옙占쏙옙
			action = new AdminMemberDeleteAction();
		/*} else if(command.equals("admin_member_vandalist")) {  //占쏙옙占쏙옙占쏙옙 占쌥댐옙 占쏙옙占쏙옙트
			action = new AdminMemberVandalsListAction();			
			//占쏙옙占쏙옙占쏙옙 회占쏙옙 占쌥달곤옙占쏙옙*/			
			
			
			
			
			
		} 
		return action;
	}
	}
