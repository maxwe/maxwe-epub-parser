package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by dingpengwei on 1/28/15.
 */
public class Manifest extends AXmlLabelParser {
    private Map<String,Item> idItems;
    private List<Item> items;

    public Manifest(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.ITEM.toString(), nodeName)){
                        //dc:identifier的开始节点
                        if (this.items == null) {
                            this.items = new LinkedList<Item>();
                        }
                        if (idItems == null){
                            this.idItems = new HashMap<String,Item>();
                        }
                        Item item = new Item(xmlPullParser);
                        this.idItems.put(item.getId(),item);
                        this.items.add(item);
                    }
                    //结束节点
                case XmlPullParser.END_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.MANIFEST.toString(), nodeName)){
                        eventType = XmlPullParser.END_DOCUMENT;
                    }
                    break;
                default:
                    break;
            }
            if (eventType != XmlPullParser.END_DOCUMENT) {
                eventType = xmlPullParser.next();
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemById(String id){
        if (this.idItems == null){
            return null;
        }
        return this.idItems.get(id);
    }

    public String getNcxFileName(){
        if (this.idItems.containsKey("ncx")){
            return this.idItems.get("ncx").getHref();
        }else if (idItems.containsKey("toc")){
            return this.idItems.get("toc").getHref();
        }else{
            return null;
        }
    }
}
