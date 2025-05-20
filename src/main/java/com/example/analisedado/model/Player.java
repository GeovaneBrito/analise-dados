package com.example.analisedado.model;

import java.util.List;

public class Player {

    private String id;
    private String name;
    private int age;
    private int score;
    private boolean active;
    private String country;
    private Team team;
    private List<Log> logs;

    public static class Team {
        private String name;
        private boolean leader;
        private List<Project> projects;

        public static class Project {
            private String name;
            private boolean completed;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isCompleted() {
                return completed;
            }

            public void setCompleted(boolean completed) {
                this.completed = completed;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isLeader() {
            return leader;
        }

        public void setLeader(boolean leader) {
            this.leader = leader;
        }

        public List<Project> getProjects() {
            return projects;
        }

        public void setProjects(List<Project> projects) {
            this.projects = projects;
        }
    }

    public static class Log {
        private String date;
        private String action;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
