package com.student.admin.desire.webservice;


import com.student.admin.desire.datagetter.alllist;
import com.student.admin.desire.datagetter.listofnews;
import com.student.admin.desire.datagetter.loginresponse;
import com.student.admin.desire.datagetter.studentlist;
import com.student.admin.desire.datagetter.studymet;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface api {


//    webservice.php?Case=CommonLogin&user_name=sam@gmail.com&user_password=sam@1234


    @POST("webservice.php?Case=CommonLogin")
    Call<loginresponse> Login(
            @Query(value = "user_name", encoded = true) String name, @Query(value = "user_password", encoded = true) String password1 );



    @POST("webservice.php?Case=CommonLogin")
    Call<loginresponse> register(
            @Query("student_name") String name,@Query(value = "student_email", encoded = true) String email,
            @Query("student_phone") String phone, @Query(value = "student_gender", encoded = true) String gender,
            @Query("student_birthdate") String birth, @Query(value = "student_password", encoded = true) String password,
            @Query("student_course") String course, @Query(value = "student_std", encoded = true) String std,
            @Query("student_status") String status, @Query(value = "password_field", encoded = true) String field
    );

//  http://www.dneers.com/academyapp/webservice.php?Case=AllListAPIs

    @POST("webservice.php?Case=AllListAPIs")
    Call<alllist> alllist();


    // http://www.dneers.com/academyapp/webservice.php?Case=StudyMaterialList
    // http://www.dneers.com/academyapp/webservice.php?Case=Registration&
    // student_name=mani
    // student_email=muthu@gmail.com&
    // student_phone=7418397270&
    // student_gender=1&
    // student_birthdate=2019-21-18
    // &student_password=muthu@1234
    // &student_course=10
    // &student_std=12
    // &student_status=1
    // &password_field=nuYe2


    @POST("webservice.php?Case=StudyMaterialList")
    Call<studymet>studeymet(@Query("doctor_id") String nam);


    @POST("webservice.php?Case=NewsEventsList")
    Call<listofnews> noticeboard();

    @POST("webservice.php?Case=StudentList")
    Call<studentlist>studentlist();




//    @POST("webservice.php?Case=RecepTodayList")
//    Call<pending> PendingList2(@Query("doctor_id") String nam);

//    @POST("webservice.php?Case=ApproveList1")
//    Call<pending> PendingList1(@Query("doctor_id") String nam);

//    @POST("webservice.php?Case=WeekListing")
//    Call<pending> WeekListing(@Query("doctor_id") String nam);

//    @POST("webservice.php?Case=RecepWeekListing")
//    Call<pending> WeekListing1(@Query("doctor_id") String nam);

//    @POST("webservice.php?Case=BeforeConfirm")
//    Call<h> BeforeConfirm(@Query("patient_id") String nam);

//    @POST("webservice.php?Case=PatientPayment")
//    Call<pending> payment1(@Query("appoinment_id") String nam, @Query("amount") String nam1, @Query("paid_id") String namdfdsfsdf11);

//    @POST("webservice.php?Case=Daylist")
//    Call<pending> Daylist123(@Query("doctor_id") String nam, @Query("appoinment_date") String nam1);
//
//    @POST("webservice.php?Case=DateRangeList")
//    Call<pending> Daylist1234(@Query("doctor_id") String nam, @Query("start_date") String nam1, @Query("end_date") String nam11);
//
//    @POST("webservice.php?Case=BookingConfirm")
//    Call<pending> BookingConfirm(@Query("appoinment_id") String nam, @Query("status") String r);
//
//    @POST("webservice.php?Case=ConfirmPendingList")
//    Call<pending> appoint(@Query("doctor_id") String nam);
//
//    @POST("webservice.php?Case=PatientConfirm")
//    Call<h> shedule1(@Query("patient_id") String nam);
//
//    @POST("webservice.php?Case=ReceptionistTodayList")
//    Call<h> rese(@Query("reception_id") String nam);
//
//    @POST("webservice.php?Case=ReceptionistWeekListing")
//    Call<h> week(@Query("reception_id") String nam);
//
//    @POST("webservice.php?Case=ForgotPassword")
//    Call<h> forgetpassword(@Query(value = "doctor_email", encoded = true) String doctor_email);
//
//    @POST("webservice.php?Case=DoctorList")
//    Call<doctorlist> getdoctor();
//
//    @POST("webservice.php?Case=PatientList")
//    Call<listinpes> getdoctor1();
//
//    //  Case=PatientRegistration&patient_name=dfgg&patient_phone=dfgdfg&patient_password=fdg
//    @POST("webservice.php?Case=PatientRegistration")
//    Call<common> register(@Query(value = "patient_name", encoded = true) String name, @Query("patient_phone") String phone, @Query(value = "patient_password", encoded = true) String password, @Query(value = "patient_email", encoded = true) String password1);
//
//    @Multipart
//    @POST("webservice.php?Case=ReceptionistDoctorAvailability")
//    Call<common> avaliable1(@Query("patient_id") String name1, @Query("reception_id") String name, @Query("appoinment_chiefcomplaint") String password, @Query("appoinment_medicalhistory") String g, @Query("patient_phone") String f, @Query("patient_name") String id, @Query("appoinment_age") String age, @Query("appoinment_occupation") String occ, @Query("appoinment_address") String nane,
//                            @Query("appoinment_gender") String gen, @Query("appoinment_check") String gen1, @Part MultipartBody.Part file, @Part("name") RequestBody name12);
//
//
//
//    @POST("webservice.php?Case=ReceptionistDoctorAvailability")
//    Call<common> avaliable8(@Query("patient_id") String name1, @Query("reception_id") String name, @Query("appoinment_chiefcomplaint") String password, @Query("appoinment_medicalhistory") String g, @Query("patient_phone") String f, @Query("patient_name") String id, @Query("appoinment_age") String age, @Query("appoinment_occupation") String occ, @Query("appoinment_address") String nane,
//                            @Query("appoinment_gender") String gen, @Query("appoinment_check") String gen1);
//
//    @GET("webservice.php?Case=DoctorAvailability")
//    Call<common> avaliable(@Query("doctor_id") String name, @Query("appoinment_date") String password, @Query(value = "appoinment_slot", encoded = true) String g, @Query("patient_id") String f, @Query("Id") String id);
//
//    @GET("webservice.php?Case=DoctorAvailability")
//    Call<common> avaliable2(@Query("doctor_id") String name, @Query("appoinment_date") String password, @Query(value = "appoinment_slot", encoded = true) String g, @Query("patient_id") String f, @Query("Id") String id);
//
//    @POST("webservice.php?Case=DoctorMessage")
//    Call<chat> chat1(@Query("message_text") String nam, @Query("sender_id") String chat_id, @Query("receiver_id") String chat_id1);
//
//    @POST("webservice.php?Case=LocationList")
//    Call<location> location(@Query("doctor_id") String nam);
//
//    @POST("webservice.php?Case=DoctorMessageList")
//    Call<chat> chat(@Query("login_id") String nam, @Query("chat_id") String chat_id);
//
////    @Multipart
////    @POST("webservice.php?Case=DoctorImageUpload")
////    Call<common>uploadimage(@Part MultipartBody.Part file,@Part("name") RequestBody name);
//
//    @Multipart
//    @POST("webservice.php?Case=DoctorImageUpload")
//    Call<h>uploadImage(@Part MultipartBody.Part file, @Part("name") RequestBody name, @Query("receive_id") String g);
//
//    @Multipart
//    @POST("webservice.php?Case=DoctorImageUpload")
//    Call<h> uploadImage1(@Part MultipartBody.Part file, @Part("name") RequestBody name);
//
//    @POST("webservice.php?Case=ImageUploadList")
//    Call<imageurl>imagelist(@Query("receive_id") String nam);
//
//    @POST("webservice.php?Case=PatientsTreatmentPlan")
//    Call<list1>avaliable3(@Query("patient_id") String name, @Query("patient_calculus") String password,
//                          @Query(value = "patient_dcf", encoded = true) String g, @Query("patient_dcrct") String f,
//                          @Query("patient_mobility") String id, @Query(value = "patient_impaction", encoded = true) String g1, @Query("patient_misteeth") String f12,
//                          @Query(value = "patient_rootstump", encoded = true) String g123, @Query("patient_others") String f123, @Query("patient_trmtplan") String f1239);
//    @POST("webservice.php?Case=PatientsTreatmentDetails")
//         Call<imageurl>avaliable4(@Query("patient_id") String name, @Query("plan_id") String password,
//                                  @Query(value = "treatment_done", encoded = true) String g, @Query("treatment_advice") String f, @Query("tadvice_date") String f1);
//   @POST("webservice.php?Case=PatientsTreatmentDetailsList")
//    Call<listofdata>listof1(@Query("plan_id") String nam1, @Query("patient_id") String nam);
//
////    http://www.dneers.com/sakthidentalapp/webservice.php?Case=DoctorAmountPaid&appoinment_id=358&amount=890
//
//    @POST("webservice.php?Case=DoctorAmountPaid")
//    Call<listofdata>listof2(@Query("appoinment_id") String nam1, @Query("amount") String nam);
//
//    @POST("webservice.php?Case=DoctorAmountPaidStatus2")
//    Call<listofdata>listof3(@Query("appoinment_id") String nam1);
//
//    @POST("webservice.php?Case=TreatmentPopupList")
//    Call<poplist>poplist(@Query("appoinment_id") String nam1);


//    http://www.dneers.com/sakthidentalapp/webservice.php?Case=TreatmentPopupList&appoinment_id=356
//
// http://www.dneers.com/sakthidentalapp/webservice.php?Case=DoctorAmountPaidStatus2&appoinment_id=357

//    Case=PatientsTreatmentDetailsList&patient_id=2&plan_id=1

//    Case=PatientsTreatmentDetails&patient_id=2&plan_id=1&treatment_done=dfsdf&treatment_advice=

//    http://www.dneers.com/doctorapp/webservice.php?Case=ImageUploadList&receive_id=37

//    Call<UploadObject> uploadFile(@Part MultipartBody.Part file, @Part("name") RequestBody name)

//    uploadFile(@Part MultipartBody.Part file, @Part("name") RequestBody name);


}
