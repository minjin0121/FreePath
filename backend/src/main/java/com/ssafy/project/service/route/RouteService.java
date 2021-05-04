package com.ssafy.project.service.route;

import com.ssafy.project.model.route.RouteFindRequest;

public interface RouteService {

	public Object findRoute(RouteFindRequest routeFindRequest);//경로 찾기
	
	
	
	public Object findLast(RouteFindRequest routeFindRequest);
	
}
