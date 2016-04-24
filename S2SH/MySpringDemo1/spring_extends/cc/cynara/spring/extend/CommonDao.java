package cc.cynara.spring.extend;


public class  CommonDao {
	
	private String s;
	
	
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public void saveEntity(){
		System.out.println("save entity");
	}
	public void updateEntity(){
		System.out.println("update entity");
	}
}
