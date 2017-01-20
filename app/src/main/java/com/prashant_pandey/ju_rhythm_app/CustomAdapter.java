package com.yoavi.materialtest1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;


/**
 * Created by Chikki on 1/17/2017.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final static int Image_Slider=0;
    private final static int quote=1;
    private final static int event=2;
    private final static int prize=3;
    private final static int video=4;
    private final static int sponsors=5;

    String VideoId="uhOoTXwxqco";

    YouTubeThumbnailView youTubeThumbnailView;
    final String API_KEY="AIzaSyBEhMQeWh6tLq35I6kPk5puns9IJ0wHN98";

    private Context context;
    public CustomAdapter(Context context){
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        CardView v1;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case Image_Slider:
                v1 = (CardView)LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.homepage_imageslider,parent,false);
                viewHolder = new ViewHolder(v1);
                break;

            case quote:
                v1 = (CardView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.homepage_quote,parent,false);
                viewHolder= new ViewHolder(v1);
                break;

            case event:
                v1 = (CardView)LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.homepage_event,parent,false);

                ImageView cultural= (ImageView) v1.findViewById(R.id.imgCultural);
                cultural.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(parent.getContext(),"Clicked on Cultural",Toast.LENGTH_LONG).show();
                    }
                });

                ImageView imgTechnical=(ImageView)v1.findViewById(R.id.imgTechnical);
                imgTechnical.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(parent.getContext(),"Technical",Toast.LENGTH_LONG).show();
                    }
                });

                ImageView imgESummit=(ImageView)v1.findViewById(R.id.imgESummit);
                imgESummit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(parent.getContext(),"Clicked on ESummit",Toast.LENGTH_LONG).show();
                    }
                });
                viewHolder = new ViewHolder(v1);
                break;

            case prize:
                v1 = (CardView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.homepage_prize,parent,false);
                viewHolder= new ViewHolder(v1);
                break;

            case video:
                v1 = (CardView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.homepage_random,parent,false);

                viewHolder= new ViewHolder(v1);
                break;

            case sponsors:
                v1 = (CardView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.homepage_sponsors,parent,false);
                TextView textView =(TextView)v1.findViewById(R.id.moreSponsors);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(parent.getContext(),"Sponsors page",Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolder= new ViewHolder(v1);

        }
            return (ViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //check this method
        if(position==video){

        final YouTubeThumbnailLoader.OnThumbnailLoadedListener  onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.relativeLayoutOverYouTubeThumbnailView.setVisibility(View.VISIBLE);
            }
        };

        youTubeThumbnailView.initialize(API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo(VideoId);
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
            }
        });
        }
    }


    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == Image_Slider)
            return Image_Slider;
        else if (position== quote)
            return quote;
        else if(position==event)
            return event;
        else if(position==prize)
            return  prize;
        else if(position==video)
            return  video;
        else
            return sponsors;
    }

    ImageView play;

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;

        ImageView playButton;
        public ViewHolder(View itemView) {
            super(itemView);
            //check
            playButton=(ImageView)itemView.findViewById(R.id.youtube_image);
            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) context, API_KEY, VideoId);
                    context.startActivity(intent);
                }
            });
            relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutOverYoutube);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.thumb);
        }

    }



}
