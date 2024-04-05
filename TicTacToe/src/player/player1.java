package player;

public class player1 {
    private String name;
    private char symbol;
    private String address;
    private long contactnumber;
    private String emailid;
    private int age;

    public void setplayerdetails(String name,char symbol,String address,long contactnumber,String emailid,int age){
        this.name=name;
        this.symbol=symbol;
        this.address=address;
        this.contactnumber=contactnumber;
        this.emailid=emailid;
        this.age=age;
    }

    public void setplayernameandsymbol(String name,char symbol){
        this.name =name;
        this.symbol = symbol;
    }

    public void setplayersymbolandemailidage(String name,char symbol,String emailid, int age){
        this.name = name;
        this.symbol = symbol;
        this.emailid= emailid;
        this.age = age;
    }

    public String getPlayerName(){
        return this.name;
    }

    public char getPlayerSymbol(){
        return this.symbol;
    }

    public void getPlayerNameAndSymbol() {
        System.out.println("Player Name: " + this.name);
        System.out.println("Player Symbol: " + this.symbol);
    }


    public void getPlayerNameAndAge() {
        System.out.println("Player Name: " + this.name);
        System.out.println("Player Age: " + this.age);
    }

    public void getPlayerDetails(){
        System.out.println("Player's Name: "+ this.name);
        System.out.println("Player's Symbol: "+ this.symbol);
        System.out.println("Player's Address: "+ this.address);
        System.out.println("Player's Contact Number: "+ this.contactnumber);
        System.out.println("Player's Emailid: "+ this.emailid);
        System.out.println("Player's Age: "+ this.age);
    }
}


