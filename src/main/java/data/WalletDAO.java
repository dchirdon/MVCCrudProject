package data;

import java.util.List;

public interface WalletDAO {
	Item addItem(Item i); //create
	List<Item> getAllItems(); //retrieve
	Item getItemById(int id); 
	Item deleteItem(Item i); //update
	Item editItem(Item i); //delete
}
