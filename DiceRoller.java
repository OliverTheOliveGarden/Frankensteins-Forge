import java.util.Random;

public class DiceRoller {
    
    Random rand = new Random();

    public int D4(){
        return rand.nextInt(1, 5);
    }
    
    public int D6(){
        return rand.nextInt(1, 7);
    }
    
    public int D10(){
        return rand.nextInt(1, 11);
    }
    
    public int D12(){
        return rand.nextInt(1, 13);
    }
    
    public int D20(){
        return rand.nextInt(1, 21);
    }
    
    public int D100(){
        return rand.nextInt(1, 101);
    }
    
}
