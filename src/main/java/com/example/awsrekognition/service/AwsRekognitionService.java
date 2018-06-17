package com.example.awsrekognition.service;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.DetectModerationLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectModerationLabelsResult;
import com.amazonaws.services.rekognition.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;

@Service
public class AwsRekognitionService {

    private AmazonRekognition client;

    public AwsRekognitionService(AmazonRekognition client) {
        this.client = client;
    }

    public DetectModerationLabelsResult detectModerationLabels(MultipartFile imageToCheck) throws IOException {
        Image imageToUpload = new Image();
        imageToUpload.withBytes(ByteBuffer.wrap(imageToCheck.getBytes()));
        DetectModerationLabelsRequest request = new DetectModerationLabelsRequest();
        request.withImage(imageToUpload);

        return client.detectModerationLabels(request);
    }

}
