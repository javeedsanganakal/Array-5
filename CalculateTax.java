//Approach - 1: Iterative
//Time Complexity : O(1) // constant values in array max O(8)
//Space Complexity : O(n) // using extra space

public class Main {
    public static void main(String[] args) {
        List<List<Double>> levels = new ArrayList<>();
        levels.add(Arrays.asList(10000.0, 0.1));
        levels.add(Arrays.asList(20000.0, 0.2));
        levels.add(Arrays.asList(30000.0, 0.3));
        levels.add(Arrays.asList(null, 0.4));
        double tax = calculateTax(levels, 45000);
        System.out.println(tax);
    }
    
    private static double calculateTax(List<List<Double>> levels, double salary){
        //to traverse the list
        int i = 0;
        //to mataintain the range
        double prev = 0;
        double pendingSalary = salary;
        double tax = 0;
        while(pendingSalary > 0){
            //get the salary range and percentage
            List<Double> li = levels.get(i);
            //salary curr
            Double curr = li.get(0);
            double taxPercentage = li.get(1);
            
            //last remaining amount 
            if(curr == null){
                tax = tax + pendingSalary * taxPercentage;
                return tax;
            }
            
            //particular range amount ex: 0-10k, 10k-20k, 20k-30k, 30k-above
            double taxable = Math.min((curr-prev), pendingSalary);
            //sum of all taxes
            tax = tax + taxable * taxPercentage;
            prev = curr;
            i++;
        }
        return 0;
    }
}
