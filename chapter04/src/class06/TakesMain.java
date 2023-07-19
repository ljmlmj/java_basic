package class06;

public class TakesMain {

	public static void main(String[] args) {
		// 성적 객체를 담을 Takes 타입 배열 선언
		TakesData td = new TakesData();
		Takes[] takes = td.takes;
		
		// 데이터 저장
		//initData(takes);
		
		// 전학생 성적 출력
		printTake(takes);
		
		// 성적이 "A+"인 학생의 id를 반환받아 출력
		String[] names = getAplus(takes);
		for (String arrName  : names) {
			System.out.println(arrName);
		}
	}

	// 데이터 저장 메소드
	private static void initData(Takes[] takes) {
		takes[0] = new Takes("1292001", "C101-01", "B+");
		takes[1] = new Takes("1292001", "C103-01", "A+");
		takes[2] = new Takes("1292001", "C301-01", "A");
		takes[3] = new Takes("1292002", "C102-01", "A");
		takes[4] = new Takes("1292002", "C103-01", "B+");
		takes[5] = new Takes("1292002", "C502-01", "C+");
		takes[6] = new Takes("1292003", "C103-02", "B");
		takes[7] = new Takes("1292003", "C501-02", "A+");
		takes[8] = new Takes("1292301", "C102-01", "C+");
		takes[9] = new Takes("1292303", "C102-01", "C");
		takes[10] = new Takes("1292303", "C103-02", "B+");
		takes[11] = new Takes("1292303", "C501-01", "A+");
	}
	
	// 전학생 성적 출력하는 메소드
	private static void printTake(Takes[] takes) {
		System.out.println("[전 학생 성적 출력]");
		System.out.println("id\t\tsubject \tscore");
		
		for (Takes take : takes) {
			System.out.println(take.getId().toString() + "\t\t" + take.getSubject().toString() + "\t\t"
							+ take.getScore().toString());
		}
		System.out.println();
	}

	// 성적이 "A+"인 학생의 id를 반환받아 출력하는 메소드
	private static String[] getAplus(Takes[] takes) {
		System.out.println("[성적이 \"A+\"인 학생의 id]");
		String strName = "";
		for (Takes take : takes) {
			if (take.getScore().equals("A+")) {
				strName += take.getId() + ",";
			}
		}
		String[] arrName = strName.split(",");
		
		return arrName;
	}

}
