package action;

import java.time.LocalDateTime;

public class Action {
    private int actionId;
    private LocalDateTime localDateTime;
    private int lineNumber;
    private String text;
    private boolean isAddition;

    public Action(int id, LocalDateTime l, int ln, String t, boolean a){
        this.actionId=id;
        this.localDateTime = l;
        this.lineNumber = ln;
        this.text = t;
        this.isAddition = a;
    }

    public int getActionId(){
        return this.actionId;
    }

    public void setActionId(int aid){
        this.actionId = aid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAddition() {
        return isAddition;
    }

    public void setAddition(boolean isAddition) {
        this.isAddition = isAddition;
    }

    public int getLineNumber(){
        return this.lineNumber;
    }

    public void setLineNumber(int n){
        this.lineNumber = n;
    }
    
}
