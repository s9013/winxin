package com.wind.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.wind.util.CheckUtil;
import com.wind.util.MessageUtil;

/**
 *  @author   :   Jay
 *  @fileName :   com.wind.servlet.Servlet.java
 *	@date	  :	  2015年5月4日
 */
public class WechatServlet extends HttpServlet{
	//signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	//timestamp	时间戳
	//nonce	随机数
	//echostr	随机字符串
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("验证");
		String signature = request.getParameter("signature");	
		String timestamp = request.getParameter("timestamp");	
		String nonce = request.getParameter("nonce");	
		String echostr = request.getParameter("echostr");	
		PrintWriter out =  response.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =  response.getWriter();
		try {
			Map<String, String> map = MessageUtil.xmlToMap(request);
//			ToUserName	开发者微信号
//			FromUserName	发送方帐号（一个OpenID）
//			CreateTime	消息创建时间 （整型）
//			MsgType	text
//			Content	文本消息内容
//			MsgId	消息id，64位整型
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String createTime = map.get("CreateTime");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String msgId = map.get("MsgId");
			System.out.println(content);
			String message = null;
			if("text".equals(msgType)){
				
				if("hi".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, "hi");
				}else if("你好".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, "你也好");
				}else{
					message = MessageUtil.initText(toUserName, fromUserName, "您说的什么，臣妾不懂啊~~~");
				}
			}
			
			out.print(message);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
}
