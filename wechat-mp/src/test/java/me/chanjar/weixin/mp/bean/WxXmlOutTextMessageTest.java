package com.wallellen.wechat.mp.bean;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WxXmlOutTextMessageTest {

  public void test() {
    WxMpXmlOutTextMessage m = new WxMpXmlOutTextMessage();
    m.setContent("content");
    m.setCreateTime(1122l);
    m.setFromUserName("from");
    m.setToUserName("to");
    
    String expected = "<xml>"
        + "<ToUserName><![CDATA[to]]></ToUserName>"
        + "<FromUserName><![CDATA[from]]></FromUserName>"
        + "<CreateTime>1122</CreateTime>"
        + "<MsgType><![CDATA[text]]></MsgType>"
        + "<Content><![CDATA[content]]></Content>"
        + "</xml>";
    System.out.println(m.toXml());
    Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));
  }
  
  public void testBuild() {
    WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content("content").fromUser("from").toUser("to").build();
    String expected = "<xml>"
        + "<ToUserName><![CDATA[to]]></ToUserName>"
        + "<FromUserName><![CDATA[from]]></FromUserName>"
        + "<CreateTime>1122</CreateTime>"
        + "<MsgType><![CDATA[text]]></MsgType>"
        + "<Content><![CDATA[content]]></Content>"
        + "</xml>";
    System.out.println(m.toXml());
    Assert.assertEquals(
        m
        .toXml()
        .replaceAll("\\s", "")
        .replaceAll("<CreateTime>.*?</CreateTime>", ""), 
        expected
        .replaceAll("\\s", "")
        .replaceAll("<CreateTime>.*?</CreateTime>", "")
        );
    
  }
  

}
