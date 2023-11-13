package javaBasic;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Test;

public class Topic_06_AssertJ {
	
	@Test
	public void TC_01() {
		Topic_06_AssertJ frodo = new Topic_06_AssertJ();
		Topic_06_AssertJ sauro = new Topic_06_AssertJ();
		
		// basic Assertions
		assertThat(frodo.getName()).isEqualTo("frodon");
		assertThat(frodo.getName()).isNotEqualTo(sauro);
		
		//Chaining string specific assertions
		
		assertThat(frodo.getName())
		.startsWith("fro")
		.endsWith("do")
		.isEqualToIgnoringCase("frodo");
	}
	
	public String getName() {
		return "frodo";
		
	}
	

}
