package Basic_Graph_Maker;

import java.lang.Math;

public class Power extends yMain{
    
    private double a,b,c,d;
    
    public Power(double a,double b,double c,double d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }
    
    public void storeY(){
        
        int j=0;
        for(double i=-10;i<=10;i+=0.1){
            y[j]=(a*(Math.pow(i, 3)))+(b*(Math.pow(i, 2)))+(c*i)+d;
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
