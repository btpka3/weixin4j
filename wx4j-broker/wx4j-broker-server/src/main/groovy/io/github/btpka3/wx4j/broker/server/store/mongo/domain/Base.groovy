package io.github.btpka3.wx4j.broker.server.store.mongo.domain

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

/**
 * 数据库表结构的基础设计。
 *
 * @see org.springframework.data.auditing.AnnotationAuditingMetadata
 */
@Document
public abstract class Base {

    @Id
    protected String id;

    /**
     * 创建时间
     */
    @CreatedDate
    protected Date dateCreated;

    /**
     * 创建者的ID
     */
    @CreatedBy
    protected String createdBy;

    /**
     * 最后修改日期
     */
    @LastModifiedDate
    protected Date lastModifiedDate;

    /**
     * 最后更新者的ID
     */
    @LastModifiedBy
    protected String lastModifiedBy;

    /**
     * 是否已经逻辑删除
     */
    protected boolean deleted;

    // --------------------------------------- equals && hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // --------------------------------------- getter && setter

}
