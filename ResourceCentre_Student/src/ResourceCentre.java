import java.util.ArrayList;

public class ResourceCentre {

  public static void main(String[] args) {

    ArrayList<Camcorder> camcorderList = new ArrayList<Camcorder>();
    ArrayList<Chromebook> chromebookList = new ArrayList<Chromebook>();

    camcorderList.add(new Camcorder("CC001", "Sony HDR-CX405", 35));
    camcorderList.add(new Camcorder("CC002", "Panasonic HC-MDH2", 10));
    chromebookList.add(new Chromebook("CB001", "ASUS Chromebook ", "Win 10"));
    chromebookList.add(new Chromebook("CB002", "HP Chromebook", "Win 10"));

    int option = 0;

    while (option != 5) {

      ResourceCentre.menu();
      option = Helper.readInt("Enter an option > ");

      if (option == 1) {
        // View all items
        ResourceCentre.viewAllCamcorder(camcorderList);
        ResourceCentre.viewAllChromebook(chromebookList);

      } else if (option == 2) {
        // Add a new item
        ResourceCentre.setHeader("ADD");      
        ResourceCentre.setHeader("ITEM TYPES");
        System.out.println("1. Camcorder");
        System.out.println("2. Chromebook");
        
        int itemType = Helper.readInt("Enter option to select item type > ");

        if (itemType == 1) {
          // Add a camcorder
          Camcorder cc = inputCamcorder();
          ResourceCentre.addCamcorder(camcorderList, cc);
          System.out.println("Camcorder added");

        } else if (itemType == 2) {
          // Add a Chromebook
          Chromebook cb = inputChromebook();
          ResourceCentre.addChromebook(chromebookList, cb);
          System.out.println("Chromebook added");

        } else {
          System.out.println("Invalid type");
        }

      } else if (option == 3) {
        // Loan itemss
        ResourceCentre.setHeader("LOAN");      
        ResourceCentre.setHeader("ITEM TYPES");
        System.out.println("1. Camcorder");
        System.out.println("2. Chromebook");
        
        int itemType = Helper.readInt("Enter option to select item type > ");

        if (itemType == 1) {
          // Loan camcorder
          ResourceCentre.loanCamcorder(camcorderList);
        } else if (itemType == 2) {
          // Loan Chromebook
          ResourceCentre.loanChromebook(chromebookList);
        } else {
          System.out.println("Invalid type");
        }

      } else if (option == 4) {
        // Return item
        ResourceCentre.setHeader("RETURN");        
        ResourceCentre.setHeader("ITEM TYPES");
        System.out.println("1. Camcorder");
        System.out.println("2. Chromebook");
        
        int itemType = Helper.readInt("Enter option to select item type > ");
        if (itemType == 1) {
          // Return camcorder
          ResourceCentre.returnCamcorder(camcorderList);
        } else if (itemType == 2) {
          // Return Chromebook
          ResourceCentre.returnChromebook(chromebookList);
        } else {
          System.out.println("Invalid type");
        }

      } else if (option == 5) {
        System.out.println("Bye!");
      } else {
        System.out.println("Invalid option");
      }

    }

  }

  public static void menu() {
    ResourceCentre.setHeader("RESOURCE CENTRE APP");
    System.out.println("1. Display Inventory");
    System.out.println("2. Add item");
    System.out.println("3. Loan item");
    System.out.println("4. Return item");
    System.out.println("5. Quit");
    Helper.line(80, "-");

  }
  
  public static void setHeader(String header) {
    Helper.line(80, "-");
    System.out.println(header);
    Helper.line(80, "-");
  }

  public static String showAvailability(boolean isAvailable) {
    String avail;

    if (isAvailable == true) {
      avail = "Yes";
    } else {
      avail = "No";
    }
    return avail;
  }
}