/**
 * Constructs and describes functions of Building Objects
 */
public class Building {

    /**
     * Allocates space for private variables name, address, and number of floors of buildings
     */
    private String name = "<Name Unknown>";
    private String address = "<Address Unknown>";
    private int nFloors = 1;

    /**
     * Constructor of Building instances
     * @param name of building
     * @param address of building
     * @param number of Floors in building
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Getter for name
     * @return name of instance-specific building
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for address
     * @return address of instance-specific building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Getter for nFloors
     * @return number of floors in instance-specific building
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Redefines toString() function so that print(building name) prints descriptive message about that building
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    /**
     * Main method for testing
     * @param args
     */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}