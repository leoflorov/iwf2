package ru.leodevelopments.iwf;

/**
 * Created by Leonid on 20.12.2016.
 */

class Roster {
        private String name;
        private int numOfWins;
        private int thumbnail;

        public Roster() {
        }

        Roster(String name, int numOfWins, int thumbnail) {
            this.name = name;
            this.numOfWins = numOfWins;
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        int getNumOfWins() {
            return numOfWins;
        }

        public void setNumOfWins(int numOfWins) {
            this.numOfWins = numOfWins;
        }

        int getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(int thumbnail) {
            this.thumbnail = thumbnail;
        }
    }
