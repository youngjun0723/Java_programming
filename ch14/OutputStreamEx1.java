package ch14;

import java.io.OutputStream;

public class OutputStreamEx1 {

	public static void main(String[] args) {
		try {
			char a = 'A';
			char b = 'b';
			char c = '가';
			OutputStream os = System.out;//콘솔차에 꼽혀 있는 빨대 연결
			//print: 일반적인 사람이 읽기 쉬운 문자열 단위로 출력
			os.write(a);//write: 바이트 단위 또는 문자 하나 출력사용. ex)파일전송, 이미지전송, 네트워크 통신
			os.write(b);
			os.write(c);
			os.write(65);//바이트 읽은 뒤에 A로 변환. 만약 print(65) -> 65
			os.flush();//스트림에 남아 있는 data를 비움.
			os.close();//사용을 하지 않는 스트림 반드시 close함.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








