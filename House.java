import java.util.ArrayList;

public class House extends Building {

  ArrayList<String> residents = new ArrayList<String>();
  boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDR) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDR;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }
  public int nResidents(){
    return this.residents.size();
  }
  public void moveIn(String residentName){
    residents.add(residentName);
  }
  public void moveOut(String residentName){
    residents.remove(residentName);
    System.out.println(residentName + " moved out of " + getName()); //directions said to return the name moved out. means print?
  }
  public boolean isResident(String residentName){
    boolean isResident = residents.contains(residentName);
    return isResident;
  }
  
  public static void main(String[] args) {
    House emersonHouse = new House("Emerson", "1 Paradise Lane", 4, true);
    System.out.println(emersonHouse);
    //emersonHouse.moveIn("Xochitl Krumbiegel"); 
    //System.out.println(emersonHouse.nResidents()); 
    //System.out.println(emersonHouse.isResident("Xochitl Krumbiegel"));
  }
}