/**
 * MyTitleAreaDialog.java
 * 版权所有(C) 2010 深圳市银之杰科技股份有限公司
 * 创建:崔冉  2010-2-1 上午11:05:05
 */
package superCRM.dialog;

import org.eclipse.core.internal.content.Activator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import superCRM.SuperCRMPlugin;

/**
 * @author 崔冉
 *
 */
public class MyTitleAreaDialog extends TitleAreaDialog {

	public MyTitleAreaDialog(Shell parentShell) {
		super(parentShell);
		
	}
	/*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        // TitleArea中的Title
        setTitle("My TitleAreaDialog");

        // TitleArea中的Message
        setMessage("This is a simple TitleAreaDialog example.");

        // TitleArea中的Image
        setTitleImage(SuperCRMPlugin.getImageDescriptor("icons/sample.gif").createImage());

        return area;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
     */
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
     */
    protected Point getInitialSize() {
        return new Point(500, 375);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        // Dialog Title
        newShell.setText("Test TitleAreaDialog Title");

        // Dialog Icon
        newShell.setImage(SuperCRMPlugin.getImageDescriptor("icons/sample.gif").createImage());
    }

    protected void okPressed() {
        // implement your own function here
        super.okPressed();
    }
}
