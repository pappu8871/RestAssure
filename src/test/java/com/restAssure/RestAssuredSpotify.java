package com.restAssure;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RestAssuredSpotify {
    public String token = "";
    public static String userId;

    @BeforeTest
    public void setUp() {
        token = "Bearer BQArmoF891PRxc5dSeVgOOtwx83MPB9lx-TUfqaJyU7a4H1XLlKC8rSOr" +
                "8ABEGpGVrxn1Yd2YGKxE3GEDMqiQNEOH1-U7qqa9YgI5fego1zr-a8Pfr66zBjlyaHe" +
                "Ur7PmrX9baN2-hV-uduqLUgYSGvCjH6ajsAV43l5wNOfuAGM74yyZFt_00d_uelqIhBMM6zGunn4gFEyIUY" +
                "kDUt30T57IyKzDS1nC76wKpioym0o6rju3ELCFM_CDo7sHN3Qe7J9T4" +
                "9ZgqPYBxSQ1lqlr29SHE8xD6VtPMOtzXWA";
    }
    @Test(priority = 0)
    public void User_Current_Profile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
        System.out.println("Response print using sout: " + response);
        userId = response.path("id");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }

    @Test(priority = 1)
    public void getCurrent_Users_Profile() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .when().get("\thttps://api.spotify.com/v1/users/c57a1ec77x3xo9y3tguerrx7y");
        System.out.println("Response print using sout: " + response);
        userId = response.path("id");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }

    @Test(priority = 2)
    public void getCurrent_User_playlist() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .when().get("\thttps://api.spotify.com/v1/me/playlists");
        System.out.println("Response print using sout: " + response);
        userId = response.path("id");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }

    @Test(priority = 3)
    public void getPlaylist_Cover_Image() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .when().get("https://api.spotify.com/v1/playlists/39NIaZruv2FwgiR4NfxS2B/images");
        System.out.println("Response print using sout: " + response);
//        userId = response.path("id");
//        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }

    @Test(priority = 4)
    public void  Create_Playlist() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .body("{\n" +
                        "  \"name\": \"New Playlist\",\n" +
                        "  \"description\": \"New playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when().post("https://api.spotify.com/v1/users/c57a1ec77x3xo9y3tguerrx7y/playlists");
        System.out.println("Response print using sout: " + response);
        response.prettyPrint();
    }
    @Test(priority = 5)
    public void getPlaylist_cover_image () {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .when().get("\thttps://api.spotify.com/v1/playlists/44zRY4dBumkv9PMewZtBzW/images");
        System.out.println("Response print using sout: " + response);
//        userId = response.path("id");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }
    @Test(priority = 6)
    public void putRecorder_replace_playlist_item() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .body("{\n" +
                        "  \"range_start\": 1,\n" +
                        "  \"insert_before\": 3,\n" +
                        "  \"range_length\": 2\n" +
                        "}")
                .when().put("\thttps://api.spotify.com/v1/playlists/1FYagXFwSpUXGIqf9CLOG1/tracks");
        System.out.println("Response print using sout: " + response);
        userId = response.path("1FYagXFwSpUXGIqf9CLOG1");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }

    @Test(priority = 7)
    public void upload_custom_playlist_cover_image() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)

                .when().put("\thttps://api.spotify.com/v1/playlists/1FYagXFwSpUXGIqf9CLOG1/images");
        System.out.println("Response print using sout: " + response);
        userId = response.path("1FYagXFwSpUXGIqf9CLOG1");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }

    @Test(priority = 8)
    public void Change_playlist_Details() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .body("{\n" +
                 "  \"name\": \"Updated Playlist Name\",\n" +
                  "  \"description\": \"Updated playlist description\",\n" +
                   "  \"public\": false\n" +
                    "}")
                .when().put("\thttps://api.spotify.com/v1/playlists/1FYagXFwSpUXGIqf9CLOG1");
        System.out.println("Response print using sout: " + response);
//        userId = response.path("id");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }


//    Starting track
    @Test(priority = 9)
    public void Track_audio_feature_for_several_track() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .get("\thttps://api.spotify.com/v1/audio-features");
        System.out.println("Response print using sout: " + response);
        userId = response.path("id");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }


    @Test(priority = 10)
    public void audio_analysis_for_track() {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .get("\thttps://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
        System.out.println("Response print using sout: " + response);
        userId = response.path("id");
        System.out.println("User Id :" + userId);
        response.prettyPrint();
    }

    }





