package com.mac.manager.service.impl;

import com.mac.manager.service.WxRespService;
import com.sdyc.wx.MsgType;
import com.sdyc.wx.req.AbstractRequestMessage;
import com.sdyc.wx.resp.msg.AbstractRespMessage;
import com.sdyc.wx.resp.msg.NewsSyncMessage;
import com.sdyc.wx.resp.msg.TextSyncMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by machao on 2015/2/13.
 */
@Service
public class WxRespServiceImpl implements WxRespService {
    @Override
    public AbstractRespMessage respMessageHandlerWithNews(AbstractRequestMessage abstractRequestMessage, List<NewsSyncMessage.Article> articleList) {
        NewsSyncMessage newsSyncMessage = new NewsSyncMessage();
        newsSyncMessage.setArticleCount(articleList.size());
        newsSyncMessage.setArticles(articleList);
        newsSyncMessage.setCreateTime(System.currentTimeMillis());
        newsSyncMessage.setFromUserName(abstractRequestMessage.getToUserName());
        newsSyncMessage.setToUserName(abstractRequestMessage.getFromUserName());
        newsSyncMessage.setMsgType(MsgType.news.name());
        return newsSyncMessage;
    }

    @Override
    public AbstractRespMessage respMessageHandlerWithText(AbstractRequestMessage abstractRequestMessage, String content) {
        TextSyncMessage textSyncMessage = new TextSyncMessage();
        textSyncMessage.setContent(content);
        textSyncMessage.setCreateTime(System.currentTimeMillis());
        textSyncMessage.setFromUserName(abstractRequestMessage.getToUserName());
        textSyncMessage.setToUserName(abstractRequestMessage.getFromUserName());
        textSyncMessage.setMsgType(MsgType.text.name());
        return textSyncMessage;
    }
}
