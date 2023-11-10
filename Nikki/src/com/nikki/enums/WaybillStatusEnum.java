/**
 * 
 */
package com.nikki.enums;

/**
 * @author Jesse
 *
 */
public enum WaybillStatusEnum {
	NEW("N", "新建", 0),//已分段
	TOSCHEDULED("S", "待调度", 1),//已下发
	LOADED("L", "已调度", 2),
	DISPATCHED("D", "已发运", 3),//在途
	REACHED("", "", 4),
	SIGNED("", "", 5),//已回单
	FINISHED("", "", 6),
	CANCELED("", "", 7);

	WaybillStatusEnum(String string, String string2, int i) {
        this.label = string;
        this.description = string2;
        this.index = i;
	}
	
	private String label;
	private String description;
	private Integer index;
}
