package com.ssafy.project.model.route;

import lombok.Data;

@Data
public class RouteFindRequest {
	
	//출발지 x,y
	private float startX;
	private float startY;
	//도착지 x,y
	private float endX;
	private float endY;
	//도착시간
	private String arriveTime;
}
