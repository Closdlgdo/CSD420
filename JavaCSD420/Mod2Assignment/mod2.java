public class mod2 {

    // function definition for m
    public static double m(int n){
        
        // base case
        if(n==1){
            return 1.0/2;
        }
        
        // recursive case
        else{
            return (1.0*n)/(n+1);
        }
        
    }
    
    // testing
    public static void main(String[] args) {

        System.out.println(m(4));
        System.out.println(m(9));
        System.out.println(m(15));

    }

}