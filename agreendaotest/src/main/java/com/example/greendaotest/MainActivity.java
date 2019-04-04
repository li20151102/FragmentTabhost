package com.example.greendaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库测试  SQLite  GreenDao框架
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_add;
    private Button btn_edit;
    private Button btn_delete;
    private Button btn_query;

    private ListView listView;

    private List<Shop> shops;
    private ShopListAdapter adapter;

    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        initView();
        initData();
    }

    private void initData() {
        shops = new ArrayList<>();
        shops = ShopDaos.queryShop();
        adapter = new ShopListAdapter(this, shops);
        listView.setAdapter(adapter);
    }

    private void initView() {

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_query = (Button) findViewById(R.id.btn_query);
        listView = (ListView) findViewById(R.id.listView);

        btn_add.setOnClickListener(this);
        btn_edit.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_query.setOnClickListener(this);

    }
    private void addDate() {
        Shop shop = new Shop();
        shop.setType(Shop.TYPE_CART);
        shop.setAddress("广东深圳");
        shop.setImage_url("https://img.alicdn.com/bao/uploaded/i2/TB1N4V2PXXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q50.jpg");
        shop.setPrice("$ 19.50");
        shop.setSell_num(15263);
        shop.setName("正宗梅菜扣肉 聪厨梅干菜扣肉 家宴常备方便菜虎皮红烧肉 2盒包邮" + i++);
        ShopDaos.insertShop(shop);
        initData();
    }

    private void updateDate() {
        if (!shops.isEmpty()) {
            Shop shop = shops.get(0);
            shop.setName("我是修改的名字");
            ShopDaos.updateShop(shop);
            initData();
        }
    }

    private void deleteDate() {
        if (!shops.isEmpty()) {
            ShopDaos.deleteShop(shops.get(0).getId());
            initData();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                addDate();
                break;
            case R.id.btn_edit:
                updateDate();
                break;
            case R.id.btn_delete:
                deleteDate();
                break;
            case R.id.listView:
                initData();
                break;
        }
    }
}
