
public class Cafe extends Building {

    private int nCoffeeOunces; //why are these private...what am i supposed to do differently
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    public void sellCoffee(int amtCoffeeOunces, int amtSugarPackets, int amtCreams){ //renamed for sell to be different from original inventory names
        restock();
        nCoffeeOunces = nCoffeeOunces-amtCoffeeOunces;
        nSugarPackets = nSugarPackets-amtSugarPackets;
        nCreams = nCreams-amtCreams;
        nCups = nCups-1;
    }

    public void getInventory(){
        System.out.println(nCoffeeOunces);
        System.out.println(nSugarPackets);
        System.out.println(nCreams);
        System.out.println(nCups);
    }

    //restocking supplies when reaching lower barriers defined
    private void restock(){
        while(nCoffeeOunces<96){
            nCoffeeOunces = nCoffeeOunces+960;
        } 
        while(nSugarPackets<12){
            nSugarPackets = nSugarPackets+120;
        }
        while(nCreams<12){
            nCreams = nCreams+120;
        }
        while(nCups<1){
            nCups = nCups+75;
        }
    }
    
    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive", 1, 960, 120, 120, 75);
        System.out.println(compassCafe);
        compassCafe.sellCoffee(900, 2, 3);
        compassCafe.sellCoffee(900, 2, 3);
        compassCafe.getInventory();
    }
    
}
