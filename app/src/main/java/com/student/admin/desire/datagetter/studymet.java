package com.student.admin.desire.datagetter;

public class studymet {

    private Response Response;

    private StudyMaterial[] StudyMaterial;

    public Response getResponse ()
    {
        return Response;
    }

    public void setResponse (Response Response)
    {
        this.Response = Response;
    }

    public StudyMaterial[] getStudyMaterial ()
    {
        return StudyMaterial;
    }

    public void setStudyMaterial (StudyMaterial[] StudyMaterial)
    {
        this.StudyMaterial = StudyMaterial;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Response = "+Response+", StudyMaterial = "+StudyMaterial+"]";
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

    public class StudyMaterial
    {
        private String subject_id;

        private String board_id;

        private String pdf_name;

        private String class_id;

        private String Id;

        public String getSubject_id ()
        {
            return subject_id;
        }

        public void setSubject_id (String subject_id)
        {
            this.subject_id = subject_id;
        }

        public String getBoard_id ()
        {
            return board_id;
        }

        public void setBoard_id (String board_id)
        {
            this.board_id = board_id;
        }

        public String getPdf_name ()
        {
            return pdf_name;
        }

        public void setPdf_name (String pdf_name)
        {
            this.pdf_name = pdf_name;
        }

        public String getClass_id ()
        {
            return class_id;
        }

        public void setClass_id (String class_id)
        {
            this.class_id = class_id;
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
            return "ClassPojo [subject_id = "+subject_id+", board_id = "+board_id+", pdf_name = "+pdf_name+", class_id = "+class_id+", Id = "+Id+"]";
        }
    }

}
