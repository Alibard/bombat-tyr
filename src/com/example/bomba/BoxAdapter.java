package com.example.bomba;
import java.util.ArrayList;



import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class BoxAdapter extends BaseAdapter {
  Context ctx;
  LayoutInflater lInflater;
  ArrayList<Product> objects;
  Picasso mPicasso;
  String ss="http://bomba.vn.ua/sites/default/files/styles/200x200/public/_dsc0072.jpg?itok=ORAFJotr";
  BoxAdapter(Context context, ArrayList<Product> products) {
    ctx = context;
    objects = products;
    lInflater = (LayoutInflater) ctx
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  // ���-�� ���������
  @Override
  public int getCount() {
    return objects.size();
  }

  // ������� �� �������
  @Override
  public Object getItem(int position) {
    return objects.get(position);
  }

  // id �� �������
  @Override
  public long getItemId(int position) {
    return position;
  }

  // ����� ������
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // ���������� ���������, �� �� ������������ view
    View view = convertView;
    if (view == null) {
      view = lInflater.inflate(R.layout.items, parent, false);
    }

    Product p = getProduct(position);

    // ��������� View � ������ ������ ������� �� �������: ������������, ����
    // � ��������
    ((TextView) view.findViewById(R.id.tvDescr)).setText(p.name);
    ((TextView) view.findViewById(R.id.tvPrice)).setText(p.price);
   // ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.image);
    ImageView imageView = (ImageView) view.findViewById(R.id.ivImage);
   // mPicasso.load(ss).into(imageView);
    mPicasso.with(ctx).load(p.image).resize(60, 60).into(imageView);
   
    
    return view;
  }

  // ����� �� �������
  Product getProduct(int position) {
    return ((Product) getItem(position));
  }

 
  
}