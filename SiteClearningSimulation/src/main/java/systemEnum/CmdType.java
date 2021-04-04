package systemEnum;

public enum CmdType {
	Adv('a'), //advance
	Left('l'), //left
	Right('r'), //right
	Quit('q'); //quit	
	
	public final char value;
	
	private CmdType(char c) {
		this.value = c;
	}
}
