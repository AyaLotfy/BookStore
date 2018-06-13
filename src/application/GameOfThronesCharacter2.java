package application;

import data.DBSchema;

public class GameOfThronesCharacter2 {
	  private String FIRST_NAME;
	    private String LAST_NAME;
	    private String UserName;
	    private String Email;
	    private String Phone;
	    private String address;
	    private String sales;

	    
	    public GameOfThronesCharacter2(){
	    }

	    public GameOfThronesCharacter2(String FIRST_NAME, String LAST_NAME, String UserName, String Email, String Phone, String address, String sales){
	        setFIRST_NAME(FIRST_NAME);
	        setLAST_NAME(LAST_NAME);
	        setUserName(UserName);
	        
	        setEmail(Email);
	        
	        setPhone(Phone);
	        setaddress(address);
	        setsales(sales);
	        
	    }

	    public String getFIRST_NAME() {
	        return FIRST_NAME;
	    }

	    public void setFIRST_NAME(String FIRST_NAME) {
	            this.FIRST_NAME = FIRST_NAME;
	    }

	    public String getLAST_NAME() {
	        return LAST_NAME;
	    }

	    public void setLAST_NAME (String LAST_NAME){
	            this.LAST_NAME = LAST_NAME;
	    }

	    public String getUserName() {
	        return UserName;
	    }

	    public void setUserName(String UserName) {
	            this.UserName = UserName;
	    }

	    public String getEmail() {
	        return Email;
	    }

	    public void setEmail(String Email) {
	        this.Email = Email;
	    }       
	    
	    public String getPhone() {
	        return Phone;
	    }

	    public void setPhone(String Phone) {
	        this.Phone = Phone;
	    }
	    
	    public String getaddress() {
	        return address;
	    }

	    public void setaddress(String address) {
	        this.address = address;
	    }    
	    
	    public String getsales() {
	        return sales;
	    }

	    public void setsales(String sales) {
	        this.sales = sales;
	    }    
	    
	}

