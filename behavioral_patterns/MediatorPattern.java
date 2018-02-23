package behavioral_patterns;

class ChatRoom {
	public void showMessage(User user, String message) {
		System.out.println(String.format("%s:\n%s", user, message));
	}
}

class User {
	String name;
	ChatRoom chatRoom;

	public User(String name, ChatRoom chatRoom) {
		this.name = name;
		this.chatRoom = chatRoom;
	}

	public void speak(String message) {
		chatRoom.showMessage(this, message);
	}

	@Override
	public String toString() {
		return name;
	}
}

public class MediatorPattern {

	public static void main(String[] args) {
		ChatRoom cr = new ChatRoom();
		User user1 = new User("zhanghui", cr);
		User user2 = new User("saiya", cr);
		user1.speak("Hi!");
		user2.speak("Hi too!");

	}

}
