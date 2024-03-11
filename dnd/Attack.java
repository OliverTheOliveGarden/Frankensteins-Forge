public class Attack {
    public String name;
    public String atkDice;
    public int numOfAtkDice;
    public String damgeType;
    public int atkBonus;
    
    Attack(String name,String atkDice,int numOfAtkDice,String damgeType,int atkBonus) {
        this.name = name;
        this.atkDice = atkDice;
        this.numOfAtkDice = numOfAtkDice;
        this.damgeType = damgeType;
        this.atkBonus = atkBonus;
    }

    public void UpdateVars(String name,String atkDice,int numOfAtkDice,String damgeType,int atkBonus) {
        this.name = name;
        this.atkDice = atkDice;
        this.numOfAtkDice = numOfAtkDice;
        this.damgeType = damgeType;
        this.atkBonus = atkBonus;
    }

    public String toString() {
        if (atkBonus == 0) {
            return "Name: " + name + ", Damage: " + numOfAtkDice + atkDice + ", Damge Type: " + damgeType;
        } else if (atkBonus > 0) {
            return "Name: " + name + ", Damage: " + numOfAtkDice + atkDice + "+" + atkBonus + ", Damge Type: " + damgeType;
        } else {
            return "Name: " + name + ", Damage: " + numOfAtkDice + atkDice + atkBonus + ", Damge Type: " + damgeType;
        } 
    }
}
