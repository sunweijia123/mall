package com.wuhan.mall.vo;

import java.io.Serializable;

/**
 * @author liuan
 * @create 2018-12-11 15:42
 */

public class JsonResult implements Serializable {

    private static final long serialVersionUID = 4099225846909069320L;

    /**状态码*/
    private int state=1;//1表示SUCCESS,-1表示ERROR
    /**状态信息*/
    private String message="ok";
    /**正确数据*/
    private Object data;

    private Integer page;
    private Integer pageSize;
    private Long total;
    private Long totalPages;
    public JsonResult() {}
    public JsonResult(String message){
        this.message=message;
    }
    public JsonResult(int state,String message){
        this.state = state;
        this.message = message;
    };
    /**一般查询时调用，封装查询结果*/
    public JsonResult(Object data) {
        this.data=data;
    }
    /**出现异常时时调用*/
    public JsonResult(Throwable t){
        this.state=0;
        this.message=t.getMessage();
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public static JsonResult OK(Object data){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(data);
        jsonResult.setMessage("ok");
        jsonResult.setState(1);
        return jsonResult;
    }

    public static  JsonResult OKList(Object data,Integer page,Integer pageSize,Long total,Long totalPages){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setPage(page);
        jsonResult.setPageSize(pageSize);
        jsonResult.setTotal(total);
        jsonResult.setData(data);
        jsonResult.setTotalPages(totalPages);
        jsonResult.setMessage("ok");
        jsonResult.setState(1);
        return jsonResult;
    }

    public static JsonResult FAILED(String message){
        return new JsonResult(-1,message);
    }

}

