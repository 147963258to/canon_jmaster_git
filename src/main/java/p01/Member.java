package p01;

public class Member {
	//フィールド
	private int code;   //ID
	private String name; //名前
	private int age; //年齢
	private String tel; //電話番号
	
	
	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param tel
	 */
	public Member(int code, String name, int age, String tel) {
		super();
		this.code = code;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}


	/**
	 * @return id
	 */
	public int getCode() {
		return code;
	}


	/**
	 * @param id セットする id
	 */
	public void setCode(int code) {
		this.code = code;
	}


	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age セットする age
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}


	/**
	 * @param tel セットする tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	

}
