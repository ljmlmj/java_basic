package sec07;

/**
 * 학생들의 성적을 저장하기 위해서 두 개의 배열이 필요함
 * - 이름은 String[] 배열
 * - 성정은 int[] 배열
 */ 
public class Array19Module {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 기본 데이터를 저장하고 있는 배열
		// 1. 학생명 배열
		String[] nameStrings = {"최태원", "이경선", "배준섭",
				"홍원표", "김성현", "우상현", "심미안"};
		// 2. 성적 배열
		int[] scores = new int[] {87, 95, 100, 65, 70, 84, 69};
		
		// 평균점수
		double avg = 0.00;
		
		
		// 총점 구하는 메소드 호출
		int sum = 0;
		sum = sum(scores);
		
		// 평균 구하기
		avg = (double)sum / scores.length;
		System.out.printf("평균 점수는 \"%.1f점\"", avg);
		
		System.out.println();
		
		// 최고점 및 최고점 학생 구하는 메소드 호출
		maxScore(nameStrings, scores);		
	}

	private static void maxScore(String[] nameStrings, int[] scores) {
		// TODO Auto-generated method stub
		int maxScore = 0;
		String maxStudent= "";
		
		// 최고 점수와 최고 점수 학생
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > maxScore) {
				maxScore = scores[i];
				maxStudent = nameStrings[i];
			}
		}
		System.out.printf("최고점은 \"%d점\" 입니다.", maxScore);	
		System.out.println();
		System.out.printf("최고 성적은 %s님 입니다.", maxStudent);	
	}

	// 총점 구하는 메소드
	private static int sum(int[] scores) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < scores.length; i++) { // 총점
			sum += scores[i];
		}
		return sum;
	}
}
