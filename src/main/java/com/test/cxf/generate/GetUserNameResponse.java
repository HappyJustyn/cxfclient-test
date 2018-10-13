
package com.test.cxf.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getUserNameResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getUserNameResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Integer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserNameResponse", propOrder = {
    "integer"
})
public class GetUserNameResponse {

    @XmlElement(name = "Integer")
    protected String integer;

    /**
     * 获取integer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInteger() {
        return integer;
    }

    /**
     * 设置integer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInteger(String value) {
        this.integer = value;
    }

}
