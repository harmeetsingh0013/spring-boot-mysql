package in.internity.serviceapp.utility;

public class ResponseData<T> {
	
	public final T data;
	public final String message;
	public final String code;
	
	public ResponseData(final T data, final String message, final String code) {
		this.data = data;
		this.message = message;
		this.code = code;
	}

}
