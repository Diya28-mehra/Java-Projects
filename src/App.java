import java.util.*;
import notepad.Notepad;
import action.Action;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Notepad notepad = new Notepad(100);

        do{
            System.out.println("Choose your option");
            System.out.println("1. Display the text");
            System.out.println("2. Display the text of given lines");
            System.out.println("3. Insert the text");
            System.out.println("4. Insert the text in multiple lines");
            System.out.println("5. Delete the text");
            System.out.println("6. Delete from given lines");
            System.out.println("7. Copy the text");
            System.out.println("8. Paste the text");
            System.out.println("9. Undo your action");
            System.out.println("10. Redo your action");
            System.out.println("11. Exit");

            System.out.println("Enter the choice");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    notepad.display();
                    break;
                case 2:
                    System.out.println("Enter the starting and the ending value of lines");
                    int sl1 = sc.nextInt();
                    int el1 = sc.nextInt();
                    notepad.displayGivenLines(sl1,el1);
                    break;
                case 3:
                    System.out.println("Enter the line number:");
                    int lineNumber = sc.nextInt();
                    System.out.println("Write the text you want to insert:");
                    sc.nextLine();
                    String text = sc.nextLine(); 
                    notepad.insertInGivenLine(lineNumber, text);
                    break;
                case 4:
                    System.out.println("Enter the starting and the ending value of lines");
                    int sl2 = sc.nextInt();
                    int el2 = sc.nextInt();
                    sc.nextLine();
                    
                    String lines[] = new String[el2 - sl2 + 1];
                    System.out.println("Enter the text line by line you want to insert:");
                    for (int i = 0; i <= el2 - sl2; i++) {
                        lines[i] = sc.nextLine();
                    }
                    
                    notepad.insertMultipleLines(sl2, el2, lines);
                    break;               
                case 5:
                    System.out.println("Enter the line number from where you want to delete the text");
                    int l = sc.nextInt();
                    notepad.deleteGivenLine(l);
                    break;
                case 6:
                    System.out.println("Enter the starting and the ending value of lines");
                    int sl3 = sc.nextInt();
                    int el3 = sc.nextInt();
                    notepad.deleteMultipleLines(sl3,el3);
                    break;
                case 7:
                    System.out.println("Enter the line from where till where you want to copy the text");
                    int sl4 = sc.nextInt();
                    int el4 = sc.nextInt();
                    notepad.copyLines(sl4, el4);
                    break;
                case 8:
                    System.out.println("Enter the line where you want to paste the text");
                    int lnn = sc.nextInt();
                    notepad.pasteLines(lnn);
                    break;
                case 9:
                    notepad.undoOperation();
                    break;
                case 10:
                    notepad.redoOperation();
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while(true);
    }
}
