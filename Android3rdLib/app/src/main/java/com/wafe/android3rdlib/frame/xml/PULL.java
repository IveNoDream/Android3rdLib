package com.wafe.android3rdlib.frame.xml;

import android.util.Xml;

import com.wafe.android3rdlib.frame.xml.data.XMLBase;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wafej on 2018/4/30.
 */

//android推荐的解析方式
public class PULL {

    public static List<XMLBase> pullXML() throws Exception {
        // 获取person文件的输入流
        InputStream is = PULL.class.getClassLoader().getResourceAsStream(
                "person.xml");
        // 用来存放解析的person对象
        List<XMLBase> persons = null;
        // 一个标记
        boolean flag = false;
        XMLBase person = null;

        // 实例化一个XmlPullParser对象
        XmlPullParser parser = Xml.newPullParser();

        // 设置输入流的编码
        parser.setInput(is, "UTF-8");

        // 设置第一个事件，从这个事件开始解析文档
        int eventCode = parser.getEventType();

        // 设定结束标记，如果是END_DOCUEMNT,解析就结束了
        while (eventCode != XmlPullParser.END_DOCUMENT) {
            switch (eventCode) {
                case XmlPullParser.START_DOCUMENT:
                    // 开始解析的时候我们一般做一些初始化的操作
                    persons = new ArrayList<XMLBase>();
                    break;
                case XmlPullParser.START_TAG:
                    // 判断当前的元素是否是需要检索的元素
                    if ("person".equals(parser.getName())) {
                        flag = true;
                        person = new XMLBase();
                        //"person"节点的第一个属性值
                        //person.setId(Integer.valueOf(parser.getAttributeValue(0)));
                    }
                    if (flag) { // 为检索的元素赋值
                        if ("name".equals(parser.getName())) {
                            //"name"节点后的值
                            //person.setName(parser.nextText());
                        } else if ("age".equals(parser.getName())) {
                            //person.setAge(Integer.valueOf(parser.nextText()));
                        }
                    }
                    break;
                case XmlPullParser.END_TAG: // 结束标签，判断一个对象是否结束，结束后添加到集合中
                    if ("person".equals(parser.getName()) && person != null) {
                        flag = false;
                        persons.add(person);
                        person = null;
                    }
                    break;
            }
            // 这一步很重要，该方法返回一个事件码，也是触发下一个事件的方法
            eventCode = parser.next(); // 取下个标签
        }
        return persons;
    }
}