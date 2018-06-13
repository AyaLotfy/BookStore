package data;

import java.util.LinkedList;

public interface IshoppingCart {
	
	void addBook (Book book);
	
	LinkedList<Book> getBooks ();
	
	void clearCart ();
	
	void removeBook (String ISBN);
	
	void removeItems ();
}
