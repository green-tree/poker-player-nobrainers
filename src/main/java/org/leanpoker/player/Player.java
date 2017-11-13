package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "NoBrainer Player";

    public static int betRequest(JsonElement request) {
    	JsonObject json = request.getAsJsonObject();
    	JsonElement currentBuyInElement = json.get("current_buy_in");
    	return currentBuyInElement.getAsInt();
//    	rameter("game_state");
//    	if(request.ge)JSONObject json = new JSONObject(yourdata);
//    	String statistics = json.getString("statistics");
//    	String name1 = json.getString("John");
//    	String ageJohn = name1.getString("Age");
//    	
//    	String gameState = request.getasjgetPa
//    	//if(request.getAsJsonObject())
////    	request.get
////    	current_buy_in - players[in_action][bet] + minimum_raise
////    	request.set
//        return 112;
    }

    public static void showdown(JsonElement game) {
    	//
    }
}
