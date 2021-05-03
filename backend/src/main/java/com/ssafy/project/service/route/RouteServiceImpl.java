package com.ssafy.project.service.route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.model.api.ApiProperties;
import com.ssafy.project.model.route.RouteFindRequest;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private ApiProperties apiProperties;

	@Override
	public Object findRoute(RouteFindRequest routeFindRequest) {
		String apiKey = "D6BmCrs4iH/PLaOQ390EUYI9%2BAdf8B55184hmV7GpSA";
		
		final String openUrl = "https://api.odsay.com/v1/api/searchPubTransPathT?lang=0&SX="
				+ routeFindRequest.getStartX() + "&SY=" + routeFindRequest.getStartY() + "&EX="
				+ routeFindRequest.getEndX() + "&EY=" + routeFindRequest.getEndY() + "&apiKey=" + apiKey;

		StringBuffer sb = new StringBuffer();

		try {
			URL url = new URL(openUrl);

			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");

			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

			sb.append(br.readLine());

			urlConnection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public String readApi() {
		
//		System.out.println(apiProperties.getKey());

		StringBuffer sb = new StringBuffer();
		final String openUrl = "https://api.odsay.com/v1/api/searchBusLane?busNo=10&CID=1000&apiKey=" + apiProperties.getKey();

		try {
			URL url = new URL(openUrl);

			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");

			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

			sb.append(br.readLine());

			urlConnection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	@Override
	public Object findLast(RouteFindRequest routeFindRequest) {
		
		final String openUrl = "https://api.odsay.com/v1/api/searchPubTransPathT?lang=0&SX="
				+ routeFindRequest.getStartX() + "&SY=" + routeFindRequest.getStartY() + "&EX="
				+ routeFindRequest.getEndX() + "&EY=" + routeFindRequest.getEndY() + "&apiKey=" + apiProperties.getKey();
		
		try {
			URL url = new URL(openUrl);

			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(br);
			JSONObject response = (JSONObject) obj.get("result");
			JSONArray path = (JSONArray) response.get("path");

			for (int i = 0; i < path.size(); i++) {
//				System.out.println(path.get(i));
				System.out.println("==================================");
				JSONObject paths = (JSONObject) path.get(i);

				/* pathType => 1: 지하철, 2: 버스, 3: 지하철&버스 */
				long pathType = (Long) paths.get("pathType");
//				System.out.println("pathType: " + pathType);

				/* 경로 전체 정보 */
				JSONObject info = (JSONObject) paths.get("info");
//				System.out.println("info: " + info);

				/* 막차 정보를 확인하기 위한 각 sub-path 정보 확인 */
				JSONArray subPath = (JSONArray) paths.get("subPath");
				for (int j = 0; j < subPath.size(); j++) {
					JSONObject smallSubPath = (JSONObject) subPath.get(j);
					
					System.out.println(smallSubPath);
				}
			}

			urlConnection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "OK";
	}

}
