package com.cfireworks.miaosha.redis;

public class OrderKey extends BaseKeyPrefix {

	public OrderKey(String prefix) {
		super(prefix);
	}
	public static OrderKey getMiaoshaOrderByUidGid = new OrderKey("moug");
}
