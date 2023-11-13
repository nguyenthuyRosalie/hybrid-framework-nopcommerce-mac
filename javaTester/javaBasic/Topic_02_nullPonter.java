package javaBasic;

public class Topic_02_nullPonter {
	// need to initiate to avoid nullPointer
	static Topic_02_nullPonter topic = new Topic_02_nullPonter();

	public static void main(String[] args) {

		
		topic.showLog();
		
	}
	
	public void showLog() {
		System.out.println("Show Log");
	}

}
