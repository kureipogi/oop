package oop;

public class Receipt {

	    private String customerName;
	    private String customerLocation;
	    private String customerPhone;
	    private Order order;

	    public Receipt(String customerName, String customerLocation, String customerPhone, Order order) {
	        this.customerName = customerName;
	        this.customerLocation = customerLocation;
	        this.customerPhone = customerPhone;
	        this.order = order;
	    }

	    public void printReceipt() {
	        System.out.println("\n========= Receipt ================");
	        System.out.println("Customer Name: " + customerName);
	        System.out.println("Location: " + customerLocation);
	        System.out.println("Phone Number: " + customerPhone);
	        System.out.println("====================================");
	        order.printOrderDetails();
	        System.out.println("Total: ₱"+ order.getTotal());
	        System.out.println("====================================");
	    
	}
	
}
