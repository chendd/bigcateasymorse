/**
 * 
 */
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author dahui <a href="mailto:jiessiedyh@gmail.com">jiessiedyh@gmail.com</a> 
 *
 */
public class LoginDialogBox extends Composite {

	private static LoginDialogBoxUiBinder uiBinder = GWT
			.create(LoginDialogBoxUiBinder.class);

	interface LoginDialogBoxUiBinder extends UiBinder<Widget, LoginDialogBox> {
	}

	@UiField
	DialogBox loginDialgoBox;

	public LoginDialogBox() {
		initWidget(uiBinder.createAndBindUi(this));
		userName = new TextBox();
		password = new PasswordTextBox();
		saveCheckBox=new CheckBox();
		userName.setFocus(true);
	//	this.setText("登录");
		loginDialgoBox = new DialogBox();
		loginDialgoBox.setText("登录");
		loginDialgoBox.setWidget(this.getDialogWidget());
		
		loginDialgoBox.ensureDebugId("cwDialogBox");
		loginDialgoBox.setGlassEnabled(true);
		loginDialgoBox.setAnimationEnabled(true);
		loginDialgoBox.center();
		loginDialgoBox.show();
		
		
	}

	private TextBox userName;

	private PasswordTextBox password;

	private Button loginButton;

	private Label message=new Label();
	
	private CheckBox saveCheckBox;
	
	public CheckBox getSaveCheckBox() {
		return saveCheckBox;
	}

	
	public TextBox getUserName() {
		return userName;
	}

	public PasswordTextBox getPassword() {
		return password;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setMessage(String message) {
		this.message.setText(message);
	}

	private Widget getDialogWidget() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(4);
		//panel.setWidth("15em");

		if (message != null) {
			
			panel.add(message);
		}

		FlexTable table = new FlexTable();
		panel.add(table);

		table.setWidget(0, 0, new Label("用户名"));
		table.setWidget(0, 1, this.userName);
		table.setWidget(1, 0, new Label("密码"));
		table.setWidget(1, 1, this.password);
		table.setWidget(2, 1, new Label("是否保存登录信息"));
		table.setWidget(2, 0, this.saveCheckBox);

		HorizontalPanel buttonPanel = new HorizontalPanel();
		panel.add(buttonPanel);

		loginButton = new Button("登录");
		panel.add(loginButton);

		return panel;
	}


	public DialogBox getLoginDialgoBox() {
		return loginDialgoBox;
	}

	
}
