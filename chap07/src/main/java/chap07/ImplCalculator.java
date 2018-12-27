package chap07;

public class ImplCalculator implements Calculator{
	//루프로 팩토리얼 구현
	@Override
	public long factorial(long num) {
		
		long start = System.currentTimeMillis();
		
		long result = 1;
		for (int i = 1; i <= num; i++) {
			result *= 1;
		}
		
		long end = System.currentTimeMillis();
		System.out.printf("implcalculator(%d) 실행시간 = %d\n", num, (end-start));
		
		return result;
	}

}
