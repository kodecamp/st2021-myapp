package in.kodecamp.commons;

import java.text.MessageFormat;

/**
 * <p>
 * This class is just a wrapper class for service layer.
 * </p>
 */
public final class ServiceResponse {

  private Object resultObj;
  private Status status;

  // private constructor
  private ServiceResponse(Object obj, Status status) {
    this.resultObj = obj;
    this.status = status;
  }


  /**
   * <p>
   * This method sets the status as <tt>SUCCESS</tt> with the result object.
   * </p>
   * @param obj
   * @return <tt>ServiceResponse</tt> with status <tt>SUCCESS</tt>
   */
  public static ServiceResponse withSuccess(Object obj) {
    return new ServiceResponse(obj, Status.SUCCESS);
  }

  public static ServiceResponse withFailure(String errorMessage) {
    return new ServiceResponse(errorMessage, Status.FAILURE);
  }

  public static ServiceResponse withFailure(String parameterizedMsg, String ...params) {
    String formattedMsg = MessageFormat.format(parameterizedMsg, (Object[])params);
    return new ServiceResponse(formattedMsg, Status.FAILURE);
  }

  private static enum Status {
    SUCCESS, FAILURE
  }

  public Object resultObj() {
    return this.resultObj;
  }

  public boolean isFailure() {
    return Status.FAILURE.equals(this.status);
  }

  public boolean isSuccess() {
    return Status.SUCCESS.equals(this.status);
  }


}
