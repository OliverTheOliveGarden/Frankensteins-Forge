package utils;


import java.util.Random;

public class DiceRoller {
    
    Random rand = new Random();

    /**
     * Rolls a d4
     * 
     * @return the roll's result
     */
    public int D4(){
        return rand.nextInt(1, 5);
    }
    
    /**
     * Rolls a d6
     * 
     * @return the roll's result
     */
    public int D6(){
        return rand.nextInt(1, 7);
    }
    
    /**
     * Rolls a d10
     * 
     * @return the roll's result
     */
    public int D10(){
        return rand.nextInt(1, 11);
    }
    
    /**
     * Rolls a d12
     * 
     * @return the roll's result
     */
    public int D12(){
        return rand.nextInt(1, 13);
    }
    
    /**
     * Rolls a d20
     * 
     * @return the roll's result
     */
    public int D20(){
        return rand.nextInt(1, 21);
    }
    
    /**
     * Rolls a d100
     * 
     * @return the roll's result
     */
    public int D100(){
        return rand.nextInt(1, 101);
    }
    
}
