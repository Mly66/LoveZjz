package cn.nbmly.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 响应结果
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class RestResult<T> {

    /**
     * 业务返回码
     */
    @Schema(description = "业务返回码")
    private String code;

    /**
     * 业务提示信息
     */
    @Schema(description = "业务提示信息")
    private String msg;

    /**
     * 业务数据
     */
    @Schema(description = "业务数据")
    private T data;

    public RestResult() {
    }

    public RestResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
