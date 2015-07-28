package jsoup.dto;

/**
 * LFS返回
 * @author wenchang.wu
 *
 */
public class ResponseMsg {

	private String retcode;//应答码  00：成功
	private String errmsg;//应答信息
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
