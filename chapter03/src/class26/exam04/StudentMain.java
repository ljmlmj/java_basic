package class26.exam04;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student[] arrStd = new Student[5];
		arrStd[0] = new Student("김홍철", 23, '남', "010-2340-1233", 85);
		arrStd[1] = new Student("정순미", 24, '여', "010-9857-7532", 70);
		arrStd[2] = new Student("이만섭", 22, '남', "010-6548-4687", 96);
		arrStd[3] = new Student("최주호", 20, '남', "010-2528-9368", 85);
		arrStd[4] = new Student("고미림", 26, '여', "010-1068-2549", 77);

		int count = 0;
		int sum = 0;
		double avg = 0.0;
		int maxScore = 0;
		String maxStudent = null;
		
		// for문
		System.out.println("=============================================");
		System.out.println(" name   age    gender       phone      score");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < arrStd.length; i++) {
			System.out.println(arrStd[i].name + "\t" + arrStd[i].age + "\t" +
					arrStd[i].gender + "\t" + arrStd[i].phone + "\t" + arrStd[i].score);
			sum += arrStd[i].score;
			count++;
			if (arrStd[i].score > maxScore) {
				maxScore = arrStd[i].score;
				maxStudent = arrStd[i].name;
			}
		}
		avg = (double) sum / count;
		System.out.println("=============================================");
		System.out.println("총인원 : " + count);
		System.out.printf("평균점수 : %.2f\n", avg);
		System.out.printf("최고점수는 : %d점 이며 최고점의 학생은 : %s님 입니다.\n", maxScore, maxStudent);
		System.out.println();
		
		// 향상된 for문
		count = 0;
		sum = 0;
		System.out.println("=============================================");
		System.out.println(" name   age    gender       phone      score");
		System.out.println("---------------------------------------------");
		for (Student student : arrStd) {
			System.out.println(student.showStudentInfo());
			sum += student.score;
			count++;
			if (student.score > maxScore) {
				maxScore = student.score;
				maxStudent = student.name;
			}
		}
		avg = (double) sum / count;
		System.out.println("=============================================");
		System.out.println("총인원 : " + count);
		System.out.printf("평균점수 : %.2f\n", avg);
		System.out.printf("최고점수는 : %d점 이며 최고점의 학생은 : %s님 입니다.\n", maxScore, maxStudent);
		System.out.println();
	}

}
