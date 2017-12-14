package jsp.community;

import java.sql.Timestamp;

public class C_Dto {
	int cNum;
	int cId;
	String cName;
	String cTitle;
	String cContent;
	Timestamp cDate;
	int cHit;
	
	public C_Dto(){
		
	}
	
	public C_Dto(int cNum, int cId, String cName, String cTitle, String cContent, Timestamp cDate, int cHit) {
		this.cNum=cNum;
		this.cId = cId;
		this.cName = cName;
		this.cTitle = cTitle;
		this.cContent = cContent;
		this.cDate = cDate;
		this.cHit = cHit;
	}
	public int getcNum(){
		return cNum;
	}
	public void setcNum(int cNum){
		this.cNum=cNum;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcTitle() {
		return cTitle;
	}
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public Timestamp getcDate() {
		return cDate;
	}
	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}
	public int getcHit() {
		return cHit;
	}
	public void setcHit(int cHit) {
		this.cHit = cHit;
	}
}
