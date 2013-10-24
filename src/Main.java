public class Main {
    public static void main(String[] args) {
        if(args.length > 0) {
            for(String str: args) {
                Shenon s = new Shenon(str);
                System.out.printf("%.2f ", s.getEntropy());
                System.out.printf("%.2f ", s.getAmount());
                System.out.println();
            }    
        } else {
            System.out.println("Please, enter the strings for calculating entropy and amount!...");
        }       
    }
}
