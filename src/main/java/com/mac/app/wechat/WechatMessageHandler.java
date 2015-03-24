package com.mac.app.wechat;

import com.mac.baidu.bean.BaiduFoodResult;
import com.mac.baidu.bean.BaiduFoodShopInfo;
import com.mac.baidu.bean.BaiduSearch;
import com.mac.manager.service.WxRespService;
import com.sdyc.wx.DefaultMessageHandlerImpl;
import com.sdyc.wx.req.msg.LocationMessage;
import com.sdyc.wx.req.msg.TextMessage;
import com.sdyc.wx.resp.msg.AbstractRespMessage;
import com.sdyc.wx.resp.msg.NewsSyncMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：微信公众号消息处理
 * 作者： yangyan
 * 时间： 2014/9/12 .
 */
public class WechatMessageHandler extends DefaultMessageHandlerImpl {

    @Autowired
    WxRespService wxRespService;

    @Override
    public AbstractRespMessage handleText(TextMessage message) {
        if("2".equals(message.getContent())){
            List<NewsSyncMessage.Article> articleList = new ArrayList<NewsSyncMessage.Article>();

            NewsSyncMessage.Article article1 = new NewsSyncMessage.Article();
            article1.setTitle("时间会紧锁，美梦不会停！");
            article1.setDescription("");
            article1.setPicUrl("http://image.zcool.com.cn/56/35/m_1303967876491.jpg");
            article1.setUrl("http://www.lewaimai.com");

            NewsSyncMessage.Article article2 = new NewsSyncMessage.Article();
            article2.setTitle("第2篇\n儿时玩过的那些游戏");
            article2.setDescription("");
            article2.setPicUrl("http://img.soufun.com/news/2011_05/19/home/1305793349799_000.jpg");
            article2.setUrl("http://www.lewaimai.com");

            NewsSyncMessage.Article article3 = new NewsSyncMessage.Article();
            article3.setTitle("第3篇\n儿时陪伴我们的那些歌曲");
            article3.setDescription("");
            article3.setPicUrl("http://pic24.nipic.com/20121027/9869816_155446185135_2.jpg");
            article3.setUrl("http://www.lewaimai.com");

            articleList.add(article1);
            articleList.add(article2);
            articleList.add(article3);
            return this.wxRespService.respMessageHandlerWithNews(message, articleList);
        }else if("肯德基".equals(message.getContent())){
            List<NewsSyncMessage.Article> articleList = new ArrayList<NewsSyncMessage.Article>();
            NewsSyncMessage.Article article = new NewsSyncMessage.Article();
            article.setTitle("肯德基优惠券");
            article.setDescription("肯德基优惠券来啦！！！！");
            article.setPicUrl("http://113.200.64.31/mac/images/kfc.tif");
            article.setUrl("http://youhui.kfc.com.cn/mobile/");
            articleList.add(article);
            return this.wxRespService.respMessageHandlerWithNews(message, articleList);
        }else if("麦当劳".equals(message.getContent())){
            List<NewsSyncMessage.Article> articleList = new ArrayList<NewsSyncMessage.Article>();
            NewsSyncMessage.Article article = new NewsSyncMessage.Article();
            article.setTitle("麦当劳优惠券");
            article.setDescription("麦当劳优惠券来啦！！！！");
            article.setPicUrl("http://113.200.64.31/mac/images/mcdonald's.tif");
            article.setUrl("http://m.baidu.com/from=844b/bd_page_type=1/ssid=0/uid=0/" +
                    "pu=usm%400%2Csz%401320_1001%2Cta%40iphone_2_4.4_3_537/" +
                    "baiduid=C6565E5B9D71C2B79490E71A92B76D51/" +
                    "w=0_10_%E5%88%B8%E5%A6%88%E5%A6%88+%E9%BA%A6%E5%BD%93%E5%8A%B3/" +
                    "t=iphone/l=3/tc?m=8&srd=1&dict=20&src=http%3A%2F%2Fmaidanglao.quanmama.com%2F");
            articleList.add(article);
            return this.wxRespService.respMessageHandlerWithNews(message, articleList);
        }else if("简介".equals(message.getContent()) || "滋奇老友记".equals(message.getContent()) || message.getContent().contains("老友记")){
            List<NewsSyncMessage.Article> articleList = new ArrayList<NewsSyncMessage.Article>();
            NewsSyncMessage.Article article = new NewsSyncMessage.Article();
            article.setTitle("时间会紧锁，美梦不会停！");
            article.setDescription("");
            article.setPicUrl("http://113.200.64.31/mac/images/pic001.jpg");
            article.setUrl("http://113.200.64.31/mac/main.htm");
            articleList.add(article);
            return this.wxRespService.respMessageHandlerWithNews(message, articleList);
        }else if("滋奇".equals(message.getContent()) || "兹奇".equals(message.getContent())){
            List<NewsSyncMessage.Article> articleList = new ArrayList<NewsSyncMessage.Article>();
            NewsSyncMessage.Article article = new NewsSyncMessage.Article();
            article.setTitle("老友记—何为滋奇");
            article.setDescription("");
            article.setPicUrl("http://113.200.64.31/mac/images/ziqi.jpg");
            article.setUrl("http://113.200.64.31/mac/ziqi.htm");
            articleList.add(article);
            return this.wxRespService.respMessageHandlerWithNews(message, articleList);
        }
        else if("联系电话".equals(message.getContent()) || "联系方式".equals(message.getContent()) || message.getContent().contains("电话") || message.getContent().contains("联系")
                || message.getContent().contains("手机") || message.getContent().contains("座机")){
            return this.wxRespService.respMessageHandlerWithText(message, "店内座机：029-88855573\n手机：13299116891 ，18658215824");
        }else if("地址".equals(message.getContent()) || "位置".equals(message.getContent()) || message.getContent().contains("导航") || message.getContent().contains("去这里")
                || message.getContent().contains("去店里") || message.getContent().contains("怎么走")){
//            respMessage = daohang(requestMap,fromUserName,toUserName);
        }else if("测试".equals(message.getContent())){
            List<NewsSyncMessage.Article> articleList = new ArrayList<NewsSyncMessage.Article>();
            NewsSyncMessage.Article article = new NewsSyncMessage.Article();
            article.setTitle("测试");
            article.setDescription("");
            article.setPicUrl("http://113.200.64.31/mac/images/ziqi.jpg");
            article.setUrl("http://115.28.45.153/mac/main.jsp");
            articleList.add(article);
            return this.wxRespService.respMessageHandlerWithNews(message, articleList);
        }
        return null;
    }

