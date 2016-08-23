package com.androidxx.yangjw.day37_retrofit_get_demo;

import java.util.List;

/**
 * Created by yangjw on 2016/8/23.
 */
public class KaiceBean {


    /**
     * id : 1471846189
     * iconurl : /allimgs/img_iapp/201608/_1471846114916.png
     * gname : 巅峰战舰
     * testtype : 4
     * score : 5.0
     * linkurl : 00:00
     * istop : 0
     * colors : 0
     * platform : 1,2
     * operators : 英雄互娱
     * state : 1
     * addtime : 08-23 00:00
     * teststarttime : 2016-08-23 00:00:00
     * gift : 射击空战
     * keyword :
     * uid : 402881d2554284e2015547751122012a
     * gid : 1463556745
     * indexpy : 0
     * isdel : 1
     * openflag : 3
     * openflagname : 公测
     * vtypeimage : <i class='android'></i><i class='ios'></i>
     */

    private List<InfoBean> info;

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        private int id;
        private String iconurl;
        private String gname;
        private String testtype;
        private double score;
        private String linkurl;
        private int istop;
        private int colors;
        private String platform;
        private String operators;
        private int state;
        private String addtime;
        private String teststarttime;
        private String gift;
        private String keyword;
        private String uid;
        private String gid;
        private String indexpy;
        private int isdel;
        private int openflag;
        private String openflagname;
        private String vtypeimage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public String getTesttype() {
            return testtype;
        }

        public void setTesttype(String testtype) {
            this.testtype = testtype;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public int getIstop() {
            return istop;
        }

        public void setIstop(int istop) {
            this.istop = istop;
        }

        public int getColors() {
            return colors;
        }

        public void setColors(int colors) {
            this.colors = colors;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getOperators() {
            return operators;
        }

        public void setOperators(String operators) {
            this.operators = operators;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getTeststarttime() {
            return teststarttime;
        }

        public void setTeststarttime(String teststarttime) {
            this.teststarttime = teststarttime;
        }

        public String getGift() {
            return gift;
        }

        public void setGift(String gift) {
            this.gift = gift;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getIndexpy() {
            return indexpy;
        }

        public void setIndexpy(String indexpy) {
            this.indexpy = indexpy;
        }

        public int getIsdel() {
            return isdel;
        }

        public void setIsdel(int isdel) {
            this.isdel = isdel;
        }

        public int getOpenflag() {
            return openflag;
        }

        public void setOpenflag(int openflag) {
            this.openflag = openflag;
        }

        public String getOpenflagname() {
            return openflagname;
        }

        public void setOpenflagname(String openflagname) {
            this.openflagname = openflagname;
        }

        public String getVtypeimage() {
            return vtypeimage;
        }

        public void setVtypeimage(String vtypeimage) {
            this.vtypeimage = vtypeimage;
        }
    }
}
