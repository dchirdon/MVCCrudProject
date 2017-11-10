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
		private Map<Integer, Item> items;

		public WalletDAOInMemoryImpl() {
			items = new HashMap<>();
			loadSampleItems();
		}

		public WalletDAOInMemoryImpl(Map<Integer, Item> items) {
			items = new HashMap<>();
			loadSampleWallet();
		}

		private void loadSampleGiraffes() {
			items.put(1, new Item("Jerry", 1, 14.3));
			items.put(2, new Item("Gina", 2, 15));
			items.put(3, new Item("Dobby", 3, 8));
			return;
		}

		@Override
		public Item addGiraffe(Item i) {
			return items.put(i.getId(), i);

		}

		@Override
		public List<Item> getAllItems() {
			return new ArrayList<Item>(items.values());
		}

		@Override
		public Item getWalletById(int id) {
			return items.get(id);
		}

		@Override
		public Item deleteItem(Item i) {
			return items.remove(i.getId());

		}

		@Override
		public Item updateItem(Item i) {
			return items.put(i.getId(), i);
		}

	}


