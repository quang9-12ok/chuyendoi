package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EnterController;
import controller.chuyenDoiController;
import model.chuyenDoiModel;

public class chuyenDoiView extends JFrame {
    private chuyenDoiModel chuyenDoiModel;
    private JLabel jl_doC, jl_doF;
    private JTextField jtf_doC, jtf_doF;
    private Component frame;
    private String selectedConversion;
    public boolean getSelectedConver;

    public chuyenDoiView(){
        this.chuyenDoiModel = new chuyenDoiModel();
        this.init();
    }

    private void init(){
        this.setTitle("Temperature Converter");
        this.setSize(600,300);
        this.setLocationRelativeTo(null);

        Font font = new Font("Arial",Font.BOLD,20);
        jl_doC = new JLabel("Celsius");
        jl_doC.setFont(font);
        jl_doF = new JLabel("Fahreheit");
        jl_doF.setFont(font);

        jtf_doC = new JTextField(10);
        jtf_doC.setFont(font);
        jtf_doF = new JTextField(10);
        jtf_doF.setFont(font);

        chuyenDoiController chuyenDoiController = new chuyenDoiController(this);
        EnterController enterController = new EnterController(this);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu_Commands = new JMenu("Commands");
        JMenuItem jMenuItem_f2c = new JMenuItem("f2c");
        jMenuItem_f2c.addActionListener(chuyenDoiController);
        jMenu_Commands.add(jMenuItem_f2c);
        JMenuItem jMenuItem_c2f = new JMenuItem("c2f");
        jMenuItem_c2f.addActionListener(chuyenDoiController);
        JMenuItem jMenuItem_exit = new JMenuItem("exit");
        //jMenu_Commands.add(jMenuItem_f2c);
        jMenu_Commands.add(jMenuItem_c2f);
        jMenu_Commands.add(jMenuItem_exit);
        jMenuBar.add(jMenu_Commands);
        this.setJMenuBar(jMenuBar);

        // add enter key listener
        // jtf_doC.addKeyListener(new KeyAdapter() {
        //     public void keyPressed(KeyEvent e){
        //         if(e.getKeyCode() == KeyEvent.VK_ENTER){
        //             enterController.actionPerformed(null);
        //         }
        //     }
        // });

        // jtf_doF.addKeyListener(new KeyAdapter() {
        //     public void keyPressed(KeyEvent e){
        //         if(e.getKeyCode() == KeyEvent.VK_ENTER){
        //             enterController.actionPerformed(null);
        //         }
        //     }
        // });

        jtf_doC.addKeyListener(enterController);
        jtf_doF.addKeyListener(enterController);

        JPanel jPanel = new JPanel();
        jPanel.add(jl_doC);
        jPanel.add(jtf_doC);
        jPanel.add(jl_doF);
        jPanel.add(jtf_doF);

        this.add(jPanel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void f2c(){
        
        try {
            // Lấy giá trị độ F từ JTextField jtf_doF
            double doF = Double.valueOf(jtf_doF.getText());
    
            // Gọi phương thức chuyển đổi từ độ F sang độ C của model
            chuyenDoiModel.setDoF(doF);
            chuyenDoiModel.fToC(); // Chuyển đổi từ độ F sang độ C
    
            // Lấy giá trị độ C từ model và cập nhật lên JTextField jtf_doC
            double doC = chuyenDoiModel.getDoC();
            jtf_doC.setText(String.valueOf(doC));
        } catch (NumberFormatException e) {
            // Xử lý ngoại lệ khi nhập không phải số
            JOptionPane.showMessageDialog(frame, "Vui lòng nhập vào một số hợp lệ cho độ F.", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void c2f(){
        try {
        // Lấy giá trị độ C từ JTextField jtf_doC
        double doC = Double.valueOf(jtf_doC.getText());

        // Gọi phương thức chuyển đổi từ độ C sang độ F của model
        chuyenDoiModel.setDoC(doC);
        chuyenDoiModel.cToF(); // Chuyển đổi từ độ C sang độ F

        // Lấy giá trị độ F từ model và cập nhật lên JTextField jtf_doF
        double doF = chuyenDoiModel.getDoF();
        jtf_doF.setText(String.valueOf(doF));
    } catch (NumberFormatException e) {
        // Xử lý ngoại lệ khi nhập không phải số
        JOptionPane.showMessageDialog(frame, "Vui lòng nhập vào một số hợp lệ cho độ C.", "Lỗi Nhập Liệu", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    // public void addEnterKeyListener(ActionListener listener){
    //     jtf_doC.addActionListener(listener);
    //     jtf_doF.addActionListener(listener);

    // }

    public String getSelectedConversion() {
        return this.selectedConversion;
    }

    public void setSelectedConversion(String selectedConversion) {
        this.selectedConversion = selectedConversion;
    }



}
