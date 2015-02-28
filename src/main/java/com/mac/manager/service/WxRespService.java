package com.mac.manager.service;

import com.sdyc.wx.req.AbstractRequestMessage;
import com.sdyc.wx.resp.msg.AbstractRespMessage;
import com.sdyc.wx.resp.msg.NewsSyncMessage;

import java.util.List;

/**
 * Created by machao on 2015/2/13.
 */
public interface WxRespService {

    /**
     * 以图文格式响应
     * @param abstractRequestMessage
     * @param articleList
     * @return
     */
    public AbstractRespMessage respMessageHandlerWithNews(AbstractRequestMessage abstractRequestMessage, List<NewsSyncMessage.Article> articleList);

    /**
     * 以文字格式响应
     * @param abstractRequestMessage
     * @param content
     * @return
     */
    public AbstractRespMessage respMessageHandlerWithText(AbstractRequestMessage abstractRequestMessage, String content);
}
