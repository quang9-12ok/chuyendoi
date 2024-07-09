package model;

public class chuyenDoiModel {
    private double doC;
    private double doF;
    
    public String jtf_doC, jtf_doF;

    public chuyenDoiModel(){

    }

    public double getDoC() {
        return doC;
    }

    public double getDoF() {
        return doF;
    }

    public void setDoC(double doC) {
        this.doC = doC;
    }

    public void setDoF(double doF) {
        this.doF = doF;
    }

    public void cToF(){
       // °F = (°C × 9/5) + 32
        this.doF = (this.doC*9/5) + 32;
    }
    public void fToC(){
        //°C = (°F - 32) × 5/9
        this.doC = (this.doF - 32) * 5/9;
       
    }



}
