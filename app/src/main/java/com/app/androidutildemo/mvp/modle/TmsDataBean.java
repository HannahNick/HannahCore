package com.app.androidutildemo.mvp.modle;

import java.util.List;

/**
 * Created by Nick on 2018/11/19.
 */
public class TmsDataBean {

    private String componentType;
    private String tmsDetailId;
    private String module;
    private String id;
    private List<ChildrenBean> children;
    private ConfigBean config;

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getTmsDetailId() {
        return tmsDetailId;
    }

    public void setTmsDetailId(String tmsDetailId) {
        this.tmsDetailId = tmsDetailId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ChildrenBean> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBean> children) {
        this.children = children;
    }

    public ConfigBean getConfig() {
        return config;
    }

    public void setConfig(ConfigBean config) {
        this.config = config;
    }

    public static class ChildrenBean {
        private String componentType;
        private String tmsDetailId;
        private ConfigBean config;

        public String getComponentType() {
            return componentType;
        }

        public void setComponentType(String componentType) {
            this.componentType = componentType;
        }

        public ConfigBean getConfig() {
            return config;
        }

        public void setConfig(ConfigBean config) {
            this.config = config;
        }

        public String getTmsDetailId() {
            return tmsDetailId;
        }

        public void setTmsDetailId(String tmsDetailId) {
            this.tmsDetailId = tmsDetailId;
        }

        public static class ConfigBean{
            private List<GroupsBean> groups;
            private String baseUrl;
            private String imgUrl;
            private String type;
            private StyleBean style;

            private Header header;

            public List<GroupsBean> getGroups() {
                return groups;
            }

            public void setGroups(List<GroupsBean> groups) {
                this.groups = groups;
            }

            public String getBaseUrl() {
                return baseUrl;
            }

