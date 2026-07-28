package ch10;

public class ExceptionEx2 {

	public static void main(String[] args) {
		try {
			int arr[] = new int[3];
			arr[0] = 1;
			arr[1] = 2;
			arr[2] = 3;
			arr[3] = 4;
		} catch (Exception e) {
			//System.err.println(e.getMessage());
			e.printStackTrace();
		}	finally {//예외발생에 관계없이 무조건 실행되는 영역(옵션)
			System.out.println("finally");
		}
		System.out.println("End~");
	}

}