    @Override
    public AbstractRespMessage handleLocation(LocationMessage message) {

        List<NewsSyncMessage.Article> articleList = new ArrayList<NewsSyncMessage.Article>();
//        String x = message.getLocation_X();
//        String y = message.getLocation_Y();
//        BaiduFoodResult baiduFoodResult = BaiduSearchFood.getFoodAroundLocation(x, y);
        BaiduFoodResult baiduFoodResult = BaiduSearch.getZiqilaoyoujiLocation();
        if(baiduFoodResult!=null && baiduFoodResult.getResults()!=null && baiduFoodResult.getResults().size()>0){
            for(int i=0;i<baiduFoodResult.getResults().size();i++){
                BaiduFoodShopInfo bfs = baiduFoodResult.getResults().get(i);
                NewsSyncMessage.Article article = new NewsSyncMessage.Article();
//                article.setTitle(bfs.getName()+"\n距离约"+bfs.getDetail_info().getDistance()+"米");
                article.setTitle(bfs.getName() + "欢迎您~\n点击进入地图导航");
                article.setDescription("");
                if(i==0) {
//                    article.setPicUrl("http://113.200.64.31/mac/images/BaiduFoodImg.tif");
                    article.setPicUrl("http://113.200.64.31/mac/images/laoyouji.jpg");
                }else{
                    article.setPicUrl("http://113.200.64.31/mac/images/location.tif");
                }
                article.setUrl(bfs.getDetail_info().getDetail_url());
                articleList.add(article);
            }
        }
        return this.wxRespService.respMessageHandlerWithNews(message, articleList);
    }


}
