package chapter7;

public class Book {
	private String bookName;
	private String author;
	
	public Book() {};
	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void showBookInfo() {
		// sysout + Ctrl + Space => main이 선언 되었을 때만 작동
		System.out.println(bookName + ", " + author);
		
	}
	
}
