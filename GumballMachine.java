

public class GumballMachine implements IGumballMachine {
 
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
 
    State state = soldOutState;
    int count,amount, slotCount = 0;
 
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } 
    }
 
    public void insertQuarter() {
        amount = amount + 25;
        System.out.println("You Inserted a Quarter. Balance is : " + amount);
        state.insertQuarter();
    }
    
    public void insertDime() {
        amount = amount + 10;
        System.out.println("You Inserted a Dime. Balance is : " + amount);
        state.insertQuarter();
    }
    
    public void insertNickel() {
        amount = amount + 5;
        System.out.println("You Inserted a Nickel. Balance is : " + amount);
        state.insertQuarter();
    }
 
    public void ejectQuarter() {
        System.out.println("Amount Returned : " + amount);
        amount = 0;
        state.ejectQuarter();
    }
 
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
    
    public void takeGumballFromSlot()
    {
        System.out.println("Gumballs taken from slot : " + slotCount);
        slotCount = 0;
    }
    
    public boolean isGumballInSlot()
    {
        if (slotCount > 0 )
            return true;
        else
            return false;
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
        slotCount = slotCount + 1;
        amount = amount - 50;
        System.out.println("Change returned : " + amount);
        amount = 0;
        System.out.println("Gumballs in slot : " + slotCount);
    }
 
    int getCount() {
        return count;
    }
    
    int getAmount(){
        return amount;
    }
    
    int getSlotCount()
    {
        return slotCount;
    }
 
    void refill(int count) {
        this.count = count;
        state = noQuarterState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
