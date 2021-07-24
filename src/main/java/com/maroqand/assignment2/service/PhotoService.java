package com.maroqand.assignment2.service;

import com.google.gson.Gson;
import com.maroqand.assignment2.model.Album;
import com.maroqand.assignment2.model.Photo;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService {
    private static HttpURLConnection connection;
    public BufferedReader reader;
    JSONObject jsonObject = new JSONObject();
    ArrayList<Photo> imageParams;
    Album album;
    List<String> imgUrl;

    public List<String> getPhotos(String photoName, Model model) {
        try {
            URL url = new URL("https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=4b53c35d166569f04bc7aa69c53dc8cf&tags=eco&format=json&nojsoncallback=1&tags=" + photoName + "&per_page=25&page=");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int status = connection.getResponseCode();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            jsonObject = new JSONObject(reader.readLine());
            for (int i = 0; i < jsonObject.length(); i++) {
                Gson gson = new Gson();
                album = gson.fromJson(String.valueOf(jsonObject), Album.class);
                imageParams = new ArrayList<>(album.getPhotos().getPhoto());
            }
            imgUrl = new ArrayList<>();
            for (Photo a : imageParams) {
                imgUrl.add("https://live.staticflickr.com/" + a.getServer() + "/" + a.getId() + "_" + a.getSecret() + ".jpg");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("imgUrls", imgUrl);
        return imgUrl;
    }
}
