package com.automate.server.messaging.handlers;

import java.util.List;

import com.automate.models.Node;
import com.automate.protocol.Message;
import com.automate.protocol.client.ClientNodeListMessage;
import com.automate.protocol.server.ServerNodeListMessage;
import com.automate.protocol.server.ServerProtocolParameters;
import com.automate.server.database.IDatabaseManager;
import com.automate.server.messaging.IMessageHandler;
import com.automate.server.security.ISecurityManager;

public class NodeListMessageHandler implements
		IMessageHandler<ClientNodeListMessage, Void> {

	IDatabaseManager dbManager;
	ISecurityManager securityManager;
	
	@Override
	public Message<ServerProtocolParameters> handleMessage(
			ServerProtocolParameters responseParameters,
			ClientNodeListMessage message, Void params) {
		String username = securityManager.getUsername(message.getParameters().sessionKey);
		if(username == null) {
			return new ServerNodeListMessage(responseParameters, null);
		} else {
			List<Node> nodelist = dbManager.getClientNodeList(username);
			return new ServerNodeListMessage(responseParameters, nodelist);
		}
	}

}
