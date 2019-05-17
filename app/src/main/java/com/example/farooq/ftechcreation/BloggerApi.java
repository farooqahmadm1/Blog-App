package com.example.farooq.ftechcreation;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class BloggerApi {
    private static final String key ="AIzaSyAsKFpk_yUA1enQOR-nSKLP_eNL_-kkW0w";
    private static final String url= "https://www.googleapis.com/blogger/v3/blogs/5573238815586147578/posts/";

    public static PostService  postService = null;

    public static PostService getService(){
        if(postService==null){
            Retrofit retrofit =new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService = retrofit.create(PostService.class);
        }
        return postService;
    }


    public interface PostService{

        @GET("?key="+key)
        Call<PostList> getPostlist();

        @GET("(postId)/?key"+key)
        Call<Item> getPostById(@Path("postId") String id);
    }
}
