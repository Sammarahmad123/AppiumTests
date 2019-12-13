package ApiClasses;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ApiClasses.TestData.testData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public  class ApiHelper {
	
	ObjectMapper ow = new ObjectMapper();
	String ApiBaseUrl="https://e-label.humanfocus.org.uk/CBT_APITest/api/cbt";
	///GetOrganUserDetails/870799/20802
	ToolKitModel toolKit=new ToolKitModel();
	ToolKitModel publishToolKit=new ToolKitModel();
	TrainingModel trainingModel=new TrainingModel();
	InsertModuleModel moduleModel=new InsertModuleModel();
	CloneContentItemModel contentModel=new CloneContentItemModel();
	
	
	
	static String toolKitId;
	static String toolKitName;
	static int training_code;
	static int videoContentCode=3329;
	static int documentContentCode=3317;
	
	static int titleTypeQuestionCode=3321;

	static int inputTypeQuestionCode=3320;
	static int multipleTypeQuestionCode=3319;
	static int singleSelectionTypeQuestionCode=3318;
	
	
	
	
	public String  CreateToolKitAPIRequest() throws JsonProcessingException
	{
		
		toolKit.setAccessedPoint("create-content");
		toolKit.setContentTypeID(2);
		toolKit.setContentTypeTitle("e-Learning");
		toolKit.setGroupID("");
		toolKit.setIsPublish(false);
		toolKit.setOrganID(testData.OrganID);
		toolKit.setTID(0);
		toolKit.setToolkitDescription("Auto generated toolkit");
		toolKit.setToolkitID(0);
		toolKit.setToolkitName(testData.ToolkitName);
		toolKit.setToolkitURL("IMG__T755435.jpg");
		toolKit.setUserID(testData.UserID);
		toolKit.setUserName(testData.UserName);
		
		
		
		toolKitName=toolKit.getToolkitName();
		String Json=ow.writeValueAsString(toolKit);
		RestAssured.baseURI=ApiBaseUrl;
		Response response=null;
		response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(Json)
				.post("/InsertToolkit");
		
		String responseToString=response.asString();
		
		JSONObject obj = new JSONObject(responseToString);
		
		toolKitId= obj.get("ToolkitID").toString();
		
		System.out.println(toolKitId);
		
		return toolKit.getToolkitName();
	}
	
	public void publishToolKit() throws JsonProcessingException
	{
		
		publishToolKit.setContentTypeID(1);
		publishToolKit.setContentTypeTitle("e-Learning");
		publishToolKit.setGroupID("");
		publishToolKit.setIsPublish(true);
		//publishToolKit.setToolkitName(toolKitName);
		publishToolKit.setOrganID(20478);
		publishToolKit.setToolkitID(Integer.parseInt(toolKitId));
		publishToolKit.setTID(0);
		publishToolKit.setUserID(testData.UserID);
		publishToolKit.setUserName(testData.UserName);
		publishToolKit.setAccessedPoint("create-content");
		
		String Json=ow.writeValueAsString(publishToolKit);
		RestAssured.baseURI=ApiBaseUrl;
		Response response=null;
		response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(Json)
				.post("/UpdateToolkit");
		
		String responseToString=response.asString();
		
		System.out.println(responseToString);
		
		
		
	}
	

	public void  CreateTrainingAPIRequest() throws JsonProcessingException
	{
		trainingModel.setAccessedPoint("create-content");
		trainingModel.setDependency("");
		trainingModel.setContentType("Normal");
		trainingModel.setFail("<p>Failed</p>");
		trainingModel.setIsActive(true);
		trainingModel.setIsMandatory(true);
		trainingModel.setIsPublic(true);
		trainingModel.setIsShowResult(true);
		trainingModel.setNoOfAttempts(2);
		trainingModel.setOrganID(testData.OrganID);
		trainingModel.setPass("<p>Passed</p>");
		trainingModel.setScoreType("Test Assessment");
		trainingModel.setScoringCriteria(80);
		trainingModel.setTID(0);
		trainingModel.setToolkitID(toolKitId);
		trainingModel.setTopTrainingCode(null);
		trainingModel.setTrainingCode(testData.TrainingCode);
		//System.out.println("This is my training code:"+training_code);
		trainingModel.setTrainingTitle(testData.TrainingName);
		trainingModel.setUserID(testData.UserID);
		trainingModel.setUserName(testData.UserName);
		trainingModel.setValidDuration(0);
		
		String Json=ow.writeValueAsString(trainingModel);
		//System.out.println(Json);
		RestAssured.baseURI=ApiBaseUrl;
		Response response=null;
		response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(Json)
				.post("/InsertTraining");
		
		String responseToString=response.asString();
		System.out.println(responseToString);

	}
	public void InsertModuleAPIReqeust(String p_SSectiontName,int p_IModuleNumber,int p_iModuleOrderNumber) throws JsonProcessingException
	{
		moduleModel.setAccessedPoint("create-content");
		moduleModel.setUserID(testData.UserID);
		moduleModel.setOrganID(testData.OrganID);
		moduleModel.setUserName(testData.UserName);
		moduleModel.setContentID(testData.TrainingCode);
		moduleModel.setIsActive(true);
		moduleModel.setIsFeedbackRequired(false);
		moduleModel.setIsInternalURL(false);
		moduleModel.setIsRequired(true);
		moduleModel.setIsSample(false);
		moduleModel.setIsTitleVisible(true);
		moduleModel.setModuleCallOrder(p_iModuleOrderNumber);
		moduleModel.setModuleID(0);
		moduleModel.setModuleNumber(p_IModuleNumber);
		moduleModel.setMovieURL("");
		moduleModel.setPassPercentage(0);
		moduleModel.setPassWeight(0);
		moduleModel.setRemarks("");
		moduleModel.setTotalWeight(0);
		moduleModel.setTID(0);
		moduleModel.setModuleTitle(p_SSectiontName);
		
		String Json=ow.writeValueAsString(moduleModel);
		
		RestAssured.baseURI=ApiBaseUrl;
		Response response=null;
		response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(Json)
				.post("/InsertModule");
		
		String responseToString=response.asString();
		System.out.println(responseToString);
		
	}
	
	
	
	public void getContentBuilderOverViewModelAPiCall() throws JsonProcessingException
	 {
		// String ApiBaseUrl="https://e-label.humanfocus.org.uk/CBT_APIStg/api/cbt";
		 int [] moduleIDs=new int[3];
		 
		 RestAssured.baseURI=ApiBaseUrl;
			Response response=null;
			response = RestAssured.given()
					.when()
					.get("/GetContentBuilderOverview/"+20478+"/"+testData.TrainingCode);
			String responseToString=response.asString();
			System.out.println(responseToString);
			
			JSONObject obj = new JSONObject(responseToString);

			JSONArray jsonarr= obj.getJSONArray("GetContentBuilderOverview");
			
			for(int i=0;i<3;i++)
			{
				moduleIDs[i]=jsonarr.getJSONObject(i).getInt("ModuleID");
				System.out.println(moduleIDs[i]);
			}
			
			insertContentToSection(moduleIDs[0],videoContentCode);
			insertContentToSection(moduleIDs[1],documentContentCode);
			insertContentToSection(moduleIDs[2],multipleTypeQuestionCode);
			insertContentToSection(moduleIDs[2],multipleTypeQuestionCode);
			insertContentToSection(moduleIDs[2],singleSelectionTypeQuestionCode);
			
			
			
			
	 }
	
	public void insertContentToSection(int p_imoduleID,int p_iContentTypeCode) throws JsonProcessingException
	{
		
		contentModel.setAccessedPoint("create-content");
		contentModel.setModuleID(p_imoduleID);
		contentModel.setModuleItemID(p_iContentTypeCode);
		contentModel.setOrganID(testData.OrganID);
		contentModel.setPreviousModuleItemId(0);
		contentModel.setTID(0);
		contentModel.setUserID(testData.UserID);
		contentModel.setUserName(testData.UserName);
		
		String Json=ow.writeValueAsString(contentModel);
				
		RestAssured.baseURI=ApiBaseUrl;
		Response response=null;
		response = RestAssured.given()
					.contentType(ContentType.JSON)
					.body(Json)
					.post("/CloneContentItem");
				
		String responseToString=response.asString();
		System.out.println(responseToString);
		
	}
	
	
	
	

}
