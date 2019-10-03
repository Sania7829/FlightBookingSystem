package flightBooking;

public class RegisterCust {
private int  Reg_id;
private String u_name,Password,Email_id,RepeatPassword;
public String getRepeatPassword() {
	return RepeatPassword;
}
public void setRepeatPassword(String repeatPassword) {
	RepeatPassword = repeatPassword;
}
public int getReg_id() {
	return Reg_id;
}
public void setReg_id(int reg_id) {
	Reg_id = reg_id;
}
public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmail_id() {
	return Email_id;
}
public void setEmail_id(String email_id) {
	Email_id = email_id;
}


}
