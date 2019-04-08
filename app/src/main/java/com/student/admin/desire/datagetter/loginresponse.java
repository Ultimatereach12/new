package com.student.admin.desire.datagetter;

public class loginresponse {
    private Response Response;

    private LoginDetails[] LoginDetails;

    public Response getResponse ()
    {
        return Response;
    }

    public void setResponse (Response Response)
    {
        this.Response = Response;
    }

    public LoginDetails[] getLoginDetails ()
    {
        return LoginDetails;
    }

    public void setLoginDetails (LoginDetails[] LoginDetails)
    {
        this.LoginDetails = LoginDetails;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Response = "+Response+", LoginDetails = "+LoginDetails+"]";
    }

    public class Response
    {
        private String response_code;

        private String response_message;

        public String getResponse_code ()
        {
            return response_code;
        }

        public void setResponse_code (String response_code)
        {
            this.response_code = response_code;
        }

        public String getResponse_message ()
        {
            return response_message;
        }

        public void setResponse_message (String response_message)
        {
            this.response_message = response_message;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [response_code = "+response_code+", response_message = "+response_message+"]";
        }
    }

    public class LoginDetails
    {
        private String student_name;

        private String login_type;

        private String Id;

        public String getStudent_name ()
        {
            return student_name;
        }

        public void setStudent_name (String student_name)
        {
            this.student_name = student_name;
        }

        public String getLogin_type ()
        {
            return login_type;
        }

        public void setLogin_type (String login_type)
        {
            this.login_type = login_type;
        }

        public String getId ()
        {
            return Id;
        }

        public void setId (String Id)
        {
            this.Id = Id;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [student_name = "+student_name+", login_type = "+login_type+", Id = "+Id+"]";
        }
    }


}
