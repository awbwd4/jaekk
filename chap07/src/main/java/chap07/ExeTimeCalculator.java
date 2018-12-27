package chap07;

public class ExeTimeCalculator implements Calculator {
	
	private Calculator delegate;

	public ExeTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
	}
	
	
	
	
	
	@Override
	public long factorial(long num) {
		long start=System.nanoTime();
		//long start=System.currentTimeMillis();
		
		long result = delegate.factorial(num);
		//팩토리얼 연산을 직접 구현하지 않고, 다른 객체에 위임함.
		
		
		long end = System.nanoTime();
		//long end = System.currentTimeMillis();
		
		
		System.out.printf("%s.factorial(%d) 실행 시간 = %d\n",
				delegate.getClass().getSimpleName(),
				num, (end-start)
				);
		
		
		return result;
		
		
	}
	

	
	
	

}
