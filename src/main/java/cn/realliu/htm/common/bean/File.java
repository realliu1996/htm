package cn.realliu.htm.common.bean;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/2/26
 * @Time: 21:16
 * @Description：上传文件实体
 */
@Component
public class File {

    private static final long serialVersionUID = 1L;

    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //路径
    private String url;
    //保存文件名
    private String title;
    //文件名
    private String filename;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
