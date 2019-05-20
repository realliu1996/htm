package cn.realliu.htm.common.bean;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/19
 * @Time: 22:36
 * @Description：占比实体
 */
@Component
public class Proportion {

    private static final long serialVersionUID = 1L;

    //一室一厅一卫占比
    private String oneRoomOnelive;
    //两室一厅一卫占比
    private String twoRoomOnelive;
    //三室一厅一卫占比
    private String thirdRoomOnelive;
    //三室两厅一卫占比
    private String thirdRoomTwolive;


    //城中区占比
    private String inCity;
    //郊区占比
    private String outCity;
    //城乡结合部占比
    private String onCity;

    public String getOneRoomOnelive() {
        return this.oneRoomOnelive;
    }

    public void setOneRoomOnelive(String oneRoomOnelive) {
        this.oneRoomOnelive = oneRoomOnelive;
    }

    public String getTwoRoomOnelive() {
        return this.twoRoomOnelive;
    }

    public void setTwoRoomOnelive(String twoRoomOnelive) {
        this.twoRoomOnelive = twoRoomOnelive;
    }

    public String getThirdRoomOnelive() {
        return this.thirdRoomOnelive;
    }

    public void setThirdRoomOnelive(String thirdRoomOnelive) {
        this.thirdRoomOnelive = thirdRoomOnelive;
    }

    public String getThirdRoomTwolive() {
        return this.thirdRoomTwolive;
    }

    public void setThirdRoomTwolive(String thirdRoomTwolive) {
        this.thirdRoomTwolive = thirdRoomTwolive;
    }

    public String getInCity() {
        return this.inCity;
    }

    public void setInCity(String inCity) {
        this.inCity = inCity;
    }

    public String getOutCity() {
        return this.outCity;
    }

    public void setOutCity(String outCity) {
        this.outCity = outCity;
    }

    public String getOnCity() {
        return this.onCity;
    }

    public void setOnCity(String onCity) {
        this.onCity = onCity;
    }
}
