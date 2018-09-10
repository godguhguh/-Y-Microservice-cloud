package com.ypp.tunte.common.domain;

import com.ypp.tunte.common.annotation.CommonDataFieldAnnotation;
import com.ypp.tunte.common.enums.DataFieldTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/5 0005
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "creator" ,length=32)
    public String getCreator() {
        return creator;
    }

    @CommonDataFieldAnnotation
    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @CommonDataFieldAnnotation(type = DataFieldTypeEnum.DATE)
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "last_modify_time")
    public Date getLastModifyTime() {
        return lastModifyTime;
    }
    @CommonDataFieldAnnotation(type = DataFieldTypeEnum.DATE)
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
