package com.app.androidutildemo.mvp.modle;

import java.util.List;

/**
 * Created by Nick on 2018/11/22.
 */
public class TmsPoolListBean {
    /**
     * data : {"userOrg":null,"data":{"pageNumber":1,"currentNo":1,"pageSize":10,"rows":[{"skuName":"高新高筋鲜面王25KG/包*5包","skuSpec":"25KG/包*5包","price":"460.00","goodsId":"265010641965632","shopName":"好伙计","id":"265010642219584","goodsName":"高新高筋鲜面王25KG/包*5包","cityIds":"100","goodsDescription":"高新高筋鲜面王25KG/包*5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/90da24d91ce2bf145636270224a0acf5.png","skuId":"265010642219584"},{"skuName":"深圳面粉高筋小麦粉22.7kg *5包","skuSpec":"22.7KG/包*5包","price":"605.00","goodsId":"265011698180672","shopName":"好伙计","id":"265011698430528","goodsName":"深圳面粉高筋小麦粉22.7kg*5包","cityIds":"100","goodsDescription":"深圳面粉高筋小麦粉22.7kg *5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/b0fedfe0b78b74b1b509e23043aa2eb6.png","skuId":"265011698430528"},{"skuName":"香雪饺皮粉25KG/包*5包","skuSpec":"25KG/包*5包","price":"445.00","goodsId":"265013005595200","shopName":"好伙计","id":"265013005832768","goodsName":"香雪饺皮粉25KG/包*5包","cityIds":"100","goodsDescription":"香雪饺皮粉25KG/包*5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/796c87bba9308d18371f2c906de4ca64.png","skuId":"265013005832768"},{"skuName":"远洋龙圣中颗粒大豆49KG/袋","skuSpec":"49KG/包","price":"999.00","goodsId":"352767610107072","shopName":"好伙计","id":"352767610594496","goodsName":"测试秒杀","cityIds":"100","goodsDescription":"测试秒杀","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/917dd14fefa05049658425db74138b5b.jpg","skuId":"352767610594496"}],"totalElements":4},"saleId":"1","poolSize":4,"remark":null,"pageId":"1042042925412790272","getItemInfoUrl":"http://heyguys.haohuoji.com.cn/GOODSNOZZLE-APP-SERVICE/goodsSkuApp/queryInfoList.apec","descList":[],"batchQueryParams":{"CMS-skuList":"[{\"cityId\":\"100\",\"skuId\":\"265010642219584\"},{\"cityId\":\"100\",\"skuId\":\"265011698430528\"},{\"cityId\":\"100\",\"skuId\":\"265013005832768\"},{\"cityId\":\"100\",\"skuId\":\"352767610594496\"}]"},"createBy":"1530495608230995","poolNo":"1063358075814031360","systemTypeEnum":"HHJ","id":"1063358075814031360","poolName":"好伙计有图","status":"1","desc":"{}"}
     * errorCode :
     * errorMsg :
     * repeatAct : b89b5508-4045-4255-84f7-8aea68be308b
     * succeed : true
     */

    private DataBeanX data;
    private String errorCode;
    private String errorMsg;
    private String repeatAct;
    private boolean succeed;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getRepeatAct() {
        return repeatAct;
    }

