package welldev.io;

public final class Constants {
	public static final String checkIfUser = "from User where userName =: userName and password =:password";
	public static final String getAllProduct = "from Product";
	public static final String updateProductById = "UPDATE Product SET name =:name, quantity =:quantity, price =:price where id =:id";
	public static final String deleteProductById = "DELETE from Product where id =:id";
	public static final String updatePassword = "Update User SET password =:password where id =:id";
	
	public static final String insertuseruri = "/insertuser";
}
