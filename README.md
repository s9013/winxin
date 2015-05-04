# 微信公众平台开发

微信公众帐号

微信只能访问公网80端口，使用[ngrok](https://ngrok.com)(下载需要翻墙)映射

	ngrok authtoken xxxx  
	xxxx为注册的authtoken
	
	启动
	ngrok -subdomain=wind -config ngrok.cfg 8888
	
	这样就可以在公网上访问本地项目
	http://wind.tunnel.mobi/Winxin/wx.do

    



	

