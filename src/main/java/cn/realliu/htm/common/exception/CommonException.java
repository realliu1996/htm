package cn.realliu.htm.common.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/15
 * @Time: 15:11
 * @Description：通用异常类
 */
public class CommonException extends Exception {

    private static final long serialVersionUID = 1L;

    private static final Map<Integer,CommonException> exceptionMap = new HashMap<>();

    private static final Map<Integer,String> errmsgMap = new HashMap<>();

    static {
        errmsgMap.put(401,"参数为空");
        errmsgMap.put(402,"用户或者密码错误");
        errmsgMap.put(403,"参数错误");
        errmsgMap.put(404,"查询结果为空");
        errmsgMap.put(405,"用户未启用");
        errmsgMap.put(406,"未知错误");
        exceptionMap.put(501,new CommonException(501,getMessage(501)));
    }

    private int errcode;
    private String errmsg;

    public CommonException(int errcode,String errmsg){
        super(errmsg);
        this.errcode=errcode;
        this.errmsg=errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public static String getMessage(int errcode){
        if (errmsgMap.containsKey(errcode)){
            return errmsgMap.get(errcode);
        }else {
            return errmsgMap.get(501);
        }
    }

    public static CommonException getException(int errcode){
        if (exceptionMap.containsKey(errcode)){
            return exceptionMap.get(errcode);
        }else if (errmsgMap.containsKey(errcode)){
            CommonException ce = new CommonException(errcode,getMessage(errcode));
            exceptionMap.put(errcode,ce);
            return ce;
        }else {
            return exceptionMap.get(501);
        }
    }
}
