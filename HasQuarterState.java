

import java.util.Random;

public class HasQuarterState implements State {
    GumballMachine gumballMachine;
 
    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
  
    public void insertQuarter() {
        System.out.println("You inserted one more coin");
    }
 
    public void ejectQuarter() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
 
    public void turnCrank() {
        System.out.println("You turned...");
        if (gumballMachine.getAmount() >= 50 )
        {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
        else
            System.out.println("But no sufficient money!");
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "waiting for turn of crank";
    }
}
