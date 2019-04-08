package com.student.admin.desire.datagetter;

public class listofnews {
    private NewsEventsList[] NewsEventsList;

    private Response Response;

    public NewsEventsList[] getNewsEventsList ()
    {
        return NewsEventsList;
    }

    public void setNewsEventsList (NewsEventsList[] NewsEventsList)
    {
        this.NewsEventsList = NewsEventsList;
    }
    public Response getResponse ()
    {
        return Response;
    }
    public void setResponse (Response Response)
    {
        this.Response = Response;
    }
    @Override
    public String toString()
    {
        return "ClassPojo [NewsEventsList = "+NewsEventsList+", Response = "+Response+"]";
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


    public class NewsEventsList
    {
        private String news_content;

        private String Id;

        private String news_title;

        public String getNews_content ()
        {
            return news_content;
        }

        public void setNews_content (String news_content)
        {
            this.news_content = news_content;
        }

        public String getId ()
        {
            return Id;
        }

        public void setId (String Id)
        {
            this.Id = Id;
        }

        public String getNews_title ()
        {
            return news_title;
        }

        public void setNews_title (String news_title)
        {
            this.news_title = news_title;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [news_content = "+news_content+", Id = "+Id+", news_title = "+news_title+"]";
        }
    }


}
