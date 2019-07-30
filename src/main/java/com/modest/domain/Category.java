package com.modest.domain;

import java.io.Serializable;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
public class Category implements Serializable {
    private String cid;

    private String cname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
