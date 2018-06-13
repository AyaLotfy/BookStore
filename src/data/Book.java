//package data;
//
//import java.time.Year;
//
//public class Book {
//
//	private String ISBN, title, pub;
//	
//	private Double price;
//	
//	private int copies;
//	
//	private Year pub_year;
//
//	
//	
//	public Book (String ISBN, String title, String price, String copies, String pub) {
////		this.copies = copies;
////		this.ISBN = ISBN;
////		this.price = price;
////		this.title = title;
////		this.pub = pub;
////		this.total = Double.toString(Double.parseDouble(price) * Double.parseDouble(copies));
//	}
//
//	public String getISBN() {
//		return ISBN;
//	}
//
////	public String getPrice() {
////		return price;
////	}
////
////	public String getCopies() {
////		return copies;
////	}
//
//	public String getTitle() {
//		return title;
//	}
//
////	public String getTotal() {
////		return total;
////	}
//	
//	public String getPub() {
//		return pub;
//	}
//}


package data;

public class Book {

	private String ISBN, title, pub_name, category, author, pub_year;

	private Double price;

	private int copies, threshold, id = 0;

	public Book() {
		this.id = 0;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCopies(String copies) {
		this.copies = Integer.parseInt(copies);
	}
	public void setCopies(Integer copies) {
		this.copies = copies;
	}

	public void setThreshold(String threshold) {
		this.threshold = Integer.parseInt(threshold);
	}
	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public void setPubName(String pub_name) {
		this.pub_name = pub_name;
	}

	public void setPub_year(String pub_year) {
		this.pub_year = pub_year;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(String price) {
		this.price = Double.parseDouble(price);
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public String getISBN() {
		return ISBN;
	}

	public Double getPrice() {
		return price;
	}

	public int getCopies() {
		return copies;
	}

	public int getThreshold() {
		return threshold;
	}

	public String getTitle() {
		return title;
	}

	public String getPubName() {
		return pub_name;
	}

	public String getCategory() {
		return category;
	}

	public String getAuthor() {
		return author;
	}
	
	public String getPubYear() {
		return pub_year;
	}
	
	public int getID() {
		return id;
	}

}