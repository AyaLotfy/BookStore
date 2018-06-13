package data;

public class Table implements ITable {
	
	private String[] attributes;
	
	private String[][] data;

	@Override
	public String[] getAttributes() {
		// TODO Auto-generated method stub
		return attributes;
	}

	@Override
	public String[][] getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setAttributes(String[] attributes) {
		// TODO Auto-generated method stub
		this.attributes = attributes;
	}

	@Override
	public void setData(String[][] data) {
		// TODO Auto-generated method stub
		this.data = data;
	}

	

}
