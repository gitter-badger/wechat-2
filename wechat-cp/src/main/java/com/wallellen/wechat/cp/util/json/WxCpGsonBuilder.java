package com.wallellen.wechat.cp.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wallellen.wechat.common.bean.result.WxError;
import com.wallellen.wechat.common.util.json.WxErrorAdapter;
import com.wallellen.wechat.cp.bean.WxCpDepart;
import com.wallellen.wechat.cp.bean.WxCpMessage;
import com.wallellen.wechat.cp.bean.WxCpTag;
import com.wallellen.wechat.cp.bean.WxCpUser;

public class WxCpGsonBuilder {

  public static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxCpMessage.class, new WxCpMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxCpDepart.class, new WxCpDepartGsonAdapter());
    INSTANCE.registerTypeAdapter(WxCpUser.class, new WxCpUserGsonAdapter());
    INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
    INSTANCE.registerTypeAdapter(WxCpTag.class, new WxCpTagGsonAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
