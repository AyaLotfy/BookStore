package application;

public class GameOfThronesCharacter {
	    private String name;
	    private String allegiance;
	    private String position;
	    private String salary;
	    private String price;

	    public GameOfThronesCharacter(){
	    }

	    public GameOfThronesCharacter(String name, String allegiance, String position, String salary, String price){
	        setName(name);
	        setAllegiance(allegiance);
	        setPosition(position);
	        setSalary(salary);
	        setprice(price);
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	            this.name = name;
	    }

	    public String getAllegiance() {
	        return allegiance;
	    }

	    public void setAllegiance (String allegiance){
	            this.allegiance = allegiance;
	    }

	    public String getPosition() {
	        return position;
	    }

	    public void setPosition(String position) {
	            this.position = position;
	    }

	    public String getSalary() {
	        return salary;
	    }

	    public void setSalary(String salary) {
	        this.salary = salary;
	    }       
	    
	    public String getprice() {
	        return price;
	    }

	    public void setprice(String price) {
	        this.price = price;
	    }       
	}

