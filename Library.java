import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  //updating collection
  public void addTitle(String title){
    collection.put(title, true);
  }
  public String removeTitle(String title){
    collection.remove(title);
    return title + " has been removed from the collection";
  }

  //updating title status
  public void checkOut(String title){
    collection.replace(title, false);
  }
  public void returnTitle(String title){
    collection.replace(title, true);
  }

  //browsing titles
  public boolean containsTitle(String title){
    boolean containsTitle = collection.contains(title);
    return containsTitle;
  }
  public boolean isAvailable(String title){
    boolean isAvailable = collection.get(title); 
    return isAvailable;
  }
  
  //print collection's contents and status
  public void printCollection(){
    System.out.println(collection.toString());
  }

  public static void main(String[] args) {
    Library neilsonLibrary = new Library("Neilson Library", "7 Neilson Drive", 5);
    System.out.println(neilsonLibrary);
    neilsonLibrary.addTitle("Where the Crawdads Sing");
    neilsonLibrary.printCollection(); 
    neilsonLibrary.checkOut("Where the Crawdads Sing");
    System.out.println(neilsonLibrary.isAvailable("Where the Crawdads Sing"));
    }
  }