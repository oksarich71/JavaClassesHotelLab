public class Guest {
    private String name;
    private int wallet;

    public Guest(String name, int wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public int wallet(){
        return this.wallet;
    }

    public void payBill(int bill){
        if (this.wallet >= bill){
            this.wallet -= bill;
        }else{
            System.out.println("You owe us money");
        }
    }
}
