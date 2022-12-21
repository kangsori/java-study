package chapter03;

public class Song {
	
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int track ;
	private int year ;

	public Song(String title,String artist) {
		
		//다른생성자 부를때는 맨 앞에서 선언
		this(title,artist,"","",0,0);
		
		System.out.println("some code6");
		
	}
	
	public Song(String title,String artist,String album,String composer,int track, int year) {
		this.title=title;
		this.artist=artist;
		this.album=album;
		this.composer=composer;
		this.track=track;
		this.year=year;
		
		System.out.println("some code1");
		System.out.println("some code2");
		System.out.println("some code3");
		System.out.println("some code4");
		System.out.println("some code5");
	}
	
	public void show() {
		System.out.println(artist +" "+ title + " " + "("+album +", "+ year +", "+ track +"번 트랙, "+ composer +" 작곡)");
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}


}
