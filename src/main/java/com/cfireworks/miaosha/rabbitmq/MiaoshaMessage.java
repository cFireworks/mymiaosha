package com.cfireworks.miaosha.rabbitmq;

import com.cfireworks.miaosha.domain.MiaoshaUser;

/**
 * @description: 秒杀信息
 * @author: cfireworks
 * @create: 2020-05-24 13:57
 **/
public class MiaoshaMessage {
    private MiaoshaUser user;
    private long goodsId;
    public MiaoshaUser getUser() {
        return user;
    }
    public void setUser(MiaoshaUser user) {
        this.user = user;
    }
    public long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }
}
