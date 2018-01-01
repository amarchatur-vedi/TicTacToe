package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;

public class TicTacToe extends JFrame implements ActionListener{
    JLabel jl1,jl2,jl3;
    JButton jb1;
    JPanel jp1,jp2;
    JButton jb[]=new JButton[9];
    public TicTacToe(){
        jp1=new JPanel();
        jp2=new JPanel();
        jb1=new JButton("Reset");    
        for(int i=0;i<9;i++)
        {
            jb[i]=new JButton("");
            jb[i].addActionListener(this);
            jb[i].setBorder(new BasicBorders.ButtonBorder(Color.black, Color.black, Color.black, Color.black));
            jp1.add(jb[i]);
        }
        jl1=new JLabel("");
        jl2=new JLabel();
        jl3=new JLabel();
        setLayout(new BorderLayout());
        jb1.setBorder(new BasicBorders.ButtonBorder(Color.black, Color.black, Color.black, Color.black));
        jb1.setPreferredSize(new Dimension(80,25));
        jp2.add(jl1);jp2.add(jb1);jp2.add(jl2);
        jp2.add(jl3);add(jp1);add(jp2,BorderLayout.SOUTH);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            for(int i=0;i<9;i++)
                {
                    jl1.setText("");
                    jb[i].setEnabled(true);
                    jb[i].setText("");
                    jl3.setText("");
                }
            }
        });
        jp1.setLayout(new GridLayout(3,3));
        jp2.setLayout(new FlowLayout());
        
    }
    public void actionPerformed(ActionEvent ae){
        if(jl1.getText()=="")
            jl1.setText("0");
        int x=Integer.parseInt(jl1.getText());
        for(int i=0;i<9;i++)
        {
            
            if(ae.getSource()==jb[i])
            {
                if(x==0)
                {
                jl1.setText("1");
                jb[i].setText("O");
                }
                
                if(x>=1||x<=8)
                {
                    x++;
                    jl1.setText(""+x);
                    int y=Integer.parseInt(jl1.getText());
                    if(y%2==0)
                        jb[i].setText("X");
                    else
                        jb[i].setText("O");
                }
            }
            if((jb[0].getText()=="X"&&jb[1].getText()=="X"&&jb[2].getText()=="X")||(jb[0].getText()=="X"&&jb[3].getText()=="X"&&jb[6].getText()=="X")
                ||(jb[0].getText()=="X"&&jb[4].getText()=="X"&&jb[8].getText()=="X")||(jb[2].getText()=="X"&&jb[5].getText()=="X"&&jb[8].getText()=="X")
                    ||(jb[2].getText()=="X"&&jb[4].getText()=="X"&&jb[6].getText()=="X")||(jb[6].getText()=="X"&&jb[7].getText()=="X"&&jb[8].getText()=="X")
                    ||(jb[1].getText()=="X"&&jb[4].getText()=="X"&&jb[7].getText()=="X")||(jb[3].getText()=="X"&&jb[4].getText()=="X"&&jb[5].getText()=="X"))//Winner X from first place
            {
                jl3.setText("X Won!!");
                for(int j=0;j<9;j++)
                    jb[j].setEnabled(false);
            }
            if((jb[0].getText()=="O"&&jb[1].getText()=="O"&&jb[2].getText()=="O")||(jb[0].getText()=="O"&&jb[3].getText()=="O"&&jb[6].getText()=="O")
                ||(jb[0].getText()=="O"&&jb[4].getText()=="O"&&jb[8].getText()=="O")||(jb[2].getText()=="O"&&jb[5].getText()=="O"&&jb[8].getText()=="O")
                    ||(jb[2].getText()=="O"&&jb[4].getText()=="O"&&jb[6].getText()=="O")||(jb[6].getText()=="O"&&jb[7].getText()=="O"&&jb[8].getText()=="O")
                    ||(jb[1].getText()=="O"&&jb[4].getText()=="O"&&jb[7].getText()=="O")||(jb[3].getText()=="O"&&jb[4].getText()=="O"&&jb[5].getText()=="O"))//Winner O from first place
            {
                jl3.setText("O Won!!");
                for(int j=0;j<9;j++)
                    jb[j].setEnabled(false);
            }
            
            
            
        }
        if(x>8)
        {
            for(int i=0;i<9;i++)
            {
                jb[i].setEnabled(false);
                jl3.setText("Match Drawn!!");
            }
        }
            
    }
    public static void main(String args[])
    {
        TicTacToe kc=new TicTacToe();
        kc.setSize(300,300);
        kc.setVisible(true);
        kc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        kc.setResizable(false);
        
        
    }
}

