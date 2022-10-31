
public class Cafe extends Building {
    //defining variables to avoid constants being buried
    private int nCoffeeOunces;
    private int restockCoffeeOunces;
    private int lowThresholdCoffeeOunces;

    private int nSugarPackets;
    private int restockSugarPackets;
    private int lowThresholdSugarPackets;

    private int nCreams;
    private int restockCreams;
    private int lowThresholdCreams;

    private int nCups;
    private int restockCups;
    private int lowThresholdCups;

    //constructor for instances of cafes
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);

        this.nCoffeeOunces = nCoffeeOunces;
        this.restockCoffeeOunces = nCoffeeOunces;
        this.lowThresholdCoffeeOunces = nCoffeeOunces/10;

        this.nSugarPackets = nSugarPackets;
        this.restockSugarPackets = nSugarPackets;
        this.lowThresholdSugarPackets = nSugarPackets/10;

        this.nCreams = nCreams;
        this.restockCreams = nCreams;
        this.lowThresholdCreams = nCreams/10;

        this.nCups = nCups;
        this.restockCups = nCups;
        this.lowThresholdCups = nCups/10;

        System.out.println("You have built a cafe: ☕");
    }

    //getters for the inventory of an instance of a cafe
    public int getnCoffeeOunces(){
        return this.nCoffeeOunces;
    }
    public int getnSugarPackets(){
        return this.nSugarPackets;
    }
    public int getnCreams(){
        return this.nCreams;
    }
    public int getnCups(){
        return this.nCups;
    }
    
    //setters for the inventory of an instance of a cafe
    public int setnCoffeeOunces(int amtCoffeeOunces){ 
        return this.nCoffeeOunces = this.nCoffeeOunces - amtCoffeeOunces;
    }
    public int setnSugarPackets(int amtSugarPackets){ 
        return this.nSugarPackets = this.nSugarPackets - amtSugarPackets;
    }
    public int setnCreams(int amtCreams){ 
        return this.nCreams = this.nCreams - amtCreams;
    }
    public int setnCups(){
        return this.nCups = this.nCups - 1;
    }

    //sellCoffee method
    public void sellCoffee(int amtCoffeeOunces, int amtSugarPackets, int amtCreams){ //renamed for sell to be different from original inventory names
        setnCoffeeOunces(amtCoffeeOunces);
        setnSugarPackets(amtSugarPackets);
        setnCreams(amtCreams);
        setnCups();
        System.out.println("Successful sale of one " + amtCoffeeOunces + "-ounce coffee, with " + amtSugarPackets + " sugar packets, and " + amtCreams + " creams.");
        System.out.println();
        restock();
    }

    //restock method
    private void restock(){
        while (getnCoffeeOunces()<this.lowThresholdCoffeeOunces){  
            System.out.println("The coffee supply was down to " + this.nCoffeeOunces + " ounces, so we've restocked.");
            System.out.println();
            this.nCoffeeOunces = this.nCoffeeOunces + this.restockCoffeeOunces; 
        }
        while (getnSugarPackets()<this.lowThresholdSugarPackets){  
            System.out.println("The sugar supply was down to " + this.nSugarPackets + " packets, so we've restocked.");
            System.out.println();
            this.nSugarPackets = this.nSugarPackets + this.restockSugarPackets;
        }
        while (getnCreams()<this.lowThresholdCreams){  
            System.out.println("The cream supply was down to " + this.nCreams + ", so we've restocked.");
            System.out.println();
            this.nCreams = this.nCreams + this.restockCreams; 
        }
        while (getnCups()<this.lowThresholdCups){
            System.out.println("The cup supply was down to " + this.nCups + ", so we've restocked.");
            System.out.println();
            this.nCups = this.nCups + this.restockCups;
        }
    }

    //print inventory method
    public void getInventory(){
        System.out.println(getName() + " Inventory:");
        System.out.println(getnCoffeeOunces() + " ounces of coffee");
        System.out.println(getnSugarPackets() + " sugar packets");
        System.out.println(getnCreams() + " creams");
        System.out.println(getnCups() + " cups");
        System.out.println();
    }
    
    //main method for testing
    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive", 1, 35, 120, 120, 75);
        Cafe starbucks = new Cafe("Starbucks Coffee", "100 Industrial Road", 3, 600,200,200,3);
        
        System.out.println(compassCafe);
        System.out.println(starbucks);

        compassCafe.sellCoffee(34, 2, 3);
        compassCafe.getInventory();

        compassCafe.sellCoffee(12, 4, 0);
        starbucks.sellCoffee(1, 1, 1);

        compassCafe.getInventory();
        starbucks.getInventory();
    }
    
}
