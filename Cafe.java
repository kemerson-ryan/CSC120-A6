/**
 * Cafe class extends Building class
 * no outside sources used
 * @author Ryan (K) Emerson
 * @version October 31, 2022
 */
public class Cafe extends Building {
    /**
     * Allocating space for variables used throughout Cafe class
     */
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

    /**
     * Constructor of Cafe instances
     * @param name of cafe
     * @param address of cafe
     * @param number of floors in cafe
     * @param number of Coffee Ounces initially stocked at the cafe
     * @param number of Sugar Packets initially stocked at the cafe
     * @param number of Creams initially stocked at the cafe
     * @param number of Cups initially stocked at the cafe
     */
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

    /**
     * Getter of number of Coffee Ounces in stock
     * @return number of coffee ounces in stock
     */
    public int getnCoffeeOunces(){
        return this.nCoffeeOunces;
    }
    /**
     * Getter of number of Sugar packets in stock
     * @return number of sugar packets in stock
     */
    public int getnSugarPackets(){
        return this.nSugarPackets;
    }
    /**
     * Getter of number of Creams in stock
     * @return number of creams in stock
     */
    public int getnCreams(){
        return this.nCreams;
    }
    /**
     * Getter of number of Cups in stock
     * @return number of cups in stock
     */
    public int getnCups(){
        return this.nCups;
    }
    
    /**
     * Setting number of Coffee Ounces left in stock after a purchase
     * @param amount of coffee ounces purchased in transaction
     * @return number of coffee ounces left in stock after purchase
     */
    public int setnCoffeeOunces(int amtCoffeeOunces){ 
        return this.nCoffeeOunces = this.nCoffeeOunces - amtCoffeeOunces;
    }
    /**
     * Setting number of Sugar Packets left in stock after a purchase
     * @param amount of sugar purchased in transaction
     * @return number of sugar left in stock after purchase
     */
    public int setnSugarPackets(int amtSugarPackets){ 
        return this.nSugarPackets = this.nSugarPackets - amtSugarPackets;
    }
    /**
     * Setting number of Creams left in stock after a purchase
     * @param amount of creams purchased in transaction
     * @return number of cream left in stock after purchase
     */
    public int setnCreams(int amtCreams){ 
        return this.nCreams = this.nCreams - amtCreams;
    }
    /**
     * Decreases number of cups by 1 after each coffee sold
     * @return number of cups left in stock
     */
    public int setnCups(){
        return this.nCups = this.nCups - 1;
    }

    /**
     * Use setters to remove supplies from inventory with each purchase, and calls restock method after sale
     * @param amount Coffee purchased
     * @param amount Sugar purchased
     * @param amount Cream purchased
     */
    public void sellCoffee(int amtCoffeeOunces, int amtSugarPackets, int amtCreams){ //renamed for sell to be different from original inventory names
        setnCoffeeOunces(amtCoffeeOunces);
        setnSugarPackets(amtSugarPackets);
        setnCreams(amtCreams);
        setnCups();
        System.out.println("Successful sale of one " + amtCoffeeOunces + "-ounce coffee, with " + amtSugarPackets + " sugar packets, and " + amtCreams + " creams.");
        System.out.println();
        restock();
    }

    /**
     * Private method to restock supplies when inventory in instance of cafe low
     */
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

    /**
     * Prints inventory of supplies in cafe instance
     */
    public void getInventory(){
        System.out.println(getName() + " Inventory:");
        System.out.println(getnCoffeeOunces() + " ounces of coffee");
        System.out.println(getnSugarPackets() + " sugar packets");
        System.out.println(getnCreams() + " creams");
        System.out.println(getnCups() + " cups");
        System.out.println();
    }
    
    /**
     * Main method for testing
     * @param args
     */
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
