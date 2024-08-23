package com.codenox.apk.parser.parser;

import com.codenox.apk.parser.struct.xml.XmlCData;
import com.codenox.apk.parser.struct.xml.XmlNamespaceEndTag;
import com.codenox.apk.parser.struct.xml.XmlNamespaceStartTag;
import com.codenox.apk.parser.struct.xml.XmlNodeEndTag;
import com.codenox.apk.parser.struct.xml.XmlNodeStartTag;

/**
 * callback interface for parse binary xml file.
 *
 * @author dongliu
 */
public interface XmlStreamer {

    void onStartTag(XmlNodeStartTag xmlNodeStartTag);

    void onEndTag(XmlNodeEndTag xmlNodeEndTag);

    void onCData(XmlCData xmlCData);

    void onNamespaceStart(XmlNamespaceStartTag tag);

    void onNamespaceEnd(XmlNamespaceEndTag tag);
}
