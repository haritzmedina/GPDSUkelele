package com.gpds.ukelele.db;

/**
 * Created by Imanol on 05/11/2015.
 */
public class Action {

        private String username;
        private String actionName;
        //private Timer time;

        public Action(String username) {
            this.username = username;
        }

        public String getUsername() {

            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public Action(String username, String password) {

            this.username = username;
            this.actionName = actionName;
        }
    }

