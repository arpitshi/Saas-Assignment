import java.util.*;

public class Assignment13{


    public static void main(String[]args){
        Scanner s=new Scanner(System.in);

        int H1=s.nextInt();
        int[]s1=new int[2*H1];
        for(int i=0;i<2*H1;i++){
            s1[i]=s.nextInt();

        }
        int H2=s.nextInt();
        int[]s2=new int[2*H2];
        for(int i=0;i<2*H2;i++){
            s2[i]=s.nextInt();
        }
        s.close();

       Set<Integer> donosignal =new TreeSet<>();

       for(int num : s1){
           donosignal.add(num);
       }
       for(int num : s2){
           donosignal.add(num);
       }
        List<Integer> mergeS = new ArrayList<>(donosignal);
        for(int i=0;i<mergeS.size();i++){
            System.out.print(mergeS.get(i));
            if(i!=mergeS.size()-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
