/*******************************************
 class UI (user interface) 

	checkID(ID)	
	promptCommand()
	promptID()
	showFinishMsg()
	showWelcomeMsg()
	UI() �غc�l �غc aGradeSystem

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
				/** Loop1 : �߰ݿ�JID�ΥHQ���} **/
				if (checkID(ID)) {
					showWelcomeMsg();
					System.out.print(String.valueOf(aGradeSystem.find(ID).name)+"\n");
					exit = false;
					while (!exit) {
						/** Loop2 : �o�쥿�TID�����ϥΪ̿�J�|�ث��O **/
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
	  123456789 time: O(n) n is aGradeSystem �����Z�H��
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
		System.out.printf("��J���O  : 1) G ��ܦ��Z (Grade)\n");
		System.out.printf("        2) R ��ܱƦW (Rank)\n");
		System.out.printf("        3) W ��s�t�� (Weight)\n");
		System.out.printf("        4) E ���}��� (Exit)\n");
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
		System.out.print("��J ID �άO Q(����) \n");
	}

	public void showFinishMsg() {
		System.out.print("�����o!!!\n");
	}

	public void showWelcomeMsg() {
		System.out.print("Welcome ");
	}
}