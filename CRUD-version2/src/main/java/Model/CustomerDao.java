package Model;

import java.util.*;

public class CustomerDao {
    private static final Map<Integer, Customer> listCUSTOMER = new HashMap<Integer, Customer>();

    static {
        initCustomers();
    }

    private static void initCustomers() {

        Customer cus1 = new Customer(1, "Nguyen Truong Lam", "0973439239", "kisibian108@gmail.com");
        Customer cus2 = new Customer(2, "Nguyen Xuan Linh", "0915973456", "linh@gmail.com");
        Customer cus3 = new Customer(3, "Nguyen Thu Hoai", "0912213669", "hoai@gmail.com");
        Customer cus4 = new Customer(4, "Nguyen Thu Hien", "0912212991", "hien@gmail.com");

        listCUSTOMER.put(cus1.getId(), cus1);
        listCUSTOMER.put(cus2.getId(), cus2);
        listCUSTOMER.put(cus3.getId(), cus3);
        listCUSTOMER.put(cus4.getId(), cus4);
    }

    public static Customer getCustomer( int customerId){
        return listCUSTOMER.get(customerId);
    }

    public static void addCustomer( Customer customer){
        listCUSTOMER.put(customer.getId(), customer);
    }

    public static Customer updateAndCreateCustomer( Customer customer){
        listCUSTOMER.put(customer.getId(), customer);
        return customer;
    }

    public static void deleteCustomer( int customerId ){
        listCUSTOMER.remove(customerId);
    }

    public static List<Customer> getAllCustomer(){
        Collection<Customer> c = listCUSTOMER.values();
        List<Customer> list = new ArrayList<Customer>();
        list.addAll(c);
        return list;
    }
}
