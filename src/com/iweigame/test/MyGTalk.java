package com.iweigame.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Registration;

public class MyGTalk {

	private static String newRandomUUID() {
		String uuidRaw = UUID.randomUUID().toString();
		return uuidRaw.replaceAll("-", "");
	}

	public static void main(String[] args) throws Exception {
		final String username = newRandomUUID();
		String password = newRandomUUID();
		ConnectionConfiguration config = new ConnectionConfiguration(
				"192.168.1.133", 5222);
		config.setSecurityMode(SecurityMode.required);
		config.setSASLAuthenticationEnabled(false);
		config.setCompressionEnabled(false);
		XMPPConnection connection = new XMPPConnection(config);
		connection.connect();
		// connection.login(username,password,"AndroidpnClient");

		Registration registration = new Registration();

		// packet filter
		PacketFilter packetFilter = new PacketTypeFilter(IQ.class);
		// packet listener

		registration.setType(IQ.Type.SET);
		Map userMessageMap = new HashMap<String, String>();
		userMessageMap.put("username", username);
		userMessageMap.put("password", password);
		registration.setAttributes(userMessageMap);
		connection.sendPacket(registration);

		connection.login(username, password, "AndroidpnClient");

		connection.addPacketListener(new PacketListener() {

			@Override
			public void processPacket(Packet arg0) {
				// TODO Auto-generated method stub

			}
		}, packetFilter);
		// XMPPConnection.DEBUG_ENABLED = true;
		// XMPPConnection connection = new XMPPConnection("gmail.com");
		// connection.connect();
		// connection.login("jiessiedyh@gmail.com", "19860518");
		//
		// Chat chat =
		// connection.getChatManager().createChat("gebaocai@gmail.com", new
		// MessageListener() {
		// public void processMessage(Chat chat, Message message) {
		// System.out.println(message.getFrom() + " " + new
		// java.util.Date().toLocaleString() + "说:" + message.getBody());
		// }
		// });
		// BufferedReader cmdIn = new BufferedReader(new
		// InputStreamReader(System.in));
		// for(;;) {
		// try {
		// String cmd = cmdIn.readLine();
		// if("!q".equalsIgnoreCase(cmd)) {
		// break;
		// }
		// chat.sendMessage(cmd);
		// }catch(Exception ex) {
		// }
		// }
		// connection.disconnect();
		// System.exit(0);
	}

}
