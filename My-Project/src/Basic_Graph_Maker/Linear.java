package Basic_Graph_Maker;

import java.io.FileInputStream;

public class Linear extends yMain{
    private double a,c;

    public Linear(double a, double c) {
        this.a = a;
        this.c = c;
    }
    
    public void storeY(){//store the value of y corresponding to value of x(which is 'i' in this case) into an array
        
        int j=0;
        for(double i=-10;i<=10;i+=0.1){
            y[j]=(double)a*i+(double)c;
            j++;
        }
        
    }
    
    /*public void textY(){
        
        try{
            PrintWriter p = new PrintWriter(new FileOutputStream("C://Graph2/data.txt"));
            for(int i=0;i<201;i++){
                p.printf("%.2f\n",y[i]);
            }
            p.close();
        }catch(IOException e){
            System.out.println("Problem with file output");
        }
        
        try{
            Scanner sc = new Scanner(new FileInputStream("C://Graph2/data.txt"));
            PrintWriter p = new PrintWriter(new FileOutputStream("C://Graph2/data2.txt"));
            try{
                while(sc.hasNext()){
                    p.printf("%.2f\n",(sc.nextDouble()*100));
                }
                p.close();
            }catch(Exception e){
                System.out.println("Problem with file output");
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }*/
    
    /*public void changeY(){
        try{
            Scanner sc = new Scanner(new FileInputStream("C://Graph2/data2.txt"));
            int i=0;
            while(sc.hasNext()){
                y[i]=sc.nextDouble();
                i++;
            }
        }catch(Exception e){
            System.out.println("File not found");
        }
        super.yMax();
        super.yMin();
    }*/
    
    /*public void setYHeight(){
        for(int i=0;i<201;i++){
            if(y[i]>=0){
                yHeight[i]=(int)(this.yMax-y[i]);
            }
            else if(y[i]<0){
                yHeight[i]=(int)(this.yMax-y[i]);
            }
        }
    }*/
    
    public void draw(){
        super.textY();
        super.changeY();
        super.setYHeight();
        super.drawGraph();
    }
}
