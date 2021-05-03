package Basic_Graph_Maker;

import java.lang.Math;

public class Quadratic extends yMain{
    
    private double a,b,c;
    
    public Quadratic(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    public void storeY(){
        
        int j=0;
        for(double i=-10;i<=10;i+=0.1){
            y[j]=(double)(a*(Math.pow(i, 2)))+(double)b*i+(double)c;
            j++;
        }
    }
    
    public void draw(){
        super.textY();
        super.changeY();
        super.setYHeight();
        super.drawGraph();
    }
}
