package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.jocelinlaroch08.inventorymanagement.config.FlickrKey;
import com.jocelinlaroch08.inventorymanagement.service.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class FlickServiceImpl implements FlickrService {

    public FlickServiceImpl(Flickr flickr) {
        this.flickr = flickr;
    }

    private String apiKey = FlickrKey.key;
    private String apiSecret = FlickrKey.secretKey;
    private String appKey = FlickrKey.appKey;
    private String appSecret = FlickrKey.appSecret;

    @Autowired
    private Flickr flickr;

    @Override
    public String save(InputStream photo, String title) throws FlickrException {
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setTitle(title);

        String photoId = flickr.getUploader().upload(photo, uploadMetaData);

        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }

    /* private void connect() {
        flickr = new Flickr(apiKey, apiSecret, new REST());

        Auth auth = new Auth();
        auth.setPermission(Permission.DELETE);
        auth.setToken(appKey);
        auth.setTokenSecret(appSecret);

        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);

        flickr.setAuth(auth);
    } */
    
}
