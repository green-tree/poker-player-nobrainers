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
    	JsonArray playersArray = players.getAsJsonArray();
    	for (int i = 0; i < playersArray.size(); i++) {
			JsonElement player = playersArray.get(i);
			if(player.getAsJsonObject().get("name").getAsString().equals("noBrainers")) {
				//"hole_cards":[{"rank":"10","suit":"spades"}]
				JsonArray cardsArray = player.getAsJsonObject().get("hold-cards").getAsJsonArray();
				String firstCardRank = cardsArray.get(0).getAsJsonObject().get("rank").getAsString();
				String secondCardRank = cardsArray.get(0).getAsJsonObject().get("rank").getAsString();

				if(firstCardRank.equals(secondCardRank)) {
					return 1000;
				}
				
				if(isNumber(firstCardRank) && isNumber(secondCardRank))
				{
					return 0;
				}
				
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
    
    private static boolean isNumber(String card) {
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
