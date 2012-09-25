package com.xys.cenxi.customer.test;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TestGridDesigner {

	  protected Shell shell;

	  public static void main(String[] paramArrayOfString)
	  {/*
	    try
	    {
	      DesignerDemo localDesignerDemo = new DesignerDemo();
	      localDesignerDemo.open();
	    } catch (Exception localException) {
	      localException.printStackTrace();
	    }
	  */}

	  public void open()
	  {
	    Display localDisplay = Display.getDefault();
	    createContents();
	    this.shell.open();
	    this.shell.layout();
	    while (!this.shell.isDisposed())
	      if (!localDisplay.readAndDispatch())
	        localDisplay.sleep();
	  }

	  protected void createContents()
	  {
	    this.shell = new Shell();
	    this.shell.setLayout(new FillLayout());
	    this.shell.setSize(500, 375);
	    this.shell.setText("SWT Application");

	    Composite localComposite = new Composite(this.shell, 0);
	    localComposite.setLayout(new FillLayout());
//	    GridDesigner localGridDesigner = new GridDesigner(localComposite, 0);
	  }
}