            public void setBaseUrl(String baseUrl) {
                this.baseUrl = baseUrl;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public Header getHeader() {
                return header;
            }

            public void setHeader(Header header) {
                this.header = header;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public StyleBean getStyle() {
                return style;
            }

            public void setStyle(StyleBean style) {
                this.style = style;
            }

            public static class StyleBean{

                private String marginBottom;
                private String opacity;
                private String marginTop;

                public String getMarginBottom() {
                    return marginBottom;
                }

                public void setMarginBottom(String marginBottom) {
                    this.marginBottom = marginBottom;
                }

                public String getOpacity() {
                    return opacity;
                }

                public void setOpacity(String opacity) {
                    this.opacity = opacity;
                }

                public String getMarginTop() {
                    return marginTop;
                }

                public void setMarginTop(String marginTop) {
                    this.marginTop = marginTop;
                }
            }


            public static class GroupsBean{
                private String id;
                private String imgUrl;
                private String actionType;
                private String action;
                private String imgTitle;
                private String itemOrder;
                private String title;
                private String titleColor;
                private String subTitleColor;
                private String subTitle;
                private String bgColor;
                private String bgImg;
                private String skuName;
                private String goodsDescrition;
                private String goodsName;
                private String goodsId;
                private String poolName;
                private List<RowsBean> rows;
                private double price;
                private String type;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getActionType() {
                    return actionType;
                }

                public void setActionType(String actionType) {
                    this.actionType = actionType;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }

                public String getImgTitle() {
                    return imgTitle;
                }

                public void setImgTitle(String imgTitle) {
                    this.imgTitle = imgTitle;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getSubTitle() {
                    return subTitle;
                }

                public void setSubTitle(String subTitle) {
                    this.subTitle = subTitle;
                }

                public String getBgColor() {
                    return bgColor;
                }

                public void setBgColor(String bgColor) {
                    this.bgColor = bgColor;
                }

                public String getItemOrder() {
                    return itemOrder;
                }

                public void setItemOrder(String itemOrder) {
                    this.itemOrder = itemOrder;
                }

                public String getSkuName() {
                    return skuName;
                }

                public void setSkuName(String skuName) {
                    this.skuName = skuName;
                }

                public String getGoodsDescrition() {
                    return goodsDescrition;
                }

                public void setGoodsDescrition(String goodsDescrition) {
                    this.goodsDescrition = goodsDescrition;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public double getPrice() {
                    return price;
                }

                public void setPrice(double getPrice) {
                    this.price = getPrice;
                }

                public List<RowsBean> getRows() {
                    return rows;
                }

                public void setRows(List<RowsBean> rows) {
                    this.rows = rows;
                }

                public String getPoolName() {
                    return poolName;
                }

                public void setPoolName(String poolName) {
                    this.poolName = poolName;
                }

                public String getBgImg() {
                    return bgImg;
                }

                public void setBgImg(String bgImg) {
                    this.bgImg = bgImg;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getTitleColor() {
                    return titleColor;
                }

                public void setTitleColor(String titleColor) {
                    this.titleColor = titleColor;
                }

                public String getSubTitleColor() {
                    return subTitleColor;
                }

                public void setSubTitleColor(String subTitleColor) {
                    this.subTitleColor = subTitleColor;
                }

                public static class RowsBean {

                    private String skuName;
                    private String goodsId;
                    private String goodsName;
                    private String picUrl;
                    private String publicName;
                    private double goodsPrice;
                    private String poolId;
                    private Object remark;
                    private String id;
                    private String skuId;
                    private String status;
                    private String createDate;
                    private String skuSpec;
                    private String imgUrl;
                    private String goodsDescrition;
                    private int goodsCount;
                    private boolean lastOne;

                    public String getSkuName() {
                        return skuName;
                    }

                    public void setSkuName(String skuName) {
                        this.skuName = skuName;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getPublicName() {
                        return publicName;
                    }

                    public void setPublicName(String publicName) {
                        this.publicName = publicName;
                    }

                    public double getGoodsPrice() {
                        return goodsPrice;
                    }

                    public void setGoodsPrice(double goodsPrice) {
                        this.goodsPrice = goodsPrice;
                    }

                    public String getPoolId() {
                        return poolId;
                    }

                    public void setPoolId(String poolId) {
                        this.poolId = poolId;
                    }

                    public Object getRemark() {
                        return remark;
                    }

                    public void setRemark(Object remark) {
                        this.remark = remark;
                    }

                    public String getGoodsId() {
                        return goodsId;
                    }

                    public void setGoodsId(String goodsId) {
                        this.goodsId = goodsId;
                    }

                    public String getGoodsName() {
                        return goodsName;
                    }

                    public void setGoodsName(String goodsName) {
                        this.goodsName = goodsName;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getSkuId() {
                        return skuId;
                    }

                    public void setSkuId(String skuId) {
                        this.skuId = skuId;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getCreateDate() {
                        return createDate;
                    }

                    public void setCreateDate(String createDate) {
                        this.createDate = createDate;
                    }

                    public String getSkuSpec() {
                        return skuSpec;
                    }

                    public void setSkuSpec(String skuSpec) {
                        this.skuSpec = skuSpec;
                    }

                    public String getImgUrl() {
                        return imgUrl;
                    }

                    public void setImgUrl(String imgUrl) {
                        this.imgUrl = imgUrl;
                    }

                    public int getGoodsCount() {
                        return goodsCount;
                    }

                    public void setGoodsCount(int goodsCount) {
                        this.goodsCount = goodsCount;
                    }

                    public boolean isLastOne() {
                        return lastOne;
                    }

                    public void setLastOne(boolean lastOne) {
                        this.lastOne = lastOne;
                    }

                    public String getGoodsDescrition() {
                        return goodsDescrition;
                    }

                    public void setGoodsDescrition(String goodsDescrition) {
                        this.goodsDescrition = goodsDescrition;
                    }
                }
            }

            public static class Header{
                private String imgUrl;
                private String actionType;
                private String action;
                private boolean ifShow;

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getActionType() {
                    return actionType;
                }

                public void setActionType(String actionType) {
                    this.actionType = actionType;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }

                public boolean isIfShow() {
                    return ifShow;
                }

                public void setIfShow(boolean ifShow) {
                    this.ifShow = ifShow;
                }
            }



        }


    }

    public static class ConfigBean{

        private PopBoxBean popBox;
        private StyleBean style;
        private TopNavBean topNav;
        private BoottomNavBean boottomNav;
        private SuspensionBean suspension;

        public PopBoxBean getPopBox() {
            return popBox;
        }

        public void setPopBox(PopBoxBean popBox) {
            this.popBox = popBox;
        }

        public StyleBean getStyle() {
            return style;
        }

        public void setStyle(StyleBean style) {
            this.style = style;
        }

        public TopNavBean getTopNav() {
            return topNav;
        }

        public void setTopNav(TopNavBean topNav) {
            this.topNav = topNav;
        }

        public BoottomNavBean getBoottomNav() {
            return boottomNav;
        }

        public void setBoottomNav(BoottomNavBean boottomNav) {
            this.boottomNav = boottomNav;
        }

        public SuspensionBean getSuspension() {
            return suspension;
        }

        public void setSuspension(SuspensionBean suspension) {
            this.suspension = suspension;
        }

        public static class PopBoxBean {
            /**
             * imgUrl : https://emallws.oss-cn-shenzhen.aliyuncs.com/cms/bcebb4cf62ff7408337f6e7a824bd1af.jpg
             * actionType : route
             * width : 300
             * action : #/feedback
             * ifShow : true
             * frequence : 90
             */

            private String imgUrl;
            private String actionType;
            private int width;
            private String action;
            private boolean ifShow;
            private String frequence;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getActionType() {
                return actionType;
            }

            public void setActionType(String actionType) {
                this.actionType = actionType;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public boolean isIfShow() {
                return ifShow;
            }

            public void setIfShow(boolean ifShow) {
                this.ifShow = ifShow;
            }

            public String getFrequence() {
                return frequence;
            }

            public void setFrequence(String frequence) {
                this.frequence = frequence;
            }
        }

        public static class StyleBean {
        }

        public static class TopNavBean {

            private RightIconBean rightIcon;
            private String background;
            private LeftIconBean leftIcon;
            private LinearGradientBean linearGradient;
            private String theme;
            private boolean ifShow;
            private AppGradientBean appGradient;

            public RightIconBean getRightIcon() {
                return rightIcon;
            }

            public void setRightIcon(RightIconBean rightIcon) {
                this.rightIcon = rightIcon;
            }

            public String getBackground() {
                return background;
            }

            public void setBackground(String background) {
                this.background = background;
            }

            public LeftIconBean getLeftIcon() {
                return leftIcon;
            }

            public void setLeftIcon(LeftIconBean leftIcon) {
                this.leftIcon = leftIcon;
            }

            public LinearGradientBean getLinearGradient() {
                return linearGradient;
            }

            public void setLinearGradient(LinearGradientBean linearGradient) {
                this.linearGradient = linearGradient;
            }

            public String getTheme() {
                return theme;
            }

            public void setTheme(String theme) {
                this.theme = theme;
            }

            public boolean isIfShow() {
                return ifShow;
            }

            public void setIfShow(boolean ifShow) {
                this.ifShow = ifShow;
            }

            public AppGradientBean getAppGradient() {
                return appGradient;
            }

            public void setAppGradient(AppGradientBean appGradient) {
                this.appGradient = appGradient;
            }

            public static class RightIconBean {
                /**
                 * imgUrl :
                 * actionType :
                 * action :
                 */

                private String imgUrl;
                private String actionType;
                private String action;

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getActionType() {
                    return actionType;
                }

                public void setActionType(String actionType) {
                    this.actionType = actionType;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }
            }

            public static class LeftIconBean {
                /**
                 * imgUrl :
                 * actionType :
                 * action :
                 */

                private String imgUrl;
                private String actionType;
                private String action;

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getActionType() {
                    return actionType;
                }

                public void setActionType(String actionType) {
                    this.actionType = actionType;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }
            }

            public static class LinearGradientBean {
                /**
                 * backgroundColor : #ffe694
                 * background : [{"color":"#fdd34e","step":"0%"},{"color":"#ffa423","step":"100%"}]
                 * deg : 180deg
                 * ifGradient : false
                 */

                private String backgroundColor;
                private String deg;
                private boolean ifGradient;
                private List<BackgroundBean> background;

                public String getBackgroundColor() {
                    return backgroundColor;
                }

                public void setBackgroundColor(String backgroundColor) {
                    this.backgroundColor = backgroundColor;
                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public boolean isIfGradient() {
                    return ifGradient;
                }

                public void setIfGradient(boolean ifGradient) {
                    this.ifGradient = ifGradient;
                }

                public List<BackgroundBean> getBackground() {
                    return background;
                }

                public void setBackground(List<BackgroundBean> background) {
                    this.background = background;
                }

                public static class BackgroundBean {
                    /**
                     * color : #fdd34e
                     * step : 0%
                     */

                    private String color;
                    private String step;

                    public String getColor() {
                        return color;
                    }

                    public void setColor(String color) {
                        this.color = color;
                    }

                    public String getStep() {
                        return step;
                    }

                    public void setStep(String step) {
                        this.step = step;
                    }
                }
            }

            public static class AppGradientBean {
                /**
                 * backgroundColor : #CCA322
                 * background : [{"color":"#fdd34e","step":"0%"},{"color":"#ffa423","step":"100%"}]
                 * deg : 180deg
                 * ifGradient : false
                 */

                private String backgroundColor;
                private String deg;
                private boolean ifGradient;
                private List<BackgroundBeanX> background;

                public String getBackgroundColor() {
                    return backgroundColor;
                }

                public void setBackgroundColor(String backgroundColor) {
                    this.backgroundColor = backgroundColor;
                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public boolean isIfGradient() {
                    return ifGradient;
                }

                public void setIfGradient(boolean ifGradient) {
                    this.ifGradient = ifGradient;
                }

                public List<BackgroundBeanX> getBackground() {
                    return background;
                }

                public void setBackground(List<BackgroundBeanX> background) {
                    this.background = background;
                }

                public static class BackgroundBeanX {
                    /**
                     * color : #fdd34e
                     * step : 0%
                     */

                    private String color;
                    private String step;

                    public String getColor() {
                        return color;
                    }

                    public void setColor(String color) {
                        this.color = color;
                    }

                    public String getStep() {
                        return step;
                    }

                    public void setStep(String step) {
                        this.step = step;
                    }
                }
            }
        }

        public static class BoottomNavBean {
            /**
             * iconWidth :
             * color :
             * bakcgroundColor :
             * groups : [{"imgUrl":"","actionType":"","activeImgUrl":"","action":"","text":"首页"},{"imgUrl":"","actionType":"","activeImgUrl":"","action":"","text":"分类"},{"imgUrl":"","actionType":"","activeImgUrl":"","action":"","text":"购物"},{"imgUrl":"","actionType":"","activeImgUrl":"","action":"","text":"我的"}]
             * fontSize :
             * height :
             */

            private String iconWidth;
            private String color;
            private String bakcgroundColor;
            private String fontSize;
            private String height;
            private List<GroupsBean> groups;

            public String getIconWidth() {
                return iconWidth;
            }

            public void setIconWidth(String iconWidth) {
                this.iconWidth = iconWidth;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getBakcgroundColor() {
                return bakcgroundColor;
            }

            public void setBakcgroundColor(String bakcgroundColor) {
                this.bakcgroundColor = bakcgroundColor;
            }

            public String getFontSize() {
                return fontSize;
            }

            public void setFontSize(String fontSize) {
                this.fontSize = fontSize;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public List<GroupsBean> getGroups() {
                return groups;
            }

            public void setGroups(List<GroupsBean> groups) {
                this.groups = groups;
            }

            public static class GroupsBean {
                /**
                 * imgUrl :
                 * actionType :
                 * activeImgUrl :
                 * action :
                 * text : 首页
                 */

                private String imgUrl;
                private String actionType;
                private String activeImgUrl;
                private String action;
                private String text;

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getActionType() {
                    return actionType;
                }

                public void setActionType(String actionType) {
                    this.actionType = actionType;
                }

                public String getActiveImgUrl() {
                    return activeImgUrl;
                }

                public void setActiveImgUrl(String activeImgUrl) {
                    this.activeImgUrl = activeImgUrl;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }

        public static class SuspensionBean {
            /**
             * imgUrl : https://p3.ssl.qhimg.com/t01539d86c446cfd22b.png
             * actionType : link
             * bottom : 100
             * width : 60
             * action :
             * ifShow : false
             * right : 30
             * height : 60
             * desc :
             */

            private String imgUrl;
            private String actionType;
            private String bottom;
            private String width;
            private String action;
            private boolean ifShow;
            private String right;
            private String height;
            private String desc;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getActionType() {
                return actionType;
            }

            public void setActionType(String actionType) {
                this.actionType = actionType;
            }

            public String getBottom() {
                return bottom;
            }

            public void setBottom(String bottom) {
                this.bottom = bottom;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public boolean isIfShow() {
                return ifShow;
            }

            public void setIfShow(boolean ifShow) {
                this.ifShow = ifShow;
            }

            public String getRight() {
                return right;
            }

            public void setRight(String right) {
                this.right = right;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }
}
