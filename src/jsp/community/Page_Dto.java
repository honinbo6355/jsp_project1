package jsp.community;

public class Page_Dto {
	private int page_num; 
	private int total_record; 
	private int page_per_record_cnt; 
	private int group_per_page_cnt; 
	private int record_start_num; 
	private int record_end_num; 
	private int total_page; 
	private int group_num; 
	private int page_snum; 
	private int page_enum; 
	private int prev_page_num; 
	private int next_page_num; 
	

	public Page_Dto(){
		
	}
	
	public int getPage_num() {
		return page_num;
	}

	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}

	public int getTotal_record() {
		return total_record;
	}

	public void setTotal_record(int total_record) {
		this.total_record = total_record;
	}

	public int getPage_per_record_cnt() {
		return page_per_record_cnt;
	}

	public void setPage_per_record_cnt(int page_per_record_cnt) {
		this.page_per_record_cnt = page_per_record_cnt;
	}

	public int getGroup_per_page_cnt() {
		return group_per_page_cnt;
	}

	public void setGroup_per_page_cnt(int group_per_page_cnt) {
		this.group_per_page_cnt = group_per_page_cnt;
	}

	public int getRecord_start_num() {
		return record_start_num;
	}

	public void setRecord_start_num(int record_start_num) {
		this.record_start_num = record_start_num;
	}

	public int getRecord_end_num() {
		return record_end_num;
	}

	public void setRecord_end_num(int record_end_num) {
		this.record_end_num = record_end_num;
	}

	public int getTotal_page() {
		return total_page;
	}

	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}

	public int getGroup_num() {
		return group_num;
	}

	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}

	public int getPage_snum() {
		return page_snum;
	}

	public void setPage_snum(int page_snum) {
		this.page_snum = page_snum;
	}

	public int getPage_enum() {
		return page_enum;
	}

	public void setPage_enum(int page_enum) {
		this.page_enum = page_enum;
	}

	public int getPrev_page_num() {
		return prev_page_num;
	}

	public void setPrev_page_num(int prev_page_num) {
		this.prev_page_num = prev_page_num;
	}

	public int getNext_page_num() {
		return next_page_num;
	}

	public void setNext_page_num(int next_page_num) {
		this.next_page_num = next_page_num;
	}

	public void Pazing(){
		this.record_end_num=this.page_num*this.page_per_record_cnt;
		this.record_start_num=this.record_end_num-(this.page_per_record_cnt-1);
		if(this.record_end_num>this.total_record)
			this.record_end_num=this.total_record;
		this.total_page=(this.total_record/this.page_per_record_cnt)+((this.total_record%this.page_per_record_cnt>0)?1:0);
		if(this.page_num>this.total_page)
			this.page_num=this.total_page;
		this.group_num=this.page_num/this.group_per_page_cnt+((this.page_num%this.group_per_page_cnt>0)?1:0);
		this.page_enum=this.group_num*this.group_per_page_cnt;
		this.page_snum=this.page_enum-(this.group_per_page_cnt-1);
		if(this.page_enum>this.total_page)
			this.page_enum=this.total_page;
		this.prev_page_num=this.page_snum-this.group_per_page_cnt;
		this.next_page_num=this.page_snum+this.group_per_page_cnt;
		if(this.prev_page_num<1)
			this.prev_page_num=1;
		if(this.next_page_num>this.total_page){
			this.next_page_num=this.total_page;
		}
	}
}
