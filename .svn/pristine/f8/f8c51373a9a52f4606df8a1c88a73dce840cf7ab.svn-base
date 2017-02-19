package com.oraclewdp.crm.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * jsp分页标签
 *
 * 基于ul标签，li标签和a标签
 *
 * 要自己写样式
 *
 *
 * 需要的核心接口是Pages<T>
 *
 *
 * @see Pages
 */
public class JspPageTag extends SimpleTagSupport {

    private Pages<?> pages;

    private String ulClass;



    private String first;

    private String last;

    private String prev;

    private String next;

    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    public Pages<?> getPages() {
        return pages;
    }

    public void setPages(Pages<?> pages) {
        this.pages = pages;
    }

    public String getUlClass() {
        return ulClass;
    }



    public void setUlClass(String ulClass) {
        this.ulClass = ulClass;
    }



    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public void doTag() throws JspException, IOException {

        JspWriter out = this.getJspContext().getOut();

        out.write("<ul");
        if(ulClass!=null){
            out.print(" class=\"");
            out.print(ulClass);
            out.print("\" ");
        }
        out.println(">");

        String prev = this.prev==null||this.prev.isEmpty()?"&lt;":this.prev;
        String first = this.first==null||this.first.isEmpty()?"&lt;&lt;":this.first;
        String next = this.next==null||this.next.isEmpty()?"&gt;":this.next;
        String last = this.last==null||this.last.isEmpty()?"&gt;&gt;":this.last;

        if(pages.getAllCount()>pages.getPageSize()){
            if(pages.getCurrentPage()==1){
                out.print("<li><a href=\"javascript:void(0);\">");
                out.print(first);
                out.println("</a></li>");

                out.print("<li><a href=\"javascript:void(0);\">");
                out.print(prev);
                out.println("</a></li>");
            }else{

                out.print("<li><a href=\"");
                out.print(link);
                out.print("?page=");
                out.print(pages.getCurrentPage()-1);
                out.print("\">");
                out.print(prev);
                out.println("</a></li>");
            }

            int p , q;
            if(pages.getPageCount()<=pages.getPageSize()){
                p=1;
                q = pages.getPageCount()+1;
            }else{
                int t= pages.getCurrentPage()/pages.getPageSize();
                if(pages.getCurrentPage()%pages.getPageSize()==0){
                    p = ((pages.getCurrentPage()-1)/pages.getPageSize())*pages.getPageSize()+1;
                }else{
                    p = t * pages.getPageSize()+1;
                }
                q = p + pages.getPageSize();
            }


            for (int i=p;i<q&&i<=pages.getPageCount();i++){
                out.print("<li>");
                if(i==pages.getCurrentPage()){
                    out.print("<a href=\"javascript:void(0);\" class=\"active\">");
                    out.print(i);
                    out.print("</a>");
                }else{
                    out.print("<a href=\"");
                    out.print(link);
                    out.print("?page=");
                    out.print(i);
                    out.print("\">");
                    out.print(i);
                    out.print("</a>");
                }

                out.println("</li>");

            }

            if(pages.getCurrentPage() == pages.getPageCount()){
                out.print("<li><a href=\"javascript:void(0);\">");
                out.print(next);
                out.println("</a></li>");
                out.print("<li><a href=\"javascript:void(0);\">");
                out.print(last);
                out.println("</a></li>");
            }else{
                out.print("<li><a href=\"");
                out.print(link);
                out.print("?page=" );
                out.print(pages.getCurrentPage()+1);
                out.println("\">下一页</a></li>");

                out.print("<li><a href=\"");
                out.print(link);
                out.print("?page=");
                out.print(pages.getPageCount());
                out.println("\">尾页</a></li>");
            }





        }
        out.println("</ul>");






    }


}
