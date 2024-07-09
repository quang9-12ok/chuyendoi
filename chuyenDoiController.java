package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.chuyenDoiModel;

import view.chuyenDoiView;

public class chuyenDoiController implements ActionListener{
    private chuyenDoiView chuyenDoiView;
    private chuyenDoiModel chuyenDoiModel;

    public chuyenDoiController(view.chuyenDoiView chuyenDoiView) {
        this.chuyenDoiView = chuyenDoiView;
    }
    public chuyenDoiController(model.chuyenDoiModel chuyenDoiModel){
        
        this.chuyenDoiModel = chuyenDoiModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {    
        String button = e.getActionCommand();

        if(button.equals("f2c")){
            this.chuyenDoiView.setSelectedConversion("f2c");
            // this.chuyenDoiView.f2c();
        } else if(button.equals("c2f")){
            this.chuyenDoiView.setSelectedConversion("c2f");
            //this.chuyenDoiView.c2f();
        } 
        
    }

    

}
