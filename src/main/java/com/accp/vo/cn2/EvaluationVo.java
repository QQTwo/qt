package com.accp.vo.cn2;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.accp.pojo.Evaluationservice;

public class EvaluationVo {
			private int serviceAppraiseID;
			public int getServiceAppraiseID() {
				return serviceAppraiseID;
			}
			public void setServiceAppraiseID(int serviceAppraiseID) {
				this.serviceAppraiseID = serviceAppraiseID;
			}
			private int userid;
			private String userimgpath;
			private String username;
			private String servicetitle;
			private String   serviceappraisecontent;
			@DateTimeFormat(pattern="yyyy-MM-dd")
			private Date   serviceappraisedate;
			private int serviceappraiselevel;
			
			private Evaluationservice evaluation;
			
			
			public Evaluationservice getEvaluation() {
				return evaluation;
			}
			public void setEvaluation(Evaluationservice evaluation) {
				this.evaluation = evaluation;
			}
			public String getUserimgpath() {
				return userimgpath;
			}
			public void setUserimgpath(String userimgpath) {
				this.userimgpath = userimgpath;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getServicetitle() {
				return servicetitle;
			}
			public void setServicetitle(String servicetitle) {
				this.servicetitle = servicetitle;
			}
			public String getServiceappraisecontent() {
				return serviceappraisecontent;
			}
			public void setServiceappraisecontent(String serviceappraisecontent) {
				this.serviceappraisecontent = serviceappraisecontent;
			}
			public Date getServiceappraisedate() {
				return serviceappraisedate;
			}
			public void setServiceappraisedate(Date serviceappraisedate) {
				this.serviceappraisedate = serviceappraisedate;
			}
			public int getServiceappraiselevel() {
				return serviceappraiselevel;
			}
			public void setServiceappraiselevel(int serviceappraiselevel) {
				this.serviceappraiselevel = serviceappraiselevel;
			}
			public int getUserid() {
				return userid;
			}
			public void setUserid(int userid) {
				this.userid = userid;
			}
			
			
			
			
}