    public void setRepeatAct(String repeatAct) {
        this.repeatAct = repeatAct;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public static class DataBeanX {
        /**
         * userOrg : null
         * data : {"pageNumber":1,"currentNo":1,"pageSize":10,"rows":[{"skuName":"高新高筋鲜面王25KG/包*5包","skuSpec":"25KG/包*5包","price":"460.00","goodsId":"265010641965632","shopName":"好伙计","id":"265010642219584","goodsName":"高新高筋鲜面王25KG/包*5包","cityIds":"100","goodsDescription":"高新高筋鲜面王25KG/包*5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/90da24d91ce2bf145636270224a0acf5.png","skuId":"265010642219584"},{"skuName":"深圳面粉高筋小麦粉22.7kg *5包","skuSpec":"22.7KG/包*5包","price":"605.00","goodsId":"265011698180672","shopName":"好伙计","id":"265011698430528","goodsName":"深圳面粉高筋小麦粉22.7kg*5包","cityIds":"100","goodsDescription":"深圳面粉高筋小麦粉22.7kg *5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/b0fedfe0b78b74b1b509e23043aa2eb6.png","skuId":"265011698430528"},{"skuName":"香雪饺皮粉25KG/包*5包","skuSpec":"25KG/包*5包","price":"445.00","goodsId":"265013005595200","shopName":"好伙计","id":"265013005832768","goodsName":"香雪饺皮粉25KG/包*5包","cityIds":"100","goodsDescription":"香雪饺皮粉25KG/包*5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/796c87bba9308d18371f2c906de4ca64.png","skuId":"265013005832768"},{"skuName":"远洋龙圣中颗粒大豆49KG/袋","skuSpec":"49KG/包","price":"999.00","goodsId":"352767610107072","shopName":"好伙计","id":"352767610594496","goodsName":"测试秒杀","cityIds":"100","goodsDescription":"测试秒杀","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/917dd14fefa05049658425db74138b5b.jpg","skuId":"352767610594496"}],"totalElements":4}
         * saleId : 1
         * poolSize : 4
         * remark : null
         * pageId : 1042042925412790272
         * getItemInfoUrl : http://heyguys.haohuoji.com.cn/GOODSNOZZLE-APP-SERVICE/goodsSkuApp/queryInfoList.apec
         * descList : []
         * batchQueryParams : {"CMS-skuList":"[{\"cityId\":\"100\",\"skuId\":\"265010642219584\"},{\"cityId\":\"100\",\"skuId\":\"265011698430528\"},{\"cityId\":\"100\",\"skuId\":\"265013005832768\"},{\"cityId\":\"100\",\"skuId\":\"352767610594496\"}]"}
         * createBy : 1530495608230995
         * poolNo : 1063358075814031360
         * systemTypeEnum : HHJ
         * id : 1063358075814031360
         * poolName : 好伙计有图
         * status : 1
         * desc : {}
         */

        private Object userOrg;
        private DataBean data;
        private String saleId;
        private int poolSize;
        private Object remark;
        private String pageId;
        private String getItemInfoUrl;
        private String createBy;
        private String poolNo;
        private String systemTypeEnum;
        private String id;
        private String poolName;
        private String status;
        private String desc;
        private List<?> descList;

        public Object getUserOrg() {
            return userOrg;
        }

        public void setUserOrg(Object userOrg) {
            this.userOrg = userOrg;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getSaleId() {
            return saleId;
        }

        public void setSaleId(String saleId) {
            this.saleId = saleId;
        }

        public int getPoolSize() {
            return poolSize;
        }

        public void setPoolSize(int poolSize) {
            this.poolSize = poolSize;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getPageId() {
            return pageId;
        }

        public void setPageId(String pageId) {
            this.pageId = pageId;
        }

        public String getGetItemInfoUrl() {
            return getItemInfoUrl;
        }

        public void setGetItemInfoUrl(String getItemInfoUrl) {
            this.getItemInfoUrl = getItemInfoUrl;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getPoolNo() {
            return poolNo;
        }

        public void setPoolNo(String poolNo) {
            this.poolNo = poolNo;
        }

        public String getSystemTypeEnum() {
            return systemTypeEnum;
        }

        public void setSystemTypeEnum(String systemTypeEnum) {
            this.systemTypeEnum = systemTypeEnum;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPoolName() {
            return poolName;
        }

        public void setPoolName(String poolName) {
            this.poolName = poolName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public List<?> getDescList() {
            return descList;
        }

        public void setDescList(List<?> descList) {
            this.descList = descList;
        }

        public static class DataBean {
            /**
             * pageNumber : 1
             * currentNo : 1
             * pageSize : 10
             * rows : [{"skuName":"高新高筋鲜面王25KG/包*5包","skuSpec":"25KG/包*5包","price":"460.00","goodsId":"265010641965632","shopName":"好伙计","id":"265010642219584","goodsName":"高新高筋鲜面王25KG/包*5包","cityIds":"100","goodsDescription":"高新高筋鲜面王25KG/包*5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/90da24d91ce2bf145636270224a0acf5.png","skuId":"265010642219584"},{"skuName":"深圳面粉高筋小麦粉22.7kg *5包","skuSpec":"22.7KG/包*5包","price":"605.00","goodsId":"265011698180672","shopName":"好伙计","id":"265011698430528","goodsName":"深圳面粉高筋小麦粉22.7kg*5包","cityIds":"100","goodsDescription":"深圳面粉高筋小麦粉22.7kg *5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/b0fedfe0b78b74b1b509e23043aa2eb6.png","skuId":"265011698430528"},{"skuName":"香雪饺皮粉25KG/包*5包","skuSpec":"25KG/包*5包","price":"445.00","goodsId":"265013005595200","shopName":"好伙计","id":"265013005832768","goodsName":"香雪饺皮粉25KG/包*5包","cityIds":"100","goodsDescription":"香雪饺皮粉25KG/包*5包","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/796c87bba9308d18371f2c906de4ca64.png","skuId":"265013005832768"},{"skuName":"远洋龙圣中颗粒大豆49KG/袋","skuSpec":"49KG/包","price":"999.00","goodsId":"352767610107072","shopName":"好伙计","id":"352767610594496","goodsName":"测试秒杀","cityIds":"100","goodsDescription":"测试秒杀","skuImage":"https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/917dd14fefa05049658425db74138b5b.jpg","skuId":"352767610594496"}]
             * totalElements : 4
             */

            private int pageNumber;
            private int currentNo;
            private int pageSize;
            private int totalElements;
            private List<RowsBean> rows;

            public int getPageNumber() {
                return pageNumber;
            }

            public void setPageNumber(int pageNumber) {
                this.pageNumber = pageNumber;
            }

            public int getCurrentNo() {
                return currentNo;
            }

            public void setCurrentNo(int currentNo) {
                this.currentNo = currentNo;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getTotalElements() {
                return totalElements;
            }

            public void setTotalElements(int totalElements) {
                this.totalElements = totalElements;
            }

            public List<RowsBean> getRows() {
                return rows;
            }

            public void setRows(List<RowsBean> rows) {
                this.rows = rows;
            }

            public static class RowsBean {
                /**
                 * skuName : 高新高筋鲜面王25KG/包*5包
                 * skuSpec : 25KG/包*5包
                 * price : 460.00
                 * goodsId : 265010641965632
                 * shopName : 好伙计
                 * id : 265010642219584
                 * goodsName : 高新高筋鲜面王25KG/包*5包
                 * cityIds : 100
                 * goodsDescription : 高新高筋鲜面王25KG/包*5包
                 * skuImage : https://heyguys-image.oss-cn-shenzhen.aliyuncs.com/90da24d91ce2bf145636270224a0acf5.png
                 * skuId : 265010642219584
                 */

                private String skuName;
                private String skuSpec;
                private String price;
                private String goodsId;
                private String shopName;
                private String id;
                private String goodsName;
                private String cityIds;
                private String goodsDescription;
                private String skuImage;
                private String skuId;

                public String getSkuName() {
                    return skuName;
                }

                public void setSkuName(String skuName) {
                    this.skuName = skuName;
                }

                public String getSkuSpec() {
                    return skuSpec;
                }

                public void setSkuSpec(String skuSpec) {
                    this.skuSpec = skuSpec;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(String goodsId) {
                    this.goodsId = goodsId;
                }

                public String getShopName() {
                    return shopName;
                }

                public void setShopName(String shopName) {
                    this.shopName = shopName;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getCityIds() {
                    return cityIds;
                }

                public void setCityIds(String cityIds) {
                    this.cityIds = cityIds;
                }

                public String getGoodsDescription() {
                    return goodsDescription;
                }

                public void setGoodsDescription(String goodsDescription) {
                    this.goodsDescription = goodsDescription;
                }

                public String getSkuImage() {
                    return skuImage;
                }

                public void setSkuImage(String skuImage) {
                    this.skuImage = skuImage;
                }

                public String getSkuId() {
                    return skuId;
                }

                public void setSkuId(String skuId) {
                    this.skuId = skuId;
                }
            }
        }

    }
}
