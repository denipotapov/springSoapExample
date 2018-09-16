package com.personal.info.controller;

import com.personal.info.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import personal.com.schema.GetPersonalInfoRequest;
import personal.com.schema.GetPersonalInfoResponse;

@Endpoint
public class PersonalInfoEndpoint {

    private static final String NAMESPACE_URI = "http://com.personal/schema";

    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    public PersonalInfoEndpoint(PersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonalInfoRequest")
    @ResponsePayload
    public GetPersonalInfoResponse getPersonalInfo(@RequestPayload GetPersonalInfoRequest request) {
        GetPersonalInfoResponse response = new GetPersonalInfoResponse();
        response.setPersonalInfo(personalInfoRepository.findApplicant(request.getName()));

        return response;
    }
}
