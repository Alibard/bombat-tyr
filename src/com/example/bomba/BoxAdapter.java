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

  // кол-во элементов
  @Override
  public int getCount() {
    return objects.size();
  }

  // элемент по позиции
  @Override
  public Object getItem(int position) {
    return objects.get(position);
  }

  // id по позиции
  @Override
  public long getItemId(int position) {
    return position;
  }

  // пункт списка
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // используем созданные, но не используемые view
    View view = convertView;
    if (view == null) {
      view = lInflater.inflate(R.layout.items, parent, false);
    }

    Product p = getProduct(position);

    // заполняем View в пункте списка данными из товаров: наименование, цена
    // и картинка
    ((TextView) view.findViewById(R.id.tvDescr)).setText(p.name);
    ((TextView) view.findViewById(R.id.tvPrice)).setText(p.price);
   // ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.image);
    ImageView imageView = (ImageView) view.findViewById(R.id.ivImage);
   // mPicasso.load(ss).into(imageView);
    mPicasso.with(ctx).load(p.image).resize(60, 60).into(imageView);
   
    
    return view;
  }

  // товар по позиции
  Product getProduct(int position) {
    return ((Product) getItem(position));
  }

 
  
}