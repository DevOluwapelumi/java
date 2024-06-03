import javax.swing.*;
// import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleFrame implements ActionListener{
    JLabel label;
    boolean state =true;

    public SimpleFrame() {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(new Point(500, 200));
        frame.setTitle("SimpleFrame");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("1695711686865.jpg"));
        frame.setLayout(new FlowLayout());
        label = new JLabel("<html><span style='color: blue; font-size: 16px; font-family: Arial;'>Hello, Oluwapelumi! Welcome to Java GUI Class</span></html>");
        frame.add(label);

        JButton but = new JButton("Welcome User!");
        // but.addActionListener(this);
        but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
            label.setText("<html><span style='color: blue; font-size: 16px; font-family: Arial;'>Mr. Oluwapelumi, This is GUI Class</span></html>");
            }
        });
        frame.add(but);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        // if(state){
        //     label.setText("<html><span style='color: blue; font-size: 16px; font-family: Arial;'>Mr. Oluwapelumi, Kindly Login Here!!!</span></html>");
        //     state = false;
        // }
        // else{
        //     label.setText("<html><span style='color: blue; font-size: 16px; font-family: Arial;'>Mr. Oluwapelumi, This is GUI Class</span></html>");
        //     state = true;
        // }
    }

    public static void main(String[]args){
        SimpleFrame fr = new SimpleFrame();
    }
}