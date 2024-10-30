package oop;

public class Order {

	    private MenuItem[] items = new MenuItem[5];
	    private int[] quantities = new int[5];
	    private int count = 0;

	    public void addItem(MenuItem item, int quantity) {
	        if (count >= items.length) {
	            items = resizeArray(items);
	            quantities = resizeArray(quantities);
	        }
	        items[count] = item;
	        quantities[count] = quantity;
	        count++;
	    }

	    public double getTotal() {
	    	
	        double total = 0.0;
	        for (int i = 0; i < count; i++) {
	            total += items[i].getPrice() * quantities[i];
	        }
	        return total;
	    }

	    public void printOrderDetails() {
	        for (int i = 0; i < count; i++) {
	            System.out.println( items[i].getName()+" (x"+quantities[i]+")" + " = ₱"+ items[i].getPrice() * quantities[i]);
	        }
	    }

	    private MenuItem[] resizeArray(MenuItem[] array) {
	        MenuItem[] newArray = new MenuItem[array.length * 2];
	        System.arraycopy(array, 0, newArray, 0, array.length);
	        return newArray;
	    }

	    private int[] resizeArray(int[] array) {
	        int[] newArray = new int[array.length * 2];
	        System.arraycopy(array, 0, newArray, 0, array.length);
	        return newArray;
	    
	}
	
}
