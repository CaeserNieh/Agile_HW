/** ##################################################################
  	��Grade system ���ϥΪ�(�ǥ�)���o�L���`���Ztotal grade �αƦW rank.
	Total grade ���t��weights �Ӻ� �� weights�i�Hupdate. 
	Rank ��ܦ� total grade �b���Z�ǥͪ����ƱƧ�
	
  	Header of input file:
  	�ɮ׸��|����   :"D:\gradeInput.txt"
  	���Z�ǥͪ����� �Ҧp
        962001044 ��v�� 87 86 98 88 87
		962001051   ���§� 81 98 84 90 93
           �`�N data field names �p�U: 
        ID name lab1 lab2 lab3 midTerm finalExam
#################################################################### **/

public class Main extends Object {
    public static void main(String[] args){
		try{
			new UI();
		}
		catch(NoSuchIDExceptions e){
			System.out.printf("ID���F!\n");
			//e.printStackTrace();
		}
		catch(NoSuchCommandExceptions e1){
			System.out.printf("���O���F!\n");
			//e1.printStackTrace();
		}
	}
}


