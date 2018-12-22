package kr.tjit.listview02_20181222_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.tjit.listview02_20181222_03.adapters.StoreAdapter;
import kr.tjit.listview02_20181222_03.datas.Store;

public class MainActivity extends BaseActivity {

    ListView storeListView;
    List<Store> storeList = new ArrayList<Store>();
    StoreAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        fillStores();

//        mAdapter 객체화
        mAdapter = new StoreAdapter(mContext, storeList);
//        미리 만들어둔 listView 변수와 방금 만든 어댑터를 서로 연결.
        storeListView.setAdapter(mAdapter);

    }

//    가게 데이터를 채우기 위한 임시 메쏘드
//    노가다. 실제로는 이렇게 안 함.
    void fillStores() {
        storeList.clear();

        storeList.add(new Store("BBQ", "종로구 10길", 4, "오후 2시 ~ 오전 1시", "01012345678"));
        storeList.add(new Store("네네치킨", "종로구 7길", 4, "오후 3시 ~ 오전 4시", "01094215684"));
        storeList.add(new Store("굽네치킨", "종로구 15길", 4, "오후 4시 ~ 오전 3시", "01012345678"));
        storeList.add(new Store("노랑통닭", "종로구 8길", 4, "오후 2시 ~ 오전 7시", "01094215684"));
        storeList.add(new Store("디디치킨", "종로구 1길", 4, "오후 7시 ~ 오전 2시", "01012345678"));
        storeList.add(new Store("BHC", "종로구 2길", 4, "오후 2시 ~ 오전 3시", "01094215684"));
        storeList.add(new Store("교촌치킨", "종로구 4길", 4, "오후 4시 ~ 오전 1시", "01012345678"));

    }

    @Override
    public void bindViews() {

        storeListView = findViewById(R.id.storeListView);

    }
}
