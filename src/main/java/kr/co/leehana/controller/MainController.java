package kr.co.leehana.controller;

import kr.co.leehana.service.MemberServiceImpl;
import kr.co.leehana.view.LoginFrame;
import kr.co.leehana.view.ManageView;

/**
 * @author Hana Lee
 * @since 2015-11-14 03-28
 */
public class MainController {

	private ManageView manageView;

	public static void main(String[] args) {
		MainController controller = new MainController();
		LoginFrame loginFrame = new LoginFrame(controller, new LoginController(new MemberServiceImpl()));
	}

	private void showManageView() {
		new ManageView();
	}
}
