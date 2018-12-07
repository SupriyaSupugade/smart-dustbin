package com.techfirebase.android.smartdustbin.rest;

import com.techfirebase.android.smartdustbin.domain.Area;
import com.techfirebase.android.smartdustbin.domain.AreaWorker;
import com.techfirebase.android.smartdustbin.domain.DustbinDetail;
import com.techfirebase.android.smartdustbin.domain.Supervisor;
import com.techfirebase.android.smartdustbin.domain.Worker;
import com.techfirebase.android.smartdustbin.util.DustbinResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

  @POST("/supervisor") // saving supervisor object
  Call<Supervisor> saveSupervisor(@Body Supervisor supervisor);

  @POST("/worker")
  Call<Worker> saveWorker(@Body Worker worker);

  @GET("/supervisor/{mobileNo}") // getting supervisor by id
  Call<Supervisor> getSupervisorById(@Path("mobileNo") String mobile_no);

  @GET("/supervisor")
  Call<List<Supervisor>> getSupervisors();

  @GET("/area")
  Call<List<Area>> getAreaWorker();

  @GET("/area/dustbin-status")
  Call<Map<String, DustbinResponse>> getDustbinStatus();

  @GET("/area/dustbin-list/{dustbinType}")
  Call<List<DustbinResponse>> getDustbinList(@Path("dustbinType") String dustbinType);

  @GET("/worker/{mobileNo}") // getting supervisor by id
  Call<Worker> getWorkerById(@Path("mobileNo") String mobile_no);

  @POST("/areaworker") // saving areaworker object
  Call<AreaWorker> saveAreaWorker(@Body AreaWorker areaWorker);

  @POST("/dustbinDetail") // saving dustbinDetail object
  Call<DustbinDetail> saveDustbinDetail(@Body DustbinDetail dustbinDetail);

  @GET("/worker")
  Call<List<Worker>> getAllWorkers();



}
