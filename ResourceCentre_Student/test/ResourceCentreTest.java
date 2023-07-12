import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// C206 AY2023 SEM1 - Eclipse 21-09 JDK16

public class ResourceCentreTest {
  // prepare test data
  private Camcorder cc1;
  private Camcorder cc2;
  private Camcorder cc3;
  private Chromebook cb1;
  private Chromebook cb2;
  private Chromebook cb3;

  private ArrayList<Camcorder> camcorderList;
  private ArrayList<Chromebook> chromebookList;

  public ResourceCentreTest() {
    super();
  }

  @Before
  public void setUp() throws Exception {
    // prepare test data
    cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
    cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
    cc3 = new Camcorder("CC0013", "panasoni DSC-RX100M7", 30);
    cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
    cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");
    cb3 = new Chromebook("CB0013", "HUAWEI Magicbook 100+", "Mac 10");

    camcorderList= new ArrayList<Camcorder>();
    chromebookList= new ArrayList<Chromebook>();
  }


  @Test
  public void testAddCamcorder() {
    // Item list is not null and it is empty
    assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
    assertEquals("Test that the Camcorder arraylist is empty.", 0, camcorderList.size());
    //Given an empty list, after adding 1 item, the size of the list is 1
    ResourceCentre.addCamcorder(camcorderList, cc1);    
    assertEquals("Test that the Camcorder arraylist size is 1.", 1, camcorderList.size());

    
    // Add an item
    ResourceCentre.addCamcorder(camcorderList, cc2);
    assertEquals("Test that the Camcorder arraylist size is now 2.", 2, camcorderList.size());
    //The item just added is as same as the last item in the list
    assertSame("Test that Camcorder is added to the end of the list.", cc2, camcorderList.get(1));

    // Add an item that already exists in the list
    ResourceCentre.addCamcorder(camcorderList, cc2);
    assertEquals("Test that the Camcorder arraylist size is unchange.", 2, camcorderList.size());

    // Add an item that has missing detail
    Camcorder cc_missing = new Camcorder("CC0014", "", 60);
    ResourceCentre.addCamcorder(camcorderList, cc_missing);
    assertEquals("Test that the Camcorder arraylist size is unchange.", 2, camcorderList.size());
  }

  @Test
  public void testAddChromebook() {
    //fail("Not yet implemented");
    // write your code here 
    assertNotNull("Test if there is a valid Chromebook arraylist to add to", chromebookList);
      assertEquals("Test that the Chromebook arraylist is empty.", 0, chromebookList.size());
    //Given an empty list, after adding 1 item, the size of the list is 1
      ResourceCentre.addChromebook(chromebookList, cb1);
      assertEquals("Test that the Chromebook arraylist size is 1.", 1, chromebookList.size());
      
    
    //Add an items
      ResourceCentre.addChromebook(chromebookList, cb2);
      assertEquals("Test that the Chromebook arraylist size is now 2.", 2, chromebookList.size());
      assertSame("Test that Chromebook is added to the end of the list.", cb2, chromebookList.get(1));
    
    // Add an item that already exists in the list
      ResourceCentre.addChromebook(chromebookList, cb2);
      assertEquals("Test that the Chromebook arraylist size is unchanged.", 2, chromebookList.size());
  }
}