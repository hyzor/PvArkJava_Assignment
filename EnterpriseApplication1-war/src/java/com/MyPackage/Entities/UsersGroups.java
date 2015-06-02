/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyPackage.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jesper
 */
@Entity
@Table(name = "USERS_GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersGroups.findAll", query = "SELECT u FROM UsersGroups u"),
    @NamedQuery(name = "UsersGroups.findByGroupname", query = "SELECT u FROM UsersGroups u WHERE u.groupname = :groupname"),
    @NamedQuery(name = "UsersGroups.findByUsername", query = "SELECT u FROM UsersGroups u WHERE u.username = :username")})
public class UsersGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "GROUPNAME")
    private String groupname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USERNAME")
    private String username;

    public UsersGroups() {
    }

    public UsersGroups(String username) {
        this.username = username;
    }

    public UsersGroups(String username, String groupname) {
        this.username = username;
        this.groupname = groupname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersGroups)) {
            return false;
        }
        UsersGroups other = (UsersGroups) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.MyPackage.Entities.UsersGroups[ username=" + username + " ]";
    }
    
}
