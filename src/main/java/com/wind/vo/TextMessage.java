package com.wind.vo;

/**
 *	消息对象
 *  @author   :   Jay
 *  @fileName :   com.wind.vo.TextMessage.java
 *	@date	  :	  2015年5月4日
 */
public class TextMessage {
	
//	ToUserName	开发者微信号
//	FromUserName	发送方帐号（一个OpenID）
//	CreateTime	消息创建时间 （整型）
//	MsgType	text
//	Content	文本消息内容
//	MsgId	消息id，64位整型
	private String ToUserName;
	private String FromUserName;
	private Long CreateTime;
	private String MsgType;
	private String Content;
	private String MsgId;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public TextMessage(String toUserName, String fromUserName, Long createTime,
			String msgType, String content, String msgId) {
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		Content = content;
		MsgId = msgId;
	}
	public TextMessage() {
	}
	
	

}
