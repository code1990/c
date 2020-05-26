package superCRM.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import superCRM.SuperCRMPlugin;
import superCRM.preferences.PreferenceConstants;
import superCRM.util.LayoutUtil;

/** ��¼�Ի��� */
public class LoginDialog extends TitleAreaDialog {

	/** �û��� */
	private Text userName;

	/** ���� */
	private Text password;

	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}

	/** ���õ�¼�Ի�������� */

    protected Control createDialogArea(Composite parent) {
    	System.out.println("createDialogArea");
		 Composite area = (Composite)super.createDialogArea(parent);
	     Composite composite = new Composite(area,SWT.NONE);
	     
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		new Label(composite, SWT.NONE).setText("�û�����");
		userName = new Text(composite, SWT.BORDER);
		userName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		new Label(composite, SWT.NONE).setText("���룺");
		password = new Text(composite, SWT.BORDER);
		password.setEchoChar('*');
		password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	
		return area;
    }


    protected Point getInitialSize() {
        return new Point(500, 375);
    }
    /** ���õ�¼�Ի������������ */
	protected Control createContents(Composite parent) {
		System.out.println("createContents");
		super.createContents(parent);
		this.setTitle("�û���¼");
		this.setMessage("�������û����������¼ϵͳ");
	
		return parent;
	}
	
 
    protected void configureShell(Shell newShell) {
    	/**
    	 * ��䲻�ӣ�ҳ����ʾ������
    	 */
        super.configureShell(newShell);

        // Dialog Title
       
        System.out.println("configureShell");
		newShell.setText("�û���¼");
		newShell.setSize(300, 200);
		newShell.setImage(SuperCRMPlugin.getImageDescriptor("icons/logo.gif").createImage());
		LayoutUtil.centerShell(Display.getCurrent(), newShell);
        // Dialog Icon
    }

    /** ���Ǹ���ķ���,��������ťʱ���� */
	protected void buttonPressed(int buttonId) {
		/** ���������ȷ����ť */
		if (IDialogConstants.OK_ID == buttonId) {
			/** �û�����Ϊ�� */
			if (userName.getText().equals("")) {
				this.setErrorMessage("�û�����Ϊ��");
				return;
			}
			/** ���벻Ϊ�� */
			if (password.getText().equals("")) {
				this.setErrorMessage("���벻Ϊ�գ�");
				return;
			}
			/**��֤�û�������*/
			boolean bValid = checkValid();
			if (!bValid) {
				this.setErrorMessage("�û������������");
				return;
			}
			super.okPressed();
		} else if (IDialogConstants.CANCEL_ID == buttonId)
			super.cancelPressed();
	}

	/** �ж���֤�û��������� */
	private boolean checkValid() {
		boolean bValid = false;
		/**���û������û�������ѡ�������õ��û���������Ա�,�����ȷ,����֤�ɹ�*/
		IPreferenceStore store = SuperCRMPlugin.getDefault().getPreferenceStore();
		if (userName.getText().equals(store.getString(PreferenceConstants.P_USER_NAME)) && password.getText().equals(store.getString(PreferenceConstants.P_USER_NAME)))
			bValid = true;
		return bValid;
	}
}
