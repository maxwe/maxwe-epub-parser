package org.maxwe.epub.parser.meta;

/**
 * Created by Pengwei Ding on 2015-12-09 09:56.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析ContainerXml文件 定义对外提供的接口
 */
public interface IContainer {
    /**
     * 获取content.opf文件的相对全路径
     * @return OEBPS/content.opf
     */
    String getRelativeFullPath();
    /**
     * 获取content.opf文件的所在目录的相对全路径
     * @return 如OEBPS/content.opf 则返回OEBPS
     */
    String getRelativeFullPathDir();
    /**
     * 获取content.opf文件的文件名
     * @return 如OEBPS/content.opf 则返回content.opf
     */
    String getOPFFileName();
}
