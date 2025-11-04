/**
   860. Lemonade Change

   At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to
   buy from you and order one at a time (in the order specified by bills).
   Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
   You must provide the correct change to each customer so that the net transaction is
   that the customer pays $5.

   Note that you do not have any change in hand at first.

   Given an integer array bills where bills[i] is the bill the ith customer pays,
   return true if you can provide every customer with the correct change, or false otherwise.

   Example 1:
   Input: bills = [5,5,5,10,20]
   Output: true
   Explanation: 
   From the first 3 customers, we collect three $5 bills in order.
   From the fourth customer, we collect a $10 bill and give back a $5.
   From the fifth customer, we give a $10 bill and a $5 bill.
   Since all customers got correct change, we output true.

   Example 2:
   Input: bills = [5,5,10,10,20]
   Output: false
   Explanation: 
   From the first two customers in order, we collect two $5 bills.
   For the next two customers in order, we collect a $10 bill and give back a $5 bill.
   For the last customer, we can not give the change of $15 back because we only have two
   $10 bills.
   Since not every customer received the correct change, the answer is false.

   Constraints:
   1 <= bills.length <= 105
   bills[i] is either 5, 10, or 20.
 */
boolean lemonadeChange(int[]bills) {
    int five = 0, ten = 0;
    for (int i = 0; i < bills.length; ++i) {
        if (bills[i] == 5) five++;
        else if (bills[i] == 10) {
            if (five > 0) {
                five--;
                ten++;
            } else return false;
        } else if (bills[i] == 20) {
            if (five > 0 && ten > 0) {
                ten--;
                five--;
            } else if (five >= 3) five -= 3;
            else return false;
        }
    }
    return true;
}
void main() {
    int[]bills1 = {5, 5, 5, 10, 20};
    int[]bills2 = {5, 5, 10, 10, 20};
    int[]bills3 = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
    int[]bills4 = {10, 10};
    IO.println(lemonadeChange(bills1)); // true
    IO.println(lemonadeChange(bills2)); // false
    IO.println(lemonadeChange(bills3)); // true
    IO.println(lemonadeChange(bills4)); // false
}
/**
// my stupid solution
// same mf logic but used unnecessary hashmap
boolean lemonadeChange(int[]bills) {
    Map<Integer, Integer> p = new HashMap<>();
    p.put(5, 0);
    p.put(10, 0);
    p.put(20, 0);
    for (int i = 0; i < bills.length; ++i) {
        if (bills[i] == 5) p.put(5, p.getOrDefault(5, 0)+1);
        else if (bills[i] == 10) {
            if (p.get(5) > 0) {
                p.put(5, p.getOrDefault(5, 0)-1);
                p.put(10, p.getOrDefault(10, 0)+1);
            } else return false;
        } else if (bills[i] == 20) {
            if (p.get(5) > 0 && p.get(10) > 0) {
                p.put(10, p.getOrDefault(10, 0)-1);
                p.put(5, p.getOrDefault(5, 0)-1);
                p.put(20, p.getOrDefault(20, 0)+1);
            } else if (p.get(5) >= 3) {
                p.put(5, p.getOrDefault(5, 0)-3);
                p.put(20, p.getOrDefault(20, 0)+1);
            } else return false;
        }
    }
    return true;
}
 */
