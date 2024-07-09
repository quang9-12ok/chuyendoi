package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.chuyenDoiView;

public class EnterController extends KeyAdapter implements ActionListener {
    private chuyenDoiView chuyenDoiView;

    public EnterController(chuyenDoiView chuyenDoiView) {
        this.chuyenDoiView = chuyenDoiView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        performConversion();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            performConversion();
        }
    }

    private void performConversion() {
        String selectedConversion = chuyenDoiView.getSelectedConversion();
        if ("f2c".equals(selectedConversion)) {
            chuyenDoiView.f2c();
        } else if ("c2f".equals(selectedConversion)) {
            chuyenDoiView.c2f();
        }
    }
}
