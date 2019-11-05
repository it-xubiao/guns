
package cn.stylefeng.guns.modular.kangyuan.entity;

/**
 * @ClassName Gydb
 * @Description DCS数据实体
 * @Author xubiao
 * @Date 2019/6/2814:54
 **/
public class Gydb {

    /**
     * 批次号
     */
    private String  batchNumber;

    /**
     * 罐号
     */
    private String deviceCode;

    /**
     * 罐名
     */
    private String deviceName;

    /**
     * 过程名称
     */
    private String processName;
    /**
     * 阶段名称
     */
    private String stageName;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 中间体名称
     */
    private String paraName;

    /**
     * 实际值
     */
    private Double value;

    /**
     * 单位
     */
    private String unit;

    /**
     * 系统时间
     */
    private String tmCurt;


    /**
     * 获取 批次号
     *
     * @return batchNumber 批次号
     */
    public String getBatchNumber() {
        return this.batchNumber;
    }

    /**
     * 设置 批次号
     *
     * @param batchNumber 批次号
     */
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    /**
     * 获取 罐号
     *
     * @return deviceCode 罐号
     */
    public String getDeviceCode() {
        return this.deviceCode;
    }

    /**
     * 设置 罐号
     *
     * @param deviceCode 罐号
     */
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    /**
     * 获取 罐名
     *
     * @return deviceName 罐名
     */
    public String getDeviceName() {
        return this.deviceName;
    }

    /**
     * 设置 罐名
     *
     * @param deviceName 罐名
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * 获取 过程名称
     *
     * @return processName 过程名称
     */
    public String getProcessName() {
        return this.processName;
    }

    /**
     * 设置 过程名称
     *
     * @param processName 过程名称
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 获取 阶段名称
     *
     * @return stageName 阶段名称
     */
    public String getStageName() {
        return this.stageName;
    }

    /**
     * 设置 阶段名称
     *
     * @param stageName 阶段名称
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /**
     * 获取 产品名称
     *
     * @return productName 产品名称
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 设置 产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取 中间体名称
     *
     * @return paraName 中间体名称
     */
    public String getParaName() {
        return this.paraName;
    }

    /**
     * 设置 中间体名称
     *
     * @param paraName 中间体名称
     */
    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    /**
     * 获取 实际值
     *
     * @return value 实际值
     */
    public Double getValue() {
        return this.value;
    }

    /**
     * 设置 实际值
     *
     * @param value 实际值
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * 获取 单位
     *
     * @return unit 单位
     */
    public String getUnit() {
        return this.unit;
    }

    /**
     * 设置 单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取 系统时间
     *
     * @return tmCurt 系统时间
     */
    public String getTmCurt() {
        return this.tmCurt;
    }

    /**
     * 设置 系统时间
     *
     * @param tmCurt 系统时间
     */
    public void setTmCurt(String tmCurt) {
        this.tmCurt = tmCurt;
    }
}
