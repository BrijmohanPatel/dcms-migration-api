package com.lacheln.dcms.constants;

public class CommonConstants {
	
	// 2xx Success
    public static final String STATUSCODE_200 = "200"; // OK - The request was successful.

    // 4xx Client Error
    public static final String STATUSCODE_400 = "400"; // Bad Request - The server could not understand the request.
    public static final String STATUSCODE_401 = "401"; // Unauthorized - The request requires user authentication.
    public static final String STATUSCODE_403 = "403"; // Forbidden - The server understood the request but refuses to authorize it.
    public static final String STATUSCODE_404 = "404"; // Not Found - The requested resource could not be found.
    public static final String STATUSCODE_409 = "409"; // Conflict - The request could not be completed due to a conflict with the current state of the target resource.
    
    // 5xx Server Error
    public static final String STATUSCODE_500 = "500"; // Internal Server Error - A generic error message returned when an unexpected condition was encountered.

    // Additional Status Codes
    public static final String STATUSCODE_502 = "502"; // Bad Gateway - The server, acting as a gateway or proxy, received an invalid response from an inbound server.
    public static final String STATUSCODE_503 = "503"; // Service Unavailable - The server is not ready to handle the request.

    // Additional Client Error
    public static final String STATUSCODE_410 = "410"; // Gone - Indicates that the resource requested is no longer available and will not be available again.

    // Additional Server Error
    public static final String STATUSCODE_504 = "504"; // Gateway Timeout - The server, while acting as a gateway or proxy, did not receive a timely response from an upstream server.

	
	
    public static final String SUCCESS = "success"; // Indicating a successful operation.
    public static final String FAILED = "failed";   // Indicating that the operation failed for some reason.
    public static final String ERROR = "error";     // Indicating an error occurred during the operation.
    public static final String ACTION = "";          // An empty string, as the meaning of "ACTION" is not clear from the provided context.

	
	
	/*public static final String MESSAGE 					= "Kindly check";
	public static final String INSERT 					= "insert";
	public static final String UPDATE 					= "update";
	public static final String DELETE 					= "delete";
	public static final String LOCATION 				= "location";
	public static final String DHFL 					= "dhfl";
	public static final String DESIGNATION 				= "designation";
	public static final String LOCDEPT 					= "locdept";
	public static final String DESGDEPT 				= "deptdesg";
	public static final String SELECT 					= "select";
	public static final String SELECTUNIQUE 			= "unique";
	public static final String USER 					= "user";
	public static final String USERREG 					= "userReg";
	public static final String EMPTY 					= "";
	public static final int ZERO 						= 0;*/
    
	public static final String DATAINSERTED 			= "Data Saved Successfully";
	public static final String DATAUPDATED  			= "Data Updated Successfully";
	public static final String DATADELETED  			= "Data Deleted Successfully";
	
	


}
