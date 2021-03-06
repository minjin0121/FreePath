package com.ssafy.project.service.route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

	/* API URL 주소 - 버스 호선으로 검색 */
//	private final String openUrl = "https://api.odsay.com/v1/api/searchBusLane?busNo=10&CID=1000&apiKey=6f0ylgh5xFio64cNOgk4FUwGA0LhfyiH0hi5eLERJBA";

	/* API URL 주소 - 경로로 검색 */
	private final String openUrl = "https://api.odsay.com/v1/api/searchPubTransPath?SX=126.9027279&SY=37.5349277&EX=126.9145430&EY=37.5499421&apiKey=6f0ylgh5xFio64cNOgk4FUwGA0LhfyiH0hi5eLERJBA";
	
	@Override
	public String readApi() {
		
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

}
