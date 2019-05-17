package teacher.entity;


/*
 * 老师实体类，get（）和set（）方法。
 */
public class Teacher {
	
	private Integer id;
	private String name;
	private String college;
	private String profession;
	private String grade;
	private double salary;
	private Integer age;
	
	public Teacher() {
		super();
	}

	public Teacher(Integer id, String name, String college, String profession, String grade, double salary,
			Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.profession = profession;
		this.grade = grade;
		this.salary = salary;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
