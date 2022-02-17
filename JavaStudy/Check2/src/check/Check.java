package check;

import constants.Constants;

public class Check {
	private static String firstName = "慶太";
	private static String lastName = "村野";
	
	private void printName() {
		System.out.println("printNameメソッド" + " " + "⇨" + " " + lastName + firstName);
	}
	
		public static void main(String[] args) throws Exception{
			Check name1 = new Check();
			name1.printName();
		
			Pet pt = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
			pt.introduce();
			
			RobotPet rpt = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
			rpt.introduce();
		}
		
}
