package com.dlsc.workbenchfx;

import static impl.org.controlsfx.ReflectionUtils.addUserAgentStylesheet;

import com.dlsc.workbenchfx.view.ContentPresenter;
import com.dlsc.workbenchfx.view.ContentView;
import com.dlsc.workbenchfx.view.HomePresenter;
import com.dlsc.workbenchfx.view.HomeView;
import com.dlsc.workbenchfx.view.ToolbarPresenter;
import com.dlsc.workbenchfx.view.ToolbarView;
import com.dlsc.workbenchfx.view.WorkbenchPresenter;
import com.dlsc.workbenchfx.view.WorkbenchView;
import javafx.application.Application;
import javafx.scene.control.SkinBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * TODO: javadoc
 *
 * @author François Martin
 * @author Marco Sanfratello
 */
public class WorkbenchSkin extends SkinBase<Workbench> {
  private static final Logger LOGGER =
      LogManager.getLogger(WorkbenchSkin.class.getName());

  // Views
  private ToolbarView toolbarView;
  private ToolbarPresenter toolbarPresenter;

  private HomeView homeView;
  private HomePresenter homePresenter;

  private ContentView contentView;
  private ContentPresenter contentPresenter;

  private WorkbenchView workbenchView;
  private WorkbenchPresenter workbenchPresenter;

  /**
   * TODO: javadoc
   *
   * @param workbench the {@link Workbench} for which this Skin is created
   */
  public WorkbenchSkin(Workbench workbench) {
    super(workbench);

    initViews(workbench);

    getChildren().add(workbenchView);
    Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    addUserAgentStylesheet(Workbench.class.getResource("css/main.css").toExternalForm());
  }

  private void initViews(Workbench model) {
    toolbarView = new ToolbarView();
    toolbarPresenter = new ToolbarPresenter(model, toolbarView);

    homeView = new HomeView();
    homePresenter = new HomePresenter(model, homeView);

    contentView = new ContentView();
    contentPresenter = new ContentPresenter(model, contentView);

    workbenchView = new WorkbenchView(toolbarView, homeView, contentView);
    workbenchPresenter = new WorkbenchPresenter(model, workbenchView);
  }
}
