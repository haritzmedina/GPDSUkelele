package com.gpds.ukelele.db;

/**
 * Created by Ladis on 04/11/2015.
 */
public class Trace {
    private String username;
    private String menu;
    private int menutime;

    public Trace(String username, String menu, int time) {
        this.username=username;
        this.menu=menu;
        this.menutime=time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trace trace = (Trace) o;

        if (menutime != trace.menutime) return false;
        if (username != null ? !username.equals(trace.username) : trace.username != null)
            return false;
        return !(menu != null ? !menu.equals(trace.menu) : trace.menu != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (menu != null ? menu.hashCode() : 0);
        result = 31 * result + menutime;
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getMenutime() {
        return menutime;
    }

    public void setMenutime(int menutime) {
        this.menutime = menutime;
    }


}
