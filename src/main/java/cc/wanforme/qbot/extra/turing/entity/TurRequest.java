package cc.wanforme.qbot.extra.turing.entity;

import cc.wanforme.qbot.extra.turing.constant.TuringReqType;

/** 图灵机器人 API请求体
 * @author wanne
 * 2021年12月6日
 */
public class TurRequest {

	private TuringReqType reqType = TuringReqType.TEXT;
	
	private TurPerception perception;
	
	private TurUserInfo userInfo;

	public TuringReqType getReqType() {
		return reqType;
	}

	public void setReqType(TuringReqType reqType) {
		this.reqType = reqType;
	}

	public TurPerception getPerception() {
		return perception;
	}

	public void setPerception(TurPerception perception) {
		this.perception = perception;
	}

	public TurUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(TurUserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
