import java.util.*;

/**
 * At a popular bar, each customer has a set of favorite drinks, and will happily accept any drink among this set.
 * For example, in the following situation, customer 0 will be satisfied with drinks 0, 1, 3, or 6.
 *
 * preferences = {
 *     0: [0, 1, 3, 6],
 *     1: [1, 4, 7],
 *     2: [2, 4, 7, 5],
 *     3: [3, 2, 5],
 *     4: [5, 8]
 * }
 *
 * A lazy bartender working at this bar is trying to reduce his effort by limiting the drink recipes he must memorize.
 * Given a dictionary input such as the one above, return the fewest number of drinks he must learn in order to satisfy all customers.
 *
 * For the input above, the answer would be 2, as drinks 1 and 5 will satisfy everyone.
 */
public class LazyBarTenderMain {
    public static void main(String[] args) {
        HashMap<Integer, Set<Integer>> custMap = new HashMap<Integer, Set<Integer>>();

        custMap.put(1, new HashSet<Integer>(Arrays.asList(3, 7, 5, 2, 9)));
        custMap.put(2, new HashSet<Integer>(Arrays.asList(5)));
        custMap.put(3, new HashSet<Integer>(Arrays.asList(2, 3)));
        custMap.put(4, new HashSet<Integer>(Arrays.asList(4)));
        custMap.put(5, new HashSet<Integer>(Arrays.asList(3, 4, 5, 7)));

        System.out.println("totalDrinks number of drinks required: " + countDrinks(custMap));

        System.out.println("For another input =============================== ");
        custMap = new HashMap<Integer, Set<Integer>>();

        custMap.put(1, new HashSet<Integer>(Arrays.asList(0 ,1, 3, 6)));
        custMap.put(2, new HashSet<Integer>(Arrays.asList(1,4,7)));
        custMap.put(3, new HashSet<Integer>(Arrays.asList(2, 4,7,5)));
        custMap.put(4, new HashSet<Integer>(Arrays.asList(3,2,5)));
        custMap.put(5, new HashSet<Integer>(Arrays.asList(5,8)));

        System.out.println("totalDrinks number of drinks required: " + countDrinks(custMap));

    }

    private static int countDrinks(Map<Integer, Set<Integer>> custMap) {
        int drinksToRem = 0;
        // 1. find totalDrinks drinks available
        int totalDrinks = 0;
        Iterator<Integer> iterator = custMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer mapKey = iterator.next();
            Iterator<Integer> valueIterator = custMap.get(mapKey).iterator();
            while (valueIterator.hasNext()) {
                Integer next = valueIterator.next();
                totalDrinks = totalDrinks >  next ? totalDrinks : next;
            }
        }
        totalDrinks += 1;
        // 2. create a ds such that drink -> user map
        int actualCustomers = custMap.size();
        int columns = actualCustomers+1;
        System.out.println("Users are : " + columns);
        int[][] customDS = new int[totalDrinks][columns];
        iterator = custMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer mapKey = iterator.next();
            Iterator<Integer> valueIterator = custMap.get(mapKey).iterator();
            while (valueIterator.hasNext()) {
                Integer next = valueIterator.next();
                customDS[next][mapKey-1] = 1;
                customDS[next][columns-1] += 1;
            }
        }
        // 3. iterate the ds to check if its succesfully set
        for (int i=0; i<totalDrinks; i++) {
            for (int j=0; j<columns; j++) {
                System.out.print(customDS[i][j] + " ");
            }
            System.out.println();
        }
        // 4. process the map accordingly
        int customersSatisfied = 0;
        int customersToSatisfy = custMap.size();
        while (customersSatisfied != customersToSatisfy) {
            // 4.a pick the drink which satisfies most
            int max = 0;
            int drink = 0;
            for (int i=0; i<totalDrinks; i++) {
                if (customDS[i][actualCustomers] > max) {
                    max = customDS[i][actualCustomers];
                    drink = i;
                }
            }
            // 4.b after finding the customers it satisfies add it to customersSatisfied
            customersSatisfied += max;
            // 4.c find the customers it satisfies and update the ds such that those customers
            // need not be processed again
            for (int j=0; j<columns; j++) {
                // if drink satisfies the current user
                if (customDS[drink][j] == 1) {
                    // for that user we don't need further process so remove all the other drink satisfactory
                    for (int i=0; i<totalDrinks; i++) {
                        if (customDS[i][j] == 1) {
                            customDS[i][j] = 0;
                            customDS[i][actualCustomers] -= 1;
                        }
                    }
                }
            }
            // 5. increase the drinks to remember count
            drinksToRem++;
        }
        return drinksToRem;
    }
}
