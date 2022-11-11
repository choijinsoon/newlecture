package jdbc.util;

public class JDBCTemlateException extends RuntimeException {
	private String message;
	public JDBCTemlateException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
