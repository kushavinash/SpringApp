package com.avi.model.mysql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User Details
 *
 * Created by Avinash
 */
@Entity
@Table(name = "users")
@DynamicUpdate()
@SelectBeforeUpdate()
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users implements Serializable {
	private static final long serialVersionUID = 1827336008248915008L;

	@Id
	@Column(name = "user_id", nullable = false)
	private Long user_id;
	@Column(name = "domain_id")
	private int domain_id;
	@Column(name = "localpart")
	private String localpart;
	@Column(name = "username" ,nullable=false ,columnDefinition="String default na")
	private String username;
	@Column(name = "clear")
	private String clear;
	@Column(name = "crypt")
	private String crypt;
	@Column(name = "uid" ,nullable=false ,columnDefinition="int(5) default 65534")
	private int uid;
	@Column(name = "gid" ,nullable=false ,columnDefinition="int(5) default 65534")
	private int gid;
	@Column(name = "smtp")
	private String smtp;
	@Column(name = "pop")
	private String pop;
    @Column(name = "type")
    private String type;
	@Column(name = "admin" ,nullable=false ,columnDefinition="int(1) default 0")
	private int admin;
	@Column(name = "on_avscan")
	private int on_avscan;
	@Column(name = "on_blocklist")
	private int on_blocklist;
	@Column(name = "on_complexpass")
	private int on_complexpass;
	@Column(name = "on_forward",nullable=false ,columnDefinition="int(11) default 1")
	private int on_forward;
	@Column(name = "on_piped")
	private int on_piped;
	@Column(name = "on_spamassassin")
	private int on_spamassassin;
	@Column(name = "on_vacation")
	private int on_vacation;
	@Column(name = "enabled" ,nullable=false ,columnDefinition="int(1) default 1")
	private int enabled;
	@Column(name = "flags")
	private String flags;
	@Column(name = "forward")
	private String forward;
	@Column(name = "maxmsgsize")
	private int maxmsgsize;
	@Column(name = "quota")
	private int quota;
	@Column(name = "realname")
	private String realname;
	@Column(name = "sa_tag")
	private int sa_tag;
	@Column(name = "sa_refuse" ,nullable=false ,columnDefinition="int(5) default 0")
	private int sa_refuse;
	@Column(name = "tagline")
	private String tagline;
	@Column(name = "vacation")
	private String vacation;
	@Column(name = "quota_used" ,nullable=false ,columnDefinition="int(11) default 1")
	private int quota_used;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getDomain_id() {
		return domain_id;
	}

	public void setDomain_id(int domain_id) {
		this.domain_id = domain_id;
	}

	public String getLocalpart() {
		return localpart;
	}

	public void setLocalpart(String localpart) {
		this.localpart = localpart;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClear() {
		return clear;
	}

	public void setClear(String clear) {
		this.clear = clear;
	}

	public String getCrypt() {
		return crypt;
	}

	public void setCrypt(String crypt) {
		this.crypt = crypt;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getPop() {
		return pop;
	}

	public void setPop(String pop) {
		this.pop = pop;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getOn_avscan() {
		return on_avscan;
	}

	public void setOn_avscan(int on_avscan) {
		this.on_avscan = on_avscan;
	}

	public int getOn_blocklist() {
		return on_blocklist;
	}

	public void setOn_blocklist(int on_blocklist) {
		this.on_blocklist = on_blocklist;
	}

	public int getOn_complexpass() {
		return on_complexpass;
	}

	public void setOn_complexpass(int on_complexpass) {
		this.on_complexpass = on_complexpass;
	}

	public int getOn_forward() {
		return on_forward;
	}

	public void setOn_forward(int on_forward) {
		this.on_forward = on_forward;
	}

	public int getOn_piped() {
		return on_piped;
	}

	public void setOn_piped(int on_piped) {
		this.on_piped = on_piped;
	}

	public int getOn_spamassassin() {
		return on_spamassassin;
	}

	public void setOn_spamassassin(int on_spamassassin) {
		this.on_spamassassin = on_spamassassin;
	}

	public int getOn_vacation() {
		return on_vacation;
	}

	public void setOn_vacation(int on_vacation) {
		this.on_vacation = on_vacation;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public int getMaxmsgsize() {
		return maxmsgsize;
	}

	public void setMaxmsgsize(int maxmsgsize) {
		this.maxmsgsize = maxmsgsize;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getSa_tag() {
		return sa_tag;
	}

	public void setSa_tag(int sa_tag) {
		this.sa_tag = sa_tag;
	}

	public int getSa_refuse() {
		return sa_refuse;
	}

	public void setSa_refuse(int sa_refuse) {
		this.sa_refuse = sa_refuse;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getVacation() {
		return vacation;
	}

	public void setVacation(String vacation) {
		this.vacation = vacation;
	}

	public int getQuota_used() {
		return quota_used;
	}

	public void setQuota_used(int quota_used) {
		this.quota_used = quota_used;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
