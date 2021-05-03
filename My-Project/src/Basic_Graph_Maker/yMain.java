package Basic_Graph_Maker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class yMain {
    protected double[] y = new double[201];
    protected int[] yHeight = new int[201];
    protected double yMax;
    protected double yMin;
    protected double maxHeight;
    
    public yMain(){ 
    }
    
    public void yMax(){//to set the highest value of y
        int start=0;
        for(int i =0;i<201;i++){
            if(start==0){
                this.yMax=y[i];
                start++;
            }
            else if(yMax<y[i]){
                this.yMax=y[i];
            }
        }
    }
    
    public void yMin(){//to set the lowest value of y
        int start=0;
        for(int i =0;i<201;i++){
            if(start==0){
                this.yMin=y[i];
                start++;
            }
            else if(yMin>y[i]){
                this.yMin=y[i];
            }
        }
    }
    
    public void textY(){
        
        try{//to store the value of array "y" into a text file with 2 decimal places
            PrintWriter p = new PrintWriter(new FileOutputStream("C://Users/imran/My Project/Graph-Maker-master/data.txt"));
            for(int i=0;i<201;i++){
                p.printf("%.2f\n",y[i]);
            }
            p.close();
        }catch(IOException e){
            System.out.println("Problem with file output");
        }
        
        try{//read the text file of previous value of array "y"
            Scanner sc = new Scanner(new FileInputStream("C://Users/imran/My Project/Graph-Maker-master/data.txt"));
            PrintWriter p = new PrintWriter(new FileOutputStream("C://Users/imran/My Project/Graph-Maker-master/dataModify.txt"));
            try{//to store another text file of the array "y" times with 100 to distinguish the decimal places
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
    }
    
    public void changeY(){
        try{//to change the value of array of "y" based on the text file that have been times with 100
            Scanner sc = new Scanner(new FileInputStream("C://Users/imran/My Project/Graph-Maker-master/dataModify.txt"));
            int i=0;
            while(sc.hasNext()){
                y[i]=sc.nextDouble();
                i++;
            }
        }catch(Exception e){
            System.out.println("File not found");
        }
        yMin();//to call the method yMin()
        yMax();//to call the method yMax()
    }
    
    public void setYHeight(){//to modify the value of array "y" into a different array that to make it easier to plot the graph
        for(int i=0;i<201;i++){
            if(y[i]>=0){
                yHeight[i]=(int)(this.yMax-y[i]);
            }
            else if(y[i]<0){
                yHeight[i]=(int)(this.yMax-y[i]);
            }
        }
    }
    
    public void drawGraph(){//to plot a graph based on the array yHeight[]
        
        int start=0;
        for(int i =0;i<201;i++){//to know the limit of y-axis for easier to coding by using "for loop"
            if(start==0){
                this.maxHeight=yHeight[i];
                start++;
            }
            else if(maxHeight<yHeight[i]){
                this.maxHeight=yHeight[i];
            }
        }
        if(yMax<0){//if the maximum point or coordinate below the x-axis which is zero
            try{//read the text file that have been times with 100
                int counterX=0;
                PrintWriter p = new PrintWriter(new FileOutputStream("C://Users/imran/My Project/Graph-Maker-master/outputGraph.txt"));
                for(int i=(int)this.yMax;i<=this.maxHeight;i++){//"for loop" for y-axis
                    for(int j=0;j<201;j++){//"for loop" for x-axis
                        if(yHeight[j]==i){//to plot the x&y coordinate if the value is the array yHeight[] same with value of i
                            p.print("*");
                            continue;
                        }
                        else if(i==this.yMax){//to print the x-axis line
                            if(counterX==0){
                                p.print("|");
                                counterX++;
                            }
                            else if(j%10==0)
                                p.print("|");
                            else if(j==100){
                                p.print("-");
                            }
                            else
                                p.print("-");
                        }
                        else if(j==100){//to print the y-axis line 
                            if(i%10==0){
                                p.print("=");
                            }
                            else
                                p.print("|");
                        }
                        else//else will print a space
                            p.print(" ");
                    }
                    p.println();
                }
                p.close();
            }catch(Exception e){
                System.out.println("Problem with file output");
            }
        }
        else if(yMin>0){//if the minimum point is above the x-axis whic is zero
            try{
                int counterX=0,counterY=0;
                PrintWriter p = new PrintWriter (new FileOutputStream("C://Users/imran/My Project/Graph-Maker-master/outputGraph.txt"));
                for(int i=0;i<=this.maxHeight+(int)this.yMin;i++){//"for loop" for y-axis
                    for(int j=0;j<201;j++){//"for loop" for x-axis
                        if(yHeight[j]==i){//to plot the x&y coordinate if the value is the array yHeight[] same with value of i
                            p.print("*");
                            continue;
                        }
                        else if(i==this.yMax){//to print the x-axis line
                            if(counterX==0){
                                p.print("|");
                                counterX++;
                            }
                            else if(j%10==0)
                                p.print("|");
                            else if(j==100){
                                p.print("-");
                            }
                            else
                                p.print("-");
                        }
                        else if(j==100){//to print the y-axis line 
                            if(counterY==0){
                                p.print("=");
                                counterY++;
                            }
                            else if(i%10==0){
                                p.print("=");
                            }
                            else
                                p.print("|");
                        }
                        else//else will print a space
                            p.print(" ");
                    }
                    p.println();
                }
                p.close();
            }catch(IOException e){
                System.out.println("Problem with file output");
            }
        }
        else{//the maximum point is above x-axis and minimum point below the x-axis
            try{//read the text file that have been times with 100
                int counterX=0,counterY=0;//to set limit
                PrintWriter p = new PrintWriter (new FileOutputStream("C://Users/imran/My Project/Graph-Maker-master/outputGraph.txt"));
                for(int i=0;i<=this.maxHeight;i++){//"for loop" for y-axis
                    for(int j=0;j<201;j++){//"for loop" for x-axis
                        if(yHeight[j]==i){//to plot the x&y coordinate if the value is the array yHeight[] same with value of i
                            p.print("*");
                            continue;
                        }
                        else if(i==this.yMax){//to print the x-axis line
                            if(counterX==0){
                                p.print("|");
                                counterX++;
                            }
                            else if(j%10==0)
                                p.print("|");
                            else if(j==100){
                                p.print("-");
                            }
                            else
                                p.print("-");
                        }
                        else if(j==100){//to print the y-axis line 
                            if(counterY==0){
                                p.print("=");
                                counterY++;
                            }
                            else if(i%10==0){
                                p.print("=");
                            }
                            else
                                p.print("|");
                        }
                        else//else will print a space
                            p.print(" ");
                    }
                    p.println();
                }
                p.close();
            }catch(IOException e){
                System.out.println("Problem with file output");
            }
        } 
    }
    
}
