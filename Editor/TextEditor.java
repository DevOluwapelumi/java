import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;
import java.awt.print.PrinterJob;
import javax.swing.event.CaretListener;

// import Exception;

import javax.swing.event.CaretEvent;
// import javax.swing.JOptionPane;
import java.net.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
                                                        
public class TextEditor implements ActionListener, CaretListener{
	public JTextArea page;
    public JFrame frame;
    public String path="";
    JTextField findText, replaceText;
    JLabel statusBar;
    int linenum = 1, word=1, columnnum = 1, linenumber, columnnumber;
    String text="", words[];
    JPanel panel;
	/**
	 * 
	 */
	public TextEditor(){
        splash();
        //create the main window
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setLayout(new BorderLayout());
      	frame.setTitle("TextEditor");
     
      	JMenuBar menuContainer = new JMenuBar();
      	JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

      	JMenuItem newPage = new JMenuItem("New");
      	newPage.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit( ).getMenuShortcutKeyMaskEx( ), false));
      	newPage.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                  page.setText("");
                }
                  
            });
        fileMenu.add(newPage);
        menuContainer.add(fileMenu);
        
      JMenuItem open = new JMenuItem("Open");
    	open.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit( ).getMenuShortcutKeyMaskEx( ), false));
    	open.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	JFileChooser fopen = new JFileChooser();
                int option = fopen.showOpenDialog(frame);
                int fileToOpen = option;
                JFileChooser fileOpen = fopen;
                    if(fileToOpen == JFileChooser.APPROVE_OPTION)
                {
                    page.setText("");
                    try{
                        Scanner scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
                        while(scan.hasNext()){
                            page.append(scan.nextLine()+"\n");
                        } 
                        
                        frame.setTitle(fileOpen.getSelectedFile().getPath() + "- TextEditor");
                        path = fileOpen.getSelectedFile().getPath();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        fileMenu.add(open);
            
        JMenuItem save = new JMenuItem("Save");
      	save.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit( ).getMenuShortcutKeyMaskEx( ), false));
      	save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	if (path.equals("")){
            		saveAsFile();
              	}
              	else{
              		saveFile();
              	}
            }
          });
            fileMenu.add(save);

        JMenuItem saveAs = new JMenuItem("SaveAs");
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.ALT_DOWN_MASK));
        saveAs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	saveAsFile();
            }
          });
        fileMenu.add(saveAs);
        menuContainer.add(fileMenu);

        fileMenu.addSeparator();

        JMenuItem pageSetup = new JMenuItem("Page Setup");
        pageSetup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK|

          ActionEvent.ALT_MASK));
        pageSetup.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                PrinterJob  pj = PrinterJob.getPrinterJob();
                pj.pageDialog(pj.defaultPage());
            }
          });
        fileMenu.add(pageSetup);

        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        print.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                PrinterJob  pj = PrinterJob.getPrinterJob();
                    if(pj.printDialog()){
                        try{
                            pj.print();
                        }
                        catch(Exception e){
                            System.out.print(e);
                        }
                    }         
            }
        });
        fileMenu.add(print);

        JMenuItem window = new JMenuItem("New Window");
        window.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
        window.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                new TextEditor();        
            }
        });
        fileMenu.add(window);

        fileMenu.addSeparator();

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.ALT_MASK));
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                int option = JOptionPane.showConfirmDialog(null, "Do you wish to save?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
                if (option == 0){
                    if(path == null){
                        saveAsFile();
                    }
                    else{
                        saveFile();
                    }   
                    System.exit(0);
                }
                else if(option == 1){
                    System.exit(0);
                }        
            }
        });
        fileMenu.add(exit);

        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);

        JMenuItem undo = new JMenuItem("Undo");
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
              
            }
                  
        });
        editMenu.add(undo);

        JMenuItem redo = new JMenuItem("Redo");
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        redo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
              
            }
                  
        });
        editMenu.add(redo);

        editMenu.addSeparator();

        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                page.cut();
            }
                  
        });
        editMenu.add(cut);

        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                page.copy();
            }
                  
        });
        editMenu.add(copy);

        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        paste.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                page.paste();
            }
                  
        });
        editMenu.add(paste);

        editMenu.addSeparator();

        JMenuItem delete = new JMenuItem("Delete");
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                try{
                    String text = page.getSelectedText();
                    int n = page.getText().indexOf(text); 
                    page.replaceRange("", n, n+text.length());
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No text is selected");
                }

            }
                  
        });
        editMenu.add(delete);

        JMenuItem findReplace = new JMenuItem("Find and Replace");
        findReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        findReplace.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                findAndReplace();
            }
                  
        });
        editMenu.add(findReplace);

        JMenuItem findWithG = new JMenuItem("Find with Google");
        findWithG.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.SHIFT_MASK));
        findWithG.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                try{
                    Desktop.getDesktop().browse(URI.create("www.google.com"));
                    // if(Desktop.isDesktopSupported() && Desktop.getDesktop.isSupported(Desktop.Action.BROWSE)){
                    //     Desktop.getDesktop().browse(new URI("www.google.com"));
                    // }
                    // else{
                    //     JOptionPane.showMessageDialog(null, "System not supported");
                    // }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Not able to open url");
                }
            }
                  
        });
        editMenu.add(findWithG);

        JMenuItem goTo = new JMenuItem("Go to");
        goTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        goTo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                goToLine();
            }
                  
        });
        editMenu.add(goTo);

        JMenuItem select = new JMenuItem("Select All");
        select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        select.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                page.selectAll();
            }
                  
        });
        editMenu.add(select);

        JMenuItem dateTime = new JMenuItem("Date/Time");
        dateTime.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        dateTime.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                // String date = new SimpleDateFormat("yyy/MM/dd hh:mm:ss").format(new Date());
                // page.setText(date);
            }
                  
        });
        editMenu.add(dateTime);

        menuContainer.add(editMenu);

        JMenu formatMenu = new JMenu("Format");
        final JCheckBoxMenuItem wrap = new JCheckBoxMenuItem("Word wrap");
        wrap.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                boolean checkState = wrap.isSelected();
                if (checkState == true){
                    page.setLineWrap(true);
                    page.setWrapStyleWord(true);
                }
                else
                    page.setLineWrap(false);
                    page.setWrapStyleWord(false);
            }
        });
        formatMenu.add(wrap);

        JMenuItem font = new JMenuItem("Font");
        font.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                showFontDialog();
                // FontChooser m_font = FontChooser.showDialog("Select font");
                // JTextAreaFontandColor fnt = new JTextAreaFontandColor();
                // fnt.setSize(313, 233);
                // fnt.setTitle("Font and Color setting");
                // fnt.show();
            }
                  
        });
        formatMenu.add(font);

        menuContainer.add(formatMenu);

        JMenu viewMenu = new JMenu("View");
        JMenu zoom = new JMenu("Zoom");
        JMenuItem zoomIn = new JMenuItem("zoom in");
        // zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_'+', ActionEvent.CTRL_MASK));
        zoomIn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                Font font = page.getFont();
                if(font.getSize() < 200){
                    page.setFont(new Font(null,0,font.getSize()+10));
                    frame.validate();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Zoom in can not go above maximum zoom level.");
                }
            }
              
        });
        zoom.add(zoomIn);

        JMenuItem zoomOut = new JMenuItem("zoom out");
        // zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_'-', ActionEvent.CTRL_MASK));
        zoomOut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                Font font = page.getFont();
                if(font.getSize() >= 20){
                    page.setFont(new Font(null,0,font.getSize()-10));
                    frame.validate();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Zoom in can not go above maximum zoom level.");
                }
            }
              
        });
        zoom.add(zoomOut);

        JMenuItem defaultZoom = new JMenuItem("Restore default zoom");
        // zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_'-', ActionEvent.CTRL_MASK));
        defaultZoom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                    page.setFont(new Font(null,0,20));
                    frame.validate();
            }
              
        });
        zoom.add(defaultZoom);

        viewMenu.add(zoom);

        final JCheckBoxMenuItem status = new JCheckBoxMenuItem("Status bar");
        status.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                boolean checkState = status.isSelected();
                if(checkState){                    
                     // Give the status update value  
                    updateStatus(linenum, columnnum, word, text);
                    panel.add(statusBar);
                    panel.repaint();
                }
                else{
                    panel.remove(statusBar);
                    panel.repaint();
                }
            }
        });
        viewMenu.add(status);
        menuContainer.add(viewMenu);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem viewHelp = new JMenuItem("View Help");
        viewHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        viewHelp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                  JOptionPane.showMessageDialog(null, "Simple text TextEditor like notepad using Java language. It was created by Yemi lead instructor for "
                    + "Java class at SQI college of ICT. Copyright of SQI");
                }
                  
            });
        helpMenu.add(viewHelp);
        menuContainer.add(helpMenu);

        frame.add(menuContainer, BorderLayout.NORTH);

      	JPanel mainPage = new JPanel();
      	mainPage.setLayout(new BorderLayout());
        page = new JTextArea();
        page.setPreferredSize(new Dimension(800,600));
        page.setFont(new Font("Serif", Font.PLAIN, 20));
        page.setFocusable(true);
        mainPage.add(new JScrollPane(page), BorderLayout.EAST);
        //mainPage.addKeyListener(this);
        mainPage.add(page, BorderLayout.CENTER);
        frame.add(mainPage, BorderLayout.CENTER);
        statusBar = new JLabel("Line: " + linenumber + " Column: " + columnnumber +" Characters: "+text.length()+" Words: "+word+ "     "); 
        panel = new JPanel(new FlowLayout());
        frame.add(panel, BorderLayout.SOUTH);
        page.addCaretListener(new CaretListener() {   
            @Override
            public void caretUpdate(CaretEvent ce) {
                JTextArea editArea = (JTextArea)ce.getSource();
                try {
                    text = page.getText();
                    words = text.split(" ");
                    word = words.length;
                    int caretpos = editArea.getCaretPosition();
                    linenum = editArea.getLineOfOffset(caretpos);
                    columnnum = caretpos - editArea.getLineStartOffset(linenum);
                    linenum += 1;
                    
                    // this will set the line number 
                }
                catch(Exception ex) { }
                
                updateStatus(linenum, columnnum, word, text);
            }
        });
            
        frame.pack();
    	frame.setVisible(true);
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void updateStatus(int linenumber, int columnnumber, int word, String text) {
        // create and add a status bar here
        statusBar.setText("Line: " + linenumber + " Column: " + columnnumber +" Characters: "+text.length()+" Words: "+word);
    }

    public void actionPerformed(ActionEvent ae){
        
    }

    public void saveFile(){
	        try{
	            	BufferedWriter out = new BufferedWriter(new FileWriter(path));
	                out.write(page.getText());
	                out.close();
	        }catch(Exception ex){
	                    JOptionPane.showMessageDialog(null, ex.getMessage());
	                }
    }
    
    public void saveAsFile(){
        JFileChooser fsave = new JFileChooser();
    		int option = fsave.showSaveDialog(fsave);
    		int fileToSave = option;
    		JFileChooser fileSave = fsave;
        if(fileToSave == JFileChooser.APPROVE_OPTION){
	        try{
	                BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
	                out.write(page.getText());
	                out.close();
	                frame.setTitle(fileSave.getSelectedFile().getPath() + "- TextEditor");
	                path = fileSave.getSelectedFile().getPath();
	        }catch(Exception ex){
	                    JOptionPane.showMessageDialog(null, ex.getMessage());
	                }
        }
    }

    public void findAndReplace()
    {
        JDialog findR = new JDialog();
        findR.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        findR.setLayout(new GridLayout(3,1));
        findR.setSize(400, 150);
        findR.setLocation(500, 300);
        replaceText = new JTextField("Enter text to replace", 20);
        findText = new JTextField("Enter text to find", 20);    
        findR.setTitle("Find and Replace");
        final JButton find = new JButton("Find");
        find.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    String search = findText.getText();
                    int n = page.getText().indexOf(search);
                    page.select(n,n+search.length());
                }
                catch(Exception e1) {
                  JOptionPane.showMessageDialog(null, "No text is selected");
                }
            }
        });
    final JButton replace = new JButton("Replace");
        replace.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    String search = findText.getText();
                    int n = page.getText().indexOf(search);
                    String replacing = replaceText.getText();
                    page.replaceRange(replacing, n, n+search.length());
                }
                catch(Exception e1) {
                  JOptionPane.showMessageDialog(null, "No text is selected");
                }
            }
        }); 
        JPanel panel = new JPanel();
        findR.add(findText);
        findR.add(replaceText);
        panel.add(find);
        panel.add(replace);
        findR.add(panel);
        findR.setVisible(true);
    }

    public void goToLine(){
        final JDialog go2 = new JDialog(frame);
        go2.setSize(200, 100);
        go2.setLocation(200, 300);
        JPanel pa = new JPanel(new BorderLayout());
        JLabel lb = new JLabel("Enter line number");
        pa.add(lb, BorderLayout.NORTH);
        final JTextField tf = new JTextField(10);
        pa.add(tf, BorderLayout.CENTER);
        JButton bn = new JButton("Go to line");
        bn.setSize(5, 5);
        bn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    String line = tf.getText();
                    page.setCaretPosition(page.getDocument().getDefaultRootElement().getElement(Integer.parseInt(line)-1).getStartOffset());
                    page.requestFocusInWindow();
                    go2.dispose();
                }
                catch(Exception e1) {
                  JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
        pa.add(bn, BorderLayout.SOUTH);
        go2.add(pa);
        go2.setVisible(true);
    }

    private void showFontDialog() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = env.getAvailableFontFamilyNames();

        JList<String> fontList = new JList<>(fontNames);
        fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontList.setLayoutOrientation(JList.VERTICAL);
        fontList.setVisibleRowCount(-1);

        JScrollPane fontScrollPane = new JScrollPane(fontList);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Select a font:"));
        panel.add(fontScrollPane);

        int result = JOptionPane.showConfirmDialog(null, panel, "Select Font", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);



        if (result == JOptionPane.OK_OPTION) {
            String selectedFontName = fontList.getSelectedValue();
            int selectedFontStyle = Font.PLAIN;
            int selectedFontSize = 12;
            Font selectedFont = new Font(selectedFontName, selectedFontStyle, selectedFontSize);
            page.setFont(selectedFont);
        }
    }

    public void splash()
    {
        JWindow j = new JWindow();
        JLabel l = new JLabel(new ImageIcon("images/splash.png"));
        j.getContentPane().add(l, BorderLayout.CENTER);
        j.pack();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        j.setBounds(((int)d.getWidth()-722)/2,((int)d.getHeight()-401)/2,722,401);
        j.setVisible(true);
        try
        {
            Thread.sleep(6000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        j.setVisible(false);
    }

    public static void main(String[] args) {
	     TextEditor ev = new TextEditor();
    }
}
