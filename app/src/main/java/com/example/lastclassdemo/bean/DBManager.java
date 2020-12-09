package com.example.lastclassdemo.bean;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SpreadWater
 * @Date 2020-12-09
 * @Time 11:11
 * @description 负责管理数据库的类，主要对表的内容进行操作
 */
public class DBManager {
    private static SQLiteDatabase db;
    //初始化数据库对象
    public  static void  initDB(Context context){
        DBOpenHelper helper=new DBOpenHelper(context);//得到帮助类对象
        //得到数据库对象
        db=helper.getWritableDatabase();
    }
/*
    读取数据库当中的数据，写入内存集合中
 */
    public static List<TypeBean>getTypeList(int kind){
        List<TypeBean>list=new ArrayList<>();
        //读取type表当中的数据
        String sql="select * from typetb where kind ="+kind;
        Cursor cursor=db.rawQuery(sql,null);
        //循环读入
        while (cursor.moveToNext()){
            String typename=cursor.getString(cursor.getColumnIndex("typename"));
            int imageId=cursor.getInt(cursor.getColumnIndex("imageId"));
            int sImageId=cursor.getInt(cursor.getColumnIndex("sImageId"));
            int kindl=cursor.getInt(cursor.getColumnIndex("kind"));
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            TypeBean typeBean=new TypeBean(id,typename,imageId,sImageId,kind);
            list.add(typeBean);
        }
        return list;
    }

}
