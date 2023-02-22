import java.util.*;

public class mod3 {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
    {
        /*make empty ArrayList*/
    ArrayList<E> out=new ArrayList<E>();
    /*trave into list*/
    for(int i=0;i<list.size();i++)
    {
    /*check alreay present in ArrayList or not*/
    if(!out.contains(list.get(i)))
    {
    /*not present than add it*/
    out.add(list.get(i));
    }
}
/*return list*/
return out;
}
    public static void main(String[] args)
    {
    /*make object*/
    Random r=new Random();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        System.out.println("Input ArrayList:");
        /*take a loop*/
        for(int i=0;i<50;i++)
        {
        /*generate and print number in ArrayList*/
        arr.add(r.nextInt(20)+1);
        System.out.print(arr.get(i)+" ");
        }
        /*call function and store output*/
        ArrayList<Integer> out=removeDuplicates(arr);
        /*print output*/
        System.out.println("\nOutput ArrayList:");
        for(int i=0;i<out.size();i++)
        {
        System.out.print(out.get(i)+" ");
        }
    }
}