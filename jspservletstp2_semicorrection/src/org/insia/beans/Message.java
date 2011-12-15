package org.insia.beans;

public class Message {
	private String content;
	private MessageType type;
	
	public enum MessageType {INFO, ERROR, WARNING};
	
	public Message() {
		
	}
	
	public Message(String content) {
		this(content, MessageType.ERROR);
	}
	
	public Message(String content, String type) {
		this(content, MessageType.valueOf(type));
	}
	
	public Message(String content, MessageType type) {
		this.content = content;
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
	
	public void setType(String type) {
		this.type = MessageType.valueOf(type);
	}
}
