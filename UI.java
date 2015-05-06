/*******************************************
 class UI (user interface) 

	checkID(ID)	
	promptCommand()
	promptID()
	showFinishMsg()
	showWelcomeMsg()
	UI() 建構子 建構 aGradeSystem

 *******************************************/

import java.util.Scanner;

public class UI {
	public GradeSystems aGradeSystem;
	private String ID;
	private Scanner scan;
	public boolean exit = false;

	/**-------------------------------------------------------------
	 UI() throws NoSuchIDExceptions NoSuchCommandExceptions
	 -------------------------------------------------------------- **/
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		aGradeSystem = new GradeSystems();
		scan = new Scanner(System.in);
		try {
			promptID();
			ID = scan.nextLine();
			while (!ID.equals("Q")) {
				/** Loop1 : 詢問輸入ID或以Q離開 **/
				if (checkID(ID)) {
					showWelcomeMsg();
					System.out.print(String.valueOf(aGradeSystem.find(ID).name)+"\n");
					exit = false;
					while (!exit) {
						/** Loop2 : 得到正確ID後讓使用者輸入四種指令 **/
						promptCommand();
					}
					promptID();
					ID = scan.nextLine();
				} else {
					throw new NoSuchIDExceptions();
				}
			}
			showFinishMsg();
		} finally {
		}
	}

	/**-----------------------checkID (ID)-------------------------
	  checkID (ID) throws NoSuchIDExceptions return Boolean 
	  parameter: ID a user ID ex:
	  123456789 time: O(n) n is aGradeSystem 內全班人數
	 ----------------------------------------------------------- **/
	public boolean checkID(String ID) throws NoSuchIDExceptions {
		if (aGradeSystem.check(ID)) {
			return true;
		} else {
			throw new NoSuchIDExceptions();
		}
	}

	/**--------------------- promptCommand-----------------------
	 () throws NoSuchCommandExceptions
	--------------------------------------------------------- **/
	public void promptCommand() throws NoSuchCommandExceptions {
		System.out.printf("輸入指令  : 1) G 顯示成績 (Grade)\n");
		System.out.printf("        2) R 顯示排名 (Rank)\n");
		System.out.printf("        3) W 更新配分 (Weight)\n");
		System.out.printf("        4) E 離開選單 (Exit)\n");
		String temp = scan.nextLine();
		switch (temp) {
		case "G":
			aGradeSystem.showGrade(ID);
			break;
		case "R":
			aGradeSystem.showRank(ID);
			break;
		case "W":
			aGradeSystem.updateWeights();
			break;
		case "E":
			exit = true;
			break;
		default:
			throw new NoSuchCommandExceptions();
		}

	}

	public void promptID() {
		System.out.print("輸入 ID 或是 Q(結束) \n");
	}

	public void showFinishMsg() {
		System.out.print("結束囉!!!\n");
	}

	public void showWelcomeMsg() {
		System.out.print("Welcome ");
	}
}