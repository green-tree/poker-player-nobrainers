package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.leanpoker.player.Player;

import static org.junit.Assert.*;

public class PlayerTest {
   @org.junit.Test
   public void betRequest() throws Exception {
      Player player = new Player();
      JsonParser parser =  new JsonParser();
      JsonElement element = parser.parse("[\n" +
            "  {\n" +
            "    \"game_state\": {\n" +
            "      \"tournament_id\": \"59f783998508c00004000002\",\n" +
            "      \"game_id\": \"5a099df6c4f094000400012c\",\n" +
            "      \"round\": 0,\n" +
            "      \"players\": [\n" +
            "        {\n" +
            "          \"name\": \"Tooling\",\n" +
            "          \"stack\": 1000,\n" +
            "          \"status\": \"active\",\n" +
            "          \"bet\": 0,\n" +
            "          \"hole_cards\": [],\n" +
            "          \"time_used\": 0,\n" +
            "          \"version\": \"Tooling Player\",\n" +
            "          \"id\": 0\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"The QST Brothers\",\n" +
            "          \"stack\": 1000,\n" +
            "          \"status\": \"active\",\n" +
            "          \"bet\": 0,\n" +
            "          \"hole_cards\": [],\n" +
            "          \"time_used\": 0,\n" +
            "          \"version\": \"Default Java folding player\",\n" +
            "          \"id\": 1\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"noBrainers\",\n" +
            "          \"stack\": 1000,\n" +
            "          \"status\": \"active\",\n" +
            "          \"bet\": 0,\n" +
            "          \"hole_cards\": [],\n" +
            "          \"time_used\": 0,\n" +
            "          \"version\": \"NoBrainer Player\",\n" +
            "          \"id\": 2\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Funksobrothers\",\n" +
            "          \"stack\": 1000,\n" +
            "          \"status\": \"active\",\n" +
            "          \"bet\": 0,\n" +
            "          \"hole_cards\": [],\n" +
            "          \"time_used\": 0,\n" +
            "          \"version\": \"FunkSoBrothers 0.9\",\n" +
            "          \"id\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"veithGolang\",\n" +
            "          \"stack\": 1000,\n" +
            "          \"status\": \"active\",\n" +
            "          \"bet\": 0,\n" +
            "          \"hole_cards\": [],\n" +
            "          \"time_used\": 0,\n" +
            "          \"version\": \"bet 37\",\n" +
            "          \"id\": 4\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Team Stuttgart\",\n" +
            "          \"stack\": 1000,\n" +
            "          \"status\": \"active\",\n" +
            "          \"bet\": 0,\n" +
            "          \"hole_cards\": [],\n" +
            "          \"time_used\": 0,\n" +
            "          \"version\": \"Default Java folding player\",\n" +
            "          \"id\": 5\n" +
            "        }\n" +
            "      ],\n" +
            "      \"small_blind\": 2,\n" +
            "      \"big_blind\": 4,\n" +
            "      \"orbits\": 0,\n" +
            "      \"dealer\": 1,\n" +
            "      \"community_cards\": [],\n" +
            "      \"current_buy_in\": 0,\n" +
            "      \"pot\": 0\n" +
            "    }\n" +
            "  }\n" +
            "]\n");

         player.betRequest(element);



   }

   @org.junit.Test
   public void betRequest2() throws Exception {
      Player player = new Player();
      JsonParser parser =  new JsonParser();
      JsonElement element = parser.parse(
            "{\n" +
                  "  \"players\":[\n" +
                  "    {\n" +
                  "      \"name\":\"noBrainers\",\n" +
                  "      \"stack\":1000,\n" +
                  "      \"status\":\"active\",\n" +
                  "      \"bet\":0,\n" +
                  "      \"hole_cards\":[],\n" +
                  "      \"version\":\"Version name 1\",\n" +
                  "      \"id\":0\n" +
                  "    },\n" +
                  "    {\n" +
                  "      \"name\":\"Player 2\",\n" +
                  "      \"stack\":1000,\n" +
                  "      \"status\":\"active\",\n" +
                  "      \"bet\":0,\n" +
                  "      \"hole_cards\":[],\n" +
                  "      \"version\":\"Version name 2\",\n" +
                  "      \"id\":1\n" +
                  "    }\n" +
                  "  ],\n" +
                  "  \"tournament_id\":\"550d1d68cd7bd10003000003\",\n" +
                  "  \"game_id\":\"550da1cb2d909006e90004b1\",\n" +
                  "  \"round\":0,\n" +
                  "  \"bet_index\":0,\n" +
                  "  \"small_blind\":10,\n" +
                  "  \"orbits\":0,\n" +
                  "  \"dealer\":0,\n" +
                  "  \"community_cards\":[],\n" +
                  "  \"current_buy_in\":99,\n" +
                  "  \"pot\":0\n" +
                  "}");

      int res =      player.betRequest(element);

      Assert.assertEquals(99, res);

   }

   @org.junit.Test
   public void betRequestTwoEqualCards() throws Exception {
      Player player = new Player();
      JsonParser parser =  new JsonParser();
      
      JsonElement element = parser.parse(
              "{\n" +
                    "  \"players\":[\n" +
                    "    {\n" +
                    "      \"name\":\"Player 1\",\n" +
                    "      \"stack\":0,\n" +
                    "      \"status\":\"active\",\n" +
                    "      \"bet\":0,\n" +
                    "      \"hole_cards\":[],\n" +
                    "      \"version\":\"Version name 1\",\n" +
                    "      \"id\":0\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\":\"noBrainers\",\n" +
                    "      \"stack\":0,\n" +
                    "      \"status\":\"active\",\n" +
                    "      \"bet\":0,\n" +
                    "      \"hole_cards\":[{\"rank\":\"8\",\"suit\":\"hearts\"},{\"rank\":\"9\",\"suit\":\"spades\"}],\n" +
                    "      \"version\":\"Version name 2\",\n" +
                    "      \"id\":1\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"tournament_id\":\"550d1d68cd7bd10003000003\",\n" +
                    "  \"game_id\":\"550da1cb2d909006e90004b1\",\n" +
                    "  \"round\":0,\n" +
                    "  \"bet_index\":0,\n" +
                    "  \"small_blind\":10,\n" +
                    "  \"orbits\":0,\n" +
                    "  \"dealer\":0,\n" +
                    "  \"community_cards\":[],\n" +
                    "  \"current_buy_in\":99,\n" +
                    "  \"pot\":0\n" +
                    "}");
      int res =      player.betRequest(element);

      Assert.assertEquals(1000, res);

   }







   @org.junit.Test
   public void showdown() throws Exception {
   }

}