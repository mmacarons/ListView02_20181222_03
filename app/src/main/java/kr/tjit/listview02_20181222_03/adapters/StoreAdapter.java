package kr.tjit.listview02_20181222_03.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

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
}
