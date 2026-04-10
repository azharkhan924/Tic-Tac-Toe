import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class FDemo extends JFrame implements ActionListener{
    JButton[] b1=new JButton[9];
    int wincombo[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int turn=1;
    int move1[]={9,9,9,9,9,9,9,9,9};
    int move2[]={9,9,9,9,9,9,9,9,9};
    int key1=0,key2=0;
    int x=250,y=100;
    JTextField tx1,tx2,tx3;
    JButton j1,j2,j3,j4;
    boolean flag=false;

    void resetGame() {
        for (int i = 0; i < 9; i++) {
            b1[i].setText("");
            // Ensure action listener is only added once
            boolean alreadyHasListener = false;
            for (ActionListener al : b1[i].getActionListeners()) {
                if (al == this) {
                    alreadyHasListener = true;
                    break;
                }
            }
            if (!alreadyHasListener) {
                b1[i].addActionListener(this);
            }
            move1[i] = 9;
            move2[i] = 9;
        }
        turn = 1;
        key1 = 0;
        key2 = 0;
        flag = false;
        tx3.setText("");
    }

    FDemo(){
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.black); // Set background color to black
        Font f1=new Font("Abyssinica SIL",Font.ITALIC,25);
        j1=new JButton("Start");
        j1.setSize(160,70);
        j1.setLocation(40,110);
        j1.setFont(f1);
        j1.addActionListener(this);
        add(j1);
        j2=new JButton("Restart");
        j2.setSize(160,70);
        j2.setLocation(40,180);
        j2.setFont(f1);
        j2.addActionListener(this);
        add(j2);
        j3=new JButton("About");
        j3.setSize(160,70);
        j3.setLocation(40,250);
        j3.setFont(f1);
        j3.addActionListener(this);
        add(j3);
        j4=new JButton("Exit");
        j4.setSize(160,70);
        j4.setLocation(40,320);
        j4.setFont(f1);
        j4.addActionListener(this);
        add(j4);
        j4.setForeground(Color.red);
        tx1=new JTextField("Player 1",10);
        tx1.setSize(200,50);
        tx1.setLocation(30,30);
        tx1.setFont(f1);
        tx1.setBackground(Color.black);
        tx1.setForeground(Color.cyan);
        add(tx1);
        tx2=new JTextField("Player 2");
        tx2.setSize(180,50);
        tx2.setLocation(260,30);
        tx2.setFont(f1);
        tx2.setBackground(Color.black);
        tx2.setForeground(Color.cyan);
        add(tx2);
        tx3=new JTextField();
        tx3.setSize(130,50);
        tx3.setFont(f1);
        tx3.setLocation(430,30);
        tx3.setBackground(Color.black);
        tx3.setForeground(Color.cyan);
        add(tx3);
        setFocusable(true);
        for(int i=0;i<9;i++){
            b1[i]=new JButton();
            b1[i].setSize(100,100);
            b1[i].setLocation(x,y);
             b1[i].setFont(f1);
            add(b1[i]);
            b1[i].addActionListener(this);
            b1[i].setBackground(Color.BLACK);
            x+=100;
            if(x==550){x=250;
            y+=100;}
       }}
    void checkwin() {
        String s1 = tx1.getText();
        String s2 = tx2.getText();
        for (int i = 0; i < 8; i++) {
            String c1 = b1[wincombo[i][0]].getText();
            String c2 = b1[wincombo[i][1]].getText();
            String c3 = b1[wincombo[i][2]].getText();

            if (!c1.equals("") && c1.equals(c2) && c1.equals(c3)) {
                if (c1.equals("O")) {
                    JOptionPane.showMessageDialog(null, s1 + " wins");
                } else {
                    JOptionPane.showMessageDialog(null, s2 + " wins");
                }
                resetGame();
                return;
            }
        }
        if (turn == 9) {
            JOptionPane.showMessageDialog(null, "It's a Draw");
            resetGame();
        }
    }
        
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==j1){
           tx3.setText("PLAY!!");
           flag=true;
           
        }
        else if(e.getSource()==j2){
            resetGame();
            return;
        }
        else if(e.getSource()==j3){
            JOptionPane.showMessageDialog(null,"Tic Tac Toe Game created By Azhar Khan");

        }
        else if(e.getSource()==j4){
            System.exit(0);

        }
        else if(flag==true){
        if(turn%2==1){
            for(int i=0;i<9;i++){
                if(e.getSource()==b1[i]){
                    b1[i].setText("O");
                   
                    move1[key1++]=i;
                    b1[i].removeActionListener(this);
                    b1[i].setForeground(Color.red);
                }
            }
        }
        else{
        for(int i=0;i<9;i++){
            if(e.getSource()==b1[i]){
                b1[i].setText("X");
                move2[key2++]=i;
                b1[i].removeActionListener(this);
            }
        }
    }
    checkwin();
    turn++;}
}}


class tictac3{
    static public void main(String ...ar){
        FDemo f=new FDemo();
        if(ar.length>0){
            f.tx1.setText(ar[0]);
            f.tx2.setText(ar[1]);
        }
        f.setVisible(true);
        f.setSize(570,450);
        f.setLocation(100,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}
