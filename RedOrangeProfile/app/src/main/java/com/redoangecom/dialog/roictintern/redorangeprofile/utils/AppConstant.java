package com.redoangecom.dialog.roictintern.redorangeprofile.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.redoangecom.dialog.roictintern.redorangeprofile.R;
import com.redoangecom.dialog.roictintern.redorangeprofile.models.PortFolio;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by roictintern on 03-Jan-17.
 */

public class AppConstant {

    public static final String CONSULTANCY_TAG ="consultancy";
    public static final String FILM_TAG = "film";
    public static final String GRAPHICS_TAG = "graphics";
    public static final String CONTENT_TAG = "content_writing";
    public static final String ICT_TAG = "ict";

    public static Map<Integer , PortFolio> getConsultancyData(){

        Map<Integer , PortFolio> consData = new Hashtable<>();

        PortFolio pf = new PortFolio(); //1

        pf.setBannerPath("file:///android_asset/consultancy/amartaka.jpg");
        pf.setThumbnailPath("file:///android_asset/consultancy/amartaka_thumbnail.jpg");
        pf.setHeader(R.string.amartaka_hdr);
        pf.setDesc(R.string.amartaka_body);
        pf.setGeneralDesc(R.string.amar_gen_text);
        pf.setSiteURL(R.string.amartaka_site);
        pf.setVideoURL(R.string.amartaka_video);
        pf.setTag(AppConstant.CONSULTANCY_TAG);

        consData.put(R.string.amartaka_hdr , pf);

        pf = new PortFolio(); //2

        pf.setBannerPath("file:///android_asset/consultancy/image.png");
        pf.setThumbnailPath("file:///android_asset/consultancy/image_thumbnail.jpg");
        pf.setHeader(R.string.image_hdr);
        pf.setDesc(R.string.image_body);
        pf.setGeneralDesc(R.string.img_gen_text);
        pf.setSiteURL(R.string.image_site);
        pf.setVideoURL(R.string.image_video);
        pf.setTag(AppConstant.CONSULTANCY_TAG);

        consData.put(R.string.image_hdr , pf);

        pf = new PortFolio();  //3

        pf.setBannerPath("file:///android_asset/consultancy/ritu.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.ritu_hdr);
        pf.setDesc(R.string.ritu_body);
        pf.setGeneralDesc(R.string.ritu_gen_text);
        pf.setSiteURL(-1);
        pf.setVideoURL(-1);
        pf.setTag(AppConstant.CONSULTANCY_TAG);

        consData.put(R.string.ritu_hdr , pf);

        pf = new PortFolio(); //4

        pf.setBannerPath("file:///android_asset/consultancy/snbd1.jpg");
        pf.setThumbnailPath("file:///android_asset/consultancy/snbd2.jpg");
        pf.setHeader(R.string.sharenet_hdr);
        pf.setDesc(R.string.sharenet_body);
        pf.setGeneralDesc(R.string.sn_gen_text);
        pf.setSiteURL(R.string.sharenet_site);
        pf.setVideoURL(-1);
        pf.setTag(AppConstant.CONSULTANCY_TAG);

        consData.put(R.string.sharenet_hdr , pf);
        return consData;
    }

    public static ArrayList<String> getProductionCatagories(String tag){
        Map<String , ArrayList<String>> tag_catagories = new Hashtable<>();

        ArrayList<String> graphicsCtgry = new ArrayList<>();
        graphicsCtgry.add("Branding");
        graphicsCtgry.add("Production");
        graphicsCtgry.add("Creative Presentation");
        graphicsCtgry.add("Printing");
        graphicsCtgry.add("ALL");
        tag_catagories.put(GRAPHICS_TAG , graphicsCtgry );

        ArrayList<String> filmCtgry = new ArrayList<>();
        filmCtgry.add("Documentary Film");
        filmCtgry.add("Promotional Film");
        filmCtgry.add("Animation Film");
        filmCtgry.add("TV Commercial");
        filmCtgry.add("ALL");
        tag_catagories.put(FILM_TAG , filmCtgry);

        ArrayList<String> contentCtgry = new ArrayList<>();
        contentCtgry.add("Social Media");
        contentCtgry.add("Books");
        contentCtgry.add("Websites");
        //contentCtgry.add("Flyers And Brochures");
        contentCtgry.add("ALL");
        tag_catagories.put(CONTENT_TAG , contentCtgry);

        ArrayList<String> ictCtgry = new ArrayList<>();
        ictCtgry.add("Websites");
        ictCtgry.add("Mobile Apps");
        ictCtgry.add("E_Commerce");
        ictCtgry.add("Content Management");
        ictCtgry.add("ALL");
        tag_catagories.put(ICT_TAG , ictCtgry);


        return tag_catagories.get(tag);
    }

    public static ArrayList<PortFolio> getFilmData(String catagory){

        ArrayList<PortFolio> films;
        PortFolio pf;
        Map<String , ArrayList<PortFolio>> catagorizedFilmData = new Hashtable<>();

        pf = new PortFolio();
        films = new ArrayList<>();
        pf.setHeader(R.string.ranaplaza_hdr);
        pf.setThumbnailPath("file:///android_asset/films/ranaplaza_thn.png");
        pf.setDesc(R.string.ranaplaza_body);
        pf.setVideoURL(R.string.ranaplaza_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.rickshawPlr_hdr);
        pf.setThumbnailPath("file:///android_asset/films/rickshaw_thn.png");
        pf.setDesc(R.string.rickshawPlr_body);
        pf.setVideoURL(R.string.rickshawPlr_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.period_hdr);
        pf.setThumbnailPath("file:///android_asset/films/women_thn.png");
        pf.setDesc(R.string.period_body);
        pf.setVideoURL(R.string.period_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.rosy_hdr);
        pf.setThumbnailPath("file:///android_asset/films/rosy_nilufar_thn.png");
        pf.setDesc(R.string.rosy_body);
        pf.setVideoURL(R.string.rosy_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.farmer_hdr);

        pf.setThumbnailPath("file:///android_asset/films/farmers_thn.png");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.farmer_body);
        pf.setVideoURL(R.string.farmer_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.undp_hdr);
        pf.setThumbnailPath("file:///android_asset/films/undp_thn.jpg");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.undp_body);
        pf.setVideoURL(R.string.undp_video);
        pf.setSiteURL(-1);
        films.add(pf);

