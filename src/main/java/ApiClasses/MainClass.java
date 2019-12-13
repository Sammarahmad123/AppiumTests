package ApiClasses;


import com.fasterxml.jackson.core.JsonProcessingException;

public class MainClass {
	
	public static void main(String[] args) throws JsonProcessingException
	{
		ApiHelper api=new ApiHelper();
		api.CreateToolKitAPIRequest();
		api.CreateTrainingAPIRequest();
		api.InsertModuleAPIReqeust("Document",1,2);
		api.InsertModuleAPIReqeust("Questions",2,3);
		api.getContentBuilderOverViewModelAPiCall();
		api.publishToolKit();
		
	}
	
	
	

}
