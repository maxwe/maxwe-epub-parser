package org.maxwe.epub.parser.meta;

import org.maxwe.epub.parser.meta.xml.Guide;
import org.maxwe.epub.parser.meta.xml.Manifest;
import org.maxwe.epub.parser.meta.xml.Metadata;
import org.maxwe.epub.parser.meta.xml.Spine;

/**
 * Created by Pengwei Ding on 2015-12-09 10:00.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析OPF文件 定义OPF文件对外提供接口
 * OPF文件名称不确定 以@{IContainer.java}提供接口为准
 */
public interface IOPF {

    String getFilePath();

    Metadata getMetadata();

    Manifest getManifest();

    Spine getSpine();

    Guide getGuide();

}
