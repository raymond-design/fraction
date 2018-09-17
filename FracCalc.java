 import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Call produceAnswer with an equation
        //String input;
        
        Scanner franner = new Scanner(System.in);
        String doo="";
        
        while(!(doo.equals("qwe")))
        {
        System.out.println("\"qwe\" to quit");
        System.out.println("");
            System.out.println("Type your fraction:");
        
        doo = franner.nextLine();
        String output = produceAnswer(doo);
        System.out.println("Answer:");
        System.out.println(output);
        System.out.println("");
    }
    System.out.println("end");
    }
   
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    /*public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }
    */
    public static String produceAnswer(String doo)
    { 
        // TODO: Implement this function to produce the solution to the input\
        int a;
        int b;
        String firstFrac=""; 
        String oper="";
        String secondFrac="";
       /* for(int i=0; i<doo.length(); i++)
        {
            if(doo.charAt(i)==' ')  
            {
                a=i;
                firstFrac = doo.substring(0,a);
                oper=""+doo.charAt(i+1);
                secondFrac = doo.substring(i+3);
            }
        }
        */
        //return secondFrac;
        boolean error = false;
        int whole1 = 0;
        int denom1 = 0;
        int num1 = 0;
        int whole2 = 0;
        int denom2 = 0;
        int num2 = 0;
        boolean isfracnum1 = true;
        boolean isfracnum2 = true;
        boolean iswhole1 = true;
        boolean iswhole2 = true;
        //boolean zero1 = false;
        //boolean zero2 = false;
        firstFrac = doo.substring(0, doo.indexOf(" "));
        //System.out.println("firstFrac: " + firstFrac);
        secondFrac = doo.substring(doo.indexOf(" ") +3);
        //System.out.println("secondFrac: " + secondFrac);
        oper = doo.substring(doo.indexOf(" ") + 1,doo.indexOf(" ") + 2);
        
        // frontslash not present
        if(firstFrac.indexOf("/")==-1)
        {
            isfracnum1=false;
        }
        
        if(secondFrac.indexOf("/")==-1)
        {
            isfracnum2=false; 
        }
        
        if(firstFrac.indexOf("_")==-1)
        {
            iswhole1=false;
        }
        
        if(secondFrac.indexOf("_")==-1)
        {
            iswhole2=false; 
        }
        
        //CONVERT 1stFRAC TO FRACTION
        if(iswhole1 && isfracnum1)
        // first frac: x_x/xx
        {
           whole1=Integer.parseInt(firstFrac.substring(0,firstFrac.indexOf("_")));
           //System.out.println("whole1: " + firstFrac.substring(0,firstFrac.indexOf("_")));
           //System.out.println("denom1: " + firstFrac.substring(firstFrac.indexOf("/")+1));
           denom1=Integer.parseInt(firstFrac.substring(firstFrac.indexOf("/")+1));
           num1=Integer.parseInt(firstFrac.substring(firstFrac.indexOf("_")+1,firstFrac.indexOf("/")));
        }
        
        if(!iswhole1&&isfracnum1)
        // first frac: x/xx
        {
           denom1=Integer.parseInt(firstFrac.substring(firstFrac.indexOf("/")+1));
           num1=Integer.parseInt(firstFrac.substring(0,firstFrac.indexOf("/")));
        }
        
        if(!iswhole1&&!isfracnum1)
        // first frac: xx
        {
           denom1=1;
           num1=Integer.parseInt(firstFrac);
        }
        
        //CONVERT 2ndFRAC TO FRACTION
        if(iswhole2&&isfracnum2)
        // second frac: x_x/xx
        {
           whole2=Integer.parseInt(secondFrac.substring(0,secondFrac.indexOf("_")));
           denom2=Integer.parseInt(secondFrac.substring(secondFrac.indexOf("/")+1));
           num2=Integer.parseInt(secondFrac.substring(secondFrac.indexOf("_")+1,secondFrac.indexOf("/")));
        }
        
        if(!iswhole2&&isfracnum2)
        // second frac: x/xx
        {
           denom2=Integer.parseInt(secondFrac.substring(secondFrac.indexOf("/")+1));
           num2=Integer.parseInt(secondFrac.substring(0,secondFrac.indexOf("/")));
        }
        
        if(!iswhole2&&!isfracnum2)
        // second frac: xx
        {
           denom2=1;
           num2=Integer.parseInt(secondFrac);
        }
        
        //CALCULATIONS
        int finalFrac1;
        int finalFrac2;
       /* if(whole1==0)
        {
           finalFrac1= 
        }
        //zero is present
        if(firstFrac.equalsTo("0"))
        {
            zero1=true;
        }
        if(secondFrac.equalsTo("0"))
        {
            zero2=true; 
        }*/
        //CHECKPOINT 2:
        //String checkpoint2 = "whole:"+ whole2 + " " + "numerator:" + num2 + " " + "denominator:" + denom2;
        //return checkpoint2;
        //return "something";
        //reduction:
        if(iswhole1 && isfracnum1)
        // first frac: x_x/xx
        {
           num1=(whole1*denom1)+num1;
           //System.out.println(num1);
        }
        
        if(!iswhole1&&!isfracnum1)
        {
            denom1=1;
           num1=Integer.parseInt(firstFrac);
        }

        if(!iswhole1&&isfracnum1)
        {
            num1=num1;
            denom1= denom1;
        }
        
        if(iswhole2&&isfracnum2)
        // second frac: x_x/xx
        {
           num2=(whole2*denom2)+num1;
           //System.out.println(num2);
        }
        
        if(!iswhole2&&!isfracnum2)
        {
            denom2=1;
           num2=Integer.parseInt(secondFrac);
        }
        
        if(!iswhole2&&isfracnum2)
        {
            num2=num2;
            denom2= denom2;
        }
        /* System.out.println(num1);
         System.out.println(denom1);
         System.out.println(num2);
         System.out.println(denom2);
         */
         
         
        int newNum1=num1*denom2; 
        
        int newDenom1=denom1*denom2;
        
        int newNum2=num2*denom1;
        //denom was changed last line
        int newDenom2=denom2*denom1;
        //debugger
        //System.out.println(num1 + "    " + num2 + "    " + denom1 + "    " + denom2 + "    " );
        int finalFracNum = 0;
        int finalFracDenom = 0;
        int finalWhole = 0;
        if(oper.equals("*"))
        {
            finalFracNum=newNum1*newNum2; 
            finalFracDenom=newDenom1*newDenom2; 
            
            if(finalFracDenom==0||finalFracNum==0) //special case
            {
                return "0";
            }
        }
        //System.out.println(denom1);
        if(oper.equals("+"))
        {
            finalFracNum=num1+num2; 
            finalFracDenom=denom1; 
        }
        
        if(oper.equals("/"))
        {
            finalFracNum=newNum1/newNum2; 
            finalFracDenom=newDenom1/newDenom2;
            if((finalFracDenom)==0) //special case
            {
                return "error";
            }
            
            if((finalFracNum)==0) //special case
            {
                return "0";
            }
        }
        
        if(oper.equals("-"))
        {
            finalFracNum=num1-num2; 
            finalFracDenom=denom1; 
        }
        
        
            //System.out.println(finalFracNum);
            //System.out.println(finalFracDenom);
        //simplify:
        
        while((finalFracNum%2==0&&finalFracDenom%2==0)||(finalFracNum%3==0&&finalFracDenom%3==0))
        {
          if(finalFracNum%2==0&&finalFracDenom%2==0)
          {
              finalFracNum=finalFracNum/2;
              finalFracDenom=finalFracDenom/2;
          }
          
          if(finalFracNum%3==0&&finalFracDenom%3==0)
          {
             finalFracNum=finalFracNum/3;
             finalFracDenom=finalFracDenom/3;
          }
        }
        
        while(finalFracNum>=finalFracDenom)
        {
             finalFracNum-=finalFracDenom;
             finalWhole++;
        }
        
        if(finalWhole==0)
        {
            return finalFracNum + "/" + finalFracDenom;
        }
        else
        {
            return finalWhole + "_" + finalFracNum + "/" + finalFracDenom;
        }
        //return "yeet";
    // TODO: Fill in the space below with any helper methods that you think you will need
}
}
