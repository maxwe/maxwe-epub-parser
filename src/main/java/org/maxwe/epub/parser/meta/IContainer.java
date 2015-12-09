package org.maxwe.epub.parser.meta;

/**
 * Created by Pengwei Ding on 2015-12-09 09:56.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析ContainerXml文件 定义对外提供的接口
 */
public interface IContainer {
    /**
     * 获取相对全路径
     * @return OEBPS/content.opf
     */
    String getRelativeFullPath();

}
