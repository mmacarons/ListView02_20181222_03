package kr.tjit.listview02_20181222_03;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import kr.tjit.listview02_20181222_03.datas.Store;

public class StoreDetailActivity extends BaseActivity {

//    클래스의 멤버변수로 받아올 데이터 변수를 생성.
Store mStore;
    private android.widget.ImageView logoImg;
    private TextView tempTxt;
    private TextView nameTxt;
    private TextView addressTxt;
    private TextView openTimeTxt;


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

        this.openTimeTxt = (TextView) findViewById(R.id.openTimeTxt);
        this.addressTxt = (TextView) findViewById(R.id.addressTxt);
        this.nameTxt = (TextView) findViewById(R.id.nameTxt);
        this.tempTxt = (TextView) findViewById(R.id.tempTxt);
        this.logoImg = (ImageView) findViewById(R.id.logoImg);

    }
}
