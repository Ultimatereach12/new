package com.student.admin.desire.datagetter;

public class studentlist {
    private Response Response;

    private StudentList[] StudentList;

    public Response getResponse ()
    {
        return Response;
    }

    public void setResponse (Response Response)
    {
        this.Response = Response;
    }

    public StudentList[] getStudentList ()
    {
        return StudentList;
    }

    public void setStudentList (StudentList[] StudentList)
    {
        this.StudentList = StudentList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Response = "+Response+", StudentList = "+StudentList+"]";
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

    public class StudentList
    {
        private String student_birthdate;

        private String student_name;

        private String student_gender;

        private String student_phone;

        private String Id;

        private boolean select_option;

        private String student_email;

        private String student_course;

        public String getStudent_birthdate ()
        {
            return student_birthdate;
        }

        public void setStudent_birthdate (String student_birthdate)
        {
            this.student_birthdate = student_birthdate;
        }

        public String getStudent_name ()
        {
            return student_name;
        }

        public void setStudent_name (String student_name)
        {
            this.student_name = student_name;
        }

        public String getStudent_gender ()
        {
            return student_gender;
        }

        public void setStudent_gender (String student_gender)
        {
            this.student_gender = student_gender;
        }

        public String getStudent_phone ()
        {
            return student_phone;
        }

        public void setStudent_phone (String student_phone)
        {
            this.student_phone = student_phone;
        }

        public String getId ()
        {
            return Id;
        }

        public void setId (String Id)
        {
            this.Id = Id;
        }

        public String getStudent_email ()
        {
            return student_email;
        }

        public void setStudent_email (String student_email)
        {
            this.student_email = student_email;
        }

        public String getStudent_course ()
        {
            return student_course;
        }

        public void setStudent_course (String student_course)
        {
            this.student_course = student_course;
        }

        public boolean isSelected() {
            return select_option;
        }

        public void setSelected(boolean selected) {
            select_option = selected;
        }
    }


}
