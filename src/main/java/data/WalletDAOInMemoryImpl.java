package data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository // could also be @Component but can only implement one interface
@Primary
public class WalletDAOInMemoryImpl implements WalletDAO {
	// Giraffes should be stored in a map

	private Map<Integer, Item> items;
	
	private int id = 1;

	public WalletDAOInMemoryImpl() {
		items = new HashMap<>();
		loadSampleGiraffes();
	}

	public WalletDAOInMemoryImpl(Map<Integer, Item> items) {
		items = new HashMap<>();
		loadSampleGiraffes();
	}

	private void loadSampleGiraffes() {
		items.put(id, new Item("Credit Card", id++, 14.3, null));
		items.put(id, new Item("Business Card", id++, 15, null));
		items.put(id, new Item("Debit Card", id++, 8, null));
		return;
	}

	@Override
	public Item addItem(Item i) {
		i.setId(id++);
		return items.put(i.getId(), i);
		

	}

	@Override
	public List<Item> getAllItems() {
		return new ArrayList<Item>(items.values());
	}

	@Override
	public Item getItemById(int id) {
		return items.get(id);
	}

	@Override
	public Item deleteItem(Item i) {
		return items.remove(i.getId());

	}

	@Override
	public Item editItem(Item i) {
		return items.put(i.getId(), i);
	}

}
