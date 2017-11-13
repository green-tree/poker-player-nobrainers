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
			//bei zwei gleichen karten gehen wir immer all in
			return 1000;
		}
		if(shouldGoAllIn(firstCardRank,secondCardRank)) {
			return 1000;
		}
		
		if(isNumber(firstCardRank) && isNumber(secondCardRank))
		{
			int first = getNumber(firstCardRank);
			int second = getNumber(secondCardRank);
			if(first <= 7 && second <= 7) {
				//wenn beide zahlen kleiner gleich 7 steigen wir immer aus!
				return 0;
			}
		}
		
		
		}
		return 0;
    	//return currentBuyInElement.getAsInt();
//    	
//    	String gameState = request.getasjgetPa
//    	//if(request.getAsJsonObject())
////    	request.get
////    	current_buy_in - players[in_action][bet] + minimum_raise
////    	request.set
//        return 112;
    }

    
    
     static boolean shouldGoAllIn(String firstCardRank, String secondCardRank) {
    	 if(
    			 (firstCardRank.equals("A") && secondCardRank.equals("K")) ||
    			 (firstCardRank.equals("K") && secondCardRank.equals("A")) ||

    			 (firstCardRank.equals("A") && secondCardRank.equals("Q")) ||
    			 (firstCardRank.equals("Q") && secondCardRank.equals("A")) ||

    			 (firstCardRank.equals("A") && secondCardRank.equals("J")) ||
    			 (firstCardRank.equals("J") && secondCardRank.equals("A")) ||

    			(firstCardRank.equals("K") && secondCardRank.equals("Q")) ||
    			 (firstCardRank.equals("Q") && secondCardRank.equals("K")) ||
    			 (firstCardRank.equals("A") || secondCardRank.equals("A")) ) {
    		 return true;
    	 }
    	 return false;
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
				}
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
