package studentmanage;
public class Student {
	private Integer id;
    private String name;
    private String sex;
    private String academy;
    private String major;
    private String grade;
    private Integer classes;
    public Student(Integer id,String name,String sex,String academy,String major,String grade,Integer classes){
    super();
    this.id=id;
    this.academy=academy;
    this.classes=classes;
    this.name=name;
    this.major=major;
    this.sex=sex;
    this.grade=grade;
    }
    public Student(){
    	
    }

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getAcademy() {
		return academy;
	}

	public String getMajor() {
		return major;
	}

	public String getGrade() {
		return grade;
	}

	public Integer getClasses() {
		return classes;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setClasses(Integer classes) {
		this.classes = classes;
	}
}
