package Cart;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public int getCount(){
        return items.size();
    }

    public void addItem(LineItem item, boolean isUpdate){
//        String code = item.getProduct().getCode();
//        int quantity = item.getQuantity();
//        for(LineItem cartItem : items){
//            if(cartItem.getProduct().getCode().equals(code)){
//                cartItem.setQuantity(quantity);
//                return;
//            }
//        }
//        items.add(item);
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (LineItem cartItem : items) {
            if (cartItem.getProduct().getCode().equals(code)) {
                if (isUpdate) {
                    // Ghi đè số lượng khi update
                    cartItem.setQuantity(quantity);
                } else {
                    // Cộng dồn số lượng khi add
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                }
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item){
        String code = item.getProduct().getCode();
        for(int i = 0; i < items.size(); i++){
            LineItem lineItem = items.get(i);
            if(lineItem.getProduct().getCode().equals(code)){
                items.remove(i);
                return;
            }
        }
    }
}
