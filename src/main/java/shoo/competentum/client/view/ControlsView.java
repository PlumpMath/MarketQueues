package shoo.competentum.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;

/*
public interface ControlsView<T>  {

  public interface Presenter<T> {
    void onLaunchButtonClicked();
  }
  int getNumSteps();
  void setPresenter(Presenter<T> presenter);
  Widget asWidget();
}
*/

public class ControlsView  extends Composite  {


	private final Button launchButton;


	public ControlsView() {
		DecoratorPanel contentDetailsDecorator = new DecoratorPanel();
	    contentDetailsDecorator.setWidth("18em");
	    initWidget(contentDetailsDecorator);

	    VerticalPanel contentDetailsPanel = new VerticalPanel();
	    contentDetailsPanel.setWidth("100%");



	    HorizontalPanel menuPanel = new HorizontalPanel();
	    launchButton = new Button("Launch");
	    menuPanel.add(launchButton);
	    contentDetailsPanel.add(menuPanel);
	    contentDetailsDecorator.add(contentDetailsPanel);
	}

	public HasClickHandlers getLaunchButton() {
		return launchButton;
	}

	public int getNumSteps(){
	  return 5;
  };

  public Widget asWidget() {
	  return this;
  };
}
