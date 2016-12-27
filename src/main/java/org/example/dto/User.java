package org.example.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Xavier Guti&#233;rrez
 *         27/12/16.
 */
@XmlRootElement(name = "user")
public class User implements Serializable {
    private String id;
    private String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
