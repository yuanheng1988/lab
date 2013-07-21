package cn.iscas.nfs.platform.coreservice.storage.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import cn.iscas.nfs.platform.coreservice.storage.bean.ToolMap;


@XmlRootElement
public class StringList {

    private List<ToolMap> data;

    public StringList() {
    }

    public StringList(List<ToolMap> data) {
        this.data = data;
    }

    public List<ToolMap> getData() {
        return data;
    }

    public void setData(List<ToolMap> data) {
        this.data = data;
    }
}