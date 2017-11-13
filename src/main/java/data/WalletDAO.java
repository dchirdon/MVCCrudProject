package data;

import java.util.List;

public interface WalletDAO {
	Item addItem(Item i); 
	List<Item> getAllItems(); 
	Item getItemById(int id); 
	Item deleteItem(Item i); 
	Item editItem(Item i); 
}
