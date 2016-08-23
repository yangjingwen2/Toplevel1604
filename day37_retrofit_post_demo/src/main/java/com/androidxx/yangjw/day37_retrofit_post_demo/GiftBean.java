package com.androidxx.yangjw.day37_retrofit_post_demo;

import java.util.List;

/**
 * Created by yangjw on 2016/8/23.
 */
public class GiftBean {


    /**
     * ad : [{"id":230,"title":"1688玩四周年活动","flag":1,"iconurl":"/allimgs/img_iad/_1471082588565.jpg","addtime":"2016-08-18","linkurl":"http://www.1688wan.com/szn/","giftid":"1470998731","appName":"航海王强者之路","appLogo":"/allimgs/img_iapp/201511/_1448446144213.png","appId":1448446177},{"id":233,"title":"暴走战姬礼包 ","flag":1,"iconurl":"/allimgs/img_iad/_1471417660563.jpg","addtime":"2016-08-15","giftid":"1471412714","appName":"暴走战姬","appLogo":"/allimgs/img_iapp/201608/_1470641271034.png","appId":1470641361},{"id":226,"title":"鬼吹灯3D中元节礼包 ","flag":1,"iconurl":"/allimgs/img_iad/_1471339839675.jpg","addtime":"2016-07-19","giftid":"1471331032","appName":"鬼吹灯3D","appLogo":"/allimgs/img_iapp/201606/_1465200867024.png","appId":1449826461},{"id":225,"title":"《少女前线》公测独家礼包","flag":1,"iconurl":"/allimgs/img_iad/_1469180918305.jpg","addtime":"2016-07-09","giftid":"1469180003","appName":"少女前线","appLogo":"/allimgs/img_iapp/201605/_1462435805122.png","appId":1460513921},{"id":224,"title":"大秦帝国OL至尊独家礼包","flag":1,"iconurl":"/allimgs/img_iad/_1470044181923.jpg","addtime":"2016-03-11","giftid":"1470043230","appName":"大秦帝国OL","appLogo":"/allimgs/img_iapp/201607/_1469687930154.jpg","appId":1467784200}]
     * pageno : 178
     * list : [{"id":"1471866035","iconurl":"/allimgs/img_iapp/201608/_1471863606246.png","giftname":"至尊开服礼包","number":244,"exchanges":2,"type":1,"gname":"仙道","integral":0,"isintegral":0,"addtime":"2016-08-23","ptype":"1,2,","operators":"","flag":1},{"id":"1471921876","iconurl":"/allimgs/img_iapp/201608/_1471515801933.png","giftname":"新手礼包","number":48,"exchanges":52,"type":1,"gname":"血剑江湖","integral":0,"isintegral":0,"addtime":"2016-08-23","ptype":"1,2,","operators":"","flag":1},{"id":"1471921937","iconurl":"/allimgs/img_iapp/201608/_1471515801933.png","giftname":"特权礼包","number":59,"exchanges":41,"type":1,"gname":"血剑江湖","integral":0,"isintegral":0,"addtime":"2016-08-23","ptype":"1,2,","operators":"","flag":1},{"id":"1471922062","iconurl":"/allimgs/img_iapp/201608/_1471515801933.png","giftname":"精英礼包","number":67,"exchanges":33,"type":1,"gname":"血剑江湖","integral":0,"isintegral":0,"addtime":"2016-08-23","ptype":"1,2,","operators":"","flag":1},{"id":"1471922063","iconurl":"/allimgs/img_iapp/201608/_1471515801933.png","giftname":" 公会礼包","number":71,"exchanges":29,"type":1,"gname":"血剑江湖","integral":0,"isintegral":0,"addtime":"2016-08-23","ptype":"1,2,","operators":"","flag":1},{"id":"1471936097","iconurl":"/allimgs/img_iapp/201608/_1470209583292.jpg","giftname":"公测独家礼包","number":100,"exchanges":0,"type":1,"gname":"迷城物语","integral":0,"isintegral":0,"addtime":"2016-08-23","ptype":"1,2,","operators":"","flag":1},{"id":"1471853591","iconurl":"/allimgs/img_iapp/201608/_1470822956316.jpg","giftname":"媒体礼包","number":0,"exchanges":10,"type":1,"gname":"钢铁少女","integral":0,"isintegral":0,"addtime":"2016-08-22","ptype":"1,2,","operators":"","flag":1},{"id":"1471854128","iconurl":"/allimgs/img_iapp/201608/_1470041717946.jpg","giftname":"惹火女神公测礼包","number":9,"exchanges":1,"type":1,"gname":"校花的贴身高手","integral":0,"isintegral":0,"addtime":"2016-08-22","ptype":"1,2,","operators":"","flag":1},{"id":"1471856115","iconurl":"/allimgs/img_iapp/201608/_1471310774122.png","giftname":"舞神礼包","number":49,"exchanges":1,"type":1,"gname":"舞动青春","integral":0,"isintegral":0,"addtime":"2016-08-22","ptype":"1,2,","operators":"","flag":1},{"id":"1471857921","iconurl":"/allimgs/img_iapp/201607/_1469517385626.png","giftname":"安卓开放测试独家专属礼包","number":49,"exchanges":1,"type":1,"gname":"天堂2：血盟","integral":0,"isintegral":0,"addtime":"2016-08-22","ptype":"1,2,","operators":"","flag":1}]
     */

    private int pageno;
    /**
     * id : 230
     * title : 1688玩四周年活动
     * flag : 1
     * iconurl : /allimgs/img_iad/_1471082588565.jpg
     * addtime : 2016-08-18
     * linkurl : http://www.1688wan.com/szn/
     * giftid : 1470998731
     * appName : 航海王强者之路
     * appLogo : /allimgs/img_iapp/201511/_1448446144213.png
     * appId : 1448446177
     */

    private List<AdBean> ad;
    /**
     * id : 1471866035
     * iconurl : /allimgs/img_iapp/201608/_1471863606246.png
     * giftname : 至尊开服礼包
     * number : 244
     * exchanges : 2
     * type : 1
     * gname : 仙道
     * integral : 0
     * isintegral : 0
     * addtime : 2016-08-23
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
        private String linkurl;
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

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
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
