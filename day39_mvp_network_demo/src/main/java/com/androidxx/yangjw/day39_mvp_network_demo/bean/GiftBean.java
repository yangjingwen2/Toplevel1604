package com.androidxx.yangjw.day39_mvp_network_demo.bean;

import java.util.List;

/**
 * Created by yangjw on 2016/8/26.
 */
public class GiftBean {


    /**
     * ad : [{"id":238,"title":"18梦境异闻录潜梦礼包","flag":1,"iconurl":"/allimgs/img_iad/_1472122193157.jpg","addtime":"2016-08-18","giftid":"1471860368","appName":"18梦境异闻录","appLogo":"/allimgs/img_iapp/201607/_1468900723619.png","appId":1468820958},{"id":235,"title":"恋舞OL礼包","flag":1,"iconurl":"/allimgs/img_iad/_1472032570351.jpg","addtime":"2016-08-17","giftid":"1472026775","appName":"恋舞OL","appLogo":"/userfiles/applogo/_1422412216871.jpg","appId":1411637357},{"id":233,"title":"暴走战姬礼包 ","flag":1,"iconurl":"/allimgs/img_iad/_1471417660563.jpg","addtime":"2016-08-15","giftid":"1471412714","appName":"暴走战姬","appLogo":"/allimgs/img_iapp/201608/_1470641271034.png","appId":1470641361},{"id":236,"title":"青云志大竹峰拜师礼包","flag":1,"iconurl":"/allimgs/img_iad/_1472103748752.jpg","addtime":"2016-08-13","giftid":"1472103257","appName":"青云志","appLogo":"/allimgs/img_iapp/201605/_1464162033139.png","appId":1451286953},{"id":226,"title":"鬼吹灯3D中元节礼包 ","flag":1,"iconurl":"/allimgs/img_iad/_1471339839675.jpg","addtime":"2016-07-19","giftid":"1471331032","appName":"鬼吹灯3D","appLogo":"/allimgs/img_iapp/201606/_1465200867024.png","appId":1449826461}]
     * pageno : 178
     * list : [{"id":"1472183101","iconurl":"/allimgs/img_iapp/201505/_1431668017101.jpg","giftname":"媒体新手大礼包","number":19,"exchanges":1,"type":1,"gname":"我在大清当皇帝HD","integral":0,"isintegral":0,"addtime":"2016-08-26","ptype":"1,2,","operators":"","flag":1},{"id":"1472093587","iconurl":"/allimgs/img_iapp/201606/_1465870221885.png","giftname":"天降骑兵新手礼包","number":17,"exchanges":3,"type":1,"gname":"暗黑黎明II","integral":0,"isintegral":0,"addtime":"2016-08-25","ptype":"1,2,","operators":"","flag":1},{"id":"1472093890","iconurl":"/allimgs/img_iapp/201606/_1465870221885.png","giftname":"天降骑兵特权礼包","number":50,"exchanges":0,"type":1,"gname":"暗黑黎明II","integral":0,"isintegral":0,"addtime":"2016-08-25","ptype":"1,2,","operators":"","flag":1},{"id":"1472103280","iconurl":"/allimgs/img_iapp/201605/_1464162033139.png","giftname":"大竹峰拜师礼包","number":27,"exchanges":3,"type":1,"gname":"青云志","integral":0,"isintegral":0,"addtime":"2016-08-25","ptype":"1,2,","operators":"","flag":1},{"id":"1472105542","iconurl":"/uploads/allimg/140608/11-14060R314070-L.png","giftname":"183新手礼包","number":4,"exchanges":6,"type":1,"gname":"热血帝王","integral":0,"isintegral":0,"addtime":"2016-08-25","ptype":"1,2,","operators":"","flag":1},{"id":"1472109184","iconurl":"/allimgs/img_iapp/201608/_1472027906197.png","giftname":"普发礼包","number":20,"exchanges":0,"type":1,"gname":"弹弹岛2","integral":0,"isintegral":0,"addtime":"2016-08-25","ptype":"1,2,","operators":"","flag":1},{"id":"1472115712","iconurl":"/allimgs/img_iapp/201608/_1472092656585.jpg","giftname":"特权礼包","number":194,"exchanges":6,"type":1,"gname":"至尊战道","integral":0,"isintegral":0,"addtime":"2016-08-25","ptype":"1,2,","operators":"","flag":1},{"id":"1472115833","iconurl":"/allimgs/img_iapp/201608/_1472092656585.jpg","giftname":"精英礼包","number":195,"exchanges":5,"type":1,"gname":"至尊战道","integral":0,"isintegral":0,"addtime":"2016-08-25","ptype":"1,2,","operators":"","flag":1},{"id":"1472115918","iconurl":"/allimgs/img_iapp/201608/_1472092656585.jpg","giftname":"论坛礼包","number":196,"exchanges":4,"type":1,"gname":"至尊战道","integral":0,"isintegral":0,"addtime":"2016-08-25","ptype":"1,2,","operators":"","flag":1},{"id":"1472004412","iconurl":"/allimgs/img_iapp/201608/_1471513835055.png","giftname":"媒体礼包","number":13,"exchanges":7,"type":1,"gname":"独立日","integral":0,"isintegral":0,"addtime":"2016-08-24","ptype":"1,","operators":"","flag":1}]
     */

    private int pageno;
    /**
     * id : 238
     * title : 18梦境异闻录潜梦礼包
     * flag : 1
     * iconurl : /allimgs/img_iad/_1472122193157.jpg
     * addtime : 2016-08-18
     * giftid : 1471860368
     * appName : 18梦境异闻录
     * appLogo : /allimgs/img_iapp/201607/_1468900723619.png
     * appId : 1468820958
     */

    private List<AdBean> ad;
    /**
     * id : 1472183101
     * iconurl : /allimgs/img_iapp/201505/_1431668017101.jpg
     * giftname : 媒体新手大礼包
     * number : 19
     * exchanges : 1
     * type : 1
     * gname : 我在大清当皇帝HD
     * integral : 0
     * isintegral : 0
     * addtime : 2016-08-26
     * ptype : 1,2,
     * operators :
     * flag : 1
     */

    private List<ListBean> list;

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class AdBean {
        private int id;
        private String title;
        private int flag;
        private String iconurl;
        private String addtime;
        private String giftid;
        private String appName;
        private String appLogo;
        private int appId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getGiftid() {
            return giftid;
        }

        public void setGiftid(String giftid) {
            this.giftid = giftid;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getAppLogo() {
            return appLogo;
        }

        public void setAppLogo(String appLogo) {
            this.appLogo = appLogo;
        }

        public int getAppId() {
            return appId;
        }

        public void setAppId(int appId) {
            this.appId = appId;
        }
    }

    public static class ListBean {
        private String id;
        private String iconurl;
        private String giftname;
        private int number;
        private int exchanges;
        private int type;
        private String gname;
        private int integral;
        private int isintegral;
        private String addtime;
        private String ptype;
        private String operators;
        private int flag;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getGiftname() {
            return giftname;
        }

        public void setGiftname(String giftname) {
            this.giftname = giftname;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getExchanges() {
            return exchanges;
        }

        public void setExchanges(int exchanges) {
            this.exchanges = exchanges;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public int getIsintegral() {
            return isintegral;
        }

        public void setIsintegral(int isintegral) {
            this.isintegral = isintegral;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getPtype() {
            return ptype;
        }

        public void setPtype(String ptype) {
            this.ptype = ptype;
        }

        public String getOperators() {
            return operators;
        }

        public void setOperators(String operators) {
            this.operators = operators;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }
    }
}
