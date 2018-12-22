package kr.tjit.listview02_20181222_03.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import kr.tjit.listview02_20181222_03.R;
import kr.tjit.listview02_20181222_03.datas.Store;

public class StoreAdapter extends ArrayAdapter<Store> {

//    화면에 실제로 데이터를 뿌리는데 사용되는 멤버변수 3개 생성.
    Context mContext;       // 어느 화면이 이 어뎁터를 사용하는지 저장.
//                              이벤트 처리나 기타 등등의 컨텍스트를 활용할 예시를 배우게 됨.
    List<Store> mList;      // 실제 화면에 뿌릴 근거 데이터를 담는 List
    LayoutInflater inf;     // R.layout.그린파일을 실제로 메모리에 그려주는 역할

    public StoreAdapter(Context mContext, List<Store> mList) {
        super(mContext, R.layout.store_list_item, mList);

//        위에서 정의한 3개 변수들의 값을 대입
        this.mContext = mContext;
        this.mList = mList;
        this.inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row==null) {
//            row가 null이라면 비어있는 곳에 내용을 집어넣어라.
//            inflate: xml파일을 불러다가 실제로 메모리에 올려주는 역할
            row = inf.inflate(R.layout.store_list_item, null);
        }

        TextView storeNameTxt = row.findViewById(R.id.storeNameTxt);
        TextView storeAddressTxt = row.findViewById(R.id.storeAddressTxt);
        Button storeCallBtn = row.findViewById(R.id.storeCallBtn);
        TextView storeOpenTimeTxt = row.findViewById(R.id.storeOpenTimeTxt);

//        position번째 데이터를 빼내와라.
        final Store data = mList.get(position);

//        각각의 뷰에 데이터 세팅.
        storeNameTxt.setText(data.getName());
        storeAddressTxt.setText(data.getAddress());
        storeOpenTimeTxt.setText(data.getOpenAndCloseTime());

        storeCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                전화거는 기능을 활용

//                전화를 걸기위한 uri 생성
                Uri uri = Uri.parse(String.format("tel:%s", data.getPhoneNum()));
//                만든 uri를 이용해 intent 생성
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

//                작성중인 이 클래스는 ArrayAdapter 상속받고 있음.
//                ArrayAdapter는 startActivity 기능을 물려주지 않음.
//                startActivity는 MainActivity같은 액티비티가 가진 기능.

//                mContext가 MainActivity를 대변하고 있는 상황.
                mContext.startActivity(intent);
            }
        });


        return row;
    }
}
