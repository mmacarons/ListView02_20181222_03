package kr.tjit.listview02_20181222_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import kr.tjit.listview02_20181222_03.datas.Store;

public class StoreDetailActivity extends BaseActivity {

//    클래스의 멤버변수로 받아올 데이터 변수를 생성.
    Store mStore;

    TextView nameTxt;
    TextView addressTxt;
    TextView openTimeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//        getSerializable 사용할 땐 어떤 자료로 취급할 건지 명시해줘야 함. 여기서는 Store 자료형으로 형변환.
        mStore = (Store) getIntent().getSerializableExtra("storeData");

        nameTxt.setText(mStore.getName());
        addressTxt.setText(mStore.getAddress());
        openTimeTxt.setText(mStore.getOpenAndCloseTime());

    }

    @Override
    public void bindViews() {

        nameTxt = findViewById(R.id.nameTxt);
        addressTxt = findViewById(R.id.addressTxt);
        openTimeTxt = findViewById(R.id.openTimeTxt);

    }
}
