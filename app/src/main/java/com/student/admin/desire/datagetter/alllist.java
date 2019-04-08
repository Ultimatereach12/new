package com.student.admin.desire.datagetter;

public class alllist {

    private Response Response;

    private Grade[] Grade;

    public Response getResponse ()
    {
        return Response;
    }

    public void setResponse (Response Response)
    {
        this.Response = Response;
    }

    public Grade[] getGrade ()
    {
        return Grade;
    }

    public void setGrade (Grade[] Grade)
    {
        this.Grade = Grade;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Response = "+Response+", Grade = "+Grade+"]";
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


    public class Sub_list
    {
        private String subject_name;

        private String id_class;

        private String Id;

        public String getSubject_name ()
        {
            return subject_name;
        }

        public void setSubject_name (String subject_name)
        {
            this.subject_name = subject_name;
        }

        public String getId_class ()
        {
            return id_class;
        }

        public void setId_class (String id_class)
        {
            this.id_class = id_class;
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
            return "ClassPojo [subject_name = "+subject_name+", id_class = "+id_class+", Id = "+Id+"]";
        }
    }


    public class Grade
    {
        private Board_list[] board_list;

        private String Id;

        private String class_name;

        public Board_list[] getBoard_list ()
        {
            return board_list;
        }

        public void setBoard_list (Board_list[] board_list)
        {
            this.board_list = board_list;
        }

        public String getId ()
        {
            return Id;
        }

        public void setId (String Id)
        {
            this.Id = Id;
        }

        public String getClass_name ()
        {
            return class_name;
        }

        public void setClass_name (String class_name)
        {
            this.class_name = class_name;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [board_list = "+board_list+", Id = "+Id+", class_name = "+class_name+"]";
        }
    }


    public class Board_list
    {
        private String board_name;

        private Sub_list[] sub_list;

        private String class_id;

        private String Id;

        public String getBoard_name ()
        {
            return board_name;
        }

        public void setBoard_name (String board_name)
        {
            this.board_name = board_name;
        }

        public Sub_list[] getSub_list ()
        {
            return sub_list;
        }

        public void setSub_list (Sub_list[] sub_list)
        {
            this.sub_list = sub_list;
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
            return "ClassPojo [board_name = "+board_name+", sub_list = "+sub_list+", class_id = "+class_id+", Id = "+Id+"]";
        }
}
}
