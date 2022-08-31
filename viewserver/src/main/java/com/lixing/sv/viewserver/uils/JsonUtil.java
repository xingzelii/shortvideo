package com.lixing.sv.viewserver.uils;


public class JsonUtil {
	private long statusCode;
    private String statusMsg;
    private Object object;
    /**
     * 状态码，0-成功，其他值-失败
     */
    public long getStatusCode() { return statusCode; }
    public void setStatusCode(long value) { this.statusCode = value; }
    /**
     * 返回状态描述
     */
    public String getStatusMsg() { return statusMsg; }
    public void setStatusMsg(String value) { this.statusMsg = value; }
}
