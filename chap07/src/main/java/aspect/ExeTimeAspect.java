package aspect;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;


//POJO클래스를 통해 aspect구현 ->이렇게 구현 한 aspect를 xml 스키마 설정을 통해 어디에 적용해야 할지 설정 함.
public class ExeTimeAspect {

	//joinPoint : advice 적용 가능 지점, 대상 객체의 메서드를 호출할 때 사용.
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		
		long start = System.nanoTime();
		
		try {
			Object result = joinPoint.proceed();//대상 객체의 proceed메서드 호출
			return result;
		} finally {
			
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();//메서드 시그니처
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(),//getTarget대상 객체, getArgs 대상 목록 
					sig.getName(), Arrays.toString(joinPoint.getArgs())
					);
			
		}
	}
	
}
