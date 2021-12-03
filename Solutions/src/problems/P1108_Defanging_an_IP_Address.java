package problems;

public class P1108_Defanging_an_IP_Address {
    public static void main(String[] args) {
        Solution_Defanging_an_IP_Address sol = new Solution_Defanging_an_IP_Address();
        System.out.println(sol.defangIPAddress("1.1.1.1"));
    }
}

class Solution_Defanging_an_IP_Address {
    public String defangIPAddress(String address) {
        String[] addressArr = address.split("\\.");
        String joinedString = String.join("[.]", addressArr);

        return joinedString;
    }
}
