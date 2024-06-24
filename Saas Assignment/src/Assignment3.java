import java.util.*;

class Assignment3{
    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();


        String []str=input.split("\\.");
        System.out.println(Arrays.toString(str));

        int f=Integer.parseInt(str[1]);
        int i=Integer.parseInt(str[0]);
        StringBuffer sbuffer=new StringBuffer();

        int rem=0;
        while(i !=0) {
            rem = i % 10;
            if (rem != 0) break;
            i = i / 10;
        }

        sbuffer.append(String.valueOf(f));
        for(int j=String.valueOf(f).length();j<5;j++){
            sbuffer.append("#");
        }
        sbuffer.append("."+i);
        System.out.println(sbuffer);
    }
}