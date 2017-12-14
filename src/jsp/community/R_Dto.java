package jsp.community;

import java.sql.Timestamp;

public class R_Dto {
	int rNum;
	int rParent;
	int rGroup;
	String rName;
	String rContent;
	Timestamp rDate;
	int rStep;
	int rIndent;
	
	public R_Dto(){
		
	}
	
	public R_Dto(int rNum, int rParent, int rGroup, String rName, String rContent, Timestamp rDate, int rStep, int rIndent) {
		this.rNum = rNum;
		this.rParent = rParent;
		this.rGroup = rGroup;
		this.rName = rName;
		this.rContent = rContent;
		this.rDate = rDate;
		this.rStep = rStep;
		this.rIndent = rIndent;
	}

	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	
	public int getrParent() {
		return rParent;
	}
	
	public void setrParent(int rParent) {
		this.rParent = rParent;
	}
	
	public int getrGroup() {
		return rGroup;
	}
	public void setrGroup(int rGroup) {
		this.rGroup = rGroup;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public Timestamp getrDate() {
		return rDate;
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	public int getrStep() {
		return rStep;
	}
	public void setrStep(int rStep) {
		this.rStep = rStep;
	}
	public int getrIndent() {
		return rIndent;
	}
	public void setrIndent(int rIndent) {
		this.rIndent = rIndent;
	}
}
