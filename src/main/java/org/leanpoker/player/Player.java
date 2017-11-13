package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.datatransfer.StringSelection;
import java.util.Map;

public class Player {

    static final String VERSION = "NoBrainer Player";

    public static int betRequest(JsonElement request) {
    	
    	System.out.println("My Request" + request); 
    	JsonObject json = request.getAsJsonObject();
    	JsonElement currentBuyInElement = json.get("current_buy_in");
    	
    	JsonElement players = json.get("players");
    	
    	JsonElement player = getOurPlayer(players);
    	if(player == null) {
    		System.out.println("player not found should never happen!");
    		return 0;
    	}
    	//"hole_cards":[{"rank":"10","suit":"spades"}]
    	JsonArray cardsArray = player.getAsJsonObject().get("hole_cards").getAsJsonArray();
		if(cardsArray.size() ==2) {
		String firstCardRank = cardsArray.get(0).getAsJsonObject().get("rank").getAsString();
		String secondCardRank = cardsArray.get(1).getAsJsonObject().get("rank").getAsString();
		//"hole_cards":[{"rank":"10","suit":"spades"}]
		if(firstCardRank.equals(secondCardRank)) {
			return 1000;
		}
		
		if(isNumber(firstCardRank) && isNumber(secondCardRank))
		{
			int first = getNumber(firstCardRank);
			return 0;
		}
		
		
		}
    	return currentBuyInElement.getAsInt();
//    	
//    	String gameState = request.getasjgetPa
//    	//if(request.getAsJsonObject())
////    	request.get
////    	current_buy_in - players[in_action][bet] + minimum_raise
////    	request.set
//        return 112;
    }

	private static int getNumber(String rank) {
		return Integer.parseInt(rank);
	}

	private static JsonElement getOurPlayer(JsonElement players) {
		if(players.isJsonArray()) {
			JsonArray playersArray = players.getAsJsonArray();
			
			for (int i = 0; i < playersArray.size(); i++) {
				JsonElement player = playersArray.get(i);
				if(!player.isJsonNull() && player.isJsonObject()) {
					JsonElement jsonNameElement = player.getAsJsonObject().get("name");
					if(!jsonNameElement.isJsonNull() &&jsonNameElement.isJsonPrimitive())
					{
						if(jsonNameElement.getAsString().equals("noBrainers")) {
							return player;
						}
					}
					throw new IllegalArgumentException("kein name element");
				}
				throw new IllegalArgumentException("loop über player failed");
			}
		}
		throw new IllegalArgumentException("players ist kein array");
	}
    
    static boolean isNumber(String card) {
    	try {
    		Integer.valueOf(card);
    	}
    	catch (NumberFormatException e) {
			return false;
		}
    	return true;
    }

    public static void showdown(JsonElement game) {
    	//
    }
}
