package de.spqrinfo.vppserver.ippclient;

import de.spqrinfo.vppserver.schema.ippclient.AttributeGroup;
import de.spqrinfo.vppserver.schema.ippclient.AttributeList;
import de.spqrinfo.vppserver.schema.ippclient.Tag;
import de.spqrinfo.vppserver.schema.ippclient.TagList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * Copyright (C) 2008 ITS of ETH Zurich, Switzerland, Sarah Windler Burri
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.
 * <p>
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, see <http://www.gnu.org/licenses/>.
 */
class IppJaxb {
    private static final Logger logger = LoggerFactory.getLogger(IppJaxb.class);

    private final static String TAG_LIST_FILENAME = "ipp-list-of-tag.xml";
    private final static String ATTRIBUTE_LIST_FILENAME = "ipp-list-of-attributes.xml";
    private final static String CONTEXT = "de.spqrinfo.vppserver.schema.ippclient";

    private List<Tag> tagList = null;
    private List<AttributeGroup> attributeGroupList = null;

    IppJaxb() throws FileNotFoundException, JAXBException {
        try (final InputStream tagListStream = this.getClass().getResourceAsStream(TAG_LIST_FILENAME)) {
            if (tagListStream == null) {
                throw new FileNotFoundException("Cannot load " + TAG_LIST_FILENAME + " from classpath (null)");
            }
            TagList tagList = (TagList) unmarshal(tagListStream, CONTEXT);
            this.tagList = tagList.getTag();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + TAG_LIST_FILENAME + " from classpath", e);
        }

        try (final InputStream attListStream = this.getClass().getResourceAsStream(ATTRIBUTE_LIST_FILENAME)) {
            if (attListStream == null) {
                throw new FileNotFoundException("Cannot load " + ATTRIBUTE_LIST_FILENAME + " from classpath (null)");
            }
            AttributeList attributeList = (AttributeList) unmarshal(attListStream, CONTEXT);
            attributeGroupList = attributeList.getAttributeGroup();
        } catch (IOException e) {
            throw new FileNotFoundException("Cannot load " + ATTRIBUTE_LIST_FILENAME + " from classpath (null)");
        }
    }

    private Object unmarshal(InputStream inputStream, String context) throws JAXBException, FileNotFoundException {
        Objects.requireNonNull(inputStream, "InputStream cannot be null");
        Objects.requireNonNull(context, "Context cannot be null");

        logger.debug("Attempt to unmarshal from stream {} and context {}", inputStream, context);

        JAXBContext jc = JAXBContext.newInstance(context);
        Unmarshaller u = jc.createUnmarshaller();
        return u.unmarshal(inputStream);
    }

    List<Tag> getTagList() {

        return tagList;
    }

    List<AttributeGroup> getAttributeGroupList() {
        return attributeGroupList;
    }
}
