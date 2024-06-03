import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.Scanner;
import java.io.FileReader;

// import java.awt.event.KeyEvent;
// import java.util.*;
// import java.io.*;
// import java.awt.print.PrinterJob;
// import javax.swing.event.CaretListener;
// import javax.swing.event.CaretEvent;
// import java.net.*;
// import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;
// import java.awt.event.MouseAdapter;

public class Editor implements ActionListener {
    // public JTestArea page;
    // public JFrame frame;
    // public String path="";
    // JTextField findText, replaceText;
    // JLabel statusBar;
    // int linenum = 1, word=1, columnnum = 1, linenumber, columnnumber;
    // String text="", words[];
    // JPanel panel;
    JFrame frame;
    JTextArea area;
    JMenu fileMenu;
    JMenuItem newPage;
    JMenuItem openFile;
    int count;

    public Editor(){
        frame = new JFrame();
        // frame.setForeground(color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // To close the console window on exit of the window
        frame.setLocation(new Point(400, 100)); // To set the default location to anywhere on the window
        frame.setSize(new Dimension(500, 300));
        frame.setTitle("Text Editor");  // To set the title of the window;
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("1695711686865.jpg"));
        frame.setLayout(new BorderLayout());

        area = new JTextArea(25, 50);
        area.setFont(new Font("Serif", Font.BOLD, 14));
        frame.add(new JScrollPane(area));

        JMenuBar menuContainer = new JMenuBar();    // The bar where the menu can be placed
        fileMenu = new JMenu("File");

        newPage = new JMenuItem("New", 'N');
        newPage.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(), false));
        newPage.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                count +=1;
                area.setText("");
            }
        });

        JMenuItem openMenu = new JMenuItem("Open", 'O');
        openMenu.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit(). getMenuShortcutKeyMask(), false));
        openMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JFileChooser fopen = new JFileChooser();
                int option = fopen.showOpenDialog(frame);
                int fileToOpen = option;
                JFileChooser fileOpen = fopen;
                if(fileToOpen == JFileChooser.APPROVE_OPTION)
                {
                    area.setText("");
                    try{
                        Scanner scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
                        while(scan.hasNext()){
                            area.append(scan.nextLine()+"\n");
                        }
                        frame.setTitle(fileOpen.getSelectedFile().getPath() + "- Editor");
                        // path = fileOpen.getSelectedFile().getPath();
                    }catch( Exception ex ){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });



        fileMenu.add(newPage);
        menuContainer.add(fileMenu);

        frame.add(menuContainer, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args){
        Editor ce = new Editor();
    }


}
