package class05;

public class DepartmentData {
	public Department[] departments = new Department[3];
	
	public DepartmentData() {
		departments[0] = new Department(920, "컴퓨터공학과", "201호");
		departments[1] = new Department(923, "산업공학과", "207호");
		departments[2] = new Department(925, "전자공학과", "308호");
	}
}
