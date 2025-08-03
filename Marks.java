import java.util.Scanner;

public class Marks
{

	static int [][] studentMarks;
	static int n;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of the students:");
		n = input.nextInt();

		studentMarks = new int[n][3];
                

		while(true)
		{
			System.out.println("                       ");
                        System.out.println("-----COMMANDS-----");
			System.out.println("1.ADD[studentID]");
			System.out.println("2.UPDATE[studentID][subjectID]");
			System.out.println("3.Total[studentID]");
			System.out.println("4.Avarage_Subject[subjectID]");
			System.out.println("5.Avarage_Student[studentID]");
			System.out.println("6.Grades");
			System.out.println("7.Exit");

			System.out.print("\n Enter Command(THE NUMBER INFRONT OF COMMAND):");
			String com = input.next();
			
			if(com.equals("1"))
			{
			    System.out.println("Enter the student ID:");
			    int studentID = input.nextInt() -1;
			    System.out.println("Enter the marks for the three Subject(Maths , Physics , Chemistry in order):");
			    for(int i = 0; i < 3; i++)
			    {
			        studentMarks[studentID][i] = input.nextInt();
			    }
			}
			else if(com.equals("2"))
			{
			    System.out.print("Enter the student ID:");
			    int studentID = input.nextInt() - 1;
			    System.out.print("Enter the subject ID(1.Maths , 2.Physics  , 3.Chemistry):");
			    int subjectID = input.nextInt() - 1;
			    System.out.print("Enter the new marks :");
			    int newMarks = input.nextInt();
			    studentMarks[studentID][subjectID] = newMarks;
			}
			else if(com.equals("3"))
			{
			    System.out.print("Enter the student ID:");
			    int studentID = input.nextInt() - 1;
			    int sum = 0 ;
			    for(int i = 0; i < 3; i++)
			    {
			          sum += studentMarks[studentID][i];
			    }
			    System.out.println("Total marks for " + (studentID + 1)  + "  student is" + ":" + sum);
			}
			else if(com.equals("4"))
			{   
			    double avg_Sub = 0;
			    System.out.print("Enter the subject you want Average(1.Maths 2.Physics 3.Chemistry):  ");
			    int subjectID = input.nextInt() - 1;
			    for(int i = 0; i < n; i++)
			    {
			        avg_Sub += studentMarks[i][subjectID];			    
			    }
			    System.out.println("Avarage marks for subject  " + (subjectID + 1) +" "+ "is "+":" + (avg_Sub/n));
			}
			else if(com.equals("5"))
			{
			    double avg_Std = 0;
			    System.out.print("Enter the studentID of the student :  ");
			    int studentID = input.nextInt() - 1;
			    for(int i = 0; i < 3; i++)
			    {
			        avg_Std += studentMarks[studentID][i];			    
			    }
			    System.out.println("Avarage marks for student  " + (studentID + 1) +" "+ "is "+":" + (avg_Std/n));
			}
			else if(com.equals("6"))
			{
			    System.out.println("\n================== STUDENT GRADES ==================");
                System.out.printf("%-10s %-10s %-10s %-10s\n", "Student", "Maths", "Physics", "Chemistry");

                for (int i = 0; i < n; i++) {
                    String mGrade = Sub_Grade(studentMarks[i][0]);
                    String pGrade = Sub_Grade(studentMarks[i][1]);
                    String cGrade = Sub_Grade(studentMarks[i][2]);
                    System.out.printf("%-10s %-10s %-10s %-10s\n", "Student" + (i + 1), mGrade, pGrade, cGrade);
                }
                System.out.println("====================================================");

			}
			else if(com.equals("7"))
			{
			    break;
			}
			else
			{
			    System.out.println("Invalid Input!");
			}
			
		}
		
		input.close();
	
	}
    public static String Sub_Grade(int score)
    {
        if (score >= 90) return "Grade A";
        else if (score >= 80) return "Grade B";
        else if (score >= 70) return "Grade C";
        else if (score >= 60) return "Grade D";
        else return "Fail";
    }
}