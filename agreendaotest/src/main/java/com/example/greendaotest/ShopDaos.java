package com.example.greendaotest;

import java.util.List;

/**
 * @author create by kyle_2019 on 2019/3/28 15:54
 * @package com.example.greendaotest
 * @fileName ShopDaos
 */
public class ShopDaos {
    /**
     * 添加数据，如果有重复则覆盖
     *
     * @param
     */

    public static void insertShop(Shop shop) {
        BaseApplication.getDaoInstant().getShopDao().insertOrReplace(shop);
    }

    /**
     * 删除数据
     *
     * @param
     */
    public static void deleteShop(long id) {
        BaseApplication.getDaoInstant().getShopDao().deleteByKey(id);
    }

    /**
     * 更新数据
     */
    public static void updateShop(Shop shop) {
        BaseApplication.getDaoInstant().getShopDao().update(shop);
    }

    /**
     * 查询Type为1的所有数据
     *
     * @return
     */
    public static List<Shop> queryShop() {
        return BaseApplication.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_CART)).list();
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public static List<Shop> queryAll() {
        return BaseApplication.getDaoInstant().getShopDao().loadAll();
    }
}
