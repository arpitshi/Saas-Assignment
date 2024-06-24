import java.util.*;
public class Assignment15 {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int num= s.nextInt();
        List<String> words=new ArrayList<>();
        for(int i=0;i<=num;i++){
            words.add(s.nextLine());

        }
        int size= s.nextInt();

        s.nextLine();
        String str= s.nextLine();

        List<String> ans=formatLine(str,words,size);

        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
    public static List<String> formatLine(String str,List<String>
            words,int len){
        List<String> res=new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        for(int i=0;i<words.size();i++){
            for(int j=0;j<words.get(i).length();j++){
                if(words.get(i).charAt(j)=='-'){
                    continue;
                }
                else{
                    curr.append(words.get(i).charAt(j));
                }
            }
            str=str.replace(curr.toString(),words.get(i));
            curr.setLength(0);
        }
        int i=0;
        int j=0;
        int prevHypen=0;
        StringBuilder ans=new StringBuilder();
        while(i<str.length()){
            if(ans.length()==len-1){

                if(i+1==str.length()||(i+1<str.length()&&Character.isWhitespace(str.charAt(i+1)))){
                    ans.append(str.charAt(i));
                }
                else{
                    if(str.charAt(i)=='-')
                        ans.append(str.charAt(i));
                    else{
                        int dist=i-prevHypen;
                        while(dist!=1){
                            ans.deleteCharAt(ans.length()-1);
                            dist--;
                        }
                        i=prevHypen;
                        ans.append('-');
                    }
                }
                j=0;
                String dummy=new String(ans.toString());
                res.add(dummy);
                ans.setLength(0);
            }
            else if(j==0&&!Character.isWhitespace(str.charAt(i))){
                ans.append(str.charAt(i));
                j++;
            }
            else if(j>0){
                if(str.charAt(i)=='-'){
                    prevHypen=i;
                }
                else{
                    ans.append(str.charAt(i));
                    j++;
                }
            }
            i++;
        }
        if(ans.length()>0){
            res.add(ans.toString());
        }
        return res;
    }
}