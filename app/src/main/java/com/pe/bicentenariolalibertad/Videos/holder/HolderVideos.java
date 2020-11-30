package com.pe.bicentenariolalibertad.Videos.holder;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.pe.bicentenariolalibertad.R;
import com.pe.bicentenariolalibertad.Videos.Model.ModelVideo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderVideos extends RecyclerView.ViewHolder {

    Context context;
    List<ModelVideo> models;

    SimpleExoPlayer simpleExoPlayer;
    PlayerView playerView;
    TextView title;

    public HolderVideos(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mclicklistener.onItemClick(v,getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mclicklistener.onItemLongClick(v,getAdapterPosition());
                return false;
            }
        });



    }

    public  void  setExoplyer(Application application,  String titulo, String url) {
      playerView = itemView.findViewById(R.id.videoView);
        title = itemView.findViewById(R.id.txttitleVideo);

        title.setText(titulo);

      try {
          BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(application).build();
          TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
          simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(application);
          Uri video = Uri.parse(url);
          DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("Videos");
          ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
          MediaSource mediaSource =new ExtractorMediaSource(video,dataSourceFactory, extractorsFactory,null ,null);

          playerView.setPlayer(simpleExoPlayer);
          simpleExoPlayer.prepare(mediaSource);
          simpleExoPlayer.setPlayWhenReady(false);
      }catch (Exception e){
          Log.e("HolderVideol", "error"+e.toString());
      }
  }
private HolderVideos.Clicklistener mclicklistener;
  public  interface Clicklistener{
        void onItemClick(View view, int position);
        Void onItemLongClick(View view, int position);
    }

    public void  setonClickListener(HolderVideos.Clicklistener clicklistener){
        mclicklistener= clicklistener;
    }

}
