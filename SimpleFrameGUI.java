import java.awt.*; //diamension
import javax.swing.*; //for gui 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SimpleFrameGUI implements ActionListener{ 
    JLabel ope , eq , result;
    JTextField val1 , val2;
    JPanel jp1 , jp2 ;

    public SimpleFrameGUI(){
        JFrame frame = new JFrame();
        frame.setForeground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(new Point(10 , 50));
        frame.setSize(new Dimension(400,400));
        frame.setTitle("Simple Calculator");
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2 , 1));

        jp1 = new JPanel(new FlowLayout());
        val1 = new JTextField(5);
        jp1.add(val1);
        ope = new JLabel("+");
        jp1.add(ope);
        val2 = new JTextField(5);
        jp1.add(val2);
        eq = new JLabel("=");
        jp1.add(eq);
        result = new JLabel("");
        jp1.add(result);
        frame.add(jp1);
        jp2 = new JPanel(new FlowLayout());
        JButton add = new JButton("+");
        add.addActionListener(this);
        jp2.add(add);
        JButton subt = new JButton("-");
        subt.addActionListener(this);
        jp2.add(subt);
        JButton mult = new JButton("*");
        mult.addActionListener(this);
        jp2.add(mult);
        JButton divi = new JButton("/");
        divi.addActionListener(this);
        jp2.add(divi);
        frame.add(jp2);
        frame.pack();

    }

    public void actionPerformed(ActionEvent e){
        JButton but = (JButton) e.getSource();
        String com = but.getActionCommand().toString();
        String va1 = val1.getText();
        String va2 = val2.getText();
        ope.setText(com);
        if(com == "+"){
                int ans = Integer.parseInt(va1) + Integer.parseInt(va2);
                result.setText(" " + ans);
        }
        else if( com == "-"){
            int ans = Integer.parseInt(va1) - Integer.parseInt(va2);
            result.setText(" " + ans);
        }
        else if(com == "/"){
            int ans = Integer.parseInt(va1) / Integer.parseInt(va2);
            result.setText("" + ans);
        }
    }

    public static void main (String[] args){
        SimpleFrameGUI sm = new SimpleFrameGUI();
    }
}
