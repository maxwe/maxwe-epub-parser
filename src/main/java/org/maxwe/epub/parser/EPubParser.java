package org.maxwe.epub.parser;

import org.maxwe.epub.parser.core.IEPub;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.impl.Content;
import org.maxwe.epub.parser.impl.Metadata;
import org.maxwe.epub.parser.impl.Navigation;
import org.maxwe.epub.parser.meta.*;
import org.maxwe.epub.parser.meta.xml.*;

import java.io.File;
import java.util.*;

/**
 * Created by Pengwei Ding on 2015-12-09 19:05.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class EPubParser implements IEPubMeta, IEPub {
    /**
     * EPub入口文件
     */
    private static final String META_INF_CONTAINER = "/META-INF/container.xml";

    /**
     * EPub资源文件所在的根目录
     */
    private String rootFilePath;

    /**
     * 解析Container.xml文件对象
     */
    private IContainer iContainer;

    /**
     * 解析opf文件对象
     */
    private IOPF iopf;

    private Content content;

    public EPubParser(String rootFilePath) throws Exception {
        this.rootFilePath = rootFilePath;
        String fullPathOFContainer = EPubParserUtils.pathLinker(this.rootFilePath, META_INF_CONTAINER);
        if (!new File(fullPathOFContainer).exists()) {
            throw new Exception("入口文件" + META_INF_CONTAINER + "不存在");
        } else {
            this.iContainer = new ContainerXml(fullPathOFContainer);
            this.iopf = new OPF(EPubParserUtils.pathLinker(this.rootFilePath, this.iContainer.getRelativeFullPath()));

            String navigationFilePath = EPubParserUtils.pathLinker(EPubParserUtils.pathLinker(this.rootFilePath, this.iContainer.getRelativeFullPathDir()), this.iopf.getNavigationFilePath());
            String navigationHtmlPath = EPubParserUtils.pathLinker(EPubParserUtils.pathLinker(this.rootFilePath, this.iContainer.getRelativeFullPathDir()), this.iopf.getNavigationHtmlPath());

            /**
             * 从TOC中解析出目录
             */
            Content convertNavigationFileToContent = this.convertNavigationFileToContent(navigationFilePath);
            /**
             * 从HTML中解析出目录
             */
            Content convertNavigationHtmlToContent = this.convertNavigationHtmlToContent(navigationHtmlPath);

            /**
             * 选取解析出的目录中的任意一个赋值
             */
            content = convertNavigationHtmlToContent;

            /**
             * 如果从TOC中解析出的目录比较多就取值TOC解析结果
             */
            if ((convertNavigationFileToContent == null ? 0 : convertNavigationFileToContent.getContentSize()) > (convertNavigationHtmlToContent == null ? 0 : convertNavigationHtmlToContent.getContentSize())) {
                content = convertNavigationFileToContent;
            }

            /**
             * 如果从HTML中解析出的目录比较多就取值HTML解析结果
             */
            if ((convertNavigationFileToContent == null ? 0 : convertNavigationFileToContent.getContentSize()) < (convertNavigationHtmlToContent == null ? 0 : convertNavigationHtmlToContent.getContentSize())) {
                content = convertNavigationHtmlToContent;
            }

            /**
             * 如果上面两个结果都没有就取值SPINE
             */
            if (content == null || content.getContentSize() < 1) {
                content = this.convertManifestSpineToContent();
            }

            if (content == null || content.getContentSize() < 1) {
                throw new Exception("目录不存在");
            }
        }
    }

    public Metadata getMetadata() {
        return new Metadata(
                this.iopf.getMetadata().getDcIdentifier() == null ? null : this.iopf.getMetadata().getDcIdentifier().getFirst() == null ? null : this.iopf.getMetadata().getDcIdentifier().getFirst().getValue(),
                this.iopf.getMetadata().getDcIdentifier() == null ? null : this.iopf.getMetadata().getDcIdentifier().getFirst() == null ? null : this.iopf.getMetadata().getDcIdentifier().getFirst().getValue(),
                this.iopf.getMetadata().getDcTitle() == null ? null : this.iopf.getMetadata().getDcTitle().getFirst() == null ? null : this.iopf.getMetadata().getDcTitle().getFirst().getValue(),
                this.iopf.getMetadata().getDcCreator() == null ? null : this.iopf.getMetadata().getDcCreator().getFirst() == null ? null : this.iopf.getMetadata().getDcCreator().getFirst().getValue(),
                this.iopf.getMetadata().getDcPublisher() == null ? null : this.iopf.getMetadata().getDcPublisher().getFirst() == null ? null : this.iopf.getMetadata().getDcPublisher().getFirst().getValue(),
                this.iopf.getMetadata().getDcLanguage() == null ? null : this.iopf.getMetadata().getDcLanguage().getFirst() == null ? null : this.iopf.getMetadata().getDcLanguage().getFirst().getValue(),
                this.iopf.getMetadata().getDcDate() == null ? null : this.iopf.getMetadata().getDcDate().getFirst() == null ? null : this.iopf.getMetadata().getDcDate().getFirst().getValue(),
                this.iopf.getMetadata().getDcDate() == null ? null : this.iopf.getMetadata().getDcDate().getFirst() == null ? null : this.iopf.getMetadata().getDcDate().getFirst().getValue(),
                this.iopf.getMetadata().getMetas() == null ? null : this.iopf.getMetadata().getMetas().getFirst() == null ? null : this.iopf.getMetadata().getMetas().getFirst().getValue());
    }

    public Content getContent() {
        return content;
    }

    public IContainer getIContainer() {
        return iContainer;
    }

    public IOPF getIOPF() {
        return iopf;
    }

    private Content convertNavigationFileToContent(String navigationFilePath) throws Exception {
        Content result = null;
        if (navigationFilePath != null && new File(navigationFilePath).isFile()) {
            TocNcx tocNcx = new TocNcx(navigationFilePath);
            NavMap navMap = tocNcx.getNavMap();

            LinkedList<INavigation> navigations = new LinkedList<INavigation>();
            LinkedList<NavPoint> navPoints = navMap.getNavPoints();
            if (navPoints != null) {
                for (NavPoint navPoint : navPoints) {
                    String pathLinker = EPubParserUtils.pathLinker(EPubParserUtils.pathLinker(this.rootFilePath, this.iContainer.getRelativeFullPathDir()), navPoint.getContent().getValue());
                    Navigation navigation = new Navigation(navPoint.getId(), navPoint.getPlayOrder(), navPoint.getNavLabel().getText().getValue(), pathLinker, navPoint.getContent().getValue());
                    navigations.add(navigation);
                    if (navPoint.getSubNavPoints() != null) {
                        buildNavTree(navPoint, navigation);
                    }
                }
            }
            result = new Content(navigations);
        }
        return result;
    }

    private void buildNavTree(NavPoint navPoint, Navigation navigation) {
        LinkedList<NavPoint> subNavPoints = navPoint.getSubNavPoints();
        if (subNavPoints == null) {
            return;
        } else {
            for (NavPoint subNavPoint : subNavPoints) {
                String pathLinker = EPubParserUtils.pathLinker(EPubParserUtils.pathLinker(this.rootFilePath, this.iContainer.getRelativeFullPathDir()), subNavPoint.getContent().getValue());
                Navigation subNavigation = new Navigation(subNavPoint.getId(), subNavPoint.getPlayOrder(), subNavPoint.getNavLabel().getText().getValue(), pathLinker, subNavPoint.getContent().getValue());
                navigation.getSubNavigation().add(subNavigation);
                buildNavTree(subNavPoint, subNavigation);
            }
        }
    }

    private Content convertNavigationHtmlToContent(String navigationHtmlPath) throws Exception {
        Content result = null;
        if (navigationHtmlPath != null && new File(navigationHtmlPath).isFile()) {
            LinkedList<INavigation> navigations = new LinkedList<INavigation>();
            LinkedHashMap<String, String> linkedHashMap = new Tables(navigationHtmlPath).getLinkedHashMap();
            Set<Map.Entry<String, String>> entries = linkedHashMap.entrySet();
            int index = 0;
            int lastIndexOf = navigationHtmlPath.lastIndexOf(File.separator);
            navigationHtmlPath = navigationHtmlPath.substring(0, lastIndexOf);
            for (Map.Entry<String, String> entry : entries) {
                String pathLinker = EPubParserUtils.pathLinker(navigationHtmlPath, entry.getKey());
                Navigation subNavigation = new Navigation(pathLinker, index++, entry.getValue(), pathLinker, iopf.getNavigationHtmlPath().substring(0, iopf.getNavigationHtmlPath().lastIndexOf(File.separator) == -1 ? iopf.getNavigationHtmlPath().length() : iopf.getNavigationHtmlPath().lastIndexOf(File.separator)) + File.separator + entry.getKey());
                navigations.add(subNavigation);
            }
            result = new Content(navigations);
        }
        return result;
    }

    private Content convertManifestSpineToContent() throws Exception {
        LinkedList<INavigation> navigations = new LinkedList<INavigation>();
        Spine spine = this.getIOPF().getSpine();
        Manifest manifest = this.getIOPF().getManifest();
        List<Itemref> itemrefs = spine.getItemrefs();
        int index = 0;
        for (Itemref itemref : itemrefs) {
            Item itemById = manifest.getItemById(itemref.getIdref());
            if (itemById != null) {
                String pathLinker = EPubParserUtils.pathLinker(EPubParserUtils.pathLinker(this.rootFilePath, this.iContainer.getRelativeFullPathDir()), itemById.getHref());
                navigations.add(new Navigation(pathLinker, index++, itemById.getId(), pathLinker, itemById.getHref()));
            }
        }
        return new Content(navigations);
    }

}
