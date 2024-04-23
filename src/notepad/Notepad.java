package notepad;
import action.Action;

import java.time.LocalDateTime;
import java.util.*;

public class Notepad{
    private int id;
    private String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private Queue<String> clipBoard;
    private int capacity;

    public Notepad(int capacity){
        notepad = new String[capacity];

        for (int i=0; i<capacity; i++){
            notepad[i]="";
        }

        undoAction = new Stack<>();
        redoAction = new Stack<>();
        clipBoard = new LinkedList<>();
        this.capacity = capacity;
    }


    public void display(){
        for (int i=0; i<this.capacity; i++){
            System.out.println("Line " + (i+1) + ": "+ notepad[i]);
        }
    }

    public void displayGivenLines(int a, int b){
        if (a<=0 || a>b || b>this.capacity){
            System.out.println("Unable to display text, please check the input");
            return;
        }

        for (int i=a-1; i<b; i++){
            System.out.println(notepad[i]);
        }
    }

    public void insertInGivenLine(int ln,String text){ 
        if (ln<=0 || ln>this.capacity){
            System.out.println("Invalid area Can't insert data there");
            return;
        }

        notepad[ln-1]=text;
        undoAction.push(new Action( id++ , LocalDateTime.now(), ln, text,true));
    }

    public void insertMultipleLines(int a, int b, String lines[]){
        if (a<=0 || a>b || b>this.capacity){
            System.out.println("Unable to insert text, please check the input");
            return;
        }
        int t=0;
        for (int i=a; i<=b; i++){
            insertInGivenLine(i, lines[t]);
            t++;
        }
    }

    public void deleteGivenLine(int ln){
        if (ln<=0 || ln>this.capacity){
            System.out.println("Invalid area Can't delete data from there");
            return;
        }
        if (notepad[ln-1]==""){
            System.out.println("Can't delete anything!! It's already empty");
            return;
        }
        redoAction.push(new Action(id++, LocalDateTime.now(), ln, notepad[ln-1] , false));
        notepad[ln-1]="";
    }


    public void deleteMultipleLines(int a, int b){
        if (a<=0 || a>b || b>this.capacity){
            System.out.println("Unable to delete text, please check the input");
            return;
        }

        for (int i=a; i<=b; i++){
            deleteGivenLine(i);
        }
    }


    public void copyLines(int a, int b){
        if (a<=0 || b>this.capacity){
            System.out.println("Unable to copy text, please check the input");
            return;
        }
        String copytext = "";
        for (int i=a-1; i<b; i++){
            copytext+=(notepad[i]+"\n");
        }
        if (!copytext.isEmpty()){
            clipBoard.add(copytext);
        }
    }

    public void pasteLines(int ln){
        if (clipBoard.isEmpty()) System.out.println("Nothing is there to paste");
        String text = clipBoard.peek();
        insertInGivenLine(ln,text);
    }

    public void undoOperation(){
        if (this.undoAction.isEmpty()){
            System.out.println("No action is performed yet");
            return;
        }

        Action action = this.undoAction.pop();
        deleteGivenLine(action.getLineNumber());
    }

    public void redoOperation(){
        if (this.redoAction.isEmpty()){
            System.out.println("No action is performed yet");
            return;
        }

        Action action = this.redoAction.pop();
        insertInGivenLine(action.getLineNumber(), action.getText());
    }

}