        catagorizedFilmData.put("Documentary Film" , films);

        films = new ArrayList<>();

        pf = new PortFolio();
        pf.setHeader(R.string.fao_hdr);
        pf.setThumbnailPath("file:///android_asset/films/fao_thn.png");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.fao_text);
        pf.setVideoURL(R.string.fao_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.max_hdr);
        pf.setThumbnailPath("file:///android_asset/films/max_thn.jpg");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.max_text);
        pf.setVideoURL(R.string.max_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.netgerland_hdr);
        pf.setThumbnailPath("file:///android_asset/films/netherland_thn.jpg");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.netherland_text);
        pf.setVideoURL(R.string.netherland_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.wfp_hdr);
        pf.setThumbnailPath("file:///android_asset/films/wfp_thn.jpg");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.wfp_text);
        pf.setVideoURL(R.string.wfp_video);
        pf.setSiteURL(-1);
        films.add(pf);

        catagorizedFilmData.put("Promotional Film" , films);

        films = new ArrayList<>();

        pf = new PortFolio();
        pf.setHeader(R.string.snv1_hdr);
        pf.setThumbnailPath("file:///android_asset/films/snv_thn.png");
        pf.setDesc(R.string.snv1_text);
        pf.setVideoURL(R.string.snv1_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.snv2_hdr);
        pf.setThumbnailPath("file:///android_asset/films/snv2_thn.png");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.snv2_text);
        pf.setVideoURL(R.string.snv2_video);
        pf.setSiteURL(-1);
        films.add(pf);

        pf = new PortFolio();
        pf.setHeader(R.string.giz_hdr);
        pf.setThumbnailPath("-1");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.giz_text);
        pf.setVideoURL(-1);
        pf.setSiteURL(-1);
        films.add(pf);

        catagorizedFilmData.put("Animation Film" , films);

        films = new ArrayList<>();

        pf = new PortFolio();
        pf.setHeader(-1);
        pf.setThumbnailPath("file:///android_asset/films/tvc_thn.jpg");
        pf.setBannerPath("file:///android_asset/films/films.jpg");
        pf.setDesc(R.string.tvc1_text);
        pf.setVideoURL(R.string.tvc1_video);
        pf.setSiteURL(-1);
        films.add(pf);

        catagorizedFilmData.put("TV Commercial" , films);

        films = new ArrayList<>();
        films.addAll(catagorizedFilmData.get("Documentary Film"));
        films.addAll(catagorizedFilmData.get("Promotional Film"));
        films.addAll(catagorizedFilmData.get("Animation Film"));
        films.addAll(catagorizedFilmData.get("TV Commercial"));

        catagorizedFilmData.put("ALL",films);

        return catagorizedFilmData.get(catagory);
    }

    public static ArrayList<PortFolio> getGraphicsData(String catagory){

        ArrayList<PortFolio> graphicsData;
        PortFolio pf;
        Map<String , ArrayList<PortFolio>> catagorizedGraphicsData = new HashMap<>();

        graphicsData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/graphics/icco_gr_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.iccoGr_hdr);
        pf.setDesc(R.string.iccoGr_desc);
        pf.setSiteURL(-1);
        pf.setVideoURL(-1);
        graphicsData.add(pf);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/graphics/uddp_gr_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.uddpGr_hdr);
        pf.setDesc(R.string.uddpGr_desc);
        pf.setSiteURL(-1);
        pf.setVideoURL(-1);
        graphicsData.add(pf);

        catagorizedGraphicsData.put("Branding" , graphicsData);

        graphicsData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/graphics/giz_gr_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.gizGr_hdr);
        pf.setDesc(R.string.gizGr_desc);
        pf.setSiteURL(-1);
        pf.setVideoURL(-1);
        graphicsData.add(pf);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/graphics/ucep_gr_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.ucepGr_hdr);
        pf.setDesc(R.string.ucepGr_desc);
        pf.setSiteURL(-1);
        pf.setVideoURL(-1);
        graphicsData.add(pf);

        catagorizedGraphicsData.put("Production" , graphicsData);

        graphicsData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/graphics/giz_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.gizCp_hdr);
        pf.setDesc(R.string.gizCp_desc);
        pf.setSiteURL(-1);
        pf.setVideoURL(-1);
        graphicsData.add(pf);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/graphics/fao_gr_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.faoGr_hdr);
        pf.setDesc(R.string.faoGr_desc);
        pf.setSiteURL(-1);
        pf.setVideoURL(-1);
        graphicsData.add(pf);

        catagorizedGraphicsData.put("Creative Presentation" , graphicsData);

        graphicsData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/graphics/ide_gr_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.ideGr_hdr);
        pf.setDesc(R.string.ideGr_desc);
        pf.setSiteURL(-1);
        pf.setVideoURL(-1);
        graphicsData.add(pf);
        catagorizedGraphicsData.put("Printing" , graphicsData);

        graphicsData = new ArrayList<>();
        graphicsData.addAll(catagorizedGraphicsData.get("Branding"));
        graphicsData.addAll(catagorizedGraphicsData.get("Production"));
        graphicsData.addAll(catagorizedGraphicsData.get("Creative Presentation"));
        graphicsData.addAll(catagorizedGraphicsData.get("Printing"));

        catagorizedGraphicsData.put("ALL" , graphicsData);

        return catagorizedGraphicsData.get(catagory);
    }

    public static ArrayList<PortFolio> getContentData(String catagory){

        ArrayList<PortFolio> contentData;
        PortFolio pf;
        Map<String , ArrayList<PortFolio>> catagorizedContentData = new HashMap<>();

        contentData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/contents/image_cw_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.imageCw_hdr);
        pf.setDesc(R.string.imageCw_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(-1);
        contentData.add(pf);

        catagorizedContentData.put("Social Media",contentData);

        contentData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/contents/sap_cw_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(R.string.sapCw_hdr);
        pf.setDesc(R.string.sapCw_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(-1);
        contentData.add(pf);

        catagorizedContentData.put("Books",contentData);

        catagorizedContentData.put("Websites" , getICTData("Websites"));

        contentData = new ArrayList<>();

        contentData.addAll(catagorizedContentData.get("Social Media"));
        contentData.addAll(catagorizedContentData.get("Books"));
        contentData.addAll(catagorizedContentData.get("Websites"));

        catagorizedContentData.put("ALL" , contentData);

        return catagorizedContentData.get(catagory);
    }

    public static ArrayList<PortFolio> getICTData(String catagory){

        ArrayList<PortFolio> ictData;
        PortFolio pf;
        Map<String , ArrayList<PortFolio>> catagorizedICTData = new HashMap<>();

        ictData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/image_banner_website.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(-1);
        pf.setDesc(R.string.imageIct_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(R.string.imageIct_site);
        ictData.add(pf);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/publiqtv_ict_banner.png");
        pf.setThumbnailPath("-1");
        pf.setHeader(-1);
        pf.setDesc(R.string.publiqIct_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(R.string.publiqIct_site);
        ictData.add(pf);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/sharenet_ict_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(-1);
        pf.setDesc(R.string.sharenet_burundiIct_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(R.string.sharenet_burundiIct_site);
        ictData.add(pf);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/proofs_ict_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(-1);
        pf.setDesc(R.string.proofsIct_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(R.string.proofsIct_site);
        ictData.add(pf);

        catagorizedICTData.put("Websites",ictData);

        ictData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/app_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(-1);
        pf.setDesc(R.string.appIct_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(R.string.app_link);
        ictData.add(pf);

        catagorizedICTData.put("Mobile Apps" , ictData);

        ictData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/taichi_ict_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(-1);
        pf.setDesc(R.string.taichiIct_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(R.string.taichiIct_site);
        ictData.add(pf);

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/rietveld_ict_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(-1);
        pf.setDesc(R.string.rietveldIct_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(R.string.rietveldIct_site);
        ictData.add(pf);

        catagorizedICTData.put("E_Commerce" , ictData);

        ictData = new ArrayList<>();

        pf = new PortFolio();
        pf.setBannerPath("file:///android_asset/ict/jstfrm_ict_banner.jpg");
        pf.setThumbnailPath("-1");
        pf.setHeader(-1);
        pf.setDesc(R.string.jstfrmIct_desc);
        pf.setVideoURL(-1);
        pf.setSiteURL(R.string.jstfrmIct_site);
        ictData.add(pf);

        catagorizedICTData.put("Content Management" , ictData);

        ictData = new ArrayList<>();

        ictData.addAll(catagorizedICTData.get("Websites"));
        ictData.addAll(catagorizedICTData.get("Mobile Apps"));
        ictData.addAll(catagorizedICTData.get("E_Commerce"));
        ictData.addAll(catagorizedICTData.get("Content Management"));

        catagorizedICTData.put("ALL" , ictData);

        return catagorizedICTData.get(catagory);
    }

    public static void setCustomFont(final TextView tv , final Context context , final String fontPath , final int textId){

        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                tv.setText(Html.fromHtml(context.getString(textId)));
                tv.setTypeface(Typeface.createFromAsset(context.getAssets() , fontPath));
            }
        };

        h.postDelayed(r , 500);
    }

    public static void setCustomFontToSrvc(final TextView icon ,final String iconCode , final TextView desc , final String des, final Context context , final String fa , final String rl){

        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {

                icon.setText(iconCode);
                desc.setText(des);

                icon.setTypeface(Typeface.createFromAsset(context.getAssets() , fa));
                desc.setTypeface(Typeface.createFromAsset(context.getAssets() , rl));
            }
        };

        h.postDelayed(r , 500);
    }


}
