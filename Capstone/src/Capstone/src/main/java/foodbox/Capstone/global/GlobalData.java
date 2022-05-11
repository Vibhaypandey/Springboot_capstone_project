package foodbox.Capstone.global;

import java.util.ArrayList;
import java.util.List;

import foodbox.Capstone.model.Product;

public class GlobalData {
   public static List<Product> cart;
    static {
    	cart = new ArrayList<Product>();
    }
    
}

