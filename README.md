# 곱셈

https://www.acmicpc.net/problem/1629

# 구현 방법
```
ex) 5의 45제곱을 257로 나눈 나머지를 구하는 경우 ( bi는 45를 2진수로 표현한 것의 각 자리수이다.)

    i  / 5   4   3   2   1   0
    bi / 1   0   1   1   0   1
    a  / 5
    
    1) i = 5 일때, bi = 1이므로 a = ( 1^2 * 5 ) mod 257 = 5 이다.

    i  / 5   4   3   2   1   0
    bi / 1   0   1   1   0   1
    a  / 5  25 
    
    2) i = 4일 때, bi = 0이므로 a = ( 5^2 ) mod 257 = 25 이다.
    
    i  / 5   4   3   2   1   0
    bi / 1   0   1   1   0   1
    a  / 5  25  41
    
    3) i = 3일 때,1 bi = 1이므로 a = ( 25^2 * 5 ) mod 257 = 41 이다.
    
    i  / 5   4   3   2   1   0
    bi / 1   0   1   1   0   1
    a  / 5  25  41 181
    
    4) i = 2일 때, bi = 1이므로 a = ( 41^2 * 5) mod 257 = 181 이다.
    
    i  / 5   4   3   2   1   0
    bi / 1   0   1   1   0   1
    a  / 5  25  41 181 122

    5) i = 1일 때, bi = 0이므로 a = ( 181^2 ) mod 257 = 122 이다.
    
    i  / 5   4   3   2   1   0
    bi / 1   0   1   1   0   1
    a  / 5  25  41 181 122 147
    
    6) i = 0일 때, bi = 1이므로 a = ( 122^2 * 5) mod 257 = 147 이다.
    
    따라서 최종 값 147이 답이 된다.
```

# 구현 방법의 증명
```
 귀납법으로 증명

 * ki = k를 이진수로 표핸했을때 i까지 적은 수 / 예를 들어 위의 예제에서 k3 = 101, k2 = 1011, k1 = 10110 이다.
   n은 나머지를 구할 때 나누는 수, m은 제곱이 되는 수, k는 k번 곱해야 하는 수이다.

 루프의 각 반복이 끝이 났을 때 a의 값은 ( m^ki ) mod n 이다.

 그리고 반복이 최종적으로 끝이 났을 때 a의 값은 ( m ^ k ) mod  n 이다.

 1) 최상위 비트 bj 는 항상 1이다. 따라서 a = ( m ^ 1 ) mod n = ( m ^ kj ) mod n 이다.
 
 2) 반복문의 인덱스 값이 i 가 되었을 때의 a 의 값을 ( m ^ ki ) mod n 라고 가정한다.

 3) 반복문의 인덱스 값이 i - 1 가 되었을 때의 a 의 값을 ( m ^ ki-1 ) mod n 이 되면 이 알고리즘은 항상 성립한다고 할 수 있다.
    
    i)  ki-1 의 마지막 비트 = 0 일 때, 2ki = ki-1 이다.

        따라서  a = ( m^2ki ) mod n = ( m^ki-1 ) mod n 로 a의 값이 ( m^ki-1 ) mod n 가 된다.
       
    ii) ki-1 의 마지막 비트 = 1 일 때, 2ki  + 1 = ki-1 이다.

        따라서  a = { ( m^2ki ) * m } mod n = ( m^ki-1 ) mod n 로 a의 값이 ( m^ki-1 ) mod n 가 된다. 

 4) 따라서 이 알고리즘은 항상 성립한다고 볼 수 있다.
```

# 구현 코드
```java
import java.util.Scanner;
import java.util.ArrayList;
public class MODPOWER {
	
	static ArrayList<Integer> bit = new ArrayList<Integer>();
	static long a;
	
	public static void computePower(int n, int m, int k)
	{
		int i;
		
		a = 1;
		
		for(i = bit.size() - 1; i >= 0; i--)
		{
			a = (a*a) % n ;
			
			if(bit.get(i) == 1)
			{
				a = (a * m) % n;
			}
		}
	}
	
	public static void makebit(int k)
	{
		if(k == 0) return;
		
		int n = k % 2;
		
		bit.add(n);
		
		makebit(k/2);
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		makebit(k);
		
		computePower(n, m, k);
		
		System.out.println(a);
		
		sc.close();
	}

}
```


