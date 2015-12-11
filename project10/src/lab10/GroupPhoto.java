package lab10;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 * This class displays a bunch of portraits in a scrollable window.
 */
public class GroupPhoto extends JFrame {

  // You may want to reduce the height if you're on a netbook...
  private static final int WIDTH = 800;
  private static final int HEIGHT = 800;
  
  public static void main(String[] args) {
    final ArrayList<Portrait> portraits = new ArrayList<Portrait>();
    // Chris Johnson's self-portrait
    portraits.add(new Portrait0CRJ());

    // Replace these constructor calls with calls to constructors
    // for other students' code you download from Piazza
    portraits.add(new Portrait14MTL());
    portraits.add(new Portrait14CP());
    portraits.add(new Portrait14AT());
    
    // Boilerplate code for starting any Swing application
    Runnable r = new Runnable()
    {
      public void run()
      {
        createAndShow(portraits);
      }
    };
    SwingUtilities.invokeLater(r);
 }

  
   public GroupPhoto(ArrayList<Portrait> portraits) {
      super("Our Family");

      // Create a gridded panel having enough spots for every portrait.
      // Portraits are arranged in a square.
      JPanel panel = new JPanel();
      int root = (int) Math.ceil(Math.sqrt(portraits.size()));
      panel.setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      for (Portrait p : portraits) {
         constraints.gridx = (constraints.gridx + 1) % root;
         panel.add(p, constraints);
      }

      // We'll someday have enough portraits that our window won't be big
      // enough, so let's give it scrollbars.
      JScrollPane scroller = new JScrollPane(panel);
      add(scroller);
   }

   
   private static void createAndShow(ArrayList<Portrait> portraits)
   {
     JFrame frame = new GroupPhoto(portraits);     
     frame.setSize(WIDTH, HEIGHT);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
   }
   
}