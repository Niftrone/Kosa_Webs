package controller;
//Controller 를 생성하는 공장
//findController, loginController, registerController, updateController
public class ControllerFactory {
	
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {
		
	}
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("REGISTER")) {
			controller = new RegisterController();
			System.out.println("registercontroller 생성");
		}else if(command.equals("FIND")) {
			controller = new FindController();
			System.out.println("findrcontroller 생성");
		}else if(command.equals("LOGIN")) {
			controller = new LoginController();
			System.out.println("logincontroller 생성");
		}else if(command.equals("UPDATE")) {
			controller = new UpdateController();
			System.out.println("updatecontroller 생성");
		}
		return controller;
	}
	
	
}
