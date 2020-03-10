
package com.study.luoluo.wanandroid.module.knowledge.bean;

import java.util.List;


public class KnowledgeTreeData {

    private List<KnowledgeTreeData> children;

    private Long courseId;

    private Long id;

    private String name;

    private Long order;

    private Long parentChapterId;

    private Boolean userControlSetTop;

    private Long visible;

    public List<KnowledgeTreeData> getChildren() {
        return children;
    }

    public void setChildren(List<KnowledgeTreeData> children) {
        this.children = children;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Long getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(Long parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public Boolean getUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(Boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public Long getVisible() {
        return visible;
    }

    public void setVisible(Long visible) {
        this.visible = visible;
    }

}
