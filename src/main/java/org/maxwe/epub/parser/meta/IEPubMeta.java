package org.maxwe.epub.parser.meta;

import org.maxwe.epub.parser.impl.Content;
import org.maxwe.epub.parser.impl.Metadata;

/**
 * Created by Pengwei Ding on 2015-12-09 19:04.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析EPub元数据
 */
public interface IEPubMeta {

    Metadata getMetadata();

    Content getContent();

    IContainer getIContainer();

    IOPF getIOPF();

}
