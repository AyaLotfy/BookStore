package data;

public class User {

	private int id;

	private String name;

	private Byte is_manager;

	public User() {

	}

	public User(int id, String name, Byte is_manager) {
		this.name = name;
		this.id = id;
		this.is_manager = is_manager;

	}

	public Byte Is_manager() {
		return is_manager;
	}

	public void setIs_manager(Byte is_manager) {
		this.is_manager = is_manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
