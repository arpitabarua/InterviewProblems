package solutions13;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] routes = {
                {7, 12},
                {4, 5, 15},
                {6},
                {15, 19},
                {9, 12, 13}
        };

        int S = 15;
        int T = 12;

        System.out.println(
                solution.numBusesToDestination(routes, S, T)
        );
    }

    public int numBusesToDestination(int[][] routes, int S, int T) {

        if (S == T) {
            return 0;
        }

        // Step 1: Convert routes to sets once
        List<Set<Integer>> routeSets = new ArrayList<>();

        for (int[] route : routes) {
            Set<Integer> stops = new HashSet<>();

            for (int stop : route) {
                stops.add(stop);
            }

            routeSets.add(stops);
        }

        // Step 2: Initialize BFS
        Queue<Route> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        // Find all routes containing source S
        for (int i = 0; i < routeSets.size(); i++) {

            if (routeSets.get(i).contains(S)) {
                Route newRoute = new Route();
                newRoute.routeIndex = i;
                newRoute.level = 1;

                queue.add(newRoute);
                visited.add(i);
            }
        }

        // Step 3: BFS
        while (!queue.isEmpty()) {

            Route currentRoute = queue.poll();

            Set<Integer> currentStops =
                    routeSets.get(currentRoute.routeIndex);

            // Check destination
            if (currentStops.contains(T)) {
                return currentRoute.level;
            }

            // Check connecting routes
            for (int i = 0; i < routeSets.size(); i++) {

                if (!visited.contains(i) &&
                        !Collections.disjoint(
                                currentStops,
                                routeSets.get(i))) {

                    Route newRoute = new Route();
                    newRoute.routeIndex = i;
                    newRoute.level = currentRoute.level + 1;

                    visited.add(i);
                    queue.add(newRoute);
                }
            }
        }

        return -1;
    }
}

class Route {
    int routeIndex;
    int level;
}